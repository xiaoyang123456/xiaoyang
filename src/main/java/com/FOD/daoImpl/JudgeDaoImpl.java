package com.FOD.daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.FOD.dao.IJudgeDao;
import com.FOD.entity.Judge;
import com.FOD.util.DBUtil;
/**
 * 
 * @author 赵凛威
 *
 */
public class JudgeDaoImpl implements IJudgeDao{

	public List<Judge> findAll() {
		Judge judge=null;
		List<Judge> list=new ArrayList<Judge>();
		Connection conn = DBUtil.getConnection();
		String sql="select * from  judge";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				judge=new Judge();				
				judge.setId(rs.getInt("id"));
				judge.setPid(rs.getInt("pid"));
				judge.setTime(rs.getDate("time"));
				judge.setUid(rs.getInt("uid"));
				judge.setContent(rs.getString("content"));
				list.add(judge);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询表judge失败！",e);
		}finally{
			DBUtil.closeConnection(conn);
		}
		return list;
	}

	public List<Judge> findSplit(int currentPage, int lineSize) {
		Judge judge=null;
		List<Judge> list=new ArrayList<Judge>();
		Connection conn = DBUtil.getConnection();
		String sql="select * from  judge limit ?,?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, (currentPage-1)*lineSize);
			ps.setInt(2, lineSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				judge=new Judge();				
				judge.setId(rs.getInt("id"));
				judge.setPid(rs.getInt("pid"));
				judge.setTime(rs.getDate("time"));
				judge.setUid(rs.getInt("uid"));
				judge.setContent(rs.getString("content"));
				list.add(judge);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("表judge分页查询失败！",e);
		}finally{
			DBUtil.closeConnection(conn);
		}
		return list;
	}

	public Judge findByID(int id) {
		Judge judge = null;
		String sql = "select * from judge where id = ?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				judge = new Judge();
				judge.setContent(rs.getString("content"));
				judge.setId(rs.getInt("id"));
				judge.setPid(rs.getInt("pid"));
				judge.setTime(rs.getDate("time"));
				judge.setUid(rs.getInt("uid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查找数据失败!",e);
		}finally{
			DBUtil.closeConnection(con);
		}
		return judge;
	}

	public int doDelete(int id) {
		int a=0;
		Connection conn = DBUtil.getConnection();
		String sql="select * from  judge where id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			a = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("删除表judge数据失败！",e);
		}finally{
			DBUtil.closeConnection(conn);
		}
		return a;
	}

	public int doAdd(Judge v) {
		int a=0;
		Judge judge=(Judge)v;
		String sql="insert into judge(id,pid,time,uid,content) values(?,?,?,?,?)";
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, judge.getId());
			ps.setInt(2, judge.getPid());
			ps.setDate(3, (Date)judge.getTime());
			ps.setInt(4, judge.getUid());
			ps.setString(5, judge.getContent());
			a = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("增加judge表数据失败",e);
		}finally{
			DBUtil.closeConnection(conn);
		}
		return a;
	}

	public int doUpdate(Judge judge) {
		int a=0;
		String sql="update judge   set pid=?,time=?,uid=?,content=? where id=?";
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, judge.getId());
			ps.setInt(2, judge.getPid());
			ps.setDate(3, (Date)judge.getTime());
			ps.setInt(4, judge.getUid());
			ps.setString(5, judge.getContent());
			a = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("更新表judge数据失败",e);
		}finally{
			DBUtil.closeConnection(conn);
		}
		return a;
	}

}
