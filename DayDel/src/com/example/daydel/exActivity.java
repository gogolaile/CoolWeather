package com.example.daydel;

import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;

public class exActivity extends MainActivity{

	private static int screenwidth;
	private static int screenheight;
	private static exActivity temp ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);	
		WindowManager wm = (WindowManager)getSystemService(Context.WINDOW_SERVICE);
		screenwidth = wm.getDefaultDisplay().getWidth();
		screenheight = wm.getDefaultDisplay().getHeight();
		temp = this;
	}
	
	public static exActivity getactivity(){
		return temp;
	}
	
	public  static int  getScreenwidth(){
		return screenwidth;
	}
	
	public  static int getScreenheight(){
		return screenheight;
	}
	
}
