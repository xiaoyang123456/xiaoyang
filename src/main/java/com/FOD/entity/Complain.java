package com.FOD.entity;
/*
 * 陈彪
 */
public class Complain {
	private Integer comide;//投诉编号
	private Integer uid;//用户编号
	private String  title ;//标题
	private String  content;//内容
	private String name;//姓名：
	private  String gender ;//性别;
	private String phone ;//联系电话
	private String address;//家庭住址
	@Override
	public String toString() {
		return "Complain [comide=" + comide + ", uid=" + uid + ", title=" + title + ", content=" + content + ", name="
				+ name + ", gender=" + gender + ", phone=" + phone + ", address=" + address + "]";
	}
	public Integer getComide() {
		return comide;
	}
	public void setComide(Integer comide) {
		this.comide = comide;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Complain(Integer comide, Integer uid, String title, String content, String name, String gender, String phone,
			String address) {
		super();
		this.comide = comide;
		this.uid = uid;
		this.title = title;
		this.content = content;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.address = address;
	}
	public Complain() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
