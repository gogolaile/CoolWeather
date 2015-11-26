package com.example.train;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

public class CityAdapter<T> extends BaseAdapter implements Filterable {

	private List<T> mObjects;
	private List<T> mObjects2;
	private final Object mLock = new Object();
	private int mResource;
	private int mDropDownResource;
	private int mFieldId = 0;
	private boolean mNotifyOnChange = true;
	private Context mContext;
	private ArrayList<T> mOriginalValues;
	private ArrayFilter mFilter;
	private LayoutInflater mInflater;
    public  CityAdapter(Context context,int textViewResourceId,T[] objects,T[] object2) {
		// TODO Auto-generated constructor stub
		init(context,textViewResourceId,0,Arrays.asList(objects),Arrays.asList(object2));
	}
	
	public void add(T object){
		if(mOriginalValues != null){
			synchronized(mLock){
				mOriginalValues.add(object);
				if(mNotifyOnChange)notifyDataSetChanged();
			}
		}else{
			mObjects.add(object);
			if(mNotifyOnChange)notifyDataSetChanged();
		}
	}
	public void insert(T object,int index){
		if(mOriginalValues !=null){
			synchronized(mLock){
				mOriginalValues.add(index,object);
				if(mNotifyOnChange) notifyDataSetChanged();
			}
		}else{
			mObjects.add(index, object);
			if(mNotifyOnChange) notifyDataSetChanged();
		}
	}
	public void remove(T object){
		if(mOriginalValues != null){
			synchronized(mLock){
				mOriginalValues.remove(object);
			}
		}else{
			mObjects.remove(object);
		}if(mNotifyOnChange) notifyDataSetChanged();
	}
	public void clear(){
		if(mOriginalValues != null){
			synchronized(mLock){
				mOriginalValues.clear();
			}
		}else{
			mObjects.clear();
		}if(mNotifyOnChange)notifyDataSetChanged();
	}
	public void sort(Comparator<? super T>comparator){
		Collections.sort(mObjects,comparator);
		if(mNotifyOnChange) notifyDataSetChanged();
	}
	public void notifyDataSetChanged(){
		super.notifyDataSetChanged();
		mNotifyOnChange = true;
	}
	public void setNotifyOnChange(boolean notifyOnChange){
		mNotifyOnChange = notifyOnChange;
	}
	private void init(Context context,int resource,int textViewResourceId,List<T> objects,List<T> objects2){
		mContext = context;
		mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mResource = mDropDownResource = resource;
		mObjects = objects;
		mObjects2 = objects2;
		mFieldId = textViewResourceId;
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
	private View createViewFromResource(int position,View convertView,ViewGroup parent,int resource){
		View view;
		TextView text;
		if(convertView == null){
			view = mInflater.inflate(resource, parent,false);
		}else{
			view = convertView;
		}try{
			if(mFieldId == 0){
				text = (TextView)view;
			}else{
				text = (TextView)view.findViewById(mFieldId);
			}
		}catch(ClassCastException e){
			throw new IllegalStateException(
				"ArrayAdapter requires the resource ID to be a TextView",e
			);
		}
		text.setText(getItem(position).toString());
		return view;
	}
	
	public void setDropDownViewResource(int resource){
		this.mDropDownResource = resource;
	}
	
	public View getDropDownView(int position,View convertView,ViewGroup parent){
		return createViewFromResource(position,convertView,parent,mDropDownResource);
	}
	public static ArrayAdapter<CharSequence> createFromResource(Context context,int textArrayResId,int textViewResId){
		CharSequence[] Strings = context.getResources().getTextArray(textArrayResId);
		return new ArrayAdapter<CharSequence>(context,textViewResId,Strings);
	}

	@Override
	public Filter getFilter() {
		// TODO Auto-generated method stub
		if(mFilter == null){
			mFilter = new ArrayFilter();
		}return mFilter;
	}
	private class ArrayFilter extends Filter{

		@Override
		protected FilterResults performFiltering(CharSequence prefix) {
			// TODO Auto-generated method stub
			FilterResults results = new FilterResults();
			if(mOriginalValues == null){
				synchronized(mLock){
					mOriginalValues = new ArrayList<T>(mObjects);
				}
			}if(prefix == null ||prefix.length() == 0){
				synchronized(mLock){
					ArrayList<T> list = new ArrayList<T>(mOriginalValues);
					results.values = list;
					results.count = list.size();
				}
			}else{
				String prefixString = prefix.toString().toLowerCase();
				final ArrayList<T>  values = mOriginalValues;
				final int count = values.size();
				final ArrayList<T> newValues = new ArrayList<T>(count);
				for(int i = 0;i < count; i++){
					final T value = values.get(i);
					final String valueText = value.toString().toLowerCase();
					final T value2 = mObjects2.get(i);
					final String valueText2 = value2.toString().toLowerCase();
					if(valueText2.startsWith(prefixString)){
						newValues.add(value);
					}else if(valueText.startsWith(prefixString)){
						newValues.add(value);
					}else{
						final String[] words = valueText.split(" ");
						final int wordCount  = words.length;
						for(int k = 0;k < wordCount; k++){
							if(words[k].startsWith(prefixString)){
								newValues.add(value);
								break;
							}}
						final String[]  words2 = valueText2.split(" ");
						final int wordCount2 = words2.length;
						for(int k= 0;k < wordCount2;k++){
							if(words2[k].startsWith(prefixString)){
								newValues.add(value);
								break;
							}
						}
						}}
				results.values = newValues;
				results.count = newValues.size();
				}
			return results;
		}

		@Override
		protected void publishResults(CharSequence constraint, FilterResults results) {
			// TODO Auto-generated method stub
			
		}
		
	}
 
}
