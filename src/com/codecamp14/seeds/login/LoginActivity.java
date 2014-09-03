package com.codecamp14.seeds.login;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.codecamp14.seeds.MainActivity;
import com.codecamp14.seeds.R;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class LoginActivity extends Activity {
	
	protected EditText mUsername;
	protected EditText mPassword;
	protected Button loginButton;
	
	protected TextView mSignUpTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		mSignUpTextView = (TextView)findViewById(R.id.signUP);
		mSignUpTextView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(LoginActivity.this,SignUpActivity.class);
				startActivity(i);
			}
		});
		mUsername = (EditText)findViewById(R.id.usernameField);
		mPassword = (EditText)findViewById(R.id.passwordField);
		loginButton = (Button)findViewById(R.id.button1);
		
		
		loginButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String username = mUsername.getText().toString();
				String password = mPassword.getText().toString();
				
				username = username.trim();
				password = password.trim();
				
				if(username.isEmpty() || password.isEmpty()){
					AlertDialog.Builder aDialog = new AlertDialog.Builder(LoginActivity.this);
					aDialog.setTitle("Error!!!");
					aDialog.setMessage("Please make sure you input your Username and Password.");
					aDialog.setPositiveButton(android.R.string.ok, null);
					AlertDialog dialog = aDialog.create();
					dialog.show();
				}
				else {
					//Login
					ParseUser.logInInBackground(username, password, new LogInCallback(){

						@Override
						public void done(ParseUser user, ParseException e) {
							// TODO Auto-generated method stub
							if(e == null){
							//Success
								Intent i = new Intent(LoginActivity.this, MainActivity.class);
								i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
								i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
								startActivity(i);
							}else{
								AlertDialog.Builder aDialog = new AlertDialog.Builder(LoginActivity.this);
								aDialog.setTitle("Error!!!");
								aDialog.setMessage(e.getMessage());
								aDialog.setPositiveButton(android.R.string.ok, null);
								AlertDialog dialog = aDialog.create();
								dialog.show();
							}
						}
						
					});
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
