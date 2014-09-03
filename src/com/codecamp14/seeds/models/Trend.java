package com.codecamp14.seeds.models;

public class Trend {
	private String trendingTitle;
	private String trendingCat;
	private int trendingPic;
	
	
	public void setTrendingTitle(String trendingTitle) {
		this.trendingTitle = trendingTitle;
	}


	public void setTrendingCat(String trendingCat) {
		this.trendingCat = trendingCat;
	}


	public void setTrendingPic(int trendingPic) {
		this.trendingPic = trendingPic;
	}


	public String getTrendingTitle() {
		return trendingTitle;
	}


	public String getTrendingCat() {
		return trendingCat;
	}


	public int getTrendingPic() {
		return trendingPic;
	}


	public Trend(String trendingTitle, String trendingCat, int trendingPic) {
		super();
		this.trendingTitle = trendingTitle;
		this.trendingCat = trendingCat;
		this.trendingPic = trendingPic;
	};
}
