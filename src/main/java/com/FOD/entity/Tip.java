package com.FOD.entity;

import java.util.Date;
/*
 * 陈彪
 */
public class Tip {
	private Integer tid;//编号
	private  String username;//用户名
	private String content;//内容
	private Integer feel;//当前心情
	private Integer score;//平分
	private Date time ;//时间
	
	public Tip() {
		// TODO Auto-generated constructor stub
	}

	public Tip(Integer tid, String username, String content, Integer feel, Integer score, Date time) {
		super();
		this.tid = tid;
		this.username = username;
		this.content = content;
		this.feel = feel;
		this.score = score;
		this.time = time;
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getFeel() {
		return feel;
	}

	public void setFeel(Integer feel) {
		this.feel = feel;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Tip [tid=" + tid + ", username=" + username + ", content=" + content + ", feel=" + feel + ", score="
				+ score + ", time=" + time + "]";
	}
	
}
