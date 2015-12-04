package com.example.daydel;


import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

enum WhichView{MAINVIEW,NEWONEVIEW,ADDVIEW,DELETEVIEW,CHECKVIEW,EDITVIEW,DELETEALLVIEW,SEARCHERVIEW,HELPVIEW,ABOUTVIEW,WELCOMEVIEW}

public class MainActivity extends Activity implements OnClickListener{

	WhichView curr;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		gotoMainMenu();

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
		setContentView(R.layout.deleteall);
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
		setContentView(R.layout.delete);
		curr = WhichView.DELETEVIEW;
	}

	private void gotoNewoneView() {
		// TODO Auto-generated method stub
		setContentView(R.layout.newone);
		curr = WhichView.NEWONEVIEW;
	}


    public boolean onKeyDown(int keyCode,KeyEvent e){
    	if(keyCode != 4){
    		return false;
    	}
		return false;    	
    }
}