package com.codecamp14.seeds;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import com.codecamp.libs.RestClient;
import com.codecamp.libs.RestClient.RequestMethod;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CampaignFragment extends Fragment {
	/*{
	"id": "1",
	"title": "Space Rites: Interactive Installation & Performance Series",
	"brief": "Taylor Lee Shepherd's oscilloscopes will translate footsteps, voices and music into responsive visuals in the St. Maurice church.",
	"creator": "New Orleans airlift",
	"goal": "6000",
	"created": "2014-08-26 10:55:00",
	"goal_duration": "2014-09-04",
	"total_donations": "0",
	"total_donors": "0"
	},*/

	JSONParser jsonParser = new JSONParser();
	EditText inputName, inputAmount, numOfDays, inputArticle;
	Button btnStartCampaign;
	ProgressDialog pDialog;

	// url to create new product
//	private static String url_create_campaign = "http://www.etrademanager.com/connect/create_product.php";
//	commented by val
//	private static final String TAG_SUCCESS = "success";
	private static final String TAG_SUCCESS = "response";

	public CampaignFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_campaign, container,
				false);

		Spinner spinner = (Spinner) rootView.findViewById(R.id.categorySpinner);

		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				getActivity(), R.array.spinner_array,
				android.R.layout.simple_spinner_item);

		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);

		inputName = (EditText) rootView.findViewById(R.id.inputName);
		inputAmount = (EditText) rootView.findViewById(R.id.inputAmount);
		numOfDays = (EditText) rootView.findViewById(R.id.numOfDays);
		inputArticle = (EditText) rootView.findViewById(R.id.inputArticle);

		btnStartCampaign = (Button) rootView
				.findViewById(R.id.btnStartCampaign);
		btnStartCampaign.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new StartCampaign().execute();
			}
		});
		return rootView;
	}

	public class StartCampaign extends AsyncTask<String, String, String> {

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			pDialog = new ProgressDialog(getActivity());
			pDialog.setMessage("Starting Campaign...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(true);
			pDialog.show();
		}

		@Override
		protected String doInBackground(String... args) {
			// TODO Auto-generated method stub
			String title = inputName.getText().toString();
			String amount = inputAmount.getText().toString();
			int days = numOfDays.getInputType();
			String article = inputArticle.getText().toString();

/*			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("title", title));
			params.add(new BasicNameValuePair("amount", amount));
			params.add(new BasicNameValuePair("days", String.valueOf(days)));
			params.add(new BasicNameValuePair("article", article));*/

			/*JSONObject json = jsonParser.makeHttpRequest(url_create_campaign,
					"POST", params);*/
			RestClient client =new RestClient(UrlLink.createCampaign);
			client.AddParam("title", title);
			client.AddParam("goal", amount);
			client.AddParam("goalDuration",Integer.toString(days));
			client.AddParam("category", Integer.toString(1));
			client.AddParam("brief", article);
			try{
				client.Execute(RequestMethod.POST);
				String response=client.getResponse();
				return response;
				
			}catch(Exception ex){
				String response=client.getErrorMessage();
				Log.e("exception","this" ,ex);
				return response;
				}
				
			}
			

	/*		Log.d("Create Response", json.toString());
			try {
				int success = json.getInt(TAG_SUCCESS);

				if (success == 1) {
					Intent i = new Intent(getActivity(), BrowseProject.class);
					// i.putExtra("first", title.getText().toString());
					// i.putExtra("second", amount.getText().toString());
					// i.putExtra("third", days.getText().toString());
					// i.putExtra("fourth", article.getText().toString());
					startActivity(i);
					// finish();
				} else {
					Toast.makeText(getActivity(), "Failed to Create " + title,
							Toast.LENGTH_SHORT).show();
				}

			} catch (JSONException e) {
				e.printStackTrace();
			}
			return null;
		}*/

		@Override
		protected void onPostExecute(String result){
			// TODO Auto-generated method stub
			super.onPostExecute(result);
		/*	
			try {
				int success = json.getInt(TAG_SUCCESS);

				if (success == 1) {
					Intent i = new Intent(getActivity(), BrowseProject.class);
					// i.putExtra("first", title.getText().toString());
					// i.putExtra("second", amount.getText().toString());
					// i.putExtra("third", days.getText().toString());
					// i.putExtra("fourth", article.getText().toString());
					startActivity(i);
					// finish();
				} else {
					Toast.makeText(getActivity(), "Failed to Create " + title,
							Toast.LENGTH_SHORT).show();
				}

			} catch (JSONException e) {
				e.printStackTrace();
			}
			return null;
		}*/
			
			pDialog.dismiss();
			AlertDialog.Builder adiag=new AlertDialog.Builder(getActivity());
			adiag.setMessage(result);
			adiag.setCancelable(true);
			adiag.create();
			adiag.show();
		}

	}

}
