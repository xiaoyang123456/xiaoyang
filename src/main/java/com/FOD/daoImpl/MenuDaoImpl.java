package com.FOD.daoImpl;
/*
 * 陈彪
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.FOD.dao.IMenuDao;
import com.FOD.entity.Menu;
import com.FOD.util.DBUtil;

public class MenuDaoImpl implements IMenuDao {

	public List<Menu> findAll() {
		String sql="select * from menu";
		Menu menu=null;
		List<Menu> list=new ArrayList<Menu>();
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				menu=new Menu();
				menu.setMid(rs.getInt("mid"));
				menu.setTime(rs.getTime("time"));
				menu.setMcontent(rs.getString("mcontent"));
				list.add(menu);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return list;
	}
	public List<Menu> findSplit(int currentPage, int lineSize) {
		Menu zf=null;
		List<Menu> list=new ArrayList<Menu>();
		Connection conn = DBUtil.getConnection();
		String sql="select * from menu  limit ?,?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, (currentPage-1)*lineSize);
			ps.setInt(2, lineSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				zf=new Menu();
				zf.setMid(rs.getInt("mid"));
				zf.setTime(rs.getTime("time"));
				zf.setMcontent(rs.getString("mcontent"));
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

	public Menu findByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	public int doDelete(int id) {
		int a=0;
		Connection conn = DBUtil.getConnection();
		String sql="delete * from  menu where id=?";
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

	public int doAdd(Menu v) {
		int a=0;
		String sql="insert into menu(time,mcontent) values(?,?)";
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setTime(1, (Time) v.getTime());
			ps.setString(2,v.getMcontent());
			a = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return a;
	}

	public int doUpdate(Menu v) {
		int a=0;
		String sql="update menu   set time=?,mcontent=? where mid=? ";
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setTime(1, (Time) v.getTime());
			ps.setString(2, v.getMcontent());
			ps.setInt(3, v.getMid());
			a = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return a;
	}
}
