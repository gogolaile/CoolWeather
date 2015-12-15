package com.example.layer;


import android.app.Activity;
import android.app.AlertDialog;

import android.content.Context;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import android.widget.ViewSwitcher.ViewFactory;


public class MainActivity extends Activity implements  OnGestureListener{
 



		ImageSwitcher imageSwitcher;  
	    ImageSwitcher imageSwitcher1; 
	    ImageSwitcher imageSwitcher2; 
	    ImageSwitcher imageSwitcher3; 
	    ImageSwitcher imageSwitcher4; 
		Animation[] animations = new Animation[5];
		Animation[] reverse = new Animation[5];
		final int FLIP_DISTANCE = 50;
	    GestureDetector detector;
	    Gallery gallery;  
	    int imagePosition;  
	    /** 
	     * 所有的图像图片 
	     */  
	    private  int[] images   
	            = new int[]{ 
	        R.drawable.menu_calendar,R.drawable.menu_converter,R.drawable.menu_icon_alarm  
	        ,R.drawable.menu_icon_pedometer,R.drawable.menu_icon_personalsafety};  
	    AlertDialog imageChooseDialog;  
	    @Override  
	    public void onCreate(Bundle savedInstanceState) {  
	        super.onCreate(savedInstanceState);  
	        setContentView(R.layout.main);  
	        detector = new GestureDetector(MainActivity.this,MainActivity.this);
	        initImageChooseDialog(); 
	  

	    }  
	        
	      
	    //初始化对话框；  
	    private void initImageChooseDialog() {  
            ImageAdapter adapter = new ImageAdapter(this);
	        gallery = (Gallery)findViewById(R.id.img_gallery);  
	        gallery.setAdapter(adapter);//设置gallery数据。  
	        //gallery.setSelection(images.length/2);
	        gallery.setSelection(adapter.getCount()/2);
	        gallery.setUnselectedAlpha(0.3f);
            gallery.setSpacing(100);
	        imageSwitcher = (ImageSwitcher)findViewById(R.id.imageswitch);  
	        imageSwitcher.setFactory(new ImageViewFactory(this));     
	        imageSwitcher1 = (ImageSwitcher)findViewById(R.id.imageswitch1);  
	        imageSwitcher1.setFactory(new ImageViewFactory(this));      
	        imageSwitcher2 = (ImageSwitcher)findViewById(R.id.imageswitch2);  
	        imageSwitcher2.setFactory(new ImageViewFactory(this));     
	        imageSwitcher3 = (ImageSwitcher)findViewById(R.id.imageswitch4);  
	        imageSwitcher3.setFactory(new ImageViewFactory(this));      
	        imageSwitcher4 = (ImageSwitcher)findViewById(R.id.imageswitch5);  
	        imageSwitcher4.setFactory(new ImageViewFactory(this)); 
     
	        imageSwitcher.setImageResource(images[2]);
	        imageSwitcher1.setImageResource(images[1]);
	        imageSwitcher2.setImageResource(images[3]);
	        imageSwitcher3.setImageResource(images[0]);
	        imageSwitcher4.setImageResource(images[4]);
	        
	        animations[0] = AnimationUtils.loadAnimation(MainActivity.this,R.anim.anim);
	        animations[1] = AnimationUtils.loadAnimation(MainActivity.this,R.anim.anim2);
	        animations[2] = AnimationUtils.loadAnimation(MainActivity.this,R.anim.anim3);
	        animations[3] = AnimationUtils.loadAnimation(MainActivity.this,R.anim.anim4);
	        animations[4] = AnimationUtils.loadAnimation(MainActivity.this,R.anim.anim5);
	        reverse[0] = AnimationUtils.loadAnimation(MainActivity.this,R.anim.reverse);
	        reverse[1] = AnimationUtils.loadAnimation(MainActivity.this,R.anim.reverse2);
	        reverse[2] = AnimationUtils.loadAnimation(MainActivity.this,R.anim.reverse3);
	        reverse[3] = AnimationUtils.loadAnimation(MainActivity.this,R.anim.reverse4);
	        reverse[4] = AnimationUtils.loadAnimation(MainActivity.this,R.anim.reverse5);

	        gallery.setOnItemSelectedListener(new OnItemSelectedListener() {
			  
	  
	            @Override  
	            public void onItemSelected(AdapterView<?> parent, View view,  
	                    int position, long id) {  
	                // TODO Auto-generated method stub  
	                ImageView imageview =(ImageView)view;
	                imagePosition=position%images.length;  
	               ((ImageView)view).setImageResource(images[imagePosition]);
	                view.setLayoutParams(new Gallery.LayoutParams(80, 80));
	                
//	    	        imageSwitcher.setInAnimation(reverse[0]);   
//	    	        imageSwitcher1.setInAnimation(reverse[1]); 
//	    	        imageSwitcher2.setInAnimation(reverse[2]);  
//	    	        imageSwitcher3.setInAnimation(reverse[3]); 
//	    	        imageSwitcher4.setInAnimation(reverse[4]);  
	    	        imageSwitcher.setInAnimation(animations[0]);   
	    	        imageSwitcher1.setInAnimation(animations[1]); 
	    	        imageSwitcher2.setInAnimation(animations[2]);  
	    	        imageSwitcher3.setInAnimation(animations[3]); 
	    	        imageSwitcher4.setInAnimation(animations[4]); 

	                imageSwitcher.setImageResource(images[position%images.length]); 	                
	                imageSwitcher1.setImageResource(images[(position+4)%images.length]);
	                imageSwitcher2.setImageResource(images[(position+6)%images.length]);
	                imageSwitcher3.setImageResource(images[(position+3)%images.length]);
	                imageSwitcher4.setImageResource(images[(position+7)%images.length]);
	                
	            }  
	  
	            @Override  
	            public void onNothingSelected(AdapterView<?> parent) {  
	                // TODO Auto-generated method stub  
	                  
	            }  
	        });  

	    }  
	      
	    /** 
	     * 这个Adapter类表示Data、Adapter、View,Adapter表示 Data和View之间的纽带 
	     * 每显示一列数据都会运行这个类. 
	     */  
	    class ImageAdapter extends BaseAdapter{  
	        private Context context;  
	          
	        public ImageAdapter(Context context) {  
	            this.context = context;  
	        }  
	          
	        /** 
	         * 显示的数据列数。这里是可供选择的图片数量。表示画+的次数，在创建类时首先运行。 
	         */  
	        @Override  
	        public int getCount() {  
	            // TODO Auto-generated method stub  
	//System.out.println("BaseAdapter-----getCount:"+images.length);  
	           // return images.length;  
	              return Integer.MAX_VALUE;
	        }  
	  
	        @Override  
	        public Object getItem(int position) {  
	            // TODO Auto-generated method stub  
	//System.out.println("BaseAdapter-----getItem:"+position); 
	            return position;  
	        }  
	  
	        @Override  
	        public long getItemId(int position) {  
	            // TODO Auto-generated method stub  
	//System.out.println("BaseAdapter-----getItemId:"+position);  
	            return position;  
	        }  
	          
	        /** 
	         * 返回自己定义试图；也可以在xml文件里进行定义，（这里定义 的是gallery里的数据的格式 。） 
	         * 这里position表示当前选择列的位置。 
	         * 每显示一列数据都会执行一次 
	         */  
	        @Override  
	        public View getView(int position, View convertView, ViewGroup parent) {   
	        	ImageView iv;
	        	if (convertView == null) {  
	            iv = new ImageView(context);  
	            iv.setImageResource(images[position%images.length]);  
	            iv.setAdjustViewBounds(true);  
	            iv.setLayoutParams(new Gallery.LayoutParams(80,80));  
	        	}else{
	        		iv=(ImageView)convertView;
	        	}
	        	
	            return iv;  
	        }  
	    }  
	    class ImageViewFactory implements ViewFactory{  
	        Context context;  
	        public ImageViewFactory(Context context) {  
	            this.context = context;  
	        }  
	  
	        @Override  
	        public View makeView() {  
	            ImageView iv = new ImageView(context);  
	            //设置显示的大小 。布局参数。  
	            iv.setLayoutParams(new ImageSwitcher.LayoutParams(90, 90));  
	            return iv;  
	        }  
	          
	    }


	    @Override   
	    public boolean onTouchEvent(MotionEvent event) {   
	        // 将该Activity上的触碰事件交给GestureDetector处理   
	        return detector.onTouchEvent(event);   
	    }   
	   
	    @Override   
	    public boolean onDown(MotionEvent e) {   
	         // 触碰时间按下时触发该方法   

	        return false;   
	    }   
	   
	    @Override   
	    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,   
	float velocityY) {   
	         // 当用户在屏幕上“拖动”时触发该方法   
	        Toast.makeText(this, "onFling:"+e1, Toast.LENGTH_SHORT).show();  
	        if(e1 == null){
	        	Toast.makeText(this, "e1 null", Toast.LENGTH_SHORT).show(); 
	        	return true;
	        }
	        if(e2 == null){
	        	Toast.makeText(this, "e2 null", Toast.LENGTH_SHORT).show(); 
	        }
			if (e1.getX() - e2.getX() > FLIP_DISTANCE)
			{
    	        imageSwitcher.setInAnimation(reverse[0]);   
    	        imageSwitcher1.setInAnimation(reverse[1]); 
    	        imageSwitcher2.setInAnimation(reverse[2]);  
    	        imageSwitcher3.setInAnimation(reverse[3]); 
    	        imageSwitcher4.setInAnimation(reverse[4]);  
				System.out.println("left:");
				return true;
			}
			else if (e2.getX() - e1.getX() > FLIP_DISTANCE)
			{
     	        this.imageSwitcher.setInAnimation(animations[0]);   
    	        this.imageSwitcher1.setInAnimation(animations[1]); 
    	        this.imageSwitcher2.setInAnimation(animations[2]);  
    	        this.imageSwitcher3.setInAnimation(animations[3]); 
    	        this.imageSwitcher4.setInAnimation(animations[4]); 
    	        System.out.println("right:");
    	        return true;
			}
	        
	        return false;   
	    }   
	   
	    @Override   
	    public void onLongPress(MotionEvent e) {   
	        // 当用户在屏幕上长按时触发该方法   

	    }   
	   
	    @Override   
	    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,   
	float distanceY) {  
	        // 当屏幕“滚动”时触发该方法   
	        Toast.makeText(this, "onScroll", Toast.LENGTH_SHORT).show(); 
	        if(e1 == null){
	        	Toast.makeText(this, "e1 null", Toast.LENGTH_SHORT).show(); 
	        	return true;
	        }
	        if(e2 == null){
	        	Toast.makeText(this, "e2 null", Toast.LENGTH_SHORT).show(); 
	        }
			if (e1.getX() - e2.getX() > FLIP_DISTANCE)
			{
    	        imageSwitcher.setInAnimation(reverse[0]);   
    	        imageSwitcher1.setInAnimation(reverse[1]); 
    	        imageSwitcher2.setInAnimation(reverse[2]);  
    	        imageSwitcher3.setInAnimation(reverse[3]); 
    	        imageSwitcher4.setInAnimation(reverse[4]);  
				System.out.println("left:");
				return true;
			}
			else if (e2.getX() - e1.getX() > FLIP_DISTANCE)
			{
     	        this.imageSwitcher.setInAnimation(animations[0]);   
    	        this.imageSwitcher1.setInAnimation(animations[1]); 
    	        this.imageSwitcher2.setInAnimation(animations[2]);  
    	        this.imageSwitcher3.setInAnimation(animations[3]); 
    	        this.imageSwitcher4.setInAnimation(animations[4]); 
    	        System.out.println("right:");
    	        return true;
			}
	        return false;   
	    }   
	   
	    @Override   
	    public void onShowPress(MotionEvent e) {   
	        // 当用户在触摸屏幕上按下、而且还未移动和松开时触发该方法   
 
	    }   
	   
	    @Override   
	    public boolean onSingleTapUp(MotionEvent e) {   
	        // 在屏幕上的轻击事件将会触发该方法   
	      
	        return false;   
	    } 
}  

