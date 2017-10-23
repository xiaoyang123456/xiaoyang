package com.FOD.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.FOD.dao.IGdFoodDao;
import com.FOD.entity.GdFood;
import com.FOD.util.DBUtil;

/**
 * 
 * @author XY
 *
 */
public class GdFoodDaoImpl implements IGdFoodDao{

	public List<GdFood> findAll() {
		List<GdFood> list = new ArrayList<GdFood>();
		String sql = "select * from gdfood";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				GdFood gdFood = new GdFood();
				gdFood.setId(rs.getInt("id"));
				gdFood.setPelement(rs.getString("pelement"));
				gdFood.setPimages(rs.getString("pimages"));
				gdFood.setPintroduction(rs.getString("pintroduction"));
				gdFood.setPkind(rs.getString("pkind"));
				gdFood.setPname(rs.getString("pname"));
				gdFood.setPpoints(rs.getInt("ppoints"));
				gdFood.setPprice(rs.getDouble("pprice"));
				gdFood.setPstock(rs.getInt("pstock"));
				
				list.add(gdFood);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询数据失败!",e);
		}finally{
			DBUtil.closeConnection(con);
		}
		return list;
	}

	public List<GdFood> findSplit(int currentPage, int lineSize) {
		List<GdFood> list = new ArrayList<GdFood>();
		String sql = "select * from gdfood limit ?,?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, (currentPage-1)*lineSize);
			ps.setInt(2, lineSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				GdFood gdFood = new GdFood();
				gdFood.setId(rs.getInt("id"));
				gdFood.setPelement(rs.getString("pelement"));
				gdFood.setPimages(rs.getString("pimages"));
				gdFood.setPintroduction(rs.getString("pintroduction"));
				gdFood.setPkind(rs.getString("pkind"));
				gdFood.setPname(rs.getString("pname"));
				gdFood.setPpoints(rs.getInt("ppoints"));
				gdFood.setPprice(rs.getDouble("pprice"));
				gdFood.setPstock(rs.getInt("pstock"));
				
				list.add(gdFood);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询数据失败!",e);
		}finally{
			DBUtil.closeConnection(con);
		}
		return list;
	}

	public GdFood findByID(int id) {
		GdFood gdFood = null;
		String sql = "select * from gdfood where id = ?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				gdFood = new GdFood();
				gdFood.setId(rs.getInt("id"));
				gdFood.setPelement(rs.getString("pelement"));
				gdFood.setPimages(rs.getString("pimages"));
				gdFood.setPintroduction(rs.getString("pintroduction"));
				gdFood.setPkind(rs.getString("pkind"));
				gdFood.setPname(rs.getString("pname"));
				gdFood.setPpoints(rs.getInt("ppoints"));
				gdFood.setPprice(rs.getDouble("pprice"));
				gdFood.setPstock(rs.getInt("pstock"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询数据失败!",e);
		}finally{
			DBUtil.closeConnection(con);
		}
		return gdFood;
	}

	public int doDelete(int id) {
		int executeUpdate = 0;
		String sql = "delete * from gdfood where id = ?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			executeUpdate = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("删除数据失败!",e);
		}finally{
			DBUtil.closeConnection(con);
		}
		return executeUpdate;
	}

	public int doAdd(GdFood v) {
		int executeUpdate = 0;
		String sql = "insert into gdfood (pname,pprice,ppoints,pelement,pstock,"
				+ "pintroduction,pkind,pimages) values(?,?,?,?,?,?,?,?)";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, v.getPname());
			ps.setDouble(2, v.getPprice());
			ps.setInt(3, v.getPpoints());
			ps.setString(4, v.getPelement());
			ps.setInt(5, v.getPstock());
			ps.setString(6, v.getPintroduction());
			ps.setString(7, v.getPkind());
			ps.setString(8, v.getPimages());
			executeUpdate = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("添加价数据失败!",e);
		}finally{
			DBUtil.closeConnection(con);
		}
		return executeUpdate;
	}

	public int doUpdate(GdFood v) {
		int executeUpdate = 0;
		String sql = "update gdfood set pname = ?,"
				+ "pprice = ?,ppoints = ?,pelement = ?,pstock = ?,"
				+ "pintroduction = ?,pkind = ?,pimages = ? where id = ?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, v.getPname());
			ps.setDouble(2, v.getPprice());
			ps.setInt(3, v.getPpoints());
			ps.setString(4, v.getPelement());
			ps.setInt(5, v.getPstock());
			ps.setString(6, v.getPintroduction());
			ps.setString(7, v.getPkind());
			ps.setString(8, v.getPimages());
			ps.setInt(9, v.getId());
			executeUpdate = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据更新失败!",e);
		}finally{
			DBUtil.closeConnection(con);
		}
		return executeUpdate;
	}

	public List<String> findKinds() {
		String sql="select pkind from zxfood group by pkind";
		Connection conn = DBUtil.getConnection();
		List<String> list=new ArrayList<String>();
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet set = pstm.executeQuery();
			while(set.next()){
				String pkind = set.getString("pkind");
				list.add(pkind);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return list;
	}
	
	
	
	public List<GdFood> findByKind(String kind) {
		String sql="select * from gdfood where pkind=?";
		Connection conn = DBUtil.getConnection();
		List<GdFood> list=new ArrayList<GdFood>();
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, kind);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				GdFood gdFood = new GdFood();
				gdFood.setId(rs.getInt("id"));
				gdFood.setPelement(rs.getString("pelement"));
				gdFood.setPimages(rs.getString("pimages"));
				gdFood.setPintroduction(rs.getString("pintroduction"));
				gdFood.setPkind(rs.getString("pkind"));
				gdFood.setPname(rs.getString("pname"));
				gdFood.setPpoints(rs.getInt("ppoints"));
				gdFood.setPprice(rs.getDouble("pprice"));
				gdFood.setPstock(rs.getInt("pstock"));
				
				list.add(gdFood);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
			
		}
		return list;
	}
	
	public int doUpdateStock(int cut,int id) {
		String sql="update zxfood set pstock=pstock-? where id=?";
		Connection conn = DBUtil.getConnection();
		int result=0;
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, cut);
			pstm.setInt(2, id);
			result= pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
			
		}
		return result;
	}
}
