package com.example.daydel;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Utils {
	  public static SQLiteDatabase createOrOpenDatabase(){
		  SQLiteDatabase sld = null;
		  try{
			  sld = SQLiteDatabase.openOrCreateDatabase(exActivity.getactivity().getFilesDir().toString()+"/daydel", null); 
		  }catch(Exception e){
			  e.printStackTrace();
		  }
		  return sld;
	  }
      public static void createTable(){
    	try{ 
    	  SQLiteDatabase db = createOrOpenDatabase();
    	  String[] sql = new String[]{"create the table if not exists schedule(Tid integer primary key,type char(255))"};
    	    for(String s:sql)
    	    		db.execSQL(s);
    	    db.close();
          }catch(Exception e){
        	  e.printStackTrace();
        	  }
          }
      
      public static void  type_insert(String type){
    	  if(type.equals("会议")||type.equals("备忘")||type.equals("待办")||type.equals("约会"))
    		  return;
    	  String sql = "select type from schedule";
    	  SQLiteDatabase  db = createOrOpenDatabase();
    	  try{
    		  Cursor cur = db.rawQuery(sql, new String[]{});
    		  while(cur.moveToNext()){
    			  if(cur.getString(0).equals(type))
    				  return;
    		  }
    	  }catch(Exception e){
    		  e.printStackTrace();
    	  }
    	  
      }
	
}
