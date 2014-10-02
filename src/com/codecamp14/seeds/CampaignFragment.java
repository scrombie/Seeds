<<<<<<< HEAD
//
package com.codecamp14.seeds;

import java.io.File;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
=======
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
>>>>>>> 5646baddf2d9c0fe2d5ba15e083889fd6908408d
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
<<<<<<< HEAD
import android.widget.TextView;
import android.widget.Toast;

import com.codecamp.libs.RestClient;
import com.codecamp.libs.RestClient.RequestMethod;

=======
import android.widget.Toast;

>>>>>>> 5646baddf2d9c0fe2d5ba15e083889fd6908408d
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

<<<<<<< HEAD
	//	JSONParser jsonParser = new JSONParser();
	EditText inputName, inputAmount, numOfDays, inputArticle;
	Button btnStartCampaign,imageload;
	ProgressDialog pDialog;
	private static final int SELECT_FILE1 = 1;
	String selectedPath1 = "NONE";
	String selectedType="None";
	TextView selectedPathView;

	// url to create new product
	//	private static String url_create_campaign = "http://www.etrademanager.com/connect/create_product.php";
	//	commented by val
	private static final String TAG_MESSAGE = "message";
	private static final String TAG_SUCCESS = "response";


=======
	JSONParser jsonParser = new JSONParser();
	EditText inputName, inputAmount, numOfDays, inputArticle;
	Button btnStartCampaign;
	ProgressDialog pDialog;

	// url to create new product
//	private static String url_create_campaign = "http://www.etrademanager.com/connect/create_product.php";
//	commented by val
//	private static final String TAG_SUCCESS = "success";
	private static final String TAG_SUCCESS = "response";

>>>>>>> 5646baddf2d9c0fe2d5ba15e083889fd6908408d
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
<<<<<<< HEAD
		selectedPathView=(TextView)rootView.findViewById(R.id.selectedPath);

		imageload=(Button)rootView.findViewById(R.id.imageload);
		imageload.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				openGallery(SELECT_FILE1);


			}
		});
=======

>>>>>>> 5646baddf2d9c0fe2d5ba15e083889fd6908408d
		btnStartCampaign = (Button) rootView
				.findViewById(R.id.btnStartCampaign);
		btnStartCampaign.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
<<<<<<< HEAD

=======
>>>>>>> 5646baddf2d9c0fe2d5ba15e083889fd6908408d
				new StartCampaign().execute();
			}
		});
		return rootView;
	}
<<<<<<< HEAD
	public void openGallery(int req_code){
		Intent intent =new Intent();
		intent.setType("image/*");
		intent.setAction(Intent.ACTION_GET_CONTENT);
		startActivityForResult(Intent.createChooser(intent,"Select image to upload"), req_code);
	}
	public String[] getFileInfo(Uri uri) {
		String[] projection = { MediaStore.Images.Media.DATA,MediaStore.Images.Media.MIME_TYPE };
		Cursor cursor = getActivity().getContentResolver().query(uri, projection, null, null, null);
		int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
		int index=cursor.getColumnIndexOrThrow(MediaStore.Images.Media.MIME_TYPE);

		cursor.moveToFirst();
		String info[]={cursor.getString(column_index),cursor.getString(index)};
		//        return cursor.getString(column_index);
		return info;
	}


	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		if(resultCode==Activity.RESULT_OK){
			Uri selectedImageUri = data.getData();
			if (requestCode == SELECT_FILE1)
			{	
				String[] selectedinfo=getFileInfo(selectedImageUri);
				selectedPath1 =selectedinfo[0];
				selectedType=selectedinfo[1];
				selectedPathView.setText(selectedPath1);
			}

		}
		super.onActivityResult(requestCode, resultCode, data);
	}
	private boolean isNetworkAvailable() {
		ConnectivityManager connectMan=(ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkinfo=connectMan.getActiveNetworkInfo();
		boolean isAvailable=false;
		if(networkinfo != null&&networkinfo.isConnected()){
			isAvailable=true;
		}
		return isAvailable;
	}


	public class StartCampaign extends AsyncTask<String, String, String> {
		boolean respondcheck=false;
=======

	public class StartCampaign extends AsyncTask<String, String, String> {

>>>>>>> 5646baddf2d9c0fe2d5ba15e083889fd6908408d
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			pDialog = new ProgressDialog(getActivity());
			pDialog.setMessage("Starting Campaign...");
<<<<<<< HEAD
=======
			pDialog.setIndeterminate(false);
>>>>>>> 5646baddf2d9c0fe2d5ba15e083889fd6908408d
			pDialog.setCancelable(true);
			pDialog.show();
		}

		@Override
		protected String doInBackground(String... args) {
			// TODO Auto-generated method stub
<<<<<<< HEAD
			String response;
=======
>>>>>>> 5646baddf2d9c0fe2d5ba15e083889fd6908408d
			String title = inputName.getText().toString();
			String amount = inputAmount.getText().toString();
			int days = numOfDays.getInputType();
			String article = inputArticle.getText().toString();
<<<<<<< HEAD
			RestClient client =new RestClient(UrlLink.createCampaign);
			client.AddParam("title", title);
			client.AddParam("goal", amount);
			client.AddParam("goal_duration",Integer.toString(days));
			client.AddParam("category", Integer.toString(1));
			client.AddParam("brief", article);
			File image=new File(selectedPath1);
			if(image.isFile()){
				client.AddFile("photos", image, selectedType);
			}
			try{
				if(isNetworkAvailable()){
					client.Execute(RequestMethod.MultiPartPOST);
					int responseCode=client.getResponseCode();
					if(responseCode==200||responseCode==400||responseCode==201){
						response=client.getResponse();
						return response;
					}
				}
				else{
					pDialog.dismiss();
					Toast.makeText(getActivity(), ""+client.getErrorMessage(), Toast.LENGTH_LONG).show();
				}

			}catch(Exception ex){
				ex.printStackTrace();
				Log.e("exception","this" ,ex);

			}
			return null;

		}

=======

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
>>>>>>> 5646baddf2d9c0fe2d5ba15e083889fd6908408d

		@Override
		protected void onPostExecute(String result){
			// TODO Auto-generated method stub
			super.onPostExecute(result);
<<<<<<< HEAD
			String show="";
			String title="";
			if(!TextUtils.isEmpty(result)){
				try {
					JSONObject json=new JSONObject(result);
					int responseTest=json.getInt(TAG_SUCCESS);
					switch(responseTest){
					case 1:
						title=
						show=json.getString(TAG_MESSAGE);
						break;
					case 0:
						show=json.getString(TAG_MESSAGE);
						break;
					}

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
			}else{
				title="Oop!!";
				show="Unable to connect, Please try again";
			}
			pDialog.dismiss();
			AlertDialog.Builder adiag=new AlertDialog.Builder(getActivity());
			adiag.setTitle(!TextUtils.isEmpty(title)?title:null);
			adiag.setMessage(show);
			adiag.setCancelable(true);
			adiag.create();
			adiag.show();

=======
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
>>>>>>> 5646baddf2d9c0fe2d5ba15e083889fd6908408d
		}

	}

}
