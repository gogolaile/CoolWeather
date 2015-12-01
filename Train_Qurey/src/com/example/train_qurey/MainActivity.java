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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

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
		Button zzcx_qurey = (Button)findViewById(R.id.zzcxbt);
		Button zzcx_back = (Button)findViewById(R.id.zzcxfhbt);
		zzcx_qurey.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(isLegal())
					return;
			}
		});
		
		zzcx_back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				gotoMainMenu();
			}
		});
	}
	public void gotoCCCX(){
		setContentView(R.layout.cccx);
		curr = WhichView.CCCXVIEW;
		Button cccx_qurey = (Button)findViewById(R.id.cccx_cx);
		Button cccx_back = (Button)findViewById(R.id.cccx_fh);
		cccx_qurey.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(isLegal())
					return;
			}
		});
		
		cccx_back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				gotoMainMenu();
			}
		});
	}
	public void gotoCZCX(){
		setContentView(R.layout.czcx);
		curr = WhichView.CZCXVIEW;
		Button czcx_qurey = (Button)findViewById(R.id.czcx_cx);
		Button czcx_back = (Button)findViewById(R.id.czcx_fh);
		czcx_qurey.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(isLegal())
					return;
			}
		});
		czcx_back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				gotoMainMenu();
			}
		});
	}
	
	public void gotoCCTJ(){
		setContentView(R.layout.cctj);
		curr = WhichView.CCTJVIEW;
		Button cctj_add = (Button)findViewById(R.id.cctj_tj);
		Button cctj_fh = (Button)findViewById(R.id.cctj_fh);
		cctj_add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(isLegal())
					return;
			}
		});
		cctj_fh.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				gotoFJGN();
			}
		});
	}
	public void gotoCZTJ(){
		setContentView(R.layout.cztj);
		curr = WhichView.CZTJVIEW;
		Button cztj_add = (Button)findViewById(R.id.cztj_tj);
		Button cztj_back = (Button)findViewById(R.id.cztj_fh);
		cztj_add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(isLegal())
					return;
			}
		});
		cztj_back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				gotoFJGN();
			}
		});
	}
	public void gotoGXTJ(){
		setContentView(R.layout.gxtj);
		curr = WhichView.GXTJVIEW;
		Button gxtj_add = (Button)findViewById(R.id.gxtj_tj);
		Button gxtj_back = (Button)findViewById(R.id.gxtj_fh);
		gxtj_add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(isLegal())
					return;
			}
		});
		gxtj_back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				gotoFJGN();
			}
		});
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
	
	public boolean isLegal(){
		  if(curr == WhichView.ZZCXVIEW){
			  EditText start_station = (EditText)findViewById(R.id.EditText01);
			  EditText transfer_station = (EditText)findViewById(R.id.zzcxzzz);
			  EditText terminal_station = (EditText)findViewById(R.id.zzcxzdz);
			  CheckBox check = (CheckBox)findViewById(R.id.zzcxzzzbt);
			  if(start_station.getText().toString().trim().equals("")){
				  Toast.makeText(MainActivity.this, "出发站不能为空",Toast.LENGTH_SHORT).show();
				  return true;
			  }
			  if(terminal_station.getText().toString().trim().equals("")){ 
				  Toast.makeText(MainActivity.this, "终点站不能为空", Toast.LENGTH_SHORT).show();
				  return true;
				  }
			  if(check.isChecked()&&transfer_station.getText().toString().trim().equals(""))return true;
			  if(start_station.getText().toString().trim().equals(terminal_station.getText().toString().trim())){
				  Toast.makeText(MainActivity.this, "出发站和终点站不能相同", Toast.LENGTH_SHORT).show();
				  return true;
			  }	
		  }
		  if(curr == WhichView.CCCXVIEW){
			  EditText train_number = (EditText)findViewById(R.id.cccxcc);
			  if(train_number.getText().toString().trim().equals("")){
				  Toast.makeText(MainActivity.this, "车次不能为空", Toast.LENGTH_SHORT).show();
				  return true;
			  }
		  }
		  if(curr == WhichView.CZCXVIEW){
			  EditText train_station = (EditText)findViewById(R.id.czcxwb);
			  if(train_station.getText().toString().trim().equals("")){
				  Toast.makeText(MainActivity.this,"车站不能为空", Toast.LENGTH_SHORT).show();
				  return true;
			  }
			  
		  }
		  if(curr == WhichView.CCTJVIEW){
			  EditText train_number = (EditText)findViewById(R.id.cctj_cm);
			  EditText train_type = (EditText)findViewById(R.id.cctj_lclx);
			  EditText start_station = (EditText)findViewById(R.id.cctj_sfz);
			  EditText terminal_station = (EditText)findViewById(R.id.cctj_zdz);
			  if(train_number.getText().toString().trim().equals("")){
				  Toast.makeText(MainActivity.this, "车次不能为空", Toast.LENGTH_SHORT).show();
				  return true;
			  }
			  if(train_type.getText().toString().trim().equals("")){
				  Toast.makeText(MainActivity.this, "列车类型不能为空", Toast.LENGTH_SHORT).show();
				  return true;
			  }
			  if(start_station.getText().toString().trim().equals("")){
				  Toast.makeText(MainActivity.this, "始发站不能为空", Toast.LENGTH_SHORT).show();
				  return true;
			  }
			  if(terminal_station.getText().toString().trim().equals("")){
				  Toast.makeText(MainActivity.this, "终点站不能为空", Toast.LENGTH_SHORT).show();
				  return true;
			  }
			  if(start_station.getText().toString().trim().equals(terminal_station.getText().toString().trim())){
				  Toast.makeText(MainActivity.this, "始发站和终点站不能相同", Toast.LENGTH_SHORT).show();
				  return true;
			  }	
		  }
		  if(curr == WhichView.CZTJVIEW){
			  EditText train_station = (EditText)findViewById(R.id.et_cztj_czmc);
			  EditText train_station_jc = (EditText)findViewById(R.id.et_cztj_czjc);
			  if(train_station.getText().toString().trim().equals("")){
				  Toast.makeText(MainActivity.this, "车站名称不能为空", Toast.LENGTH_SHORT).show();
				  return true;
			  }
			  if(train_station_jc.getText().toString().trim().equals("")){
				  Toast.makeText(MainActivity.this, "车站简称不能为空", Toast.LENGTH_SHORT).show();
				  return true;
			  }
		  }
		  if(curr == WhichView.GXTJVIEW){
			  EditText train_number = (EditText)findViewById(R.id.et_gxtj_cm);
			  EditText train_station = (EditText)findViewById(R.id.et_gxtj_zm);
			  EditText arrive_time = (EditText)findViewById(R.id.et_gxtj_dzsj);
			  EditText start_time = (EditText)findViewById(R.id.et_gxtj_kcsj);
			  if(train_number.getText().toString().trim().equals("")){
				  Toast.makeText(MainActivity.this, "车次不能为空", Toast.LENGTH_SHORT).show();
				  return true;
			  }
			  if(train_station.getText().toString().trim().equals("")){
				  Toast.makeText(MainActivity.this, "站名不能为空", Toast.LENGTH_SHORT).show();
				  return true;
			  }
			  if(arrive_time.getText().toString().trim().equals("")){
				  Toast.makeText(MainActivity.this, "到站时间不能为空", Toast.LENGTH_SHORT).show();
				  return true;
			  }			  
			  if(start_time.getText().toString().trim().equals("")){
				  Toast.makeText(MainActivity.this, "开车时间不能为空", Toast.LENGTH_SHORT).show();
				  return true;
			  }
			  if(arrive_time.getText().toString().trim().equals(start_time.getText().toString().trim())){
				  Toast.makeText(MainActivity.this, "开车时间不能与到站时间相同", Toast.LENGTH_SHORT).show();
				  return true;
			  }	 
		  }
		  return false;
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
