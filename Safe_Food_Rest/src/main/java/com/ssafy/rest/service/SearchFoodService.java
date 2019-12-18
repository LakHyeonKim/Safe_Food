package com.ssafy.rest.service;

import java.util.List;

import com.ssafy.rest.api.FoodRelation;

public interface SearchFoodService {
	public FoodRelation getFoodInformation(String name, String img, String bestGuessLabel, float rating) throws Exception;
}
