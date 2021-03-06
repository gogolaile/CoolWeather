package model;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import db.CoolWeatherOpenHelper;

public class CoolWeatherDB {
	/**
	 * Database name
	 */
	public static final String DB_NAME = "cool_weather";
	/**
	 * Database version
	 */
	public static final int VERSION = 1;
	private static CoolWeatherDB  coolWeatherDB;
	private SQLiteDatabase db;
	/*
	 * The privatization of the construcor
	 */
	private CoolWeatherDB(Context context){
		CoolWeatherOpenHelper dbHelper = new CoolWeatherOpenHelper(context, DB_NAME, null, VERSION);
		db = dbHelper.getWritableDatabase();
	}
	public synchronized static  CoolWeatherDB getInstance(Context context){
		if(coolWeatherDB == null){
			coolWeatherDB = new CoolWeatherDB(context);
		}
		return coolWeatherDB;
	}
	/**
	 * Examples of the Province stored in the database
	 * @param province
	 */
	public void saveProvince(Province province){
		if(province != null){
			ContentValues values = new ContentValues();
			values.put("province_name", province.getProvinceName());
			values.put("province_code", province.getProvinceCode());
			db.insert("Province", null, values);					
		}
	}
	/**
	 * read all provinces of the information from the database
	 * @return
	 */
	public List<Province> loadProvinces(){
		List<Province> list = new ArrayList<Province>();
		Cursor cursor = db.query("Province", null, null, null, null, null, null);
		if(cursor.moveToFirst()){
			do{
				Province province = new Province();
				province.setId(cursor.getInt(cursor.getColumnIndex("id")));
				province.setProvinceName(cursor.getString(cursor.getColumnIndex("province_name")));
				province.setProvinceCode(cursor.getString(cursor.getColumnIndex("province_code")));
				list.add(province);
			}while(cursor.moveToNext());
		}
		return list;	
	}
	
	/**
	 * Examples of the City stored in the database
	 */
	public void saveCity(This city){
		if(city != null){
			ContentValues values =new ContentValues();
			values.put("city_name", city.getCity_Name());
			values.put("city_code", city.getCity_Code());
			values.put("province_id", city.getProvinceId());
			db.insert("City", null, values);
		}
	}
	
	/**
	 * read all saveCities of the information from the database
	 */
	public List<This> loadCities(int provinceId){
		List<This> list = new ArrayList<This>();
		Cursor cursor = db.query("City", null, "province_id=?", new String[]{String.valueOf(provinceId)}, null, null, null);
		if(cursor.moveToFirst()){
			do{
				This city = new This();
				city.setId(cursor.getInt(cursor.getColumnIndex("id")));
				city.setCity_Name(cursor.getString(cursor.getColumnIndex("city_name")));
				city.setCity_Code(cursor.getString(cursor.getColumnIndex("city_code")));
				city.setProvinceId(provinceId);
				list.add(city);
			}while(cursor.moveToNext());
		}
		return list;
	}
	
	/**
	 * Examples of the County stored in the database
	 */
	public void saveCounty(County county){
		if(county != null){
			ContentValues values = new ContentValues();
			values.put("county_name",county.getCounty_Name());
			values.put("county_code", county.getCounty_Code());
			values.put("city_id", county.getcityId());
			db.insert("County", null, values);
		}
	}

/**
 * read all the countries of the information in the database
*/
public List<County> loadCounties(int cityId){
	List<County> list = new ArrayList<County>();
	Cursor cursor = db.query("County", null, "city_id=?", new String[]{String.valueOf(cityId)}, null, null, null);
	if(cursor.moveToFirst()){
		do{
			County county = new County();
			county.setId(cursor.getInt(cursor.getColumnIndex("id")));
			county.setCounty_Name(cursor.getString(cursor.getColumnIndex("county_name")));
			county.setCountyCode(cursor.getString(cursor.getColumnIndex("county_code")));
		    county.setCityId(cityId);
		    list.add(county);
	}while(cursor.moveToNext());
	}
		return list;
}

}

