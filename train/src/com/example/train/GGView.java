package com.example.train;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class GGView extends View{

	int[] mapId;
	static Bitmap[] bma;
	int currentId = 0;
	int currentX,currentY;
	Paint paint ;
	boolean workflag = true;
	boolean initflag = false;
	public GGView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		mapId = new int[]{R.drawable.adv1,R.drawable.adv2,R.drawable.adv3,R.drawable.adv4};
		bma = new Bitmap[mapId.length];
		paint = new Paint();
		paint.setFlags(Paint.ANTI_ALIAS_FLAG);
		initBitmaps();
		new Thread(){
			public void run(){
				while(workflag){
					currentId = (currentId+1)%mapId.length;
					GGView.this.postInvalidate();
					try{
						Thread.sleep(3000);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
	public void initBitmaps(){
		Resources res = this.getResources();
		for(int i = 0;i < mapId.length;i++){
			bma[i] = BitmapFactory.decodeResource(res,mapId[i]);
		}
	}
	public void onDraw(Canvas canvas){
		if(!initflag){
			currentX  = this.getWidth();
			currentY = this.getHeight();
			initflag = true;
		}
		Matrix matrix = new Matrix();
		matrix.postScale(2f, 2f);
		Bitmap dstbmp = Bitmap.createBitmap(bma[currentId], 0, 0, bma[currentId].getWidth(), bma[currentId].getHeight(),matrix,true);
		int picWidth = dstbmp.getWidth();
		int picHeight = dstbmp.getHeight();
		int StartX = (currentX - picWidth)/2;
		int StartY = (currentY - picHeight)/2;
		canvas.drawARGB(255,200,128,128);
		canvas.drawBitmap(dstbmp,StartX,StartY,paint);
		
	}
	
}
