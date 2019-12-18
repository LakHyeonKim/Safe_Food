package com.ssafy.safefood.vo;

public class Member {
	private String id;
	private String password;
	private String name;
	private String address;
	private String allergy;
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Member(String id, String password, String name, String address, String allergy) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
		this.allergy = allergy;
	}
	public Member(String id,String pass) {
		this.id=id;
		this.password=pass;
	}
	public Member(String id) {
		super();
		this.id = id;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", name=" + name + ", address=" + address + ", allergy="
				+ allergy + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAllergy() {
		return allergy;
	}
	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}
	
}
