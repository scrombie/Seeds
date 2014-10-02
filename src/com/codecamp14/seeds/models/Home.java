package com.codecamp14.seeds.models;

public class Home {
	private String title;
	private String category;
	private int icon;
	
	
	public Home(String title, String category, int icon) {
		super();
		this.title = title;
		this.category = category;
		this.icon = icon;
	}
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public int getIcon() {
		return this.icon;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setIcon(int icon) {
		this.icon = icon;
	}
}
