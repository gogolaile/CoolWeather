package com.example.sql;


import java.util.Vector;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends Activity {
    Vector<Vector<String>> temp;
    String arr[]= new String[temp.size()*temp.get(0).size()+1];
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        Util.createTable();
        temp = Util.search();
        ListView list = (ListView)findViewById(R.id.list);
        int k = 0;
        for(int i=0;i < temp.size();i++){
        	for(int j=0;j < temp.get(0).size(); j++){
        		arr[k++] = temp.get(i).get(j);
        	}
        }
        ArrayAdapter<String>  adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,arr);
        list.setAdapter(adapter);
	}


}
