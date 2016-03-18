package com.download.db;

import java.util.List;

import com.download.entity.ThreadInfo;

public interface ThreadDAO {

	public void insertThread(ThreadInfo threadInfo);
	public void deleteThread(String url,int thread_id);
	public void updateThread(String url,int thread_id,int finished);

	//查询文件的线程信息
	public List<ThreadInfo> getThreads(String url);
	
	//判断一个线程信息是否已经在数据库存在
	public boolean isExists(String url,int thread_id);
	
}
