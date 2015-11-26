package database;

import com.example.train.MyApplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class databaseHelper extends SQLiteOpenHelper {

	public final static String create_table ="create table traindetail("
	+"train_number integer primary key,"
    +"train_type text,"
	+"starting_station text,"
	+ "arrive_station text)";
	
	public final static String create_table1 = "create table trainjc("
	+"station_name text primary key,"
	+"station_name_abbreviation text)";
	
	public final static String create_table2 = "create table trainstation("
	+"Rid integer primary key,"		
	+"train_number integer,"
	+"station_name text,"
	+"starting_time text"
	+"drive_time text)";
	
	public databaseHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(create_table);
		db.execSQL(create_table1);
		db.execSQL(create_table2);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
