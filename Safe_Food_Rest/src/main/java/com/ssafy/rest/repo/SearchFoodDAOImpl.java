package com.ssafy.rest.repo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.rest.vo.CookedFood;
import com.ssafy.rest.vo.CrawlingFoodMaterial;

@Repository
public class SearchFoodDAOImpl implements SearchFoodDAO{
	
	private String ns1 = "MaterialMapper.";
	private String ns2 = "CookedFoodMapper.";

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public CookedFood findNameCookedFood(String name) throws Exception {
		CookedFood t = sqlSession.selectOne(ns2 + "findNameCookedFood",name);
		System.out.println(name);
		return t;
	}

	@Override
	public List<CrawlingFoodMaterial> findNameMaterial(String name) throws Exception {
		return sqlSession.selectList(ns1 + "findNameMaterial",name);
	}

}
