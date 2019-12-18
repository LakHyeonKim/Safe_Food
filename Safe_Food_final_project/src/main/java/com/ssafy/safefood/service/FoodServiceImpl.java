package com.ssafy.safefood.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.safefood.dao.FoodDAO;
import com.ssafy.safefood.vo.Food;
@Service
public class FoodServiceImpl implements FoodService{
	
	@Autowired
	private FoodDAO foodDAO;
	

	@Override
	public List<Food> findFoodByName(Food food) throws Exception {
		return foodDAO.findFoodByName(food);
	}

	@Override
	public List<Food> findFoodByMaker(Food food) throws Exception {
		return foodDAO.findFoodByMaker(food);
	}

	@Override
	public List<Food> findFoodByMaterial(Food food) throws Exception {
		return foodDAO.findFoodByMaterial(food);
	}

	@Override
	public Food findFoodByCode(Food food) throws Exception {
		return foodDAO.findFoodByCode(food);
	}

	@Override
	public List<Food> findAllFood() throws Exception {
		return foodDAO.findAllFood();
	}

	@Override
	public List<Food> randomSearchFood() throws Exception {
		List<Food> foods = foodDAO.findAllFood();
		return random_search(7, foods);
	}
	
	private static void combination( ArrayList<ArrayList<Food>> combinList, ArrayList<Food> list, ArrayList<Food> pick, int target, int deep, int cur)
	{
		if(deep == target)
		{
			combinList.add((ArrayList<Food>) pick.clone());
			return;
		}
		for(int i = cur ; i < list.size() ; i++)
		{
			pick.set(deep, list.get(i));
			combination( combinList,list, pick, target, deep+1, i+1);
		}

	}
	
	private static long comNum(int n, int r)
	{
		if(n == r || r == 0) return 1;
		if(r == 1 ) return n;
		return comNum(n-1,r) + comNum(n-1,r-1);
	}
	
	private static ArrayList<Food> random_search(int mainPageItemSize, List<Food> foods)
	{
		long combinSize = 0;
		ArrayList<Food> foodAllList = new ArrayList<Food>();
		ArrayList<Food> pick = new ArrayList<Food>();
		for(int i = 0 ; i < mainPageItemSize ; i++)
			pick.add(new Food());
		ArrayList<ArrayList<Food>> combinList = new ArrayList<ArrayList<Food>>();
		ArrayList<Food> outputList = new ArrayList<Food>();
		
		try {
			foodAllList = (ArrayList<Food>) foods;
			int N = foodAllList.size();
			combinSize = comNum(N,mainPageItemSize);
			combination(combinList,foodAllList, pick, mainPageItemSize, 0, 0);
			int randomIndex = (int) (((long) (Math.random()*combinSize)) % combinSize);	// make random number to call object of combinList 
			outputList = combinList.get(randomIndex);
		} catch (Exception e) {
			System.out.println(e);
		}
		return outputList;
	}
	
	
	
	@Override
	public List<Food> findFoodByNameAndMaterial(Food food) throws Exception {
		return foodDAO.findFoodByNameAndMaterial(food);
	}

	@Override
	public List<Food> findFoodByMakerAndMaterial(Food food) throws Exception {
		return foodDAO.findFoodByMakerAndMaterial(food);
	}

	@Override
	public Food findFoodByCodeAndMaterial(Food food) throws Exception {
		return foodDAO.findFoodByCodeAndMaterial(food);
	}

	@Override
	public List<Food> findFoodByMaterialAndMaterial(Food food) throws Exception {
		return foodDAO.findFoodByMaterialAndMaterial(food);
	}

}
