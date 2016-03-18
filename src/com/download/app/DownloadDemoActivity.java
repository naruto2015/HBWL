package com.download.app;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.download.entity.FileInfo;
import com.download.service.DownloadService;
import com.example.androiddemo.R;
 

public class DownloadDemoActivity extends Activity {
	
	private TextView tvFileName;
	private ProgressBar pbProgress;
	private Button btStop,btStart;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_download_demo);
		
		tvFileName=(TextView)findViewById(R.id.tvFileName);
		pbProgress=(ProgressBar)findViewById(R.id.pbProgress);
		btStart=(Button)findViewById(R.id.btStart);
		btStop=(Button)findViewById(R.id.btStop);
		pbProgress.setMax(100);
		
		//创建文件信息对象
		final FileInfo fileInfo=new FileInfo(0,"http://c.hiphotos.baidu.com/imgad/pic/item/c995d143ad4bd11339411e3c5dafa40f4bfb052b.jpg",
				"apple.jpg",0,0);
		//添加监听器
		btStart.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				btStart.setEnabled(false);
				Intent intent=new Intent(DownloadDemoActivity.this,DownloadService.class);
				intent.setAction(DownloadService.ACTION_START);
				intent.putExtra("fileInfo", fileInfo);
				startService(intent);
			}
		});
		

		btStop.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				btStart.setEnabled(true);
				Intent intent=new Intent(DownloadDemoActivity.this,DownloadService.class);
				intent.setAction(DownloadService.ACTION_STOP);
				intent.putExtra("fileInfo", fileInfo);
				startService(intent);
			}
		});
		
		//代码动态注册广播接收器
	    IntentFilter filter=new IntentFilter();
		filter.addAction(DownloadService.ACTION_UPDATE);
	    registerReceiver(mReceiver, filter);
	}
	
	protected void onDestory(){
		super.onDestroy();
		unregisterReceiver(mReceiver);
	}
	/*
	 * 更新UI广播接收器
	 */
	BroadcastReceiver mReceiver=new BroadcastReceiver(){
		public void onReceive(android.content.Context arg0, Intent intent) {
			if(DownloadService.ACTION_UPDATE.equals(intent.getAction())){
				int finished=intent.getIntExtra("finished", 0);
				pbProgress.setProgress(finished);
			}
		};
		
	};
}
