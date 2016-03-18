package com.hb.gds.self.view;

import java.util.Random;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public abstract class BaseView extends View{

 
	private MyThread thread;
	private boolean running=true;
	 
	public BaseView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public BaseView(Context context) {
		// TODO Auto-generated constructor stub
		super(context, null);
	}
	
	protected abstract void drawSub(Canvas canvas);
	protected abstract void logic();
	
	
	//final禁止子类修改ondraw方法
	@Override
	protected final void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		
//		rx=rx+100;
//		canvas.drawText("Logic", rx, 30, paint);
		if(thread==null){
			thread=new MyThread();
			thread.start();
		}else{
			drawSub(canvas);
		}
	}
	
	//离开屏幕
	@Override
	protected void onDetachedFromWindow() {
		// TODO Auto-generated method stub
		running=false;
		super.onDetachedFromWindow();
	}

	class MyThread extends Thread{
		@Override
		public void run() {
			while(running){
				logic();
				postInvalidate();//在线程中更新ondraw()方法;
				try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
	
}
