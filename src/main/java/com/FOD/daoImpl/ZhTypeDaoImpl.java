package com.FOD.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.FOD.dao.IZhTypeDao;
import com.FOD.entity.ZhType;
import com.FOD.util.DBUtil;

/**
 * 
 * @author XY
 *
 */
public class ZhTypeDaoImpl implements IZhTypeDao{

	public List<ZhType> findAll() {
		List<ZhType> list = new ArrayList<ZhType>();
		String sql = "select * from zhtype";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				ZhType zhType = new ZhType();
				zhType.setCpoints(rs.getInt("cpoints"));
				zhType.setCprice(rs.getDouble("cprice"));
				zhType.setCtype(rs.getString("ctype"));
				zhType.setDecoction(rs.getInt("decoction"));
				zhType.setId(rs.getInt("id"));
				zhType.setMeat(rs.getInt("meat"));
				zhType.setVegetable(rs.getInt("vegetable"));
				list.add(zhType);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查找失败!",e);
		}finally{
			DBUtil.closeConnection(con);
		}
		return list;
	}

	public List<ZhType> findSplit(int currentPage, int lineSize) {
		List<ZhType> list = new ArrayList<ZhType>();
		String sql = "select * from zhtype limit ?,?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, (currentPage-1)*lineSize);
			ps.setInt(2, lineSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				ZhType zhType = new ZhType();
				zhType.setCpoints(rs.getInt("cpoints"));
				zhType.setCprice(rs.getDouble("cprice"));
				zhType.setCtype(rs.getString("ctype"));
				zhType.setDecoction(rs.getInt("decoction"));
				zhType.setId(rs.getInt("id"));
				zhType.setMeat(rs.getInt("meat"));
				zhType.setVegetable(rs.getInt("vegetable"));
				list.add(zhType);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查找失败!",e);
		}finally{
			DBUtil.closeConnection(con);
		}
		return list;
	}

	public ZhType findByID(int id) {
		ZhType zhType = null;
		String sql = "select * from zhtype where id = ?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				zhType = new ZhType();
				zhType.setCpoints(rs.getInt("cpoints"));
				zhType.setCprice(rs.getDouble("cprice"));
				zhType.setCtype(rs.getString("ctype"));
				zhType.setDecoction(rs.getInt("decoction"));
				zhType.setId(rs.getInt("id"));
				zhType.setMeat(rs.getInt("meat"));
				zhType.setVegetable(rs.getInt("vegetable"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查找失败!",e);
		}
		return zhType;
	}

	public int doDelete(int id) {
		int executeUpdate = 0;
		String sql = "delete * from zhType where id = ?";
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

	public int doAdd(ZhType v) {
		int executeUpdate = 0;
		String sql = "insert into zhtype (ctype,cprice,meat,"
				+ "vegetable,decoction,cpoints) values(?,?,?,?,?,?)";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, v.getCtype());
			ps.setDouble(2, v.getCprice());
			ps.setInt(3, v.getMeat());
			ps.setInt(4, v.getVegetable());
			ps.setInt(5, v.getDecoction());
			ps.setInt(6, v.getCpoints());
			executeUpdate = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("添加价数据失败!",e);
		}finally{
			DBUtil.closeConnection(con);
		}
		return executeUpdate;
	}

	public int doUpdate(ZhType v) {
		int executeUpdate = 0;
		String sql = "update zhtype set ctype = ?,cprice = ?,meat = ?,"
				+ "vegetable = ?,decoction = ?,cpoints = ? where id = ?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, v.getCtype());
			ps.setDouble(2, v.getCprice());
			ps.setInt(3, v.getMeat());
			ps.setInt(4, v.getVegetable());
			ps.setInt(5, v.getDecoction());
			ps.setInt(6, v.getCpoints());
			ps.setInt(7, v.getId());
			executeUpdate = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("更新价数据失败!",e);
		}finally{
			DBUtil.closeConnection(con);
		}
		return executeUpdate;
	}
}
