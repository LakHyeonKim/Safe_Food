package com.ssafy.rest.api;

import java.util.List;

import com.ssafy.rest.vo.CookedFood;
import com.ssafy.rest.vo.CrawlingFoodMaterial;

public class FoodRelation {
	private List<CrawlingFoodMaterial> crawlingFoodMaterial;
	private CookedFood cookedFood;
	private String img;
	private String bestGuessLabel;
	private float rating;
	
	
	public FoodRelation(List<CrawlingFoodMaterial> crawlingFoodMaterial, CookedFood cookedFood, String img,
			String bestGuessLabel, float rating) {
		super();
		this.crawlingFoodMaterial = crawlingFoodMaterial;
		this.cookedFood = cookedFood;
		this.img = img;
		this.bestGuessLabel = bestGuessLabel;
		this.rating = rating;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public FoodRelation() {
		super();
	}

	public FoodRelation(List<CrawlingFoodMaterial> crawlingFoodMaterial, CookedFood cookedFood, String img,
			String bestGuessLabel) {
		super();
		this.crawlingFoodMaterial = crawlingFoodMaterial;
		this.cookedFood = cookedFood;
		this.img = img;
		this.bestGuessLabel = bestGuessLabel;
	}

	public List<CrawlingFoodMaterial> getCrawlingFoodMaterial() {
		return crawlingFoodMaterial;
	}

	public void setCrawlingFoodMaterial(List<CrawlingFoodMaterial> crawlingFoodMaterial) {
		this.crawlingFoodMaterial = crawlingFoodMaterial;
	}

	public CookedFood getCookedFood() {
		return cookedFood;
	}

	public void setCookedFood(CookedFood cookedFood) {
		this.cookedFood = cookedFood;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getBestGuessLabel() {
		return bestGuessLabel;
	}

	public void setBestGuessLabel(String bestGuessLabel) {
		this.bestGuessLabel = bestGuessLabel;
	}

	@Override
	public String toString() {
		return "FoodRelation [crawlingFoodMaterial=" + crawlingFoodMaterial + ", cookedFood=" + cookedFood + ", img="
				+ img + ", bestGuessLabel=" + bestGuessLabel + ", rating=" + rating + "]";
	}

}
