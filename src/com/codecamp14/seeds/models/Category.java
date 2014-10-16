package com.codecamp14.seeds.models;

public class Category {
	private int id;
	String category;
	String catdesc;
	
	
	
	public Category(int id,String category, String catdesc) {
		super();
		this.setId(id);
		this.category = category;
		this.catdesc = catdesc;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	private void setId(int id) {
		this.id = id;
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
