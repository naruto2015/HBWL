package com.hb.gds.self.view;

import com.example.androiddemo.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View{

	
	private Bitmap bitmap;
	
	public MyView(Context context, AttributeSet attrs) {
		super(context, attrs);
		bitmap=BitmapFactory.decodeResource(getResources()
				, R.drawable.ic_launcher);
		// TODO Auto-generated constructor stub
	}

	public MyView(Context context) {
		super(context,null);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onDraw(Canvas canvas) {
		 
		Paint paint=new Paint();
		paint.setTextSize(30);
		paint.setColor(Color.RED);
		paint.setStyle(Style.STROKE);//设置绘制图形为空心
		
		canvas.drawText("This is onDraw", 0, 30, paint);
		
		//直线
		canvas.drawLine(0, 60, 100, 60, paint);
		//矩形
//		canvas.drawRect(0, 90, 100, 190, paint);
		//rect绘制矩形
//		Rect rect=new Rect(0, 90, 100, 190);
		RectF rect=new RectF(0, 90, 100, 190);
		canvas.drawRoundRect(rect, 10, 10, paint);
		//绘制圆形
		canvas.drawCircle(50, 270, 50, paint);
		
		canvas.drawBitmap(bitmap, 0, 350, paint);
		
	}
	
	 
}
