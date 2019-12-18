package com.ssafy.safefood;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.safefood.service.FoodService;
import com.ssafy.safefood.vo.Food;

@Controller
public class FoodController {
	@Autowired
	private FoodService foodService;
	
	@RequestMapping("detailPage.do")
	public ModelAndView detailPage(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int code = Integer.parseInt(request.getParameter("code"));
		Food vo = new Food();
		vo.setCode(code);
		Food food = foodService.findFoodByCode(vo);
		System.out.println(food);
		return new ModelAndView("DetailPage","food",food);
	}
	
	@RequestMapping("randomSearchFood.do")
	public ModelAndView randomSearchFood(HttpServletRequest request, HttpServletResponse response) throws Exception{
		List<Food> foods = foodService.randomSearchFood();
		return new ModelAndView("ProductItems","foods",foods).addObject("size", 5);
	}
	
	@RequestMapping("findFood.do")
	public ModelAndView findAllFood(HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("들어옴");
		String field = request.getParameter("searchField");
//		String field = food.
		if(field==null) field="";
		String text = request.getParameter("searchText");
		if(text==null) text="";
		String searchAllegry = request.getParameter("allergy");
		String[] allergyArr = null;
		ArrayList<Food>[] list = null;
		if(searchAllegry==null) {
			searchAllegry="";
		}
		else {
			allergyArr = searchAllegry.split(",");
			list = new ArrayList[allergyArr.length];
			for(int i=0;i<list.length;i++) {
				list[i] = new ArrayList<>();
			}
		}
		field = field.trim();
		text = text.trim();
		//list도 trim해줘야하나???
		
		for(String a : allergyArr) {
			System.out.print(a+" ");
		}
		System.out.println();
//		System.out.println("============"+searchAllegry);
//		System.out.println(field);
//		System.out.println(text);
		
		ArrayList<Food> result = null;
		ArrayList<Food> result2 = null;
		HashSet<Food> result1=new HashSet<>();
		Food vo = null;
		
		try {
			if(searchAllegry=="") {//체크박스 안돼있으면~
				switch(field){
					case "Name":
						vo = new Food();
						vo.setName(text);
						result = (ArrayList<Food>) foodService.findFoodByName(vo);
						break;
					case "Maker":
						vo = new Food();
						vo.setMaker(text);
						result = (ArrayList<Food>) foodService.findFoodByMaker(vo);
						break;
					case "Material":
						vo = new Food();
						vo.setMaterial(text);
						result = (ArrayList<Food>) foodService.findFoodByMaterial(vo);
						break;
					default:
						if(text=="")
							result = (ArrayList<Food>) foodService.findAllFood();
						else {
							vo = new Food();
							vo.setName(text);
							vo.setMaker(text);
							vo.setMaterial(text);
							result1.addAll(foodService.findFoodByName(vo));
							result1.addAll(foodService.findFoodByMaker(vo));
							result1.addAll(foodService.findFoodByMaterial(vo));
							result=new ArrayList<Food>(result1);
						}
						break;
				}//switch
			}else {//체크 돼있으면~~
				for(int i=0;i<allergyArr.length;i++) {
					switch(field){
						case "Name":
							vo = new Food();
							vo.setName(text);
							vo.setAllergy(allergyArr[i]);
							list[i].addAll((ArrayList<Food>) foodService.findFoodByNameAndMaterial(vo));
							System.out.println("여기~");
							for(Food f : list[i]) {
								System.out.print(f.getName()+" ");
							}
							System.out.println();
							break;
						case "Maker":
							vo = new Food();
							vo.setMaker(text);
							vo.setAllergy(allergyArr[i]);
							list[i].addAll((ArrayList<Food>) foodService.findFoodByMakerAndMaterial(vo));
							break;
						case "Material":
							vo = new Food();
							vo.setMaterial(text);
							vo.setAllergy(allergyArr[i]);
							list[i].addAll((ArrayList<Food>) foodService.findFoodByMaterialAndMaterial(vo));
							break;
						default://전체검색///
							if (text == ""){//체크 돼있고, 전체검색에 검색어없이 쳤을때 -> 체크된 애만 출력
								vo = new Food();
								vo.setMaterial(allergyArr[i]);
								list[i].addAll((ArrayList<Food>) foodService.findFoodByMaterial(vo));
//								result = (ArrayList<Food>) foodService.findAllFood();
							}
							else {//체크 되있고, 전체검색에 검색어있을때
								vo = new Food();
								vo.setName(text);
								vo.setMaker(text);
								vo.setMaterial(text);
								vo.setAllergy(allergyArr[i]);
								list[i].addAll((ArrayList<Food>) foodService.findFoodByMaterialAndMaterial(vo));
								list[i].addAll((ArrayList<Food>) foodService.findFoodByMakerAndMaterial(vo));
								list[i].addAll((ArrayList<Food>) foodService.findFoodByNameAndMaterial(vo));
							}
							break;
					}// switch	
				}//for
				int pivot = -1;
				result = new ArrayList<>();
				result2 = new ArrayList<>();
				result2.addAll(list[0]);
				System.out.println();
				result.addAll(result2);
				System.out.print("제거 작업 전 result : ");
				for(int j=0;j<result.size();j++) {
					System.out.print(result.get(j).getName()+" ");
				}
				if(pivot<allergyArr.length-1) {
					for(int i=pivot+1;i<allergyArr.length;i++) {
						int removeCnt = 0;
						for(int j=0;j<result2.size();j++) {
							boolean isMatch = false;
							for(int k=0;k<list[i].size();k++) {
								if(result2.get(j).getName().equals(list[i].get(k).getName())) {
									isMatch = true;
									break;
								}
							}
							if(!isMatch) {
								result.remove(j-removeCnt);
								removeCnt++;
							}
						}
					}
				}
				System.out.print("제거 작업 후 result : ");
				for(int j=0;j<result.size();j++) {
					System.out.print(result.get(j).getName()+" ");
				}
				System.out.println();
			}///checkbox if
			
			
			if(result==null) {
				return new ModelAndView("ProductItems").
						addObject("foods", result).
						addObject("field", field).
						addObject("text", text).
						addObject("size", 0);
			}else {
				return new ModelAndView("ProductItems").
						addObject("foods", result).
						addObject("field", field).
						addObject("text", text).
						addObject("size", result.size());
			}
		}catch(Exception e) {
			System.out.println(e);
			return new ModelAndView("Error", "msg", "결과가 없습니다.");
		}
	}
}
