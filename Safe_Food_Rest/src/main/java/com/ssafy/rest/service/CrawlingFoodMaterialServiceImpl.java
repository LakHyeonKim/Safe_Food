package com.ssafy.rest.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.rest.repo.CrawlingFoodMaterialDAO;
import com.ssafy.rest.vo.CrawlingFoodMaterial;

@Service
public class CrawlingFoodMaterialServiceImpl implements CrawlingFoodMaterialService{

	@Autowired
	private CrawlingFoodMaterialDAO crawlingFoodMaterialDAO;
	
	@Override
	public boolean saveFoodMaterial() throws Exception {
		int startPage = 1;
		int endPage = 24;
		String jsonData = "";
		for(int i = startPage; i <= endPage; i++) {
			String url = "http://www.sdfi.co.kr/foodsafetykorea/_DataLoad_%ED%95%84%EB%93%9C%EC%84%A4%EB%AA%85.asp?strServiceID=COOKRCP01&show_cnt=50&start_idx=" + i;
			Document doc = Jsoup.connect(url).post();
			Elements element = doc.select("body");
			jsonData = element.text();
			JSONParser jsonParse = new JSONParser();
			JSONObject jsonObj = (JSONObject) jsonParse.parse(jsonData);
			JSONArray personArray = (JSONArray) jsonObj.get("dataList");
			for(int j=0; j < personArray.size(); j++) { 
				JSONObject personObject = (JSONObject) personArray.get(j);
				String name = personObject.get("col_1").toString();
				String foodMaterial = personObject.get("col_13").toString();
				String recipe = "";
				for(int colNum = 14; colNum <= 52; colNum+=2) {
					recipe += personObject.get("col_" + colNum).toString() + "Z";
				}
				String img = personObject.get("col_11").toString();
				boolean result = crawlingFoodMaterialDAO.saveFoodMaterial(new CrawlingFoodMaterial(name, foodMaterial, recipe, img));
				if(!result) {
					return false;
				}
			}
		}
		return true;
	}

}
