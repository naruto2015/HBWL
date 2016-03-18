package com.hb.gds.self.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

public class MyText extends BaseView{

	
	private Paint paint=new Paint();
	private float rx=0;
	public MyText(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public MyText(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void drawSub(Canvas canvas) {
		// TODO Auto-generated method stub
		paint.setTextSize(30);
		canvas.drawText("MyText", 0, 30, paint);
	}

	@Override
	protected void logic() {
		// TODO Auto-generated method stub
		if(rx>getWidth()){
			rx=0-paint.measureText("MyText");
		}
	}

	
	
}
