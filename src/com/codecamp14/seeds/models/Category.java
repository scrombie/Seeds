package com.codecamp14.seeds.models;

public class Category {
	private int id;
	String Name;
	String catdesc;
	
	
	
	public Category(int id,String category, String catdesc) {
		super();
		this.setId(id);
		this.Name = category;
		this.catdesc = catdesc;
	}
	public Category(int id,String category){
		this(id,category,"");
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
	public String getName() {
		return Name;
	}
	public String getCatdesc() {
		return catdesc;
	}
	public void setName(String category) {
		this.Name = category;
	}
	public void setCatdesc(String catdesc) {
		this.catdesc = catdesc;
	}
}
