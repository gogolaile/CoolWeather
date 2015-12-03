package com.example.train_qurey;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

public class CityAdapter<T> extends BaseAdapter implements Filterable {

	private List<T> mObjects;
	private List<T> mObjects2;
	private final Object mLock  = new Object();
	private int mResource;
	private int mFieldId;
	private int mDropDownResource;
	private LayoutInflater mInflater;
	private Context mContext;
	public CityAdapter(Context context,int textViewResourceId,T[] objects,T[] objects2){
		init(context,textViewResourceId,0,Arrays.asList(objects),Arrays.asList(objects2));
	}
	private void init(Context context, int textViewResourceId, int i, List<T> asList, List<T> asList2) {
		// TODO Auto-generated method stub
		mObjects = asList;
		mObjects2 = asList2;
		mFieldId = i;
		mResource = mDropDownResource = textViewResourceId;
		mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mContext = context;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mObjects.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mObjects.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		return createViewFromResource(position,convertView,parent,mResource);
	}

	private View createViewFromResource(int position, View convertView, ViewGroup parent, int mResource2) {
		// TODO Auto-generated method stub
		View view;
		TextView text;
		if(convertView == null){
			view = mInflater.inflate(mResource2, parent,false);
		}else{
			view = convertView;
		}
		try{
			if(mFieldId == 0){
				text = (TextView)view;
			}
			else{
				text = (TextView)view.findViewById(mFieldId);
			}
		}catch(ClassCastException e){
			throw new IllegalStateException("ArrayAdapter requires the resource ID to be a TextView",e);
		}
		text.setText(getItem(position).toString());
		return view;
	}
	public int getPosition(T item){
		return mObjects.indexOf(item);
	}
	
	@Override
	public Filter getFilter() {
		// TODO Auto-generated method stub
		return null;
	}

}
