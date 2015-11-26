package Utils;

import com.example.train.MyApplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import database.databaseHelper;
import java.util.Vector;

public class util {
	 private static databaseHelper helper = new databaseHelper(MyApplication.getContext(), "gogo", null, 1);
	 static public void createtable(){
		SQLiteDatabase db = helper.getReadableDatabase();
	}
	 
	public static boolean insert(String train_number, String train_type, String starting_station, String drive_station) {
		// TODO Auto-generated method stub
	    SQLiteDatabase db = helper.getWritableDatabase();
	    ContentValues values = new ContentValues();
	    values.put("train_number", train_number);
	    values.put("train_type", train_type);
	    values.put("starting_station", starting_station);
	    values.put("drive_station", drive_station);
        db.insert("traindetail", null, values);
	    values.clear();
	    return true;
	}
	public static Vector<Vector<String>> query(String sql){
		Vector<Vector<String>> vector = new Vector<Vector<String>>();
		SQLiteDatabase db = helper.getReadableDatabase();
		try{
			Cursor cur = db.rawQuery(sql, new String[]{});
			while(cur.moveToNext()){
				Vector<String> v =new Vector<String>();
				int col = cur.getColumnCount();
				for(int i=0;i < col;i++){
					v.add(cur.getString(i));
				}
				vector.add(v);
			}
			cur.close();
			db.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return vector;
	}

	public static boolean insert(String station_name, String station_czjc) {
		// TODO Auto-generated method stub
		 SQLiteDatabase db = helper.getWritableDatabase();
		    ContentValues values = new ContentValues();
		    values.put("station_name", station_name);
		    values.put("station_name_abbreviation",station_czjc);
	        db.insert("trainjc", null, values);
		    values.clear();
		    return true;
	}

	public static void insert(int rid, String etrain_number, String estation_name, String earrive_time,
			String edrive_time) {
		// TODO Auto-generated method stub
		 SQLiteDatabase db = helper.getWritableDatabase();
		    ContentValues values = new ContentValues();
		    values.put("Rid", rid);
		    values.put("train_number",etrain_number);
		    values.put("station_name",estation_name);
		    values.put("staring_time",earrive_time);
		    values.put("drive_time",edrive_time);
	        db.insert("trainjc", null, values);
		    values.clear();
	}

	public static int getInsertId(String string, String string2) {
		// TODO Auto-generated method stub
		int id = 0;
		String sql = "select Max("+string2 +"from"+string;
		SQLiteDatabase db = helper.getReadableDatabase();
		try{
			Cursor cur = db.rawQuery(sql, new String[]{});
			if(cur.moveToNext()){
				id = cur.getInt(0);
			}
			cur.close();
			db.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		id++;
		return id;
	}
}
