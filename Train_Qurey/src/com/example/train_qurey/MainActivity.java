package com.example.train_qurey;


import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.view.WindowManager;


public class MainActivity extends Activity {

	View.Welcome wv;
	Handler hd= new Handler(){
	        	public void handlerMessage(Message msg){
	        		switch(msg.what){
	        		case 0:
	        			gotoWelcomeView();
	        	        break;
	        		case 1:
	        			gotoMainMenu();
	        			break;
	        		}
	        	}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		this.hd.sendEmptyMessage(0);

	}
	public void  gotoMainMenu(){
		setContentView(R.layout.activity_main);
	}
	public void gotoWelcomeView(){
		if(wv == null)
			wv = new View.Welcome(MainActivity.this);
		setContentView(wv);
	}


}
