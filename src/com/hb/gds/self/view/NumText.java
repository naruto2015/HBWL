package com.hb.gds.self.view;

import com.example.androiddemo.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

public class NumText extends BaseView{

	
	private Paint paint=new Paint();
	
	private int lineNum=0;
	public NumText(Context context, AttributeSet attrs) {
		super(context, attrs);
		TypedArray ta=context.obtainStyledAttributes(attrs, R.styleable.NumText);
		lineNum=ta.getInt(R.styleable.NumText_lineNum, 1);
		
		ta.recycle();
		// TODO Auto-generated constructor stub
	}

	public NumText(Context context) {
		super(context,null);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void drawSub(Canvas canvas) {
		// TODO Auto-generated method stub
		for(int i=0;i<lineNum;i++){
			int textSize=30+i;
			paint.setTextSize(textSize);
			canvas.drawText("极客学院", 0, textSize+textSize*i, paint);
		}
	}

	@Override
	protected void logic() {
		// TODO Auto-generated method stub
		
	}

}
