package com.example.daydel;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

enum WhichView{MAINVIEW,NEWONEVIEW,ADDVIEW,DELETEVIEW,CHECKVIEW,EDITVIEW,DELETEALLVIEW,SEARCHERVIEW,HELPVIEW,ABOUTVIEW,WELCOMEVIEW}

public class MainActivity extends Activity implements OnClickListener{

	WhichView curr;
	WelcomeView wv;
	String[] arr ={"会议","备忘","待办","约会"};
	
	Handler hd = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			switch(msg.what)
			{
			case 0:
				gotoMainMenu();
				break;
			case 1:
				gotoWelcomeView();
				break;
			}
		}
		
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		hd.sendEmptyMessage(1);      
	}
	
	private void gotoWelcomeView() {
		// TODO Auto-generated method stub
		if(wv == null)
			wv = new WelcomeView(MainActivity.this);
		setContentView(wv);
		curr = WhichView.WELCOMEVIEW;
	}

	public void gotoMainMenu(){
		setContentView(R.layout.activity_main);
		curr = WhichView.MAINVIEW;	
		ImageButton newone_b =(ImageButton)findViewById(R.id.newone_b);
		ImageButton delete_b = (ImageButton)findViewById(R.id.delete_b);
		ImageButton check_b = (ImageButton)findViewById(R.id.check_b);
		ImageButton edit_b = (ImageButton)findViewById(R.id.edit_b);
		ImageButton deleteall_b = (ImageButton)findViewById(R.id.deleteall_b);
		ImageButton search_b = (ImageButton)findViewById(R.id.search_b);
		newone_b.setOnClickListener(this);
		delete_b.setOnClickListener(this);
		check_b.setOnClickListener(this);
		edit_b.setOnClickListener(this);
		deleteall_b.setOnClickListener(this);
		search_b.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.newone_b:
			gotoNewoneView();
			break;
		case R.id.delete_b:
			gotoDeleteView();
			break;
		case R.id.check_b:
			gotoCheckView();
			break;
		case R.id.edit_b:
			gotoEditView();
			break;
		case R.id.deleteall_b:
			gotoDeleteallView();
			break;
		case R.id.search_b:
			gotoSearchView();
			break;
		}
	}

	private void gotoSearchView() {
		// TODO Auto-generated method stub
		setContentView(R.layout.search);
		curr = WhichView.SEARCHERVIEW;
	}

	private void gotoDeleteallView() {
		// TODO Auto-generated method stub
		curr = WhichView.DELETEALLVIEW;
	}
	

	private void gotoEditView() {
		// TODO Auto-generated method stub
		setContentView(R.layout.edit);
		curr = WhichView.EDITVIEW;
	}

	private void gotoCheckView() {
		// TODO Auto-generated method stub
		setContentView(R.layout.check);
		curr = WhichView.CHECKVIEW;
	}

	private void gotoDeleteView() {
		// TODO Auto-generated method stub
		curr = WhichView.DELETEVIEW;
	}

	private void gotoNewoneView() {
		// TODO Auto-generated method stub
		setContentView(R.layout.newone);
		curr = WhichView.NEWONEVIEW;
		Button type_manage =(Button)findViewById(R.id.type_manage_button);
		Button set_time_newone = (Button)findViewById(R.id.set_the_time_newone);
		Button set_alarm_newone = (Button)findViewById(R.id.set_the_alarm_newone);
		Button complete_newone = (Button)findViewById(R.id.newone_complete_button);
		Button cancel_newone = (Button)findViewById(R.id.newone_cancel_button);
		Spinner spinner = (Spinner)findViewById(R.id.spinner);
		ArrayAdapter<String> newone_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arr);
		newone_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(newone_adapter);
		
		set_alarm_newone.setOnClickListener(new OnClickListener() {
			
		String tip;
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
				LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
				final View view = layoutInflater.inflate(R.layout.alarm_newone_dialog, null);
				final TextView Talarm_newone= (TextView)findViewById(R.id.text_alarm_newone);
				RadioGroup alarm_choose_newone = (RadioGroup)view.findViewById(R.id.alarm_mode_newone);	
				
				 alarm_choose_newone.setOnCheckedChangeListener(new OnCheckedChangeListener() {
					
					@Override
					public void onCheckedChanged(RadioGroup group, int checkedId) {
						// TODO Auto-generated method stubs					
					    tip = (checkedId == R.id.open_alarm)?"有闹钟":"无闹钟";

					}
				});
				
				builder.setView(view);
				builder.setTitle("设置闹钟");
				builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {


					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Talarm_newone.setText("闹钟:"+tip);
						 dialog.cancel();
					}

				});
				Dialog dialog = builder.create();
				dialog.show();
			}
		});
		
		set_time_newone.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog.Builder  builder = new AlertDialog.Builder(MainActivity.this);
				LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
			    View view = layoutInflater.inflate( R.layout.date_time_dialog, null);
				final DatePicker datePicker = (DatePicker)view.findViewById(R.id.day_picker_newone);
				final TimePicker timePicker = (TimePicker)view.findViewById(R.id.time_picker_newone);
				final TextView day_year_newone = (TextView)findViewById(R.id.day_newone);
				final TextView time_newone = (TextView)findViewById(R.id.time_newone);				
				builder.setView(view);
				
				Calendar cal = Calendar.getInstance();
				cal.setTimeInMillis(System.currentTimeMillis());
				datePicker.init(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), null);
				timePicker.setIs24HourView(true);
				timePicker.setCurrentHour(cal.get(Calendar.HOUR_OF_DAY));
				timePicker.setCurrentMinute(Calendar.MINUTE);
				
				builder.setTitle("选取起始时间");
				builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						int year,month,day,minute,hour;
						year = datePicker.getYear();
						month = datePicker.getMonth();
						day = datePicker.getDayOfMonth();
						minute = timePicker.getCurrentHour();
						hour = timePicker.getCurrentMinute();
						day_year_newone.setText("日期："+year+"/"+month+"/"+day);
						time_newone.setText("时间:"+hour+":"+minute);	
						dialog.cancel();
					}
				});
			Dialog dialog = builder.create();
			dialog.show();
			}
		});
		type_manage.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				gotoAddView();
			}
		});
		cancel_newone.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				gotoMainMenu();
			}
		});
		complete_newone.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				gotoMainMenu();
			}
		});
	
	}


    protected void gotoAddView() {
		// TODO Auto-generated method stub
		setContentView(R.layout.add);
		curr = WhichView.ADDVIEW;
		Button add_button = (Button)findViewById(R.id.add_type_button);
		Button comeback_button = (Button)findViewById(R.id.back_add);
		ListView add_listview = (ListView)findViewById(R.id.add_listview);
		List<Map<String,Object>> ListItems = new ArrayList<Map<String,Object>>();
		for(int i=0;i < arr.length;i++){
			Map<String,Object> ListItem = new HashMap<String,Object>();
			ListItem.put("text", arr[i]);
			ListItems.add(ListItem);
		}

		SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, ListItems, R.layout.add_listview_layout,new String[]{"text"},new int[]{R.id.Text_add_newone});
		add_listview.setAdapter(adapter);
		add_button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		comeback_button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				gotoNewoneView();
			}
		});
	}

	public boolean onKeyDown(int keyCode,KeyEvent e){
    	if(keyCode != 4){
    		return false;
    	} 
    	if(curr == WhichView.NEWONEVIEW||curr == WhichView.DELETEVIEW||curr == WhichView.CHECKVIEW||
    			curr == WhichView.EDITVIEW||curr == WhichView.ABOUTVIEW ||curr == WhichView.HELPVIEW ||curr == WhichView.DELETEALLVIEW||curr == WhichView.SEARCHERVIEW){
    		gotoMainMenu();
    		return true;
    	}
    	if(curr == WhichView.MAINVIEW){
    		System.exit(0);
    		return true;
    	}
    	if(curr == WhichView.ADDVIEW){
    		gotoNewoneView();
    	}
		return false;    	
    }
}
