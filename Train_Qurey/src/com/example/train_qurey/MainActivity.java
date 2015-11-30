package com.example.train_qurey;


import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

enum WhichView{MAINMENUVIEW,WELCOMEVIEW,ZZCXVIEW,CCCXVIEW,CZCXVIEW,FJGNVIEW,ABOUTVIEW,HELPVIEW,CCTJVIEW,CZTJVIEW,GXTJVIEW};

   public class MainActivity extends Activity {

	VIEW1.Welcome wv;
	WhichView curr;
    public Handler hd= new Handler(){
	        	public void handleMessage(Message msg){
	        		System.out.println("handle the message");
	        		switch(msg.what){
	        		case 0:
	        			gotoWelcomeView();
	        			curr = WhichView.WELCOMEVIEW;
	        	        break;
	        		case 1:
	        			gotoMainMenu();	        			
	        			break;
	        		case 2:
	        			setContentView(R.layout.about);
	        			curr = WhichView.ABOUTVIEW;
	        			break;
	        		case 3:
	        			setContentView(R.layout.help);
	        			curr = WhichView.HELPVIEW;
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
		curr = WhichView.MAINMENUVIEW;
		ImageButton zzcx_button = (ImageButton)findViewById(R.id.zzcx_button);
		ImageButton cccx_button = (ImageButton)findViewById(R.id.cccx_button);
		ImageButton czcx_button = (ImageButton)findViewById(R.id.czcx_button);
		ImageButton fjgn_button = (ImageButton)findViewById(R.id.fjgn_button);
		ImageButton about_button = (ImageButton)findViewById(R.id.about_button);
		ImageButton help_button = (ImageButton)findViewById(R.id.help_button);
		
		zzcx_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				gotoZZCX();
			}
		});
		
		cccx_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				gotoCCCX();
			}
		});
		
		czcx_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				gotoCZCX();
			}
		});
		
		fjgn_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				gotoFJGN();
			}
		});
		about_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				hd.sendEmptyMessage(2);
			}
		});
		help_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				hd.sendEmptyMessage(3);
			}
		});
	}
	
	public void gotoWelcomeView(){
		if(wv == null)
			wv = new VIEW1.Welcome(MainActivity.this);
		setContentView(wv);
	}
	public void gotoZZCX(){
		setContentView(R.layout.zzcx);
		curr = WhichView.ZZCXVIEW;
	}
	public void gotoCCCX(){
		setContentView(R.layout.cccx);
		curr = WhichView.CCCXVIEW;
	}
	public void gotoCZCX(){
		setContentView(R.layout.czcx);
		curr = WhichView.CZCXVIEW;
	}
	
	public void gotoCCTJ(){
		setContentView(R.layout.cctj);
		curr = WhichView.CCTJVIEW;
	}
	public void gotoCZTJ(){
		setContentView(R.layout.cztj);
		curr = WhichView.CZTJVIEW;
	}
	public void gotoGXTJ(){
		setContentView(R.layout.gxtj);
		curr = WhichView.GXTJVIEW;
	}
	public void gotoFJGN(){
		setContentView(R.layout.fjgnmenu);
		curr = WhichView.FJGNVIEW;
		ImageButton cctj_button = (ImageButton)findViewById(R.id.ibcctj);
		ImageButton cztj_button = (ImageButton)findViewById(R.id.ibcztj);
		ImageButton gxtj_button = (ImageButton)findViewById(R.id.ibgxtj);
		cctj_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				gotoCCTJ();
			}
		});
		
		cztj_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				gotoCZTJ();
			}
		});
		
		gxtj_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				gotoGXTJ();
			}
		});
	}

	public boolean onKeyDown(int KeyCode,KeyEvent e){
		if(KeyCode != 4){
			return false;
		}
		if(curr == WhichView.ZZCXVIEW||curr == WhichView.CCCXVIEW||curr == WhichView.CZCXVIEW||curr == WhichView.FJGNVIEW ||curr == WhichView.ABOUTVIEW||curr == WhichView.HELPVIEW ){
			gotoMainMenu();
			return true;
		}
		if(curr == WhichView.MAINMENUVIEW){
			System.exit(0);
			return true;
		}
		if(curr == WhichView.CCTJVIEW || curr == WhichView.CZTJVIEW||curr == WhichView.GXTJVIEW){
			gotoFJGN();
			return true;
		}
			return false;
	}

}
