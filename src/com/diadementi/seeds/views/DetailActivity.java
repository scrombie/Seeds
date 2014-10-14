package com.diadementi.seeds.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.codecamp14.seeds.R;
import com.diadementi.seeds.controllers.CampaignFragment;
import com.diadementi.seeds.views.DetailsFragment.MODE;
import com.diadementi.seeds.views.ListFragment.Type;

public class DetailActivity extends ActionBarActivity {
	Intent i;
	Type t=Type.PUB;
	String mode="view";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);
		i=getIntent();
		String type=i.getExtras().containsKey("type")?i.getStringExtra("type"):"PUB";
		t=Type.valueOf(type);
		mode=i.getExtras().containsKey("mode")?i.getStringExtra("mode"):mode;
		if (savedInstanceState == null) {
			mode=i.getExtras().containsKey("mode")?i.getStringExtra("mode"):mode;
//			mode = i.getStringExtra("mode");
//			mode=TextUtils.isEmpty(mode)?"view":mode;
				
				switch (mode) {
				case "add":
					getSupportFragmentManager().beginTransaction()
							.add(R.id.container, new CampaignFragment())
							.commit();
					break;
				case "edit":
					getSupportFragmentManager().beginTransaction()
							.add(R.id.container, new CampaignFragment())
							.commit();
					break;
				default:
					String url = i.getStringExtra("url");
					getSupportFragmentManager().beginTransaction()
							.add(R.id.container, t.equals(Type.PRI)?new DetailsFragment(url,MODE.PRI):new DetailsFragment(url))
							.commit();
				}
//			}
			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.campaign_display, menu);
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
}
