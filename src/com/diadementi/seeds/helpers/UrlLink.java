package com.diadementi.seeds.helpers;

public  class UrlLink {

	public static	final	String featured="http://192.168.56.1/seeds3/v2/featured";
	public final static	String  Campaigns="http://192.168.43.146/seeds3/v2/Campaigns";
	public static final	String createCampaign="http://192.168.56.1/seeds3/v2/campaign";
	public static final String update ="http://192.168.56.1/seeds3/v2/campaign/" ;
	public static final String delete = "http://192.168.56.1/seeds3/v2/Campaign/";
	private static String campaign="http://192.168.43.146/seeds3/v2/campaign/";
	private static String category="http://192.168.43.146/seeds3/v2/Category/";
	public static String catergories="http://192.168.43.146/seeds3/v2/categories";
	public static final String register="http://192.168.56.1/seeds3/v2/register";
	public static final String login="http://192.168.56.1/seeds3/v2/login";
	public static String getCategory(int id) {
		return category+id;
	}
	public static String getCampaign(int id) {
		return campaign+id;
	}
	public static String getCampaignView(int id){
		return "http://192.168.56.1/seeds3/v2/mcampaign/"+id;
	}
	


}
