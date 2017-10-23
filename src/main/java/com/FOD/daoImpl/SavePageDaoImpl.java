package com.FOD.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.FOD.dao.ISavePageDao;
import com.FOD.entity.SavePage;
import com.FOD.util.DBUtil;

/**
 * 
 * @author 赵凛威
 *
 */
public class SavePageDaoImpl implements ISavePageDao{

	public List<SavePage> findAll() {
		SavePage sp=null;
		List<SavePage> list=new ArrayList<SavePage>();
		Connection conn = DBUtil.getConnection();
		String sql="select * from  savepage";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				sp=new SavePage();				
				sp.setId(rs.getInt("id"));
				sp.setTid(rs.getInt("pid"));
				sp.setUid(rs.getInt("uid"));
				list.add(sp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询表savepage失败！",e);
		}finally{
			DBUtil.closeConnection(conn);
		}
		return list;
	}

	public List<SavePage> findSplit(int currentPage, int lineSize) {
		SavePage sp=null;
		List<SavePage> list=new ArrayList<SavePage>();
		Connection conn = DBUtil.getConnection();
		String sql="select * from  savepage limit ?,?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, (currentPage-1)*lineSize);
			ps.setInt(2, lineSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				sp=new SavePage();				
				sp.setId(rs.getInt("id"));
				sp.setTid(rs.getInt("pid"));
				sp.setUid(rs.getInt("uid"));
				list.add(sp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("表savepage分页查询失败！",e);
		}finally{
			DBUtil.closeConnection(conn);
		}
		return list;
	}

	public SavePage findByID(int id) {
		SavePage savePage = null;
		String sql = "select * from savepage where id = ?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				savePage = new SavePage();
				savePage.setId(rs.getInt("id"));
				savePage.setTid(rs.getInt("pid"));
				savePage.setUid(rs.getInt("uid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查找数据失败!",e);
		}finally{
			DBUtil.closeConnection(con);
		}
		return savePage;
	}

	public int doDelete(int id) {
		int a=0;
		Connection conn = DBUtil.getConnection();
		String sql="select * from  savepage where id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			a = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("删除表savepage数据失败！",e);
		}finally{
			DBUtil.closeConnection(conn);
		}
		return a;
	}

	public int doAdd(SavePage v) {
		int a=0;
		SavePage sp=(SavePage)v;
		String sql="insert into savepage(id,tid,uid) values(?,?,?)";
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, sp.getId());
			ps.setInt(2, sp.getTid());
			ps.setInt(3, sp.getUid());
			a = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("增加savepage表数据失败",e);
		}finally{
			DBUtil.closeConnection(conn);
		}
		return a;
	}

	public int doUpdate(SavePage sp) {
		int a=0;
		String sql="update savepage   set tid=?,uid=? where id=?";
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, sp.getId());
			ps.setInt(2, sp.getTid());
			ps.setInt(3, sp.getUid());
			a = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("更新表savepage数据失败",e);
		}finally{
			DBUtil.closeConnection(conn);
		}
		return a;
	}

}
