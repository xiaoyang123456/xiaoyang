package com.FOD.entity;
/*
 * 陈彪
 */
public class ZxFood {
	private Integer id;//编号
	private String fname;//菜名
	private Double fprice;// 单价
	private Integer fpoints;//表示积分
	private String felement;//表示主料
	private String ftaste;//口味
	private Integer fstock;//  库存
	private String fintroduction;//详情
	private String fkind;//菜品类别
	private String fimages;//图片
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public Double getFprice() {
		return fprice;
	}
	public void setFprice(Double fprice) {
		this.fprice = fprice;
	}
	public Integer getFpoints() {
		return fpoints;
	}
	public void setFpoints(Integer fpoints) {
		this.fpoints = fpoints;
	}
	public String getFelement() {
		return felement;
	}
	public void setFelement(String felement) {
		this.felement = felement;
	}
	public String getFtaste() {
		return ftaste;
	}
	public void setFtaste(String ftaste) {
		this.ftaste = ftaste;
	}
	public Integer getFstock() {
		return fstock;
	}
	public void setFstock(Integer fstock) {
		this.fstock = fstock;
	}
	public String getFintroduction() {
		return fintroduction;
	}
	public void setFintroduction(String fintroduction) {
		this.fintroduction = fintroduction;
	}
	public String getFkind() {
		return fkind;
	}
	public void setFkind(String fkind) {
		this.fkind = fkind;
	}
	public String getFimages() {
		return fimages;
	}
	public void setFimages(String fimages) {
		this.fimages = fimages;
	}
	@Override
	public String toString() {
		return "ZxFood [id=" + id + ", fname=" + fname + ", fprice=" + fprice + ", fpoints=" + fpoints + ", felement="
				+ felement + ", ftaste=" + ftaste + ", fstock=" + fstock + ", fintroduction=" + fintroduction
				+ ", fkind=" + fkind + ", fimages=" + fimages + "]";
	}
	public ZxFood(Integer id, String fname, Double fprice, Integer fpoints, String felement, String ftaste,
			Integer fstock, String fintroduction, String fkind, String fimages) {
		super();
		this.id = id;
		this.fname = fname;
		this.fprice = fprice;
		this.fpoints = fpoints;
		this.felement = felement;
		this.ftaste = ftaste;
		this.fstock = fstock;
		this.fintroduction = fintroduction;
		this.fkind = fkind;
		this.fimages = fimages;
	}
	public ZxFood() {
		super();
		// TODO Auto-generated constructor stub
	}
}
