package com.hb.gds.self.view;

import java.util.Random;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;

public class LogicView2 extends BaseView{

	
	private Paint paint=new Paint();
	private float rx=0;
 
	private RectF rectF=new RectF(0,60,100,160);
	private float sweepAngle=0;
	Random rand=new Random();
	
	public LogicView2(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public LogicView2(Context context, AttributeSet attrs) {
		super(context, attrs); 
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void drawSub(Canvas canvas) {
		// TODO Auto-generated method stub
		paint.setTextSize(30);
		canvas.drawText("LogicView", rx, 30, paint);
		
		canvas.drawArc(rectF, 0, sweepAngle, true, paint);
	}

	@Override
	protected void logic() {
		// TODO Auto-generated method stub
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
	}

}
