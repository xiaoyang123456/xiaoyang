package com.FOD.entity;


/**
 * 赠品表（gift)
 * @author 赵凛威
 *
 */
public class Gift {
	private Integer gid;//编号
	private String gname;//赠品名称
	private Integer gpoints;//所需积分
	private Integer stock;//库存
	private String gkind;//类别
	private String ginfor;//详情
	
	
	public Gift() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Gift(Integer gid, String gname, Integer gpoints, Integer stock, String gkind, String ginfor) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.gpoints = gpoints;
		this.stock = stock;
		this.gkind = gkind;
		this.ginfor = ginfor;
	}


	public Integer getGid() {
		return gid;
	}


	public void setGid(Integer gid) {
		this.gid = gid;
	}


	public String getGname() {
		return gname;
	}


	public void setGname(String gname) {
		this.gname = gname;
	}


	public Integer getGpoints() {
		return gpoints;
	}


	public void setGpoints(Integer gpoints) {
		this.gpoints = gpoints;
	}


	public Integer getStock() {
		return stock;
	}


	public void setStock(Integer stock) {
		this.stock = stock;
	}


	public String getGkind() {
		return gkind;
	}


	public void setGkind(String gkind) {
		this.gkind = gkind;
	}


	public String getGinfor() {
		return ginfor;
	}


	public void setGinfor(String ginfor) {
		this.ginfor = ginfor;
	}


	@Override
	public String toString() {
		return "Gift [gid=" + gid + ", gname=" + gname + ", gpoints=" + gpoints + ", stock=" + stock + ", gkind="
				+ gkind + ", ginfor=" + ginfor + "]";
	}


	
}
