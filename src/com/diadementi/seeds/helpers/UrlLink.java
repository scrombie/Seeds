package com.diadementi.seeds.helpers;

public  class UrlLink {

<<<<<<< HEAD
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
=======
	public static	final	String featured="http://192.168.56.1/seeds3/v2/featured";
	public final static	String  getCampaigns="http://192.168.43.146/seeds3/v2/getCampaigns";
	public static final	String createCampaign="http://10.0.2.2/seeds3/v2/createCampaign";
	public static final String update ="http://192.168.56.1/seeds3/v2/Campaign" ;
	public static final String delete = "http://192.168.56.1/seeds3/v2/Campaign/";
	private static String campaign="http://192.168.43.146/seeds3/v2/getCampaign/";
	private static String category="http://192.168.43.146/seeds3/v2/getCategory/";
	public static String catergory="http://192.168.43.146/seeds3/v2/categories";
>>>>>>> 69f32f195192c99b221cb45cfb557bf26bba6fc1
	public static String getCategory(int id) {
		return category+id;
	}
	public static String getCampaign(int id) {
		return campaign+id;
	}
	public static String getCampaignView(int id){
		return "http://192.168.56.1/seeds3/v2/mcampaign/"+id;
	}
<<<<<<< HEAD
	public static String update(int id){
		return update+id;
	}
	public static String delete(int id){
		return delete+id;
	}
=======
	
>>>>>>> 69f32f195192c99b221cb45cfb557bf26bba6fc1


}
