package com.codecamp14.seeds.models;

public class Project {

	private String title;
	private String description;
	private String article;
	private boolean trending;

	public Project(String title, String description, String article, boolean trending) {
		this.title = title;
		this.description = description;
		this.article = article;
		this.trending = trending;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public boolean isTrending() {
		return trending;
	}

	public void setTrending(boolean trending) {
		this.trending = trending;
	}
}
