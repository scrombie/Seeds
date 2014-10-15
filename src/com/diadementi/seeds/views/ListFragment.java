/**
 * 
 */
package com.diadementi.seeds.views;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
<<<<<<< HEAD
import android.content.SharedPreferences;
=======
>>>>>>> 69f32f195192c99b221cb45cfb557bf26bba6fc1
import android.content.res.Resources.NotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.codecamp.libs.RestClient;
import com.codecamp.libs.RestClient.RequestMethod;
import com.codecamp14.seeds.R;
import com.diadementi.seeds.helpers.Alert;
import com.diadementi.seeds.helpers.CampaignAdapter;
import com.diadementi.seeds.helpers.UrlLink;
import com.diadementi.seeds.models.Campaign;
import com.google.gson.Gson;



/**
 * @author user pc
 * 
 */
public class ListFragment extends Fragment {
	ListView list;
	ProgressBar pBar;
	ArrayList<Campaign> data;
	CampaignAdapter adapter;
	String url;
	private Type type;
	public static enum Type{
		PRI,PUB;
	}
<<<<<<< HEAD
	public static final String PREFS_NAME = "MyPrefsFile";
	SharedPreferences shared;
	String apiKey;
=======
>>>>>>> 69f32f195192c99b221cb45cfb557bf26bba6fc1
	/**
	 * 
	 */
	ListFragment(){
<<<<<<< HEAD
		this(UrlLink.Campaigns);
=======
		this(UrlLink.getCampaigns);
>>>>>>> 69f32f195192c99b221cb45cfb557bf26bba6fc1
	}
	public ListFragment(String url) {
		// TODO get adapter at instantiation or onCreate
		data = new ArrayList<Campaign>();
		setHasOptionsMenu(true);
		this.url=url;
		this.type=Type.PUB;
	}
	public ListFragment(String url,Type type) {
		// TODO get adapter at instantiation or onCreate
		data = new ArrayList<Campaign>();
		setHasOptionsMenu(true);
		this.url=url;
		this.type=type;
	}

<<<<<<< HEAD
	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO 
		shared=getActivity().getSharedPreferences(PREFS_NAME, 0);
		apiKey=shared.getString("api_key", null);
		super.onCreate(savedInstanceState);
	}
=======
>>>>>>> 69f32f195192c99b221cb45cfb557bf26bba6fc1
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater,
	 * android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		final View rootView = inflater.inflate(R.layout.fragment_main,
				container, false);

		list = (ListView) rootView.findViewById(R.id.campaignList);
		pBar = (ProgressBar) rootView.findViewById(R.id.progressBar);
		 pBar.setVisibility(View.INVISIBLE);
		adapter = new CampaignAdapter(getActivity(), R.layout.list_row, data);

		list.setAdapter(adapter);
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Campaign c=(Campaign)parent.getItemAtPosition(position);
				String url=UrlLink.getCampaignView(c.getId());
				Intent i=new Intent(getActivity(),DetailActivity.class);
				String json=new Gson().toJson(c);
				i.putExtra("type",type.toString());
				i.putExtra("json", json);
				i.putExtra("url", url);
				int requestCode=0;
				startActivityForResult(i, requestCode);
//				((MainActivity) getActivity())
//				.displayCampaign(parent, position);

			}
		});
		makeRequest(url);
		return rootView;

	}
	public boolean isNetworkAvailable() {
		ConnectivityManager connectMan=(ConnectivityManager)getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkinfo=connectMan.getActiveNetworkInfo();
		boolean isAvailable=false;
		if(networkinfo != null&&networkinfo.isConnected()){
			isAvailable=true;
		}
		return isAvailable;
	}

	/**
	 * @throws NotFoundException
	 */
	public void makeRequest(String url) throws NotFoundException {
		if (isNetworkAvailable()) {
			new CampaignFetch().execute(url);
		} else {
			Alert.showAlert(getActivity(),getString(R.string.noConnection),null);
		}
	}
	


	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onActivityResult(int, int, android.content.Intent)
	 */
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		if(resultCode==Activity.RESULT_OK){
			Alert.showAlert(getActivity(), "I got an answer", null);
		}
		super.onActivityResult(requestCode, resultCode, data);
	}
	/* 
	 * 
	 */
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// TODO Auto-generated method stub
		if(this.type.equals(Type.PRI)){
			inflater.inflate(R.menu.list_pri, menu);
		}else{
			inflater.inflate(R.menu.list, menu);
		}

	}

	/* 
	 * 
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		int itemId=item.getItemId();
		switch(itemId){
		case R.id.action_new:
			add();
			break;
		case R.id.action_edit:
			edit();
		}
		return super.onOptionsItemSelected(item);
	}



	private void edit() {
		// TODO Auto-generated method stub
		Intent intent=new Intent(getActivity(),DetailActivity.class);
		intent.putExtra("mode", "edit");
		startActivity(intent);
	}
	private void add() {
		// TODO Auto-generated method stub
		Intent intent=new Intent(getActivity(),DetailActivity.class);
		intent.putExtra("mode", "add");
		startActivity(intent);
	}



	class CampaignFetch extends AsyncTask<String, Void, String> {

		private RestClient dami;
		private String text;
		private ArrayList<Campaign> dataS;
		private String response = null;

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			pBar.setVisibility(View.VISIBLE);
			pBar.setIndeterminate(true);
			dataS = new ArrayList<Campaign>();
		}

		@Override
		protected String doInBackground(String... url) {
			// TODO Auto-generated method stub

			return request(url);

		}

		/**
		 * @param url
		 * @return
		 */
		private String request(String... url) {
			dami = new RestClient(url[0]);
<<<<<<< HEAD
			dami.AddHeader("Authorization", apiKey);
			
=======
>>>>>>> 69f32f195192c99b221cb45cfb557bf26bba6fc1
			try {
				dami.Execute(RequestMethod.GET);

				text = dami.getResponse();
				Log.i("json data", text);
				Log.e("myseeds fragment error", "problem with response");

				JSONObject mainObject = new JSONObject(text);
				mainObject.get("response");
				JSONArray dataObject = mainObject.getJSONArray("data");

				for (int i = 0; i < dataObject.length(); i++) {
					dataS.add(new Campaign()
					.getInstance((JSONObject) dataObject.get(i)));
				}
				return response = "successful";
			} catch (Exception ex) {
				return response;
			}
		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			// adapter.addAll(dataS);
			if (!TextUtils.isEmpty(result)) {
				data.addAll(dataS);
				Log.e("arraylist ", data.toString());
				adapter.notifyDataSetChanged();
			} else {
				result = "Unable to Connect";
				Alert.showAlert(getActivity(), result,null);
			}
			pBar.setVisibility(View.GONE);
			//Toast.makeText(getActivity(), result, Toast.LENGTH_LONG).show();	
		}
	}

}
