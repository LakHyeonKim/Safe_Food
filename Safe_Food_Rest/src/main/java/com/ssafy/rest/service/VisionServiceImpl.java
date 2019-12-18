package com.ssafy.rest.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.cloud.translate.Detection;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.cloud.vision.v1.WebDetection;
import com.google.cloud.vision.v1.Feature.Type;
import com.google.cloud.vision.v1.WebDetection.WebEntity;
import com.google.cloud.vision.v1.WebDetection.WebImage;
import com.google.cloud.vision.v1.WebDetection.WebLabel;
import com.google.cloud.vision.v1.WebDetection.WebPage;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.ByteString;
import com.ssafy.rest.api.FoodRelation;
import com.ssafy.rest.repo.SearchFoodDAO;
import com.ssafy.rest.vo.CookedFood;
import com.ssafy.rest.vo.CrawlingFoodMaterial;

@Service
public class VisionServiceImpl implements VisionService, SearchFoodService{
	//private static String path = "C:/ssafy/SafeFood/SafeFoodFinalRest/src/main/webapp/img/";
	private static String path = "C:/ssafy/work_maven/Safe_Food_Rest/src/main/webapp/img/";
	//private static String path = "C:/Users/20120/OneDrive/code/javaSpringWorkSpace/safe_food_final_rest/src/main/webapp/img/";
	private static String bestGuessLabel = "";
	private static String getVisuallySimilarImages = "";
	@Autowired
	private SearchFoodDAO searchFoodDAO;

	@Override
	public FoodRelation getFoodInformation(String name, String img, String bestGuessLabel, float rating) throws Exception {
		CookedFood cookedFood = searchFoodDAO.findNameCookedFood(name);
		List<CrawlingFoodMaterial> crawlingFoodMaterial = searchFoodDAO.findNameMaterial(name);
		if(cookedFood == null) return null;
		cookedFood.setName(name);
		FoodRelation foodRelation = new FoodRelation(crawlingFoodMaterial, cookedFood, img, bestGuessLabel, rating);
		return foodRelation;
	}

	@Override
	public List<FoodRelation> getFoodImageAnalyze(MultipartFile file) throws Exception {
		List<FoodRelation> result = new ArrayList<>();
		Map<String,Integer> map = new HashMap<>();
		System.out.println("KEY::" + file.getName());
		System.out.println("SIZE::" + file.getSize());
		System.out.println("FILE_NAME::" + file.getOriginalFilename());
		try {

			long time = System.currentTimeMillis(); 
			byte[] data = file.getBytes();
			String originFileName = file.getOriginalFilename();
			String saveFileName = String.format("%d_%s", time, originFileName);
			file.transferTo(new File(path, saveFileName));
			System.out.println("save...ok");
			PrintStream out = System.out;
			String filePath = path + saveFileName + "";
			List<String> description = new ArrayList<>();
			List<Float> rating = new ArrayList<>();
			detectWebDetections(filePath,out,description,rating);
			for(int i = 0; i < description.size(); i++) {
				if(!map.containsKey(description.get(i))) {
					map.put(description.get(i),0);
					String imageURL = searchImage(description.get(i));
					System.out.println("imageURL::" + imageURL);
					FoodRelation temp = getFoodInformation(description.get(i),imageURL,bestGuessLabel,rating.get(i));
					if(temp == null) continue;
					result.add(temp);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * 이미지 경로를 통하여 사진 라벨 텍스트 얻는 함수
	 */
	/* private static void detectLabel(String filePath, PrintStream out) throws FileNotFoundException, IOException {
		List<AnnotateImageRequest> requests = new ArrayList<>();

		ByteString imgBytes = ByteString.readFrom(new FileInputStream(filePath));

		Image img = Image.newBuilder().setContent(imgBytes).build();
		Feature feat = Feature.newBuilder().setType(Type.LABEL_DETECTION).build();
		AnnotateImageRequest request =
				AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
		requests.add(request);

		try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
			BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
			List<AnnotateImageResponse> responses = response.getResponsesList();

			for (AnnotateImageResponse res : responses) {
				if (res.hasError()) {
					out.printf("Error: %s\n", res.getError().getMessage());
					return;
				}

				for (EntityAnnotation annotation : res.getLabelAnnotationsList()) {
					annotation.getAllFields().forEach((k, v) -> {
						String description = v.toString();
						if(Pattern.matches("^[a-zA-Z]*$", description))
							out.printf("%s : %s\n", k, autoDetectTranslate(description, "ko"));
					});
				}
			}
		}
	} */

	/*
	 * 로컬 이미지에 웹 감지 실행
	 */
	public static void detectWebDetections(String filePath, PrintStream out, List<String> description, List<Float> rating) throws Exception,
	IOException {
		List<AnnotateImageRequest> requests = new ArrayList<>();

		ByteString imgBytes = ByteString.readFrom(new FileInputStream(filePath));

		Image img = Image.newBuilder().setContent(imgBytes).build();
		Feature feat = Feature.newBuilder().setType(Type.WEB_DETECTION).build();
		AnnotateImageRequest request =
				AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
		requests.add(request);

		try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
			BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
			List<AnnotateImageResponse> responses = response.getResponsesList();

			for (AnnotateImageResponse res : responses) {
				if (res.hasError()) {
					out.printf("Error: %s\n", res.getError().getMessage());
					return;
				}

				// Search the web for usages of the image. You could use these signals later
				// for user input moderation or linking external references.
				// For a full list of available annotations, see http://g.co/cloud/vision/docs
				WebDetection annotation = res.getWebDetection();
				out.println("Entity:Id:Score");
				out.println("===============");
				for (WebEntity entity : annotation.getWebEntitiesList()) {
					String desc = autoDetectTranslate(entity.getDescription(), "ko");
					if(desc == null || desc == "" || desc == " ") continue;
					description.add(desc);
					rating.add((float)Math.round(entity.getScore() + 2.5f));
					out.println(desc + "==" + entity.getDescription() + " : " + entity.getEntityId() + " : "
							+ entity.getScore()+ "==" + (float)Math.round(entity.getScore() + 2.5f));
				}
				for (WebLabel label : annotation.getBestGuessLabelsList()) {
					bestGuessLabel = label.getLabel();
					out.format("\nBest guess label: %s", bestGuessLabel);
				}
				out.println("\nPages with matching images: Score\n==");
				for (WebPage page : annotation.getPagesWithMatchingImagesList()) {
					out.println(page.getUrl() + " : " + page.getScore());
				}
				out.println("\nPages with partially matching images: Score\n==");
				for (WebImage image : annotation.getPartialMatchingImagesList()) {
					out.println(image.getUrl() + " : " + image.getScore());
				}
				out.println("\nPages with fully matching images: Score\n==");
				for (WebImage image : annotation.getFullMatchingImagesList()) {
					out.println(image.getUrl() + " : " + image.getScore());
				}
				out.println("\nPages with visually similar images: Score\n==");
				int count = 0;
				for (WebImage image : annotation.getVisuallySimilarImagesList()) {
					if(count == 0) {
						getVisuallySimilarImages = image.getUrl();
					}
					out.println(image.getUrl() + " : " + image.getScore());
					count++;
				}
			}
		}
	}

	/*
	 * 추출한 텍스트 번역 API
	 */
	private static Translate getTranslateService() {
		return TranslateOptions.getDefaultInstance().getService();
	}

	private static String translate(String text, String source, String target) {
		Translate translate = getTranslateService();

		Translation translation = translate.translate(text,        // 바꾸고자 하는 텍스트
				Translate.TranslateOption.sourceLanguage(source),  // 원본 언어
				Translate.TranslateOption.targetLanguage(target)); // 번역할 언어

		return translation.getTranslatedText();
	}


	private static String detectLanguage(String text) {
		Translate translate = getTranslateService();
		List<Detection> detections = translate.detect(ImmutableList.of(text));

		String sourceLanguage = null;
		for (Detection detection : detections) {
			sourceLanguage = detection.getLanguage();
		}

		return sourceLanguage;
	}

	private static String autoDetectTranslate(String text, String target) {
		return translate(text, "en", target);
	}

	private static String searchImage(String desc) throws IOException {
		String resultImgUrl = "";
		String searchFailUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSBTq8FosimpiQ3fv469FdguTfSHJ3M0YTsz5tzCOTSh_fyVqL5&s";
		Document doc = Jsoup.connect("http://www.10000recipe.com/recipe/list.html?q=" + URLEncoder.encode(desc, "UTF-8")).get();
		Elements element = doc.select("div.recipe_list");
		Element img = null;
		if(element == null) {
			if(getVisuallySimilarImages == "")
				return searchFailUrl;
			else
				return getVisuallySimilarImages;
		}else {
			if(element.size() == 0) {
				if(getVisuallySimilarImages == "")
					return searchFailUrl;
				else
					return getVisuallySimilarImages;
			}else {
				if(element.get(0).select("img").size() == 0) {
					if(getVisuallySimilarImages == "")
						return searchFailUrl;
					else
						return getVisuallySimilarImages;
				}else {
					img = element.get(0).select("img").get(0);
					resultImgUrl = img.getElementsByAttribute("src").attr("src");
				}
			}
		}
		if(resultImgUrl.contains("/cache/recipe/")) {
			return resultImgUrl;
		}else {
			if(getVisuallySimilarImages == "")
				return searchFailUrl;
			else
				return getVisuallySimilarImages;
		}
	}
}
