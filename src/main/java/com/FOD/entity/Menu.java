package com.FOD.entity;

import java.util.Date;
/*
 * 陈彪
 */
public class Menu {
	private Integer mid;//编号
	private Date time;//时间
	private String  mcontent;//菜谱内容
	public Menu(Integer mid, Date time, String mcontent) {
		super();
		this.mid = mid;
		this.time = time;
		this.mcontent = mcontent;
	}
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getMcontent() {
		return mcontent;
	}
	public void setMcontent(String mcontent) {
		this.mcontent = mcontent;
	}
	@Override
	public String toString() {
		return "Menu [mid=" + mid + ", time=" + time + ", mcontent=" + mcontent + "]";
	}
}
