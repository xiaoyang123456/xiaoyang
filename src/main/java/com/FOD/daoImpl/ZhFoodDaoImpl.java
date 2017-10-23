package com.FOD.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.FOD.dao.IZhFoodDao;
import com.FOD.entity.ZhFood;
import com.FOD.util.DBUtil;

/**
 * 
 * @author XY
 *
 */
public class ZhFoodDaoImpl implements IZhFoodDao{

	public List<ZhFood> findAll() {
		ZhFood zhFood = null;
		List<ZhFood> list=new ArrayList<ZhFood>();
		Connection conn = DBUtil.getConnection();
		String sql="select * from  zhfood";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				zhFood=new ZhFood();
				zhFood.setCkind(rs.getString("ckind"));
				zhFood.setCname(rs.getString("cname"));
				zhFood.setId(rs.getInt("id"));
				
				list.add(zhFood);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查找失败!",e);
		}finally{
			DBUtil.closeConnection(conn);
		}
		return list;
	}

	public List<ZhFood> findSplit(int currentPage, int lineSize) {
		ZhFood zhFood = null;
		List<ZhFood> list=new ArrayList<ZhFood>();
		Connection conn = DBUtil.getConnection();
		String sql="select * from  zhfood limit ?,?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, (currentPage-1)*lineSize);
			ps.setInt(2, lineSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				zhFood = new ZhFood();
				zhFood.setCkind(rs.getString("ckind"));
				zhFood.setCname(rs.getString("cname"));
				zhFood.setId(rs.getInt("id"));
				list.add(zhFood);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查找失败!",e);
		}finally{
			DBUtil.closeConnection(conn);
		}
		return list;
	}

	public ZhFood findByID(int id) {
		ZhFood zhFood = null;
		String sql = "select * from zhfood where id = ?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				zhFood = new ZhFood();
				zhFood.setCkind(rs.getString("ckind"));
				zhFood.setCname(rs.getString("cname"));
				zhFood.setId(rs.getInt("id"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查找失败!",e);
		}
		return zhFood;
	}

	public int doDelete(int id) {
		int a=0;
		Connection conn = DBUtil.getConnection();
		String sql="delete * from  zhfood where id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			a = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("删除数据失败!",e);
		}finally{
			DBUtil.closeConnection(conn);
		}
		return a;
	}

	public int doAdd(ZhFood v) {
		int executeUpdate = 0;
		String sql="insert into zhfood(ckind,cname) values(?,?)";
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, v.getCkind());
			ps.setString(2, v.getCname());
			executeUpdate = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("添加数据失败!",e);
		}finally{
			DBUtil.closeConnection(conn);
		}
		return executeUpdate;
	}

	public int doUpdate(ZhFood v) {
		int executeUpdate = 0;
		String sql="update zhfood set ckind = ?,cname = ? where id = ?";
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, v.getCkind());
			ps.setString(2, v.getCname());
			ps.setInt(3, v.getId());
			executeUpdate = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("更新数据失败!",e);
		}finally{
			DBUtil.closeConnection(conn);
		}
		return executeUpdate;
	}

	public List<String> findKinds() {
		String sql="select ckind from zhfood group by ckind";
		Connection conn = DBUtil.getConnection();
		List<String> list=new ArrayList<String>();
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet set = pstm.executeQuery();
			while(set.next()){
				String ckind = set.getString("ckind");
				list.add(ckind);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return list;
	}
	
	
	
	public List<ZhFood> findByKind(String kind) {
		String sql="select * from zhfood where ckind=?";
		Connection conn = DBUtil.getConnection();
		List<ZhFood> list=new ArrayList<ZhFood>();
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, kind);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				ZhFood zhFood=new ZhFood();
				zhFood.setCkind(rs.getString("ckind"));
				zhFood.setCname(rs.getString("cname"));
				zhFood.setId(rs.getInt("id"));
				
				list.add(zhFood);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
			
		}
		return list;
	}

}
