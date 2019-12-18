package com.ssafy.rest.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ssafy.rest.api.FoodRelation;

public interface VisionService {
	public List<FoodRelation> getFoodImageAnalyze(MultipartFile file) throws Exception;
}
