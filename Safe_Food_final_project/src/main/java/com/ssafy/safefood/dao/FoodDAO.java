package com.ssafy.safefood.dao;

import java.util.List;

import com.ssafy.safefood.vo.Food;

public interface FoodDAO {
	public List<Food> findFoodByName(Food food) throws Exception;
	public List<Food> findFoodByMaker(Food food) throws Exception;
	public List<Food> findFoodByMaterial(Food food) throws Exception;
	
	public List<Food> findFoodByNameAndMaterial(Food food) throws Exception;
	public List<Food> findFoodByMaterialAndMaterial(Food food) throws Exception;
	public List<Food> findFoodByMakerAndMaterial(Food food) throws Exception;
	public Food findFoodByCodeAndMaterial(Food food) throws Exception;
	
	public Food findFoodByCode(Food food) throws Exception;
	public List<Food> findAllFood() throws Exception;
}
