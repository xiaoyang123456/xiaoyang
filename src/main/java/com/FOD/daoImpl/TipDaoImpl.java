package com.FOD.daoImpl;
/*
 * 陈彪
 */
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import com.FOD.dao.ITipDao;
import com.FOD.entity.Tip;
import com.FOD.util.DBUtil;
public class TipDaoImpl implements ITipDao{
	public List<Tip> findAll() {
		Tip zf=null;
		List<Tip> list=new ArrayList<Tip>();
		Connection conn = DBUtil.getConnection();
		String sql="select * from  tip";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				zf=new Tip();
				zf.setContent(rs.getString("content"));
				zf.setFeel(rs.getInt("feel"));
				zf.setScore(rs.getInt("score"));
				zf.setTid(rs.getInt("tid"));
				zf.setTime(rs.getDate("time"));
				zf.setUsername(rs.getString("username"));
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
	public List<Tip> findSplit(int currentPage, int lineSize) {
		Tip zf=null;
		List<Tip> list=new ArrayList<Tip>();
		Connection conn = DBUtil.getConnection();
		String sql="select * from  tip ORDER BY id desc limit ?,?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, (currentPage-1)*lineSize);
			ps.setInt(2, lineSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				zf=new Tip();
				zf.setContent(rs.getString("content"));
				zf.setFeel(rs.getInt("feel"));
				zf.setScore(rs.getInt("score"));
				zf.setTid(rs.getInt("tid"));
				zf.setTime(rs.getDate("time"));
				zf.setUsername(rs.getString("username"));
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
	public Tip findByID(int id) {
		
		//TODO
		return null;
	}

	public int doDelete(int id) {
		int a=0;
		Connection conn = DBUtil.getConnection();
		String sql="delete from tip where id=?";
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

	public int doAdd(Tip v) {
		int a=0;
		String sql="insert into tip(username,content,feel,score,time) values(?,?,?,?,?)";
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, v.getUsername());
			ps.setString(2, v.getContent());
			ps.setInt(3, v.getFeel());
			ps.setInt(4, v.getScore());
			ps.setDate(5, (Date) v.getTime());
			a = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return a;
	}
	public int doUpdate(Tip v) {
		int a=0;
		String sql="update tip   set username=?,content=?,feel=?,score=?,time=? where tid=?";
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, v.getUsername());
			ps.setString(2, v.getContent());
			ps.setInt(3, v.getFeel());
			ps.setInt(4, v.getScore());
			ps.setTime(5, (Time) v.getTime());
			ps.setInt(6, v.getTid());
			a = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return a;
	}
	public int getCount() {
		String sql="select count(*) num from tip ";
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet set = pstm.executeQuery();
			if(set.next())
				return set.getInt("num");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
			
		}
		return 0;
	}
}
