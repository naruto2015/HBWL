package com.hb.gds.bean;

 

import java.io.Serializable;
 
 

public class Topic implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5415417321253873359L;
	private String id;
	private String title;
	private String date;
	private String picUrl;
	private String content;
	private String commentNum;
	private String readNum;
	private String detailUrl;
	private String commentUrl;
	
	
	 

	public String getDetailUrl() {
		return detailUrl;
	}

	public void setDetailUrl(String detailUrl) {
		this.detailUrl = detailUrl;
	}

	public String getCommentUrl() {
		return commentUrl;
	}

	public void setCommentUrl(String commentUrl) {
		this.commentUrl = commentUrl;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(String commentNum) {
		this.commentNum = commentNum;
	}

	public String getReadNum() {
		return readNum;
	}

	public void setReadNum(String readNum) {
		this.readNum = readNum;
	}

}
