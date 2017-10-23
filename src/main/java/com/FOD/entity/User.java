package com.FOD.entity;
/*
 * 陈彪
 */
public class User {
	private Integer uid;//编号
	private String username;//用户名
	private String password;//密码
	private String phone;//电话号码
	private String address;//地址
	private Integer userpoints;//积分
	private Double money;//余额
	private Integer carid;//餐车编号
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public Integer getUserpoints() {
		return userpoints;
	}
	public void setUserpoints(Integer userpoints) {
		this.userpoints = userpoints;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public Integer getCarid() {
		return carid;
	}
	public void setCarid(Integer carid) {
		this.carid = carid;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", phone=" + phone
				+ ", address=" + address + ", userpoints=" + userpoints + ", money=" + money + ", carid=" + carid + "]";
	}
	public User(Integer uid, String username, String password, String phone, String address, Integer userpoints,
			Double money, Integer carid) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.userpoints = userpoints;
		this.money = money;
		this.carid = carid;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
