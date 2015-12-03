package com.example.train_qurey;


import Utils.CreatTable;
import Utils.LoadUtil;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.*;

import com.example.train_qurey.R.color;

enum WhichView{MAINMENUVIEW,WELCOMEVIEW,ZZCXVIEW,CCCXVIEW,CZCXVIEW,FJGNVIEW,ABOUTVIEW,HELPVIEW,CCTJVIEW,CZTJVIEW,GXTJVIEW,LISTVIEW,PASSSTATIONVIEW};

   public class MainActivity extends Activity {

	VIEW1.Welcome wv;
	WhichView curr;
	String[][] msgg;
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
		CreatTable.createtable();
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
				EditText cctj_train_number = (EditText)findViewById(R.id.cctj_cm);
				EditText cctj_train_type = (EditText)findViewById(R.id.cctj_lclx);
				EditText cctj_start_station = (EditText)findViewById(R.id.cctj_sfz);
				EditText cctj_terminal_station = (EditText)findViewById(R.id.cctj_zdz);
				String Scctj_train_number = cctj_train_number.getText().toString().trim();
				String Scctj_train_type = cctj_train_type.getText().toString().trim();
				String Scctj_start_station = cctj_start_station.getText().toString().trim();
				String Scctj_terminal_station = cctj_terminal_station.getText().toString().trim();
				final int Tid = LoadUtil.getInsertId("train", "Tid");
				
				String sql = "select * from train where Tname = '"+ Scctj_train_number +"'";
				Vector<Vector<String>> temp = LoadUtil.query(sql);
				if(temp.size() > 0){
					Toast.makeText(MainActivity.this,"车次已经存在", Toast.LENGTH_SHORT).show();
					return;
				}
				
				sql = "select * from Sid from station where Sname ='" + Scctj_start_station + "'";
				temp = LoadUtil.query(sql);
				if(temp.size() == 0){
					Toast.makeText(MainActivity.this, "始发站不存在", Toast.LENGTH_SHORT).show();
					return;
				}
				sql = "select * from Sid from station where Sname ='" + Scctj_terminal_station + "'";
				temp = LoadUtil.query(sql);
				if(temp.size() == 0){
					Toast.makeText(MainActivity.this, "终点站不存在", Toast.LENGTH_SHORT).show();
					return;
				}
				sql = "insert into train values(" + Tid + "'" +  Scctj_train_number + "','" + Scctj_train_type + "','" + Scctj_start_station + "','" + Scctj_terminal_station +"')";
				if(!LoadUtil.insert(sql)){
					Toast.makeText(MainActivity.this, "对不起，添加失败", Toast.LENGTH_SHORT).show();
				}else{
					Toast.makeText(MainActivity.this, "恭喜你，添加成功",Toast.LENGTH_SHORT).show();
				}
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
				EditText cztj_train_station = (EditText)findViewById(R.id.et_cztj_czmc);
				EditText cztj_train_station_jc = (EditText)findViewById(R.id.et_cztj_czjc);
				String ecztj_train_station = cztj_train_station.getText().toString().trim();
				String ecztj_train_station_jc = cztj_train_station_jc.getText().toString().trim();
				final int sid = LoadUtil.getInsertId("station", "Sid");
				if(!ecztj_train_station_jc.matches("[a-zA-Z]+")){
					Toast.makeText(MainActivity.this, "车站简称必须为字母", Toast.LENGTH_SHORT).show();
				}
				
				String sql = "select Sid frome station where Sname = '" + ecztj_train_station + "'";
				Vector<Vector<String>> temp = LoadUtil.query(sql);
				if(temp.size() > 0){
					Toast.makeText(MainActivity.this,"车站名称已存在",Toast.LENGTH_SHORT).show();
					return;
				}
				sql = "select Sid from station where spy = '" + ecztj_train_station_jc + "'";
				temp = LoadUtil.query(sql);
				if(temp.size() > 0){
					Toast.makeText(MainActivity.this,"车站简称已存在",Toast.LENGTH_SHORT).show();
					return;
				}
				sql = "insert into station values(" + sid + ",'" + ecztj_train_station + "','" + ecztj_train_station_jc + "')";
				if(!LoadUtil.insert(sql)){
					Toast.makeText(MainActivity.this,"对不起，添加失败",Toast.LENGTH_SHORT).show();
				}else{
					Toast.makeText(MainActivity.this,"恭喜你，添加成功",Toast.LENGTH_SHORT).show();
				}
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
				EditText gxtj_train_number = (EditText)findViewById(R.id.et_gxtj_cm);
				EditText gxtj_station_name = (EditText)findViewById(R.id.et_gxtj_zm);
				EditText gxtj_arrive_time = (EditText)findViewById(R.id.et_gxtj_dzsj);
				EditText gxtj_start_time = (EditText)findViewById(R.id.et_gxtj_kcsj);
				String egxtj_train_number = gxtj_train_number.getText().toString().trim();
				String egxtj_station_name = gxtj_station_name.getText().toString().trim();
				String egxtj_arrive_time = gxtj_arrive_time.getText().toString().trim();
				String egxtj_start_time = gxtj_start_time.getText().toString().trim();
				int Rid = LoadUtil.getInsertId("relation", "Rid");
				
				String sql = "select Tid from train where Tname = '" +  egxtj_train_number +"'";
				Vector<Vector<String >> temp = LoadUtil.query(sql);
				if(temp.size() == 0){
					Toast.makeText(MainActivity.this, "不存在该车次", Toast.LENGTH_SHORT).show();
					return;
				}
				sql = "select Sid from station where Sname = '" + egxtj_station_name +"'";
				temp = LoadUtil.query(sql);
				if(temp.size() == 0){
					Toast.makeText(MainActivity.this, "不存在改站名", Toast.LENGTH_SHORT).show();
					return;
				}
				sql = "select Rid from relation where Tname ='" +egxtj_train_number + "',Sname = '" + egxtj_station_name + "')";
				temp = LoadUtil.query(sql);
				if(temp.size() > 0){
					Toast.makeText(MainActivity.this,"改关系已存在",Toast.LENGTH_SHORT).show();
					return;
				}
				sql = "insert into relation values(" + Rid + ",'" + egxtj_train_number + "','" + egxtj_station_name + "','" + egxtj_arrive_time + "','" +egxtj_start_time + "')";
				if(!LoadUtil.insert(sql)){
					Toast.makeText(MainActivity.this, "对不起，添加失败", Toast.LENGTH_SHORT).show();
				}else{
					Toast.makeText(MainActivity.this, "恭喜你，添加成功", Toast.LENGTH_SHORT).show();
				}
					
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
	
	public void gotoListView(String[][] mssg){
		setContentView(R.layout.listview);
		curr = WhichView.LISTVIEW;
		final String[][] msg = mssg;
		ListView list = (ListView)findViewById(R.id.ListView_detail);
		BaseAdapter adapter = new BaseAdapter() {
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				LinearLayout temp_layout = new LinearLayout(MainActivity.this);
				temp_layout.setOrientation(LinearLayout.HORIZONTAL);
				temp_layout.setPadding(5, 5, 5, 5);
				for(int i =0; i < msg.length;i++){
					TextView temp_text = new TextView(MainActivity.this);
					temp_text.setText(msg[i][position]);
					temp_text.setTextColor(getResources().getColor(R.color.black));
					temp_text.setTextSize(14);
					temp_text.setPadding(1, 2,2,1);
					temp_text.setWidth(60);
					temp_text.setGravity(Gravity.CENTER);
					temp_layout.addView(temp_text);
				}
				return temp_layout;
			}
			
			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return msg[0].length;
			}
		};
		list.setAdapter(adapter);
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?>arg0,View arg1,int arg2,long arg3){
				String cccx = msg[0][arg2];
				Vector<Vector<String>> temp = LoadUtil.getInfo(cccx);
				if(temp.size() == 0){
					Toast.makeText(MainActivity.this, "没有相关信息！！",Toast.LENGTH_SHORT).show();
					return;
				}
				String[][] msgInfo = new String[temp.elementAt(0).size()][temp.size()];
				for(int i =0;i < temp.size(); i ++){
					for(int j = 0;j <temp.elementAt(0).size(); j++){
						msgInfo[j][i] = (String)temp.get(i).get(j);
					}
				}
				gotoPassStationView(msgInfo);
			}
		});
	}
	
	public void gotoPassStationView(String[][] msg){
		setContentView(R.layout.passstation);
		curr = WhichView.PASSSTATIONVIEW;
		final String[][] msgInfo = msg;
		ListView temp = (ListView)findViewById(R.id.ListView_passstation);
		BaseAdapter adapter = new BaseAdapter() {
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				LinearLayout temp_layout = new LinearLayout(MainActivity.this);
				temp_layout.setOrientation(LinearLayout.HORIZONTAL);
				temp_layout.setPadding(5, 2, 2, 4);
			    for(int i=0 ;i < msgInfo.length;i++){
			    	TextView temp_text = new TextView(MainActivity.this);
			    	temp_text.setTextSize(14);
			    	temp_text.setTextColor(getResources().getColor(color.black));
			    	temp_text.setPadding(5, 2, 3, 2);
			    	temp_text.setWidth(150);
			    	temp_text.setGravity(Gravity.CENTER);
			    	temp_layout.addView(temp_text);
			    }
			    return temp_layout;
			}
			
			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return msgInfo[0].length;
			}
		};
		temp.setAdapter(adapter);
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
