package com.FOD.entity;
/*
 * 陈彪
 */
public class SavePage {
	private Integer id;//编号
	private Integer tid;//文章编号	
	private Integer uid;//用户
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	@Override
	public String toString() {
		return "SavePage [id=" + id + ", tid=" + tid + ", uid=" + uid + "]";
	}
	public SavePage(Integer id, Integer tid, Integer uid) {
		super();
		this.id = id;
		this.tid = tid;
		this.uid = uid;
	}
	public SavePage() {
		super();
		// TODO Auto-generated constructor stub
	}
}
