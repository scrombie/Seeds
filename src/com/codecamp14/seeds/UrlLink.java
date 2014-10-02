package com.codecamp14.seeds;

public  class UrlLink {
<<<<<<< HEAD
	public static	final	String featured="http://10.0.2.2/seeds3/v2/featured";
	public final static	String  getCampaigns="http://192.168.43.146/seeds3/v2/getCampaigns";
	public static final	String createCampaign="http://10.0.2.2/seeds3/v2/createCampaign";
	private static String campaign="http://192.168.43.146/seeds3/v2/getCampaign/";
	private static String category="http://192.168.43.146/seeds3/v2/getCategory/";
	public static String catergory="http://192.168.43.146/seeds3/v2/categories";
	public static String getCategory(int id) {
		return category+id;
	}
	public static String getCampaign(int id) {
		return campaign+id;
	}
	

=======
	public static	final	String featured="http://192.168.43.146/seeds3/v2/featured";
	public final static	String  getCampaigns="http://localhost/seed3/v2/getCampaigns";
	public static final	String createCampaign="http://192.168.43.146/seed3/v2/createCampaign";
	
>>>>>>> 5646baddf2d9c0fe2d5ba15e083889fd6908408d
}
