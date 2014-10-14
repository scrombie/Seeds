/**
 * 
 */
package com.diadementi.seeds.helpers;

import java.util.Map;

import org.json.JSONObject;

/**
 * @author user pc
 *
 */
public class JSONRequest {

	/** A class that should be used to get json object from a url
	 * which handles all connection problem
	 * 
	 */
	protected String url[];
	protected Map<String,String> params;
	protected JSONObject response;
	public JSONRequest(String...url){
		// TODO Auto-generated constructor stub
		this.url=url;
	}

}
