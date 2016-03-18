package com.hb.gds.loadmanager;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.SyncStateContract.Helpers;

public class StudentContentProvider extends ContentProvider{

	private final static UriMatcher URI_MATCHER=new UriMatcher(UriMatcher.NO_MATCH);
	private final static int STUDENT=1;//表示插入单条记录
	private final static int STUDENTS=2;
	
	private DBHelper dbHelper;
	static
	{  
		URI_MATCHER.addURI("com.hb.gds.loadmanager.StudentContentProvider", "student", STUDENTS);
		URI_MATCHER.addURI("com.hb.gds.loadmanager.StudentContentProvider", "student/#", STUDENT);
	}
	
	public StudentContentProvider() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public int delete(Uri uri, String selection, String[] selectArgs) {
		// TODO Auto-generated method stub
		int count=0;//影响数据库的行数
		int flag=URI_MATCHER.match(uri);
		SQLiteDatabase database=dbHelper.getWritableDatabase();
		
		switch (flag) {
		case STUDENT:
		    long stuid=ContentUris.parseId(uri);
		    String where_value=" stuid = "+stuid;
		    if(where_value!=null && !selection.equals("")){
		    	where_value+=selection;
		    }
		    count=database.delete("student", where_value, selectArgs);
		    
			break;

		case STUDENTS:
		    count=database.delete("student", selection, selectArgs);
			break;
		}
		
		
		
		return count;
	}

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		int flag=URI_MATCHER.match(uri);
		switch (flag) {
		case STUDENT:
			
			return "vnd.android.cursor.item/student";
			 

		case STUDENTS:
			
			return "vnd.android.cursor.dir/students";

		 
		}
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues contentValues) {
		// TODO Auto-generated method stub
		int flag=URI_MATCHER.match(uri);
		SQLiteDatabase database=dbHelper.getWritableDatabase();
		Uri uri2=null;
		
		switch (flag) {
		case STUDENTS:
			long id=database.insert("student", null, contentValues);
			uri2=ContentUris.withAppendedId(uri, id);
			break;
		 
		}
		System.out.println("---------->>>>>>>"+uri2.toString());
		
		return uri2;
	}

	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		dbHelper=new DBHelper(getContext());
		return false;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
			String sortOrder) {
		
		Cursor cursor=null;
		int flag=URI_MATCHER.match(uri);
		SQLiteDatabase database=dbHelper.getReadableDatabase();
		switch (flag) {
		case STUDENT:
			long stuid=ContentUris.parseId(uri);
			String where_value=" stuid= "+stuid;
			if(selection!=null && !"".equals(selection)){
				where_value+=selection;
			}
			cursor=database.query("student", projection, where_value, selectionArgs, null, null, null); 
			break;
			
		case STUDENTS:
			cursor=database.query("student", projection, selection, selectionArgs, null, null, null); 	
			break;
		}
		
		return cursor;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
		
		int count=0;
		int flag=URI_MATCHER.match(uri);
		SQLiteDatabase database=dbHelper.getWritableDatabase();
		
		switch (flag) {
		case STUDENT:
		    long stuid=ContentUris.parseId(uri);
		    String where_value=" stuid = "+stuid;
		    if(where_value!=null && !selection.equals("")){
		    	where_value+=selection;
		    }
		    count=database.update("student", values,where_value, selectionArgs);
		    
			break;

		case STUDENTS:
		    count=database.update("student", values, selection, selectionArgs);
			break;
		}
		
		return count;
	}

}
