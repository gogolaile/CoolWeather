package com.example.train;


import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Vector;

enum WhichView{MAIN_MENU,CCCXVIEW,CZCXVIEW,ZZCXVIEW,CCTJVIEW,CZTJVIEW,GXTJVIEW,QUERYLIST,ABOUTVIEW,HELPVEIW,WELCOMEVIEW,FJGNVIEW,PASSSTATIONVIEW,LISTVIEW}


public class MainActivity extends Activity {
   
	WhichView curr;
	WelcomeView wv;
	static int flag;
	String[][] msgg = new String[][]{{""}};
	String s1[];
	String s2[];
	
	Handler hd = new  Handler(){
		public void handleMessage(Message msg){
			switch(msg.what){
			case 0:gotoWelcomeView();
			break;
			case 1:gotoMainMenu();
			break;
			case 2:setContentView(R.layout.about);
			curr = WhichView.ABOUTVIEW;
			break;
			case 3:setContentView(R.layout.help);
			curr = WhichView.HELPVEIW;
			break;
			}
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		Utils.util.createtable();
		this.hd.sendEmptyMessage(0);
	
	}
	
	protected void gotoWelcomeView() {
		// TODO Auto-generated method stub
		if(wv == null){
			wv = new WelcomeView(this);
		}
		setContentView(wv);
		curr = WhichView.WELCOMEVIEW;
	}

	public void gotoMainMenu(){
		setContentView(R.layout.activity_main);
		curr = WhichView.MAIN_MENU;
		Button fjgn = (Button)findViewById(R.id.fjgn);
		Button cccx = (Button)findViewById(R.id.cccx);
		Button zzcx = (Button)findViewById(R.id.zzcx);
		Button czcx = (Button)findViewById(R.id.czcx);
		Button about = (Button)findViewById(R.id.gy);
		Button help = (Button)findViewById(R.id.bz);
		fjgn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			gotofjgn();
	      }
		});
		
		cccx.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				gotocccx();
			}
		});
		
		czcx.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				gotoczccx();
			}
		});
		
		zzcx.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				gotozzcx();
			}
		});
		
		about.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				hd.sendEmptyMessage(2);
			}
		});
		
		help.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				hd.sendEmptyMessage(3);
			}
		});
    }
	
	public void gotofjgn(){
		setContentView(R.layout.fujiaxml);
		curr = WhichView.FJGNVIEW;
		Button cctj = (Button)findViewById(R.id.cctj);
		Button cztj = (Button)findViewById(R.id.cztj);
		Button gxtj = (Button)findViewById(R.id.gxtj);
		cctj.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				gotocctj();
			}
		});
		
        cztj.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				gotocztj();
			}
		});		
        
        gxtj.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				gotogxtj();
			}
		});
	
    }
	
	public void gotocctj(){
		setContentView(R.layout.cctj);
		curr = WhichView.CCTJVIEW;
		Button bcctj = (Button)findViewById(R.id.cctj_add);
		Button back = (Button)findViewById(R.id.cctj_back);
        
		bcctj.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(!isLegal())
					return;
		        AutoCompleteTextView etrain_number = (AutoCompleteTextView)findViewById(R.id.cctj_train_number);
		        AutoCompleteTextView etrain_type = (AutoCompleteTextView)findViewById(R.id.cctj_train_type);
		        AutoCompleteTextView estarting_station = (AutoCompleteTextView)findViewById(R.id.cctj_starting_station);
		        AutoCompleteTextView edrive_station =(AutoCompleteTextView)findViewById(R.id.cctj_terminal_station);
		        
				String train_number = etrain_number.getText().toString().trim();
				String train_type = etrain_type.getText().toString().trim();
				String starting_station = estarting_station.getText().toString().trim();
				String drive_station = edrive_station.getText().toString().trim();
				String query ="select * from traindetail where train_number='"+train_number+"'";
				Vector<Vector<String>> ss = Utils.util.query(query);
				if(ss.size() > 0){
					Toast.makeText(MainActivity.this, "对不起，已经有此车次", Toast.LENGTH_SHORT).show();
					return;
				}
				query = "select * from trainjc where station_name='"+starting_station+"'";
				if(Utils.util.query(query).size() == 0){
					Toast.makeText(MainActivity.this, "对不起，该始发站不存在", Toast.LENGTH_SHORT).show();
				    return;
			}
				query = "select * from trainjc where station_name='"+drive_station+"'";
				if(Utils.util.query(query).size() == 0){
					Toast.makeText(MainActivity.this, "对不起，该终点站不存在", Toast.LENGTH_SHORT).show();
				    return;
			}
				if(!Utils.util.insert(train_number,train_type,starting_station,drive_station))
					Toast.makeText(MainActivity.this, "对不起，添加错误！！！",Toast.LENGTH_SHORT).show();
				else
					Toast.makeText(MainActivity.this, "恭喜你，添加成功！！！", Toast.LENGTH_SHORT).show();
			}
			
		});
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				gotoMainMenu();
			}
		});
	}
	
	public void gotocztj(){
		setContentView(R.layout.cztj);
		curr = WhichView.CZCXVIEW;
		Button back = (Button)findViewById(R.id.cztj_back);
		Button add = (Button)findViewById(R.id.cztj_add);
		add.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(!isLegal())
					return;
				AutoCompleteTextView estation_name = (AutoCompleteTextView)findViewById(R.id.cztj_station_name);
				AutoCompleteTextView estation_czjc = (AutoCompleteTextView)findViewById(R.id.cztj_czjc);
				String station_name = estation_name.getText().toString().trim();
				String station_czjc = estation_czjc.getText().toString().trim();
				if(!station_czjc.matches("[a-zA-Z]+")){
					Toast.makeText(MainActivity.this, "对不起，简称只能是字母", Toast.LENGTH_SHORT).show();
					return;
				}
				String query = "select * from trainjc where station_name='"+station_name+"'";
				Vector<Vector<String>> ss = Utils.util.query(query);
				if(ss.size() > 0){
					Toast.makeText(MainActivity.this, "站名已存在", Toast.LENGTH_SHORT).show();
					return;
				}
				query = "select * from trainjc where station_name_abbreviation='"+station_czjc+"'";
				if(Utils.util.query(query).size() > 0){
					Toast.makeText(MainActivity.this,"简称已存在", Toast.LENGTH_SHORT).show();
					return;
				}
				if(!Utils.util.insert(station_name, station_czjc))
					Toast.makeText(MainActivity.this, "车站添加失败",Toast.LENGTH_SHORT).show();
				else
					Toast.makeText(MainActivity.this,"车站添加成功", Toast.LENGTH_SHORT).show();
			}
		});
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				gotoMainMenu();
			}
		});
	}
	
	public void gotogxtj(){
		setContentView(R.layout.gxtj);
		curr = WhichView.GXTJVIEW;
		Button back = (Button)findViewById(R.id.gxtj_back);
		Button add = (Button)findViewById(R.id.gxtj_add);
		add.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(!isLegal())
					return;
				AutoCompleteTextView etrain_number = (AutoCompleteTextView)findViewById(R.id.gxtj_train_number);
				AutoCompleteTextView estation_name = (AutoCompleteTextView)findViewById(R.id.gxtj_station_name);
				AutoCompleteTextView earrive_time = (AutoCompleteTextView)findViewById(R.id.gxtj_arrive_time);
				AutoCompleteTextView edrive_time = (AutoCompleteTextView)findViewById(R.id.gxtj_drive_time);
				String train_number = etrain_number.getText().toString().trim();
				String station_name = estation_name.getText().toString().trim();
				String arrive_time = earrive_time.getText().toString().trim();
				String drive_time = edrive_time.getText().toString().trim();

				int Rid = Utils.util.getInsertId("trainstation","Rid")+1;
				int cnmm = 0;
				String cznm = null;
				String query = "select * from traindetail where train_number = '"+etrain_number+"'";
				Vector<Vector<String>> ss = Utils.util.query(query);
				if(ss.size() > 0){
					cnmm = Integer.parseInt((String)ss.get(0).get(0));
				}else if(ss.size() == 0){
					Toast.makeText(MainActivity.this, "对不起，没有该车", Toast.LENGTH_SHORT).show();
					return;
				}
				query = "select * form station where station_name ='"+ estation_name+"'";
				ss = Utils.util.query(query);
				if(ss.size() > 0){
					cznm = (String)ss.get(0).get(0);
				}else if(ss.size() == 0){
					Toast.makeText(MainActivity.this, "对不起，没有该车站", Toast.LENGTH_SHORT).show();
					return;
				}
				query = "select Rid from trainstation where station_name="+cznm+"and train_number="+cnmm ;
				if(Utils.util.query(query).size() > 0){
					Toast.makeText(MainActivity.this,"对不起，该关系已经有了",Toast.LENGTH_SHORT).show();;
					return;
				}
				Utils.util.insert(Rid,train_number,station_name,arrive_time,drive_time);
				Toast.makeText(MainActivity.this, "恭喜你，添加关系成功", Toast.LENGTH_SHORT).show();
				
				
			}
		});
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				gotoMainMenu();
			}
		});
	}
	public void gotocccx(){
		setContentView(R.layout.cccx);
		curr = WhichView.CCCXVIEW;
		Button query = (Button)findViewById(R.id.cccx_query);
		Button back = (Button)findViewById(R.id.cccx_back);
		query.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(!isLegal())
					return;
				EditText etrain_number = (EditText)findViewById(R.id.cccx_edit);
				String train_number = etrain_number.getText().toString().trim();
				String query_cc = "select * from table traindetail where train_number = "+train_number;
				Vector<Vector<String>> ss = Utils.util.query(query_cc);
	            if(ss.size() == 0){
	            	Toast.makeText(MainActivity.this, "对不起，没有你要查询的车次信息",Toast.LENGTH_SHORT).show();
	            }
	            String[][] msgInfo = new String[ss.elementAt(0).size()][ss.size()];
	            for(int i = 0;i < ss.size();i++){
	            	for(int j=0; j<ss.elementAt(0).size();j++){
	            		msgInfo[j][i] = (String)ss.get(i).get(j);
	            	}
	            }
				gotoListView(msgInfo);
			}
		});
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				gotoMainMenu();
			}
		});
	}
	
	public void gotozzcx(){
		setContentView(R.layout.zzcx);
		curr = WhichView.ZZCXVIEW;
		Button query = (Button)findViewById(R.id.zzcx_query);
		Button back = (Button)findViewById(R.id.zzcx_back);
		query.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(!isLegal())
					return;
			}
		});
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				gotoMainMenu();
			}
		});
	}
	
	public void gotoczccx(){
		setContentView(R.layout.czccx);
		curr = WhichView.CZCXVIEW;
		Button query = (Button)findViewById(R.id.czcx_query);
		Button back = (Button)findViewById(R.id.czcx_back);
		query.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(!isLegal())
					return;
			}
		});
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				gotoMainMenu();
			}
		});
	}
	
	public void gotoListView(String[][] mssg){
		msgg = mssg;
		setContentView(R.layout.listview);
		curr = WhichView.LISTVIEW;
		final String[][] msg = mssg;
		ListView lv_detail = (ListView)this.findViewById(R.id.ListView_detail);
		BaseAdapter ba_detail = new BaseAdapter() {
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				LinearLayout ll_detail = new LinearLayout(MainActivity.this);
				ll_detail.setOrientation(LinearLayout.HORIZONTAL);
				ll_detail.setPadding(5, 5, 5, 5);
				for(int i=0;i<msg.length;i++){
					TextView s = new TextView(MainActivity.this);
					s.setText(msg[i][position]);
					s.setTextSize(14);
					s.setTextColor(getResources().getColor(R.color.material_blue_grey_800));
					s.setPadding(1, 2, 2, 1);
					s.setWidth(60);
					s.setGravity(Gravity.CENTER);
					ll_detail.addView(s);
					
				}
				return ll_detail;
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
		lv_detail.setAdapter(ba_detail);
		
	}
	
	public void gotoPassStationView(String[][] mssg){
		
	}
	
	public boolean isLegal(){
		if(curr == WhichView.CCCXVIEW){
			EditText ecccx = (EditText)findViewById(R.id.cccx_edit);
			if(ecccx.getText().toString().trim().equals("")){
					Toast.makeText(this, "车次不能为空!!!", Toast.LENGTH_SHORT).show();
			return false;}
		}
		if(curr == WhichView.CCTJVIEW){
			EditText ecctj_cc = (EditText)findViewById(R.id.cctj_train_number);
			EditText ecctj_traintype = (EditText)findViewById(R.id.cctj_train_type);
			EditText ecctj_start_station = (EditText)findViewById(R.id.cctj_starting_station);
			EditText ecctj_terminal_station = (EditText)findViewById(R.id.cctj_terminal_station);
			if(ecctj_cc.getText().toString().trim().equals("")){
				Toast.makeText(this, "车次不能为空!!!", Toast.LENGTH_SHORT).show();
				return false;}
			if(ecctj_traintype.getText().toString().trim().equals("")){
				Toast.makeText(this, "列车类型不能为空!!!", Toast.LENGTH_SHORT).show();
				return false;}
			if(ecctj_start_station.getText().toString().trim().equals("")){
				Toast.makeText(this, "始发站不能为空!!!", Toast.LENGTH_SHORT).show();
				return false;}
			if(ecctj_terminal_station.getText().toString().trim().equals("")){
				Toast.makeText(this, "终点站不能为空!!!", Toast.LENGTH_SHORT).show();
				return false;}
		}
		if(curr == WhichView.CZTJVIEW){
			EditText ecztj_station_name = (EditText)findViewById(R.id.cztj_station_name);
			EditText ecztj_czjc = (EditText)findViewById(R.id.cztj_czjc);
			if(ecztj_station_name.getText().toString().trim().equals("")){
				Toast.makeText(this, "站名不能为空", Toast.LENGTH_SHORT).show();
			    return false;
			}
			if(ecztj_czjc.getText().toString().trim().equals("")){
				Toast.makeText(this, "车站简称不能为空", Toast.LENGTH_SHORT).show();
			    return false;
			}
		}
		if(curr == WhichView.GXTJVIEW){
			EditText egxtj_station_name = (EditText)findViewById(R.id.gxtj_station_name);
			EditText egxtj_arrive_time = (EditText)findViewById(R.id.gxtj_arrive_time);
			EditText egxtj_train_number = (EditText)findViewById(R.id.gxtj_train_number);
			EditText egxtj_drive_time = (EditText)findViewById(R.id.gxtj_drive_time);
			if(egxtj_station_name.getText().toString().trim().equals("")){
				Toast.makeText(this, "站名不能为空", Toast.LENGTH_SHORT).show();
			    return false;
			}
			if((egxtj_arrive_time.getText().toString().trim().equals(""))&&(egxtj_drive_time.getText().toString().trim().equals(""))){
				Toast.makeText(this, "到站时间和出发时间不能同时为空", Toast.LENGTH_SHORT).show();
			    return false;
			}
			if(egxtj_train_number.getText().toString().trim().equals("")){
				Toast.makeText(this, "车次不能为空", Toast.LENGTH_SHORT).show();
			    return false;
			}
		}
		return true;
	}
	
	public boolean onKeyDown(int keyCode,KeyEvent e){
		if(keyCode !=4)
		return false;
		if(curr == WhichView.ZZCXVIEW||curr == WhichView.CCCXVIEW||curr == WhichView.CZCXVIEW||curr ==WhichView.FJGNVIEW){
			gotoMainMenu();
			return true;
	}
		if(curr == WhichView.CCTJVIEW||curr == WhichView.CZTJVIEW||curr == WhichView.GXTJVIEW){
			gotofjgn();
			return true;
	}
	    if(curr == WhichView.MAIN_MENU){
	    	System.exit(0);
	    	return true;
	    }	
	    if(curr == WhichView.PASSSTATIONVIEW){
	    	gotoListView(msgg);
	    	return true;
	    }
	    if(curr == WhichView.LISTVIEW){
	    	if(flag == 0){
	    		gotozzcx();
	    		return true;
	    	}
	    	if(flag == 1){
	    		gotocccx();
	    		return true;
	    	}
	    	if(flag == 2){
	    		gotoczccx();
	    		return true;
	    	}
	    }
	    if(curr == WhichView.ABOUTVIEW||curr == WhichView.HELPVEIW){
	    	gotoMainMenu();
	    	return true;
	    }
	    return false;
	}
	public void initLisit(){
		String sql = "select station_name from trainjc";
		Vector<Vector<String>> ss = Utils.util.query(sql);
		String[][] msgInfo = new String[ss.get(0).size()][ss.size()];
		for(int i = 0;i<ss.size();i++){
			for(int j=0;j<ss.elementAt(0).size();j++){
				msgInfo[j][i]=(String)ss.get(i).get(j);
			}}
		this.s1 = msgInfo[0];
		
		sql = "select station_name_abbreviation from trainjc";
		ss = Utils.util.query(sql);
		msgInfo = new String[ss.elementAt(0).size()][ss.size()];
		for(int i = 0;i<ss.size();i++){
			for(int j=0;j<ss.elementAt(0).size();j++){
				msgInfo[j][i]=(String)ss.get(i).get(j);
			}}
		this.s2 = msgInfo[0];
	}
	public void initLisitarray(int id){
		CityAdapter<String> cadapter = new CityAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,this.s1,this.s2);
		AutoCompleteTextView autoView = (AutoCompleteTextView)findViewById(id);
		autoView.setAdapter(cadapter);
		autoView.setThreshold(1);
		autoView.setDropDownHeight(100);
		autoView.setDropDownBackgroundResource(R.color.material_blue_grey_900);
	}
}
