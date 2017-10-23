package com.FOD.entity;

import java.util.Date;

/*
 * 陈彪
 */
public class Order {
	private Integer id;//表示编号
	private Integer oid;//订单号
	private Integer uid;//订餐人编号
	private String fname;//菜名称
	private Integer count;//分数
	private Double price;//表示单价
	private Date time;//日期
	private String state;//文章状态
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(Integer id, Integer oid, Integer uid, String fname, Integer count, Double price, Date time,
			String state) {
		super();
		this.id = id;
		this.oid = oid;
		this.uid = uid;
		this.fname = fname;
		this.count = count;
		this.price = price;
		this.time = time;
		this.state = state;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", oid=" + oid + ", uid=" + uid + ", fname=" + fname + ", count=" + count
				+ ", price=" + price + ", time=" + time + ", state=" + state + "]";
	}
}
