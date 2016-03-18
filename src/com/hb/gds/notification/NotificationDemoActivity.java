package com.hb.gds.notification;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RemoteViews;

import com.example.androiddemo.MainActivity;
import com.example.androiddemo.R;

public class NotificationDemoActivity extends Activity implements OnClickListener {

	
	private Button button,button2;
	private NotificationManager manager;
	private Notification.Builder builder; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notification_demo);
		
		button=(Button) findViewById(R.id.button1);
		button2=(Button) findViewById(R.id.button2);
		manager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);//创建通知管理类
		button.setOnClickListener(this);
		button2.setOnClickListener(this);
		
	}

	@SuppressLint("NewApi")
	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		case R.id.button1:
			Intent intent=new Intent(NotificationDemoActivity.this, MainActivity.class);
			PendingIntent coIntent=PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);
			builder.setContentIntent(coIntent);
			builder.setContentTitle("new notification is coming!");
			builder.setContentText("hello world!");
			builder.setSmallIcon(R.drawable.ic_launcher);
			builder.setTicker("有通知来了");
			
			//Notification.DEFAULT_ALL所有的提示都是默认的
			builder.setDefaults(Notification.DEFAULT_ALL);
			
//			Uri uri=Uri.parse("");
//			builder.setSound(uri);//提示用户可以自定义设置铃声
			
			Notification notification=builder.build();//仅仅限于在高版本4.1使用
			manager.notify(1000, notification);
			
			
			break;
		case R.id.button2:
			/*
			 * 自定义notification布局
			 */
			RemoteViews cRemoteViews=new RemoteViews(getPackageName(),R.layout.custom_notification);
			cRemoteViews.setImageViewResource(R.id.image, R.drawable.ic_launcher);
			cRemoteViews.setTextViewText(R.id.title, "自定义通知的标题");
			cRemoteViews.setTextViewText(R.id.text, "自定义通知的标题");
			
			Intent intent2=new Intent(NotificationDemoActivity.this, MainActivity.class);
			PendingIntent coIntent2=PendingIntent.getActivity(getApplicationContext(), 0, intent2, 0);
			builder.setContentIntent(coIntent2);
			
			builder.setContent(cRemoteViews); 
			Notification notification2=builder.build();
			manager.notify(1001, notification2);
			
			break;
		 
		}
	}

	 

}
