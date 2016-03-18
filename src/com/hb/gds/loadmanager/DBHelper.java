package com.hb.gds.loadmanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{

	private static String name="mydb.db";
	private static int version=1;
	public DBHelper(Context context) {
		super(context, name, null, version);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onCreate(SQLiteDatabase database) {
		// TODO Auto-generated method stub
		String sql="create table student(stuid integer primary key autoincrement,name var char(60))"; 
		database.execSQL(sql);
		
	}
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

}
