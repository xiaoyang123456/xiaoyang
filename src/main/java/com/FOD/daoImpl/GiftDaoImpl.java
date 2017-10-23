package com.FOD.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.FOD.dao.IGiftDao;
import com.FOD.entity.Gift;
import com.FOD.entity.User;
import com.FOD.util.DBUtil;
/**
 * 
 * @author 赵凛威
 *
 */
public class GiftDaoImpl implements IGiftDao{

	public List<Gift> findAll() {
		Gift gift=null;
		List<Gift> list=new ArrayList<Gift>();
		Connection conn = DBUtil.getConnection();
		String sql="select * from  gift";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				gift=new Gift();
				gift.setGid(rs.getInt("gid"));
				gift.setGname(rs.getString("gname"));
				gift.setGpoints(rs.getInt("gpoints"));
				gift.setStock(rs.getInt("stock"));
				gift.setGkind(rs.getString("gkind"));
				gift.setGinfor(rs.getString("ginfor"));
				list.add(gift);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询表gift失败！",e);
		}finally{
			DBUtil.closeConnection(conn);
		}
		return list;
	}

	public List<Gift> findSplit(int currentPage, int lineSize) {

		Gift gift=null;
		List<Gift> list=new ArrayList<Gift>();
		Connection conn = DBUtil.getConnection();
		String sql="select * from  gift limit ?,?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, (currentPage-1)*lineSize);
			ps.setInt(2, lineSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				gift=new Gift();
				gift.setGid(rs.getInt("gid"));
				gift.setGname(rs.getString("gname"));
				gift.setGpoints(rs.getInt("gpoints"));
				gift.setStock(rs.getInt("stock"));
				gift.setGkind(rs.getString("gkind"));
				gift.setGinfor(rs.getString("ginfor"));
				list.add(gift);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("分页查询表gift失败！",e);
		}finally{
			DBUtil.closeConnection(conn);
		}
		return list;
	
	}

	public Gift findByID(int id) {
		Gift gift = null;
		String sql = "select * from gift where id = ?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				gift = new Gift();
				gift.setGid(rs.getInt("gid"));
				gift.setGinfor(rs.getString("ginfor"));
				gift.setGkind(rs.getString("gkind"));
				gift.setGname(rs.getString("gname"));
				gift.setGpoints(rs.getInt("gpoints"));
				gift.setStock(rs.getInt("stock"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查找数据失败!",e);
		}finally{
			DBUtil.closeConnection(con);
		}
		return gift;
	}

	public int doDelete(int id) {
		int a=0;
		Connection conn = DBUtil.getConnection();
		String sql="select * from  gift where gid=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			a = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("删除表gift失败！",e);
		}finally{
			DBUtil.closeConnection(conn);
		}
		return a;
	}

	public int doAdd(Gift v) {
		int a=0;
		Gift gift=(Gift)v;
		String sql="insert into gift(gid,gname,gpoints,stock,gkind,ginfor) values(?,?,?,?,?,?)";
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, gift.getGid());
			ps.setString(2, gift.getGname());
			ps.setInt(3, gift.getGpoints());
			ps.setInt(4, gift.getStock());
			ps.setString(5, gift.getGkind());
			ps.setString(6, gift.getGinfor());
			a = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("表gift增加数据失败！",e);
		}finally{
			DBUtil.closeConnection(conn);
		}
		return a;
	}

	public int doUpdate(Gift gift) {
		int a=0;
		String sql="update gift   set gname=?,gpoints=?,stock=?,gkind=?,ginfor=? where gid=?";
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, gift.getGid());
			ps.setString(2, gift.getGname());
			ps.setInt(3, gift.getGpoints());
			ps.setInt(4, gift.getStock());
			ps.setString(5, gift.getGkind());
			ps.setString(6, gift.getGinfor());
			a = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("表gift更新数据失败！",e);
		}finally{
			DBUtil.closeConnection(conn);
		}
		return a;
	}
	//根据赠品种类分组查询,并且分页
	public List<Gift> findGift(int page, int pageSize, String gkind) {
		String sql="select * from (select * from gift where gkind like ?) m limit ?,?";
		List<Gift> list=new ArrayList<Gift>();
		Gift gift=null;
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, gkind);
			ps.setInt(2, (page-1)*pageSize);
			ps.setInt(3, pageSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				gift=new Gift();
				gift.setGid(rs.getInt("gid"));
				gift.setGname(rs.getString("gname"));
				gift.setGpoints(rs.getInt("gpoints"));
				gift.setStock(rs.getInt("stock"));
				gift.setGkind(rs.getString("gkind"));
				gift.setGinfor(rs.getString("ginfor"));
				list.add(gift);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询数据失败！",e);
		}
		
		return list;
	}
	//根据赠品所需积分     种类等条件分组查询,并且分页
	public List<Gift> findGift(int page, int pageSize, int gpoints1, int gpoints2, String gkind){
		List<Gift> list=new ArrayList<Gift>();
		String sql="";
		Gift gift=null;
		if(gpoints1!=0 &&  gpoints2!=0){
			sql="SELECT * FROM(select * FROM(select * from gift where gkind like ?) n "
					+ "where gpoints>=? and gpoints<=?) m "
					+ "LIMIT ?,?";
			Connection conn=DBUtil.getConnection();
			try {
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, gkind);
				ps.setInt(2, gpoints1);
				ps.setInt(3, gpoints2);
				ps.setInt(4, (page-1)*pageSize);
				ps.setInt(5, pageSize);
				ResultSet rs= ps.executeQuery();
				while(rs.next()){
					gift=new Gift();
					gift.setGid(rs.getInt("gid"));
					gift.setGname(rs.getString("gname"));
					gift.setGpoints(rs.getInt("gpoints"));
					gift.setStock(rs.getInt("stock"));
					gift.setGkind(rs.getString("gkind"));
					gift.setGinfor(rs.getString("ginfor"));
					list.add(gift);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DBUtil.closeConnection(conn);
			}
		}else if(gpoints1!=0 &&  gpoints2==0){
			sql="select * from (select * from (select * from gift where gkind like ?) m where gpoints>=?) m limit ?,?";
			Connection conn=DBUtil.getConnection();
			try {
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, gkind);
				ps.setInt(2, gpoints1);
				ps.setInt(3, (page-1)*pageSize);
				ps.setInt(4, pageSize);
				ResultSet rs= ps.executeQuery();
				while(rs.next()){
					gift=new Gift();
					gift.setGid(rs.getInt("gid"));
					gift.setGname(rs.getString("gname"));
					gift.setGpoints(rs.getInt("gpoints"));
					gift.setStock(rs.getInt("stock"));
					gift.setGkind(rs.getString("gkind"));
					gift.setGinfor(rs.getString("ginfor"));
					list.add(gift);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DBUtil.closeConnection(conn);
			}
		}else if(gpoints1==0 &&  gpoints2!=0){
			sql="select * from (select * from (select * from gift where gkind like ?) m where gpoints<=?) m limit ?,?";;
			Connection conn=DBUtil.getConnection();
			try {
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, gkind);
				ps.setInt(2, gpoints2);
				ps.setInt(3, (page-1)*pageSize);
				ps.setInt(4, pageSize);
				ResultSet rs= ps.executeQuery();
				while(rs.next()){
					gift=new Gift();
					gift.setGid(rs.getInt("gid"));
					gift.setGname(rs.getString("gname"));
					gift.setGpoints(rs.getInt("gpoints"));
					gift.setStock(rs.getInt("stock"));
					gift.setGkind(rs.getString("gkind"));
					gift.setGinfor(rs.getString("ginfor"));
					list.add(gift);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DBUtil.closeConnection(conn);
			}
		}
		return list;
	}

	public int updateGift(Gift gift, int num,User user) {
		int a=0;
		String sql1="update gift set stock=stock-? where gid=?";
		String sql2="update user set userpoints=userpoints-? where uid=?";
		Connection conn= DBUtil.getConnection();
		try {
			PreparedStatement ps1 = conn.prepareStatement(sql1);
			ps1.setInt(1, num);
			ps1.setInt(2, gift.getGid());
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setInt(1,gift.getGpoints()*num);
			ps2.setInt(2, user.getUid());
			int ex1 = ps1.executeUpdate();
			int ex2 = ps2.executeUpdate();
			if((ex1+ex2)==2){
				a=ex1+ex2;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("修改失败！",e);
		}
		return a;
	}
}
