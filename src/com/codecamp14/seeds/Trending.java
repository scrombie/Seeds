package com.codecamp14.seeds;

import java.util.ArrayList;
import java.util.List;

import com.codecamp14.seeds.models.Trend;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Trending extends Fragment {
	
	ListView Trendlist;
	ImageView Trendingimg;
	TextView Trendingtv;
	TextView Trendingcat;
	
	private static List<Trend> trending = new ArrayList<Trend>();
	
	
	
	public Trending(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_trending, container, false);
        Trendlist = (ListView) rootView.findViewById(R.id.TrenidnglistView1);
		trendHomeList();
		trendListView();
		
		Trendlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(getActivity(), position +" was Clicked", Toast.LENGTH_SHORT).show();
			}
			
		});
		
        return rootView;
    }

	private void trendListView() {
		// TODO Auto-generated method stub
		trending.add(new Trend("Thank you Jesus", "TECHNOLOGY",
				R.drawable.ayocanc));
		trending.add(new Trend("Mathew Gush", "HEALTH/MEDICAL",
				R.drawable.ayocanc));
		trending.add(new Trend("Process dot PHP", "ARTS",
				R.drawable.ayocanc));
		trending.add(new Trend("Bernard the Python guy", "BOOKS",
				R.drawable.ayocanc));
		trending.add(new Trend("Android App Dev", "SME/SMALL BUSINESS",
				R.drawable.ayocanc));
		trending.add(new Trend("I want to learn Python", "NO P",
				R.drawable.ayocanc));
		trending.add(new Trend("This man", "THANKS",
				R.drawable.ayocanc));
		trending.add(new Trend(getTag(), getTag(), 0));
	}

	private void trendHomeList() {
		// TODO Auto-generated method stub
		ArrayAdapter<Trend> adapter = new TrendingListAdapter();
//		String[] a= {"a","b","c"};
//		ArrayAdapter<String> array = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, a);
		Trendlist.setAdapter(adapter);
	}
	private class TrendingListAdapter extends ArrayAdapter<Trend> {

		public TrendingListAdapter() {
			super(getActivity(), R.layout.list_trending, trending);
			
			// TODO Auto-generated constructor stub
		}
}
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View itemView = convertView;
		if (itemView == null) {
			itemView = getActivity().getLayoutInflater().inflate(
					R.layout.list_trending, parent, false);
		}
		
		Trendingimg = (ImageView) itemView.findViewById(R.id.TrendingimageView);
		Trendingtv = (TextView) itemView.findViewById(R.id.TrendingTextViewtitle);
		//Trendingcat = (TextView) itemView.findViewById(R.id.TrendingtextView);
		
		
		Trend setStuff = trending.get(position);
		
		Trendingimg.setImageResource(setStuff.getTrendingPic());

		Trendingtv.setText(setStuff.getTrendingTitle());
		Trendingcat.setText(setStuff.getTrendingCat());
		return itemView;
	}
}