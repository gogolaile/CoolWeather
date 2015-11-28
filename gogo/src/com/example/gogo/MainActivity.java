package com.example.gogo;


import java.util.Vector;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Toast;

enum WhichView{MAIN_MENU,ZZCX_VIEW,CCCX_VIEW,CZCCCX_VIEW,LIST_VIEW,PASSSTATION_VIEW,CCTJ_VIEW,CZTJ_VIEW,GXTJ_VIEW,FJGN_VIEW,WELCOME_VIEW,ABOUT_VIEW,HELP_VIEW}
public class MainActivity extends Activity {

	WelcomeView wv;
	Whichview curr;
	static int flag;
	String[][] msgg = new String[][] {{""}};
	String s1[];
	String s2[];
	Handler hd = new Handler(){
		public void handleMessage(Message msg){
			switch(msg.what){
				case 0:goToWelcomeView();
				break;
				case 1:goToMainMenu();
				break;
				case 2:setContentView(R.layout.about);
				curr = WhichView.ABOUT_VIEW;
				break;
				case 3:setContentView(R.layout.help);
				curr = WhichView.HELP_VIEW;
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
		CreatTable.creattable();
		initLisit();
		this.hd.sendEmptyMessage(0);
	}
	public void goToWelcomeView(){
		if(wv == null){
			wv = new WelcomeView(this);
		}
		setContentView(wv);
		curr = WhichView.WELCOME_VIEW;
	}
	public void goToMainMenu(){
		setContentView(R.layout.main);
		curr = WhichView.MAIN_MENU;
		ImageButton ibzzcx = (ImageButton)findViewById(R.id.ibzzcx);
		ImageButton ibczcccx = (ImageButton)findViewById(R.id.ibczcccx);
		ImageButton ibcccx = (ImageButton)findViewById(R.id.ibcccx);
		ImageButton ibfjgn = (ImageButton)findViewById(R.id.ibfjgn);
		ImageButton ibabout = (ImageButton)findViewById(R.id.about_button);
		ImageButton ibhelp = (ImageButton)findViewById(R.id.help_button);
		ibabout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				hd.sendEmptyMessage(2);
			}
		});
		ibhelp.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				hd.sendEmptyMessage(2);
			}
		});
		ibzzcx.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				goTozzcxView();
			}
		});
		ibcccx.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				goTocccxView();
			}
		});
		ibczcccx.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				goToczccxView();
			}
		});
		ibfjgn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				goTofjgnView();
			}
		});
	}
	public void goTozzcxView(){
		setContentView(R.layout.zzcx);
		curr = WhichView.ZZCX_VIEW;
		flag = 0;
		Button bcx = (Button)findViewById(R.id.zzcxbt);
		Button bfn = (Button)findViewById(R.id.zzcxfhbt);
		initLisitarray(R.id.EditText01);
		initLisitarray(R.id.zzcxzzz);
		initLisitarray(R.id.zzcxzdz);
		final CheckBox zzzcx = (CheckBox)findViewById(R.id.zzcxzzzbt);
		bcx.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(!isLegal()){
					return;
				}
				AutoCompleteTextView zzcx_cfz = (AutoCompleteTextView)findViewById(R.id.EditText01);
				AutoCompleteTextView zzcx_zzz = (AutoCompleteTextView)findViewById(R.id.zzcxzzz);
				AutoCompleteTextView zzcx_zdz = (AutoCompleteTextView)findViewById(R.id.zzcxzdz);
				String start = zzcx_cfz.getText().toString().trim();
				String end = zzcx_zdz.getText().toString().trim();
				String between = zzcx_zzz.getText().toString().trim();
				Vector<Vector<String>> temp;
				if(zzzcx.isChecked() == true){
					temp  = LoadUtil.Zjzquery(start,between,end);
					if(temp.size() == 0){
						Toast.makeText(MainActivity.this, "没有你所查询的中转路线", Toast.LENGTH_SHORT).show();
						zzcx_cfz.setText("");
						zzcx_zzz.setText("");
						zzcx_zdz.setText("");
						return;
					}
					}else{
						temp = LoadUtil.getSameVector(start,end);
						if(temp.size() == 0){
							Toast.makeText(MainActivity.this, "对不起，没有相关的列车信息", Toast.LENGTH_SHORT).show();
							zzcx_cfz.setText("");
							zzcx_zzz.setText("");
							zzcx_zdz.setText("");
							return;
						}
					}
				zzcx_cfz = null;
				zzcx_zdz = null;
				zzcx_zzz = null;
				String[][] msgInfo = new String[temp.elementAt(0).size()][temp.size()];
				for(int i = 0;i < temp.size();i++){
					for(int j = 0;j < temp.elementAt(0).size();j++){
						msgInfo[j][i] = (String)temp.get(i).get(j);
					}
				}
				goToListView(msgInfo);
				}
		});
		bfn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				goToMainMenu();
			}
		});
	}
	public void goTocccxView(){
		setContentView(R.layout.cccx);
		curr = WhichView.CCCX_VIEW;
		flag = 1;
		Button bcx = (Button)findViewById(R.id.cccx.cx);
		Button bfh = (Button)findViewById(R.id.cccx_fh);
		bcx.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(!isLegal()){
					return;
				}
				AutoCompleteTextView cccx_cc = (AutoCompleteTextView)findViewById(R.id.cccxcc);
				String cccxcc = cccx_cc.getText().toString().trim();
				Vector<Vector<String>> temp = LoadUtil.trainSearch(cccxcc);
				cccx_cc = null;
				if(temp.size() == 0){
					Toast.makeText(MainActivity.this, "没有相关消息！！！", Toast.LENGTH_SHORT).show();
					return;
				}
				String[][] msgInfo = new String[temp.elementAt(0).size()][temp.size()];
				System.out.println(msgInfo.length + "msgInfo" + msgInfo[0].length);
				for(int i = 0;i < temp.size();i++){
					for(int j = 0;j <temp.elementAt(i).size();j++){
						msgInfo[j][i] = (String)temp.get(i).get(j);
					}
				}
				goToListView(msgInfo);
			}
		});
		bfh.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				goToMainMenu();
			}
		});
	}
	public void goToczccxView(){
		setContentView(R.layout.czcx);
		curr = WhichView.CZCCCX_VIEW;
		flag = 2;
		Button bcx = (Button)findViewById(R.id.czcx_cx);
		Button bfh = (Button)findViewById(R.id.czcx_fh);
		initListarray(R.id.czcxwb);
		bcx.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(!isLegal()){
					AutoCompleteTextView czcx_czzm = (AutoCompleteTextView)findViewById(R.id.czcxwb);
					String czcxczzm = czcx_czzm.getText().toString().trim();
					Vector<Vector<String>> temp = stationSearch(czcxczzm);
					czcx_czzm = null;
					if(temp.size() == 0){
						Toast.makeText(MainActivity.this,"没有相关信息", Toast.LENGTH_SHORT).show();
						return;
					}
					String[][] msgInfo = new String[temp.elementAt(0).size()][temp.size()];
					System.out.println(msgInfo.length + "msgInfo" + msgInfo[0].length);
					for(int i = 0;i <temp.size(); i++){
						for(int j = 0;j < temp.elementAt(0).size();j++){
							msgInfo[j][i] = (String)temp.get(i).get(j);
						}
					}
					goToListView(msgInfo);
				}
			}
		});
		bfh.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				goToMainMenu();
			}
		});
	}
	public void goTofjgnView(){
		setContentView(R.layout.fjgnmenu);
		curr = WhichView.FJGN_VIEW;
		ImageButton ibcctj = (ImageButton)findViewById((R.id.ibcctj);
		ImageButton ibcztj = (ImageButton)findViewById(R.id.ibcztj);
		ImageButton ibgxtj = (ImageButton)findViewById(R.id.ibgxtj);
		ibcctj.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				goTocctjView();
			}
		});
		ibcztj.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				goTocztjView();
			}
		});
		ibgxtj.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				goTogxtjView();
			}
		});
	}
	public void goTocctjView(){
		setContentView(R.layout.cctj);
		curr = WhichView.CCTJ_VIEW;
		Button bcctjtj = (Button)findViewById(R.id.cctj_tj);
		Button bcctjfh = (Button)findViewById(R.id.cctj_fh);
		initLisitarray(R.id.cctj_sfz);
		initLisitarray(R.id.cctj_zdz);
		final int tid = LoadUtil.getInsertId("train","Tid")+1;
		
		bcctjtj.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(!isLegal()){
					return;
				}
				AutoCompleteTextView cctjcnm = (AutoCompleteTextView)findViewById(R.id.cctj_cm);
				AutoCompleteTextView cctjclx = (AutoCompleteTextView)findViewById(R.id.cctj_lclx);
				AutoCompleteTextView cctjcsf = (AutoCompleteTextView)findViewById(R.id.cctj_sfz);
				AutoCompleteTextView cctjczd = (AutoCompleteTextView)findViewById(R.id.cctj_zdz);
				String cnm =cctjcnm.getText().toString().trim();
				String clx = cctjclx.getText().toString().trim();
				String csf = cctjcsf.getText().toString().trim();
				String czd = cctjczd.getText().toString().trim();
				String sql = "select * from  train where Tname ='" +cnm + "'";
				Vector<Vector<String>> ss = query(sql);
				if(ss.size() > 0){
					Toast.makeText(MainActivity.this, "对不起，已经有了此车次！！！", Toast.LENGTH_SHORT).show();
					return;
				}
				
			}
		});
	}
	public void goTocztjView(){}
	public void goTogxtjView(){}
	public void goToListView(String[][]mssg){}
	public void goToPassStationView(String[][]mssg){}
	public boolean isLegal(){}
	public boolean onKeyDown(int keyCode,KeyEvent e){}
	public void initLisit(){}
	public void initLisitarray(int id){}


}
