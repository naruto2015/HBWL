package com.hb.gds.surfaceview;

 

import android.os.Bundle;
import android.app.Activity;
 

public class SurfaceViewDemoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_surface_view_demo);
		//setContentView(new MyView(this));
		setContentView(new MyView02(this));
	}

	 

}
