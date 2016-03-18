package com.hb.gds.self.view;

import java.util.Random;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class LogicView extends View{

	
	private Paint paint=new Paint();
	private float rx=0;
	private MyThread thread;
	private RectF rectF=new RectF(0,60,100,160);
	private float sweepAngle=0;
	
	public LogicView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public LogicView(Context context) {
		// TODO Auto-generated constructor stub
		super(context, null);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		paint.setTextSize(30);
		canvas.drawText("LogicView", rx, 30, paint);
		
		canvas.drawArc(rectF, 0, sweepAngle, true, paint);
		
//		rx=rx+100;
//		canvas.drawText("Logic", rx, 30, paint);
		if(thread==null){
			thread=new MyThread();
			thread.start();
		}
		
	}
	
	class MyThread extends Thread{
		
		Random rand=new Random();
		@Override
		public void run() {
			while(true){
				rx=rx+3;
				
				if(rx>getWidth()){
					rx=0-paint.measureText("LogicView");
				}
				
				sweepAngle++;
				if(sweepAngle>360){
					sweepAngle=0;
				}
				
				int r=rand.nextInt(256);
				int g=rand.nextInt(256);
				int b=rand.nextInt(256);
				paint.setARGB(255, r, g, b);
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
