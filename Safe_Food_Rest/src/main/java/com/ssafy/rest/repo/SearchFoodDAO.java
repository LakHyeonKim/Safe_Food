package com.ssafy.rest.repo;

import java.util.List;

import com.ssafy.rest.vo.CookedFood;
import com.ssafy.rest.vo.CrawlingFoodMaterial;

public interface SearchFoodDAO {
	public CookedFood findNameCookedFood(String name) throws Exception;
	public List<CrawlingFoodMaterial> findNameMaterial(String name) throws Exception;
}
