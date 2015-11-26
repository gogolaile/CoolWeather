package com.example.train;

import android.R.color;
import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class WelcomeView extends SurfaceView implements SurfaceHolder.Callback{
        MainActivity activity;
		Paint paint;
		int currentAlpha = 0;
		int screenWidth = 480;
		int screenHeight = 320;
		int sleepSpan = 50;
		Bitmap [] logos = new Bitmap[2];
		Bitmap currentLogo;
		int currentX;
		int currentY;
		public WelcomeView(MainActivity activity){
			super(activity);
			this.activity = activity;
			this.getHolder().addCallback(this);
			paint = new Paint();
			paint.setAntiAlias(true);
			logos[0] = BitmapFactory.decodeResource(activity.getResources(), R.drawable.baina);
			logos[1] = BitmapFactory.decodeResource(activity.getResources(), R.drawable.bnkjs);
		}
		
		public void onDraw(Canvas canvas){
			paint.setColor(color.black);
			paint.setAlpha(255);
			canvas.drawRect(0, 0,screenWidth,screenHeight,paint);
			if(currentLogo == null)return;
			paint.setAlpha(currentAlpha);
			canvas.drawBitmap(currentLogo, currentX, currentY,paint);
		}
		public void surfaceChanged(SurfaceHolder arg0,int arg1,int arg2,int arg3){}

		@SuppressLint("WrongCall")
		@Override
		public void surfaceCreated(SurfaceHolder holder) {
			// TODO Auto-generated method stub
			new Thread(){
				public void run(){
					for(Bitmap bm:logos){
						currentLogo = bm;
						currentX = screenWidth/2 - bm.getWidth()/2;
						currentY = screenHeight/2  - bm.getHeight()/2;
						for(int i=255;i>-10;i=i-10){
							currentAlpha = i;
							if(currentAlpha <0){
								currentAlpha = 0;
							}
							SurfaceHolder myholder = WelcomeView.this.getHolder();
							Canvas canvas =myholder.lockCanvas();
							try{
								synchronized (myholder) {
								onDraw(canvas);	
								}
							}catch(Exception e){
								e.printStackTrace();
							}finally{
								if(canvas !=null){
									myholder.unlockCanvasAndPost(canvas);
								}}
							try{
								if(i ==255){
									Thread.sleep(1000);
								}
								Thread.sleep(sleepSpan);
							}catch(Exception e){
								e.printStackTrace();
							}
						}
					}
					activity.hd.sendEmptyMessage(1);
				}
			}.start();
		}

		@Override
		public void surfaceDestroyed(SurfaceHolder holder) {
			// TODO Auto-generated method stub
			
		}
		
}
