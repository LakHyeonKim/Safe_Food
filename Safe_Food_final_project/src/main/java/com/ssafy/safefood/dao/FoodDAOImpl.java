package com.ssafy.safefood.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.safefood.vo.Food;

@Repository
public class FoodDAOImpl implements FoodDAO{

	@Autowired
	private SqlSession sqlSession;
	private final String ns = "foodMapper.";
	
	@Override
	public List<Food> findFoodByName(Food food) throws Exception {
		return sqlSession.selectList(ns+"findFoodByName", food);
	}
	@Override
	public List<Food> findFoodByMaker(Food food) throws Exception {
		return sqlSession.selectList(ns+"findFoodByMaker", food);
	}
	@Override
	public List<Food> findFoodByMaterial(Food food) throws Exception {
		return sqlSession.selectList(ns+"findFoodByMaterial", food);
	}
	@Override
	public Food findFoodByCode(Food food) throws Exception {
		return sqlSession.selectOne(ns+"findFoodByCode", food);
	}
	@Override
	public List<Food> findAllFood() throws Exception {
		return sqlSession.selectList(ns+"findAllFood");
	}
	
	
	
	@Override
	public List<Food> findFoodByNameAndMaterial(Food food) throws Exception {
		return sqlSession.selectList(ns+"findFoodByNameAndMaterial", food);
	}
	@Override
	public List<Food> findFoodByMakerAndMaterial(Food food) throws Exception {
		return sqlSession.selectList(ns+"findFoodByMakerAndMaterial", food);
	}
	@Override
	public Food findFoodByCodeAndMaterial(Food food) throws Exception {
		return sqlSession.selectOne(ns+"findFoodByCodeAndMaterial", food);
	}
	@Override
	public List<Food> findFoodByMaterialAndMaterial(Food food) throws Exception {
		return sqlSession.selectList(ns+"findFoodByMaterialAndMaterial", food);
	}
}
