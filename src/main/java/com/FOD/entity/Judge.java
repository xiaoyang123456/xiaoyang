package com.FOD.entity;

import java.util.Date;

/*
 * 陈彪
 */
public class Judge {
	private Integer id;//评论编号
	private Integer pid;//文章编号
	private Date time;//日期
	private Integer uid;//用户编号
	private String content;//文章内容
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Judge [id=" + id + ", pid=" + pid + ", time=" + time + ", uid=" + uid + ", content=" + content + "]";
	}
	public Judge(Integer id, Integer pid, Date time, Integer uid, String content) {
		super();
		this.id = id;
		this.pid = pid;
		this.time = time;
		this.uid = uid;
		this.content = content;
	}
	public Judge() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
