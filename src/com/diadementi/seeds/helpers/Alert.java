package com.diadementi.seeds.helpers;

import org.apache.http.util.TextUtils;

import android.app.AlertDialog;
import android.content.Context;

public class Alert {
	public static void showAlert(Context context,String message, String title){
		AlertDialog.Builder alert=new AlertDialog.Builder(context);
		alert.setTitle(!TextUtils.isEmpty(title)?title:null);
		alert.setPositiveButton(android.R.string.ok, null);
		alert.setMessage(message);
		alert.create();
		alert.show();
	}
}