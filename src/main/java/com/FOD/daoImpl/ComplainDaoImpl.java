package com.FOD.daoImpl;
/*
 * 陈彪
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.FOD.dao.IComplainDao;
import com.FOD.entity.Complain;
import com.FOD.util.DBUtil;

public class ComplainDaoImpl implements IComplainDao{

	public List<Complain> findAll() {
		List<Complain> list=new ArrayList<Complain>();
		Complain cp=null;
		Connection conn = DBUtil.getConnection();
		String sql="select * from  complain";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				cp=new Complain();
				cp.setUid(rs.getInt("uid"));
				cp.setAddress(rs.getString("address"));
				cp.setComide(rs.getInt("comid"));
				cp.setContent(rs.getString("content"));
				cp.setGender(rs.getString("gender"));
				cp.setName(rs.getString("name"));
				cp.setTitle(rs.getString("title"));
				cp.setPhone(rs.getString("phone"));
				list.add(cp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return list;
	}

	public List<Complain> findSplit(int currentPage, int lineSize) {
		Complain zf=null;
		List<Complain> list=new ArrayList<Complain>();
		Connection conn = DBUtil.getConnection();
		String sql="select * from complain  limit ?,?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, (currentPage-1)*lineSize);
			ps.setInt(2, lineSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				zf=new Complain();
				zf.setUid(rs.getInt("uid"));
				zf.setAddress(rs.getString("address"));
				zf.setComide(rs.getInt("comid"));
				zf.setContent(rs.getString("content"));
				zf.setGender(rs.getString("gender"));
				zf.setName(rs.getString("name"));
				zf.setTitle(rs.getString("title"));
				zf.setPhone(rs.getString("phone"));
				list.add(zf);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return list;
	}

	public Complain findByID(int id) {
		Complain complain = new Complain();
		String sql = "select * from complain where id = ?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("查询数据失败!",e);
		}finally{
			DBUtil.closeConnection(con);
		}
		return complain;
	}

	public int doDelete(int id) {
		int a=0;
		Connection conn = DBUtil.getConnection();
		String sql="delete * from  complain where id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			a = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return a;
	}

	public int doAdd(Complain v) {
		int a=0;
		String sql="insert into complain(uid,title,content,name,gender,phone,address) values(?,?,?,?,?,?,?)";
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,v.getUid());
			ps.setString(2,v.getTitle());
			ps.setString(3,v.getContent());
			ps.setString(4,v.getName());
			ps.setString(5,v.getGender());
			ps.setString(6,v.getPhone());
			ps.setString(7,v.getAddress());
			a = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return a;
	}

	public int doUpdate(Complain v) {
		int a=0;
		String sql="update complain   set uid=?,title=?,content=?,name=?,gender=?,phone=?,address=? where comid=? ";
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,v.getUid());
			ps.setString(2,v.getTitle());
			ps.setString(3,v.getContent());
			ps.setString(4,v.getName());
			ps.setString(5,v.getGender());
			ps.setString(6,v.getPhone());
			ps.setString(7,v.getAddress());
			ps.setInt(8, v.getComide());
			a = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return a;
	}

}
