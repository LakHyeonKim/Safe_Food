package com.ssafy.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.rest.api.FoodRelation;
import com.ssafy.rest.service.CrawlingFoodMaterialService;
import com.ssafy.rest.service.VisionService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/externalApi") 
@CrossOrigin(origins = {"*"}, maxAge = 6000)
@Api(tags = {"SSAFY FOOD QNA HRM"}, description="SSAFY FOOD QNA HRM resource API")

public class APIController {
	
	@Autowired
	private CrawlingFoodMaterialService crawlingFoodMaterialService;
	@Autowired
	private VisionService visionService;
	
	@RequestMapping(value = {"/upload"}, method = {RequestMethod.POST}, consumes = org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<List<FoodRelation>> getFoodInformation(@RequestParam("image") MultipartFile file) throws Exception {
		List<FoodRelation> result = visionService.getFoodImageAnalyze(file);
		if(result != null) return new ResponseEntity(result,HttpStatus.OK);
		else return new ResponseEntity(result,HttpStatus.NO_CONTENT);
	}

	
	@GetMapping("/crawling")
	public ResponseEntity<String> getCrawlingFoodMaterial() throws Exception{
		boolean result = crawlingFoodMaterialService.saveFoodMaterial();
		if(result) return new ResponseEntity("<h1>Save...Ok</h1>",HttpStatus.OK);
		else return new ResponseEntity("<h1>Save...failk</h1>",HttpStatus.NO_CONTENT);
	}
}
