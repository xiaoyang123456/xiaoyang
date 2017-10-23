package com.FOD.entity;

import java.util.Date;
/*
 * 陈彪
 */
public class Page {
	private Integer pid;//编号
	private String title;//标题
	private String author;//作者
	private Date time;//时间
	private Integer views;//浏览量
	private Integer praize;//支持或者反对
	private String type;//文章类别
	private  String content;//表示文章内容
	public Page(Integer pid, String title, String author, Date time, Integer views, Integer praize, String type,
			String content) {
		super();
		this.pid = pid;
		this.title = title;
		this.author = author;
		this.time = time;
		this.views = views;
		this.praize = praize;
		this.type = type;
		this.content = content;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Integer getViews() {
		return views;
	}
	public void setViews(Integer views) {
		this.views = views;
	}
	public Integer getPraize() {
		return praize;
	}
	public void setPraize(Integer praize) {
		this.praize = praize;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Page [pid=" + pid + ", title=" + title + ", author=" + author + ", time=" + time + ", views=" + views
				+ ", praize=" + praize + ", type=" + type + ", content=" + content + "]";
	}
	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}
}
