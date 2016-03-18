package com.hb.gds.sharesdk;

import java.util.HashMap;

import com.example.androiddemo.R;
import com.example.androiddemo.R.drawable;
import com.example.androiddemo.R.id;
import com.example.androiddemo.R.layout;
import com.hb.gds.bean.Topic;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.onekeyshare.OnekeyShareTheme;

 
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ShareSDKDemoActivity extends Activity {

	
	
	
	private Button onekey_share;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_share_sdkdemo);
		
		onekey_share=(Button) findViewById(R.id.onekey_share);
		onekey_share.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				showShareTypeDialog();
			}
		});
	}

 
	private Topic curTopicInfo;
	private void showShareTypeDialog() {

		curTopicInfo = new Topic();
		curTopicInfo.setId("11");
		curTopicInfo.setTitle("name");
		curTopicInfo.setCommentNum("commentNum");
		curTopicInfo.setReadNum("clickNum");
		curTopicInfo.setPicUrl("http://www.baidu.com");
		curTopicInfo.setDetailUrl("赶快来下载广西和教育APP，点击→http://www.gx.10086.cn/xxt/gx/activity/xxt/app.html");
		curTopicInfo.setCommentUrl("commentsUrl");
		curTopicInfo.setDate("time");
		curTopicInfo.setContent("name");

		final OnekeyShare oks = new OnekeyShare();
		// oks.setAddress("12345678901");
		/*
		 * if(!StringUtils.isEmpty(myAddress) && !"null".equals(myAddress)) {
		 * oks.setText("我在" + myAddress); }else { oks.setText(""); }
		 */
		oks.setTitle(curTopicInfo.getTitle());
//		ImageLoader.getInstance().loadImage(curTopicInfo.getPicUrl(),
//				new ImageLoadingListener() {
//
//					@Override
//					public void onLoadingStarted(String arg0, View arg1) {
//
//					}
//
//					@Override
//					public void onLoadingFailed(String arg0, View arg1,
//							FailReason arg2) {
//						oks.setImageUrl("");
//					}
//
//					@Override
//					public void onLoadingComplete(String arg0, View arg1,
//							Bitmap arg2) {
//						oks.setImageUrl(curTopicInfo.getPicUrl());
//					}
//
//					@Override
//					public void onLoadingCancelled(String arg0, View arg1) {
//
//					}
//				});
		oks.setUrl(curTopicInfo.getDetailUrl());
		String content = "赶快来下载广西和教育APP，点击→http://www.gx.10086.cn/xxt/gx/activity/xxt/app.html";// curTopicInfo.getContent();
		if (content==null || content.equals("")) {
			content = "";
		} 
//		else if (content.length() > 20) {
//			content = content.substring(0, 20) + "...";
//		}
		oks.setText(content);
		oks.setSilent(false);
		// oks.setShareFromQQAuthSupport(shareFromQQLogin);
		oks.setTheme(OnekeyShareTheme.CLASSIC);
		oks.setDialogMode();
		// 令编辑页面显示为Dialog模式

		// 在自动授权时可以禁用SSO方式
		// if(!CustomShareFieldsPage.getBoolean("enableSSO", true))
		oks.disableSSOWhenAuthorize();

		// 去除注释，则快捷分享的操作结果将通过OneKeyShareCallback回调
		oks.setCallback(new OneKeyShareCallback());

		// 去自定义不同平台的字段内容
		// oks.setShareContentCustomizeCallback(new
		// ShareContentCustomizeDemo());

		// 去除注释，演示在九宫格设置自定义的图标
//		Bitmap enableLogo = BitmapFactory.decodeResource(getResources(),
//				R.drawable.ic_launcher);
//		Bitmap disableLogo = BitmapFactory.decodeResource(getResources(),
//				R.drawable.ic_launcher);
//		String label = "短信";
//		OnClickListener listener = new OnClickListener() {
//			public void onClick(View v) {
//				Uri uri = Uri.parse("smsto:");
//				Intent ii = new Intent(Intent.ACTION_SENDTO, uri);// 绿色文字就是启动发送短信窗口
//				ii.putExtra("sms_body",
//						"" + curTopicInfo.getDetailUrl());
//				startActivity(ii);
//		 
//			}
//		};
//		oks.setCustomerLogo(enableLogo, disableLogo, label, listener);

		// 去除注释，演示在九宫格设置自定义的图标
		// Bitmap enableLogoX = BitmapFactory.decodeResource(getResources(),
		// R.drawable.short_sms);
		// Bitmap disableLogoX = BitmapFactory.decodeResource(getResources(),
		// R.drawable.short_sms);
		// String labelX = "新浪微博";
		// OnClickListener listenerX = new OnClickListener() {
		// public void onClick(View v) {
		// // Uri uri = Uri.parse("smsto:");
		// // Intent ii = new Intent(Intent.ACTION_SENDTO, uri);//绿色文字就是启动发送短信窗口
		// // ii.putExtra("sms_body", "我在和教育客户端看到一个很好的文章推荐给你：" +
		// curTopicInfo.getDetailUrl());
		// // startActivity(ii);
		// // sendShareLog("短信");
		//
		//
		// }
		// };
		// oks.setCustomerLogo(enableLogoX, disableLogoX, labelX, listenerX);

//		Bitmap enableLogo2 = BitmapFactory.decodeResource(getResources(),
//				R.drawable.bjkj);
//		Bitmap disableLogo2 = BitmapFactory.decodeResource(getResources(),
//				R.drawable.bjkj);
//		String label2 = "班级+";
//		OnClickListener listener2 = new OnClickListener() {
//			public void onClick(View v) {
//				Intent intent = new Intent(getActivity(),
//						TopicShareActivity.class);
//				intent.putExtra(TopicShareActivity.ID, curTopicInfo.getId());
//				intent.putExtra(TopicShareActivity.PICURL,
//						curTopicInfo.getPicUrl());
//				intent.putExtra(TopicShareActivity.TITLE,
//						curTopicInfo.getTitle());
//				intent.putExtra(TopicShareActivity.DURL,
//						curTopicInfo.getDetailUrl());
//				intent.putExtra(TopicShareActivity.TYPE, 1);
//				startActivity(intent);
//			}
//		};
//		oks.setCustomerLogo(enableLogo2, disableLogo2, label2, listener2);

		// Bitmap enableMoreLogo = BitmapFactory.decodeResource(getResources(),
		// R.drawable.fxgd);
		// Bitmap disableMoreLogo = BitmapFactory.decodeResource(getResources(),
		// R.drawable.fxgd);
		// String morelabel = "更多";
		// final Uri uriToImage = Uri.fromFile(new
		// File(curTopicInfo.getPicUrl()));
		// OnClickListener morelistener = new OnClickListener() {
		// public void onClick(View v) {
		// Intent sendIntent = new Intent();
		// sendIntent.setAction(Intent.ACTION_SEND);
		// sendIntent.putExtra(Intent.EXTRA_TEXT, "我在和教育客户端看到一个很好的文章推荐给你：" +
		// curTopicInfo.getDetailUrl());
		// sendIntent.setType("text/plain");
		// startActivity(Intent.createChooser(sendIntent, "分享到"));
		// }
		// };
		// oks.setCustomerLogo(enableMoreLogo, disableMoreLogo, morelabel,
		// morelistener);
		// 去除注释，则快捷分享九宫格中将隐藏新浪微博和腾讯微博
		// oks.addHiddenPlatform(SinaWeibo.NAME);
		// oks.addHiddenPlatform(TencentWeibo.NAME);

		// 为EditPage设置一个背景的View
		oks.show(ShareSDKDemoActivity.this);

	}
	
	class OneKeyShareCallback implements PlatformActionListener {

		public void onComplete(Platform plat, int action,
				HashMap<String, Object> res) {
		//	sendShareLog(plat == null ? "Wechat" : plat.getName());
		}

		public void onError(Platform plat, int action, Throwable t) {
			t.printStackTrace();
			// 在这里添加分享失败的处理代码
		}

		public void onCancel(Platform plat, int action) {
			// 在这里添加取消分享的处理代码
		}
	}

}
