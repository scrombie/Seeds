package com.diadementi.seeds.helpers;

import org.apache.http.util.TextUtils;

import android.app.AlertDialog;
import android.content.Context;

public class Alert {
	public static void showAlert(Context context,String message, String title){
		AlertDialog.Builder alert=new AlertDialog.Builder(context);
		alert.setTitle(!TextUtils.isEmpty(title)?title:null);
<<<<<<< HEAD
		alert.setPositiveButton(android.R.string.ok, null);
=======
>>>>>>> 69f32f195192c99b221cb45cfb557bf26bba6fc1
		alert.setMessage(message);
		alert.create();
		alert.show();
	}
}