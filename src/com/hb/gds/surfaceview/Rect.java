package com.hb.gds.surfaceview;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Rect extends Contanier{

	private Paint paint=null;
	public Rect() {
		// TODO Auto-generated constructor stub
		paint=new Paint();
		paint.setColor(Color.RED);
		
		
	}
	
	@Override
	public void childrenView(Canvas canvas) {
		// TODO Auto-generated method stub
		super.childrenView(canvas);
		canvas.drawRect(0, 0, 100, 100, paint);
	}
	
}
