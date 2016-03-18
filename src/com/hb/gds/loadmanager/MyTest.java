package com.hb.gds.loadmanager;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.test.AndroidTestCase;

public class MyTest extends AndroidTestCase{
	
	public MyTest() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void add(){
		ContentResolver contentResolver=getContext().getContentResolver();
		ContentValues values=new ContentValues();
		values.put("name", "jack2");
		Uri uri=Uri.parse("content://com.hb.gds.loadmanager.StudentContentProvider/student");
		contentResolver.insert(uri, values);
	}
	
	
	public void delete(){
		ContentResolver contentResolver=getContext().getContentResolver();
		Uri uri=Uri
				.parse("content://com.hb.gds.loadmanager.StudentContentProvider/student");
		int count=contentResolver.delete(uri, null, null);
		System.out.println("---count--->>"+count);
		
	}
	
	
	public void query(){
		ContentResolver contentResolver=getContext().getContentResolver();
		//查询所有记录 
		Uri uri=Uri
				.parse("content://com.hb.gds.loadmanager.StudentContentProvider/student");
		//Uri uri2=ContentUris.withAppendedId(uri, 2);//查询主键为2的记录
		Cursor cursor=contentResolver.query(uri, null, null, null, null);
		while(cursor.moveToNext()){
			System.out.println("-->>"+cursor.getString(cursor.getColumnIndex("name")));
		}
		
		
	}
	

}
