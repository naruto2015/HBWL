package com.download.service;

import java.io.File;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.HttpStatus;
import com.download.entity.FileInfo;
import android.app.Service;
import android.content.Intent;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

public class DownloadService extends Service{

	public static final String DOWNLOAD_PATH=
			Environment.getExternalStorageDirectory().getAbsolutePath()+
			"/downloads/";
	public static final String ACTION_START="ACTION_START";
	public static final String ACTION_STOP="ACTION_STOP";
	public static final int MSG_INIT=0;
	public static final String ACTION_UPDATE="ACTION_UPDATE";
	private DownloadTask mTask=null;
	
	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
	
		//获得activity传来的参数
		if(ACTION_START.equals(intent.getAction())){
			FileInfo fileInfo=(FileInfo) intent.getSerializableExtra("fileInfo");
			Log.i("text", fileInfo.toString());
			new InitThread(fileInfo).start();
		}else if(ACTION_STOP.equals(intent.getAction())){
			FileInfo fileInfo=(FileInfo) intent.getSerializableExtra("fileInfo");
			Log.i("text", fileInfo.toString());
			if(mTask!=null){
				mTask.isPause=true;
			}
		}
		
		return super.onStartCommand(intent, flags, startId);
	}
	
	Handler handler=new Handler(){
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case MSG_INIT:
				FileInfo fileInfo=(FileInfo)msg.obj;
				Log.i("test", "Init:"+fileInfo);
				
				//启动下载任务
				mTask=new DownloadTask(DownloadService.this,fileInfo);
				mTask.download();
				break;
			 
			}
		};
	};
	
	/*
	 * 初始化子线程
	 */
	class InitThread extends Thread{
		private FileInfo mFileInfo=null;
		public InitThread(FileInfo mFileInfo){
			this.mFileInfo=mFileInfo;
		}
		@Override
		public void run() {
		
			/*
			 * 1.连接网络文件
			 * 2.获得文件的长度
			 * 3.在本地创建文件
			 * 4.设置文件的长度
			 * URL统一资源定位符
			 */
			
			HttpURLConnection conn=null;
		    RandomAccessFile raf=null;
			try {
				URL url=new URL(mFileInfo.getUrl());
			    conn=(HttpURLConnection) url.openConnection();
			    conn.setRequestMethod("GET");
			    int length=-1;
			    if(conn.getResponseCode()==HttpStatus.SC_OK){
			    	length=conn.getContentLength();
			    }
			    if(length<=0){
			    	return;
			    }
			    File dir=new File(DOWNLOAD_PATH);
			    if(!dir.exists()){
			    	dir.mkdir();
			    }
			    //在本地创建文件
			    File file=new File(dir, mFileInfo.getFileName());
			    raf=new RandomAccessFile(file, "rwd");
			   
			    //设置文件长度
			    raf.setLength(length);
			    mFileInfo.setLength(length);
			    handler.obtainMessage(MSG_INIT,mFileInfo).sendToTarget();
			    
			} catch (Exception e) {
				// TODO: handle exception
			}finally{
				
				try {
					raf.close();
					conn.disconnect();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			 
		}
	}
	
}
