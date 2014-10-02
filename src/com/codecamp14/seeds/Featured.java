package com.codecamp14.seeds;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.codecamp.libs.RestClient;
import com.codecamp.libs.RestClient.RequestMethod;
import com.squareup.picasso.Picasso;

import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Featured extends Fragment {
	ArrayList<Campaign> data;
	CampaignAdapter adapter;
		
	ListView list;
	public Featured() {
		data = new ArrayList<Campaign>();
	}

	@Override
	public View onCreateView(final LayoutInflater inflater,  ViewGroup container,
			Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.fragment_featured, container,
				false);

		list = (ListView) rootView.findViewById(R.id.featList);
		adapter = new CampaignAdapter(getActivity(), R.layout.list_item, data);

		list.setAdapter(adapter); 
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Campaign c=(Campaign)parent.getItemAtPosition(position);
				FragmentTransaction f=getFragmentManager().beginTransaction();
				String url="http://10.0.2.2/seeds3/v2/mcampaign/"+c.getId();
				Fragment campaign=new CampaignDisplayFragment(url);
				f.replace(R.id.frame_container, campaign);
				f.addToBackStack(null);
				f.commit();
				
			}
		});

		new FeaturedAsyncTask().execute();
		return rootView;
	}
	
	


	public class FeaturedAsyncTask extends AsyncTask<Void, Void, String>{


		private RestClient dami;
		private String text;
		private ArrayList<Campaign> dataS;
		private String response="unable to connect";
		ProgressDialog pDiag;

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			pDiag = new ProgressDialog(getActivity());
			pDiag.setMessage("Loading..");
			pDiag.show();
			dataS = new ArrayList<Campaign>();
		}



		@Override
		protected String doInBackground(Void... params) {
			// TODO Auto-generated method stub

			dami = new RestClient(UrlLink.featured);
			try{
				dami.Execute(RequestMethod.GET);

				text = dami.getResponse();
				Log.i("json data",text);
				Log.e("myseeds fragment error", "problem with response");

				JSONObject mainObject = new JSONObject(text);
				mainObject.get("response");
				JSONArray dataObject = mainObject.getJSONArray("data");

				for (int i =0; i< dataObject.length() ; i ++){
					dataS.add(new Campaign((JSONObject)dataObject.get(i)));
				}
				return response="successful";
			}
			catch(Exception ex){
				return response;
			}


		}

		@Override
		protected void onPostExecute(String result){
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			//adapter.addAll(dataS);
			data.addAll(dataS);
			Log.e("arraylist ",data.toString());
			adapter.notifyDataSetChanged();
			pDiag.dismiss();
			Toast.makeText(getActivity(), result, Toast.LENGTH_LONG).show();

		}
	}
	public class CampaignAdapter extends ArrayAdapter<Campaign> {
		private Context ctx;
		private int res;
		private ArrayList<Campaign> data;

		public CampaignAdapter(Context context, int resource, ArrayList<Campaign> objects){
			super(context,resource,objects);
			this.ctx=context;
			this.res=resource;
			this.data=objects;
		}
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			View v=convertView;
			if (v==null){
				LayoutInflater vi =(LayoutInflater)this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			
					v=vi.inflate(this.res, null);

			}
					ImageView image=(ImageView)v.findViewById(R.id.imageView1);
			TextView title=(TextView)v.findViewById(R.id.title);
			//		TextView desc=(TextView)v.findViewById(R.id.desc);
			//		TextView creator=(TextView)v.findViewById(R.id.creator);
			//		TextView totalDonation=(TextView)v.findViewById(R.id.totalDonation);
			//		TextView goalDuration=(TextView)v.findViewById(R.id.goalDuration);

			Campaign s=getItem(position);
			//		image.setImageResource(s.getImage());
			title.setText(s.getTitle());
			//		desc.setText(s.getDesc());
			//		creator.setText(s.getCreator());
			//		totalDonation.setText(s.getTotalDonations());
			//		goalDuration.setText(s.getGoalDuration());
			TextView category=(TextView)v.findViewById(R.id.category);
			category.setText("Arts");
			Picasso.with(getActivity())
			  .load(s.getImageUrl())
			  .resize(50, 50)
			  .centerCrop()
			  
			  .placeholder(R.drawable.ebola)
			  .error(R.drawable.ic_launcher)
			  .into(image);
			Log.i("image url",s.getImageUrl());
			return v;
		}
		public Campaign getItem(int i){
			return this.data.get(i);
		}
	}
}

