package com.diadementi.seeds.helpers;

public  class UrlLink {

	public static	final	String featured="http://seeds.diadementi.com/v2/featured";
	public final static	String  Campaigns="http://seeds.diadementi.com/v2/campaigns";
	public static final	String add="http://seeds.diadementi.com/v2/ncampaign";
	public static final String update ="http://seeds.diadementi.com/v2/campaign/" ;
	public static final String delete = "http://seeds.diadementi.com/v2/campaign/";
	private static String campaign="http://seeds.diadementi.com/v2/campaign/";
	private static String category="http://seeds.diadementi.com/v2/category/";
	public static String catergories="http://seeds.diadementi.com/v2/categories";
	public static final String register="http://seeds.diadementi.com/v2/register";
	public static final String login="http://seeds.diadementi.com/v2/login";
	public static final String usersCampaign="http://seeds.diadementi.com/v2/mycampaign";
	public static final String donate ="http://seeds.diadementi.com/v2/donation" ;

	public static String getCategory(int id) {
		return category+id;
	}
	public static String getCampaign(int id) {
		return campaign+id;
	}
	public static String getCampaignView(int id){
		return "http://seeds.diadementi.com/v2/mcampaign/"+id;
	}

	public static String update(int id){
		return update+id;
	}
	public static String delete(int id){
		return delete+id;
	}

}
