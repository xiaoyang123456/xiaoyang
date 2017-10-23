package com.FOD.daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.FOD.dao.IOrderDao;
import com.FOD.entity.Order;
import com.FOD.util.DBUtil;

/**
 * 
 * @author XY
 *
 */
public class OrderDaoImpl implements IOrderDao{

	public List<Order> findAll() {
		List<Order> list = new ArrayList<Order>();
		String sql = "select * from order";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Order order = new Order();
				order.setCount(rs.getInt("count"));
				order.setFname(rs.getString("fname"));
				order.setId(rs.getInt("id"));
				order.setOid(rs.getInt("oid"));
				order.setPrice(rs.getDouble("price"));
				order.setTime(rs.getDate("time"));
				order.setUid(rs.getInt("uid"));
				order.setState(rs.getString("state"));
				
				list.add(order);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查找失败!",e);
		}finally{
			DBUtil.closeConnection(con);
		}
		return list;
	}

	public List<Order> findSplit(int currentPage, int lineSize) {
		List<Order> list = new ArrayList<Order>();
		String sql = "select * from order limit ?,?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, (currentPage-1)*lineSize);
			ps.setInt(2, lineSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Order order = new Order();
				order.setCount(rs.getInt("count"));
				order.setFname(rs.getString("fname"));
				order.setId(rs.getInt("id"));
				order.setOid(rs.getInt("oid"));
				order.setPrice(rs.getDouble("price"));
				order.setTime(rs.getDate("time"));
				order.setUid(rs.getInt("uid"));
				order.setState(rs.getString("state"));
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查找失败!",e);
		}finally{
			DBUtil.closeConnection(con);
		}
		return list;
	}

	public Order findByID(int id) {
		Order order = null;
		String sql = "select * from order where id = ?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				order = new Order();
				order.setCount(rs.getInt("count"));
				order.setFname(rs.getString("fname"));
				order.setId(rs.getInt("id"));
				order.setOid(rs.getInt("oid"));
				order.setPrice(rs.getDouble("price"));
				order.setTime(rs.getDate("time"));
				order.setUid(rs.getInt("uid"));
				order.setState(rs.getString("state"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查找失败!",e);
		}finally{
			DBUtil.closeConnection(con);
		}
		return order;
	}

	public int doDelete(int id) {
		int executeUpdate = 0;
		String sql = "delete * from order where id = ?";
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

	public int doAdd(Order v) {
		int executeUpdate = 0;
		String sql = "insert into order(oid,uid,fname,count,price,time,state) "
				+ "values(?,?,?,?,?,?,?)";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, v.getOid());
			ps.setInt(2, v.getUid());
			ps.setString(3, v.getFname());
			ps.setInt(4, v.getCount());
			ps.setDouble(5, v.getPrice());
			ps.setDate(6, (Date) v.getTime());
			ps.setString(7, v.getState());
			
			executeUpdate = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("添加数据失败!",e);
		}finally{
			DBUtil.closeConnection(con);
		}
		return executeUpdate;
	}

	public int doUpdate(Order v) {
		int executeUpdate = 0;
		String sql = "update order set oid = ?,uid = ?,fname = ?,count = ?,"
				+ "price = ?,time = ?,state = ? where id = ?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, v.getOid());
			ps.setInt(2, v.getUid());
			ps.setString(3, v.getFname());
			ps.setInt(4, v.getCount());
			ps.setDouble(5, v.getPrice());
			ps.setDate(6, (Date) v.getTime());
			ps.setString(7, v.getState());
			ps.setInt(8, v.getId());
			executeUpdate = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("更新数据失败!",e);
		}finally{
			DBUtil.closeConnection(con);
		}
		return executeUpdate;
	}

}
