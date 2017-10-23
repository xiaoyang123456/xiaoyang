package com.FOD.entity;
/*
 * 陈彪
 */
public class GdFood {
	private Integer id;//固定订餐表 编号
	private String pname;//固定订餐表 套餐名
	private Double pprice;//固定订餐表 单价
	private Integer ppoints;//表示积分
	private String pelement;//固定订餐表 积分
	private Integer pstock;//固定订餐表   配菜
	private String pintroduction;//固定订餐表   库存
	private String pkind;//固定订餐表   套餐类别
	private String pimages;//固定订餐表  图片
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Double getPprice() {
		return pprice;
	}
	public void setPprice(Double pprice) {
		this.pprice = pprice;
	}
	public Integer getPpoints() {
		return ppoints;
	}
	public void setPpoints(Integer ppoints) {
		this.ppoints = ppoints;
	}
	public String getPelement() {
		return pelement;
	}
	public void setPelement(String pelement) {
		this.pelement = pelement;
	}
	public Integer getPstock() {
		return pstock;
	}
	public void setPstock(Integer pstock) {
		this.pstock = pstock;
	}
	public String getPintroduction() {
		return pintroduction;
	}
	public void setPintroduction(String pintroduction) {
		this.pintroduction = pintroduction;
	}
	public String getPkind() {
		return pkind;
	}
	public void setPkind(String pkind) {
		this.pkind = pkind;
	}
	public String getPimages() {
		return pimages;
	}
	public void setPimages(String pimages) {
		this.pimages = pimages;
	}
	public GdFood(Integer id, String pname, Double pprice, Integer ppoints, String pelement, Integer pstock,
			String pintroduction, String pkind, String pimages) {
		super();
		this.id = id;
		this.pname = pname;
		this.pprice = pprice;
		this.ppoints = ppoints;
		this.pelement = pelement;
		this.pstock = pstock;
		this.pintroduction = pintroduction;
		this.pkind = pkind;
		this.pimages = pimages;
	}
	public GdFood() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "GdFood [id=" + id + ", pname=" + pname + ", pprice=" + pprice + ", ppoints=" + ppoints + ", pelement="
				+ pelement + ", pstock=" + pstock + ", pintroduction=" + pintroduction + ", pkind=" + pkind
				+ ", pimages=" + pimages + "]";
	}
}
