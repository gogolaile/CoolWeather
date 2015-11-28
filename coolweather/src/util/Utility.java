package util;

import android.text.TextUtils;
import model.CoolWeatherDB;
import model.County;
import model.Province;
import model.This;

public class Utility {
	public synchronized static boolean handleProvincessResponse(
			CoolWeatherDB coolweatherDB,String response){
		if(!TextUtils.isEmpty(response)){
			String[] allProvinces = response.split(",");
			if(allProvinces != null && allProvinces.length > 0){
				for(String p:allProvinces){
					String[] array = p.split("\\|");
					Province province = new Province();
					province.setProvinceCode(array[0]);
					province.setProvinceName(array[1]);
					coolweatherDB.saveProvince(province);
				}
				return true;
			}
		}
		return false;
	}
	
	
public static boolean handlecitiesResponse(CoolWeatherDB coolweatherDB,String response,int provinceId){
	if(!TextUtils.isEmpty(response)){
		String[] allCities = response.split(",");
		if(allCities != null && allCities.length > 0){
			for(String c : allCities){
				String[] array = c.split("\\|");
				This city = new This();
				city.setCity_Code(array[0]);
				city.setCity_Name(array[1]);
				city.setProvinceId(provinceId);
				coolweatherDB.saveCity(city);
			}
			return true;
		}
	}
	return false;
}	

public static boolean handlecountiesResponse(CoolWeatherDB coolweatherDB,String response,int cityId){
	if(!TextUtils.isEmpty(response)){
		String[] allcounties = response.split(",");
		if(allcounties != null && allcounties.length > 0){
			for(String c :allcounties){
				String[] array = c.split("\\|");
				County county = new County();
				county.setCountyCode(array[0]);
				county.setCounty_Name(array[1]);
				county.setCityId(cityId);
				coolweatherDB.saveCounty(county);
			}
			return true;
		}
	}
	return false;
}
}



















