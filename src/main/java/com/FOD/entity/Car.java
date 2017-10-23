package com.FOD.entity;

/**
 * 
 * @author XY
 *
 */
public class Car {
	private Integer id;//编号
	private Integer uid;//用户id
	private String carvname;//菜名
	private double carvprice;//单价
	private Integer carvpoints;//积分
	private String carvelments;//主料
	private String carvtaste;//口味
	private Integer carvastock;//可定份数
	private String carvintro;//详情
	private String carvkind;//菜的类别
	private String carvimages;//图片
	
	public Car() {
		
	}

	public Car(Integer id, Integer uid, String carvname, double carvprice, Integer carvpoints, String carvelments,
			String carvtaste, Integer carvastock, String carvintro, String carvkind, String carvimages) {
		super();
		this.id = id;
		this.uid = uid;
		this.carvname = carvname;
		this.carvprice = carvprice;
		this.carvpoints = carvpoints;
		this.carvelments = carvelments;
		this.carvtaste = carvtaste;
		this.carvastock = carvastock;
		this.carvintro = carvintro;
		this.carvkind = carvkind;
		this.carvimages = carvimages;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getCarvname() {
		return carvname;
	}

	public void setCarvname(String carvname) {
		this.carvname = carvname;
	}

	public double getCarvprice() {
		return carvprice;
	}

	public void setCarvprice(double carvprice) {
		this.carvprice = carvprice;
	}

	public Integer getCarvpoints() {
		return carvpoints;
	}

	public void setCarvpoints(Integer carvpoints) {
		this.carvpoints = carvpoints;
	}

	public String getCarvelments() {
		return carvelments;
	}

	public void setCarvelments(String carvelments) {
		this.carvelments = carvelments;
	}

	public String getCarvtaste() {
		return carvtaste;
	}

	public void setCarvtaste(String carvtaste) {
		this.carvtaste = carvtaste;
	}

	public Integer getCarvastock() {
		return carvastock;
	}

	public void setCarvastock(Integer carvastock) {
		this.carvastock = carvastock;
	}

	public String getCarvintro() {
		return carvintro;
	}

	public void setCarvintro(String carvintro) {
		this.carvintro = carvintro;
	}

	public String getCarvkind() {
		return carvkind;
	}

	public void setCarvkind(String carvkind) {
		this.carvkind = carvkind;
	}

	public String getCarvimages() {
		return carvimages;
	}

	public void setCarvimages(String carvimages) {
		this.carvimages = carvimages;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", uid=" + uid + ", carvname=" + carvname + ", carvprice=" + carvprice
				+ ", carvpoints=" + carvpoints + ", carvelments=" + carvelments + ", carvtaste=" + carvtaste
				+ ", carvastock=" + carvastock + ", carvintro=" + carvintro + ", carvkind=" + carvkind + ", carvimages="
				+ carvimages + "]";
	}
}
