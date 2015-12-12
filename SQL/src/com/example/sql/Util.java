package com.example.sql;

import java.util.Vector;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Util {

	public static SQLiteDatabase createdb(){
		SQLiteDatabase db = null;
		try{
		db = SQLiteDatabase.openOrCreateDatabase(exactivity.getactivity().getFilesDir().toString()+"/db",null);		
		}catch(Exception e){
			e.printStackTrace();
		}
		return db;
	}
	
	public static void createTable(){
		try{
			SQLiteDatabase db = createdb();
			String[] sql = {
					"create table friends(lastname varchar(15),fristanme varchar(15),"
					+ "areacode numeric(3),phone varchar(9),st char(2),zip varchar(5))",
					"insert into friends values('BUNDY','AL','100','5551111','IL','223333')",
					"insert into friends values('MERRICK','BUD','300','5556666','CO','80212')",
					"insert into friends values('MAST','JD','381','5556767','LA','23456')",
					"insert into friends values('BULHER','FERRIS','345','5553223','IL','23332')",
					"create table price(item varchar(15),wholesale decimal(4,2))",
					"insert into price values('TOMATOES','0.34')",
					"insert into price values('POTATOES','0.51')",
					"insert into price values('BANANAS','0.67')",
					"insert into price values('TURNIPS','0.45')",
					"insert into price values('CHEESE','0.89')",
					"insert into price values('APPLES','0.23')"
			};
			for(String s:sql){
				db.execSQL(s);
			}
			db.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Vector<Vector<String>> search(){
		Vector<Vector<String>> temp = new Vector<Vector<String>>();
		try{
			SQLiteDatabase db = createdb();
			String sql = "select * frome friends lastname = 'M%'";
			Cursor cursor= db.rawQuery(sql, new String[]{});
			while(cursor.moveToNext()){
			      Vector<String> a = new Vector<String>();
			      int number = cursor.getColumnCount();
			      for(int i=0;i < number;i++){
			    	  a.add(cursor.getString(i));
			      }
			      temp.add(a);
			}
			cursor.close();
			db.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return temp;
	}
}
