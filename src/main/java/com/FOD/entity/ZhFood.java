package com.FOD.entity;
/*
 * 陈彪	
 */
public class ZhFood {
	private Integer id;//表示编号
	private String ckind;//菜类别
	private String cname;//表示菜名
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCkind() {
		return ckind;
	}
	public void setCkind(String ckind) {
		this.ckind = ckind;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public ZhFood(Integer id, String ckind, String cname) {
		super();
		this.id = id;
		this.ckind = ckind;
		this.cname = cname;
	}
	public ZhFood() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ZhFood [id=" + id + ", ckind=" + ckind + ", cname=" + cname + "]";
	}
	
}
