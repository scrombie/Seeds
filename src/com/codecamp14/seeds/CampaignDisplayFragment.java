package com.codecamp14.seeds;

import android.app.AlertDialog;
import android.app.Fragment;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class CampaignDisplayFragment extends Fragment {
	WebView webView;
	ProgressBar pBar;
	protected String url;
	public CampaignDisplayFragment(String url) {
		this.url=url;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView=inflater.inflate(R.layout.fragment_campaignview, container, false);	
		webView=(WebView) rootView.findViewById(R.id.campaignView);
		pBar=(ProgressBar)rootView.findViewById(R.id.progressBar1);
		//pBar.setVisibility(View.GONE);
		pBar.setMax(100);
		WebSettings settings=webView.getSettings();
		settings.setJavaScriptCanOpenWindowsAutomatically(true);
		String title=webView.getTitle();
		getActivity().setTitle(title);
		settings.setJavaScriptEnabled(true);
		webView.setWebChromeClient(new MyWebClient());
		webView.loadUrl(url);
		return rootView;
	}
	private class MyWebClient extends WebChromeClient{

		/* (non-Javadoc)
		 * @see android.webkit.WebChromeClient#onProgressChanged(android.webkit.WebView, int)
		 */
	
		/*	
		 (non-Javadoc)
		 * @see android.webkit.WebViewClient#onReceivedError(android.webkit.WebView, int, java.lang.String, java.lang.String)
		 /**
		 * functions for webclient were commented
		 */
		/*
		@Override
		public void onReceivedError(WebView view, int errorCode,
				String description, String failingUrl) {
			// TODO Handling page not found error
			if (errorCode==ERROR_CONNECT){
				Toast.makeText(getActivity(), "Unable to Connect Check Connection", Toast.LENGTH_LONG).show();
			}else if(errorCode==ERROR_TIMEOUT){
				AlertDialog.Builder adiag=new AlertDialog.Builder(getActivity());
				adiag.setMessage("Unable to connect network timeout");
				adiag.setCancelable(true);
				adiag.create();
				adiag.show();

			}

			//super.onReceivedError(view, errorCode, description, failingUrl);
		}*/
		/*	 (non-Javadoc)
		 * @see android.webkit.WebViewClient#onPageStarted(android.webkit.WebView, java.lang.String, android.graphics.Bitmap)

		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			// TODO Auto-generated method stub
			pBar.setIndeterminate(true);
			pBar.setVisibility(View.VISIBLE);
			pBar.setProgress(0);
			super.onPageStarted(view, url, favicon);
		}
		 (non-Javadoc)
		 * @see android.webkit.WebViewClient#onPageFinished(android.webkit.WebView, java.lang.String)

		@Override
		public void onPageFinished(WebView view, String url) {
			// TODO Auto-generated method stub
			pBar.setVisibility(View.GONE);
			pBar.setProgress(100);
			super.onPageFinished(view, url);*/
	/**
	 * Start of webChromeClient
	 */
		@Override
		public void onProgressChanged(WebView view, int newProgress) {
			// TODO Auto-generated method stub
			if (!(newProgress==100))
			setValue(newProgress);
			else pBar.setVisibility(View.GONE);
			
			super.onProgressChanged(view, newProgress);
		}
		
		
	}


	/**
	 * 
	 * @param progress
	 */

	public void setValue(int progress) {
		pBar.setProgress(progress);
	}
	

}



