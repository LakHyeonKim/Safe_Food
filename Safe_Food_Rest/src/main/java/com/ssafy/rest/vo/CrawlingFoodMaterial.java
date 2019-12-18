package com.ssafy.rest.vo;

public class CrawlingFoodMaterial {
	private int no;
	private String name;
	private String foodmMaterial;
	private String recipe;
	private String img;
	
	public CrawlingFoodMaterial() {
		super();
	}
	
	public CrawlingFoodMaterial(String name, String foodmMaterial, String recipe, String img) {
		super();
		this.name = name;
		this.foodmMaterial = foodmMaterial;
		this.recipe = recipe;
		this.img = img;
	}

	public CrawlingFoodMaterial(int no, String name, String foodMaterial, String recipe, String img) {
		super();
		this.no = no;
		this.name = name;
		this.foodmMaterial = foodMaterial;
		this.recipe = recipe;
		this.img = img;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFoodMaterial() {
		return foodmMaterial;
	}
	public void setFoodMaterial(String foodMaterial) {
		this.foodmMaterial = foodMaterial;
	}
	public String getRecipe() {
		return recipe;
	}
	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	@Override
	public String toString() {
		return "CrawlingFoodMaterial [no=" + no + ", name=" + name + ", foodMaterial=" + foodmMaterial + ", recipe=" + recipe
				+ ", img=" + img + "]";
	}
}
