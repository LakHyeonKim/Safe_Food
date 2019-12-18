package com.ssafy.rest.repo;

import com.ssafy.rest.vo.CrawlingFoodMaterial;

public interface CrawlingFoodMaterialDAO {
	public boolean saveFoodMaterial(CrawlingFoodMaterial crawlingFoodMaterial) throws Exception;
}
