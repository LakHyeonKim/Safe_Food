package com.ssafy.rest.vo;

public class CookedFood {
	/**식품을 구별하는 코드 */
	protected String code;
	/** 분류 */
	protected String foodGroup;
	/**식품 이름*/
	protected String name;
	
	/**일회 제공 량*/
	protected String supportpareat;
	/**일회 제공되는 칼로리*/
	protected String calory;
	/**일회 제공되는 탄수화물*/
	protected String carbo;
	/**일회 제공되는 단백질*/
	protected String protein;
	/**일회 제공되는 지방*/
	protected String fat;
	/**일회 제공되는 당류*/
	protected String sugar;
	/**일회 제공되는 나트륨*/
	protected String natrium;
	/**일회 제공되는 콜레스테롤*/
	protected String chole;
	/**일회 제공되는 포화지방산*/
	protected String fattyacid;
	/**일회 제공되는 트렌스지방*/
	protected String transfat;
	/**등록년도*/
	protected String year;
	
	public CookedFood() {
		super();
	}
	
	public CookedFood(String code, String foodGroup, String name, String supportpareat, String calory, String carbo,
			String protein, String fat, String sugar, String natrium, String chole, String fattyacid, String transfat,
			String year) {
		super();
		this.code = code;
		this.foodGroup = foodGroup;
		this.name = name;
		this.supportpareat = supportpareat;
		this.calory = calory;
		this.carbo = carbo;
		this.protein = protein;
		this.fat = fat;
		this.sugar = sugar;
		this.natrium = natrium;
		this.chole = chole;
		this.fattyacid = fattyacid;
		this.transfat = transfat;
		this.year = year;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFoodGroup() {
		return foodGroup;
	}

	public void setFoodGroup(String foodGroup) {
		this.foodGroup = foodGroup;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSupportpareat() {
		return supportpareat;
	}

	public void setSupportpareat(String supportpareat) {
		this.supportpareat = supportpareat;
	}

	public String getCalory() {
		return calory;
	}

	public void setCalory(String calory) {
		this.calory = calory;
	}

	public String getCarbo() {
		return carbo;
	}

	public void setCarbo(String carbo) {
		this.carbo = carbo;
	}

	public String getProtein() {
		return protein;
	}

	public void setProtein(String protein) {
		this.protein = protein;
	}

	public String getFat() {
		return fat;
	}

	public void setFat(String fat) {
		this.fat = fat;
	}

	public String getSugar() {
		return sugar;
	}

	public void setSugar(String sugar) {
		this.sugar = sugar;
	}

	public String getNatrium() {
		return natrium;
	}

	public void setNatrium(String natrium) {
		this.natrium = natrium;
	}

	public String getChole() {
		return chole;
	}

	public void setChole(String chole) {
		this.chole = chole;
	}

	public String getFattyacid() {
		return fattyacid;
	}

	public void setFattyacid(String fattyacid) {
		this.fattyacid = fattyacid;
	}

	public String getTransfat() {
		return transfat;
	}

	public void setTransfat(String transfat) {
		this.transfat = transfat;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "CookedFood [code=" + code + ", foodGroup=" + foodGroup + ", name=" + name + ", supportpareat="
				+ supportpareat + ", calory=" + calory + ", carbo=" + carbo + ", protein=" + protein + ", fat=" + fat
				+ ", sugar=" + sugar + ", natrium=" + natrium + ", chole=" + chole + ", fattyacid=" + fattyacid
				+ ", transfat=" + transfat + ", year=" + year + "]";
	}
	
}
