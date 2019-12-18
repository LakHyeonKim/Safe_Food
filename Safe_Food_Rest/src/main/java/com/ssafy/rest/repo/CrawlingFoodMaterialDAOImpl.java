package com.ssafy.rest.repo;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.rest.vo.CrawlingFoodMaterial;

@Repository
public class CrawlingFoodMaterialDAOImpl implements CrawlingFoodMaterialDAO{

	private String ns = "MaterialMapper.";

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public boolean saveFoodMaterial(CrawlingFoodMaterial crawlingFoodMaterial) throws Exception {
		int result = sqlSession.insert(ns+"saveFoodMaterial", crawlingFoodMaterial);
		if(result > 0) return true;
		return false;
	}
	
}
