package com.FOD.entity;
/*
 * 陈彪
 */
public class ZhType {
	private Integer id;// 编号
	private String ctype;// 套餐名
	private Double cprice;// 单价
	private Integer meat;//表示荤菜
	private Integer vegetable;//素菜
	private Integer decoction;//汤
	private Integer cpoints;//积分
	@Override
	public String toString() {
		return "ZhType [id=" + id + ", ctype=" + ctype + ", cprice=" + cprice + ", meat=" + meat + ", vegetable="
				+ vegetable + ", decoction=" + decoction + ", cpoints=" + cpoints + "]";
	}
	public ZhType(Integer id, String ctype, Double cprice, Integer meat, Integer vegetable, Integer decoction,
			Integer cpoints) {
		super();
		this.id = id;
		this.ctype = ctype;
		this.cprice = cprice;
		this.meat = meat;
		this.vegetable = vegetable;
		this.decoction = decoction;
		this.cpoints = cpoints;
	}
	public ZhType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public Double getCprice() {
		return cprice;
	}
	public void setCprice(Double cprice) {
		this.cprice = cprice;
	}
	public Integer getMeat() {
		return meat;
	}
	public void setMeat(Integer meat) {
		this.meat = meat;
	}
	public Integer getVegetable() {
		return vegetable;
	}
	public void setVegetable(Integer vegetable) {
		this.vegetable = vegetable;
	}
	public Integer getDecoction() {
		return decoction;
	}
	public void setDecoction(Integer decoction) {
		this.decoction = decoction;
	}
	public Integer getCpoints() {
		return cpoints;
	}
	public void setCpoints(Integer cpoints) {
		this.cpoints = cpoints;
	}
}
