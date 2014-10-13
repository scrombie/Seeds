package com.diadementi.seeds.views;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.codecamp14.seeds.R;
import com.diadementi.seeds.helpers.UrlLink;
import com.diadementi.seeds.models.Campaign;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new ListFragment(UrlLink.featured)).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		switch (id) {
	    // Respond to the action bar's Up/Home button
	    case android.R.id.home:
	        NavUtils.navigateUpFromSameTask(this);
	        return true;
		case R.id.action_settings: 
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	public void displayCampaign(AdapterView<?> parent, int position) {
		Campaign c=(Campaign)parent.getItemAtPosition(position);
		FragmentTransaction f=getSupportFragmentManager().beginTransaction();
		String url=UrlLink.getCampaignView(c.getId());
		Fragment campaign=new DetailsFragment(url);
		f.replace(R.id.container, campaign);
		f.addToBackStack(null);
		f.commit();
	}
	public boolean isNetworkAvailable() {
		ConnectivityManager connectMan=(ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkinfo=connectMan.getActiveNetworkInfo();
		boolean isAvailable=false;
		if(networkinfo != null&&networkinfo.isConnected()){
			isAvailable=true;
		}
		return isAvailable;
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}
	
}
