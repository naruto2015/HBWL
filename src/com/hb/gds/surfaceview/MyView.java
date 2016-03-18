package com.hb.gds.surfaceview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MyView extends SurfaceView implements SurfaceHolder.Callback{

	public MyView(Context context) {
		super(context);
		paint=new Paint();
		paint.setColor(Color.RED);
		getHolder().addCallback(this);
		// TODO Auto-generated constructor stub
	}

	private Paint paint=null;
	
	public void draw(){
		/*
		 * ����ͼ��ǰ��ס����
		 */
		Canvas canvas=getHolder().lockCanvas();
		
		
		/*
		 * ����
		 */
		canvas.drawRect(0, 30, 200, 100, paint);
		
		
		/*
		 * ��ɺ��������
		 */
		getHolder().unlockCanvasAndPost(canvas);
		
	}
	
	@Override
	public void surfaceChanged(SurfaceHolder holder, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		draw();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}

}
