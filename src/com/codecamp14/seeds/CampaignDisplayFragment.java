package com.codecamp14.seeds;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class CampaignDisplayFragment extends Fragment {
	WebView webView;
	protected String url;
	public CampaignDisplayFragment(String url) {
		this.url=url;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView=inflater.inflate(R.layout.fragment_campaignview, container, false);	
		webView=(WebView) rootView.findViewById(R.id.campaignView);
		WebSettings settings=webView.getSettings();
		settings.setJavaScriptCanOpenWindowsAutomatically(true);
		String title=webView.getTitle();
		getActivity().setTitle(title);
		settings.setJavaScriptEnabled(true);
		webView.loadUrl(url);
		return rootView;
	}
//	private class MyWebClient extends WebViewClient
	

}
