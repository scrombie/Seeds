package com.codecamp14.seeds.models;

public class Browse {
	String category;
	String catdesc;
	
	
	
	public Browse(String category, String catdesc) {
		super();
		this.category = category;
		this.catdesc = catdesc;
	}
	public String getCategory() {
		return category;
	}
	public String getCatdesc() {
		return catdesc;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setCatdesc(String catdesc) {
		this.catdesc = catdesc;
	}
}
