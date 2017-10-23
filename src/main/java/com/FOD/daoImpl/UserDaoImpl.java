package com.FOD.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.FOD.dao.IUserDao;
import com.FOD.entity.User;
import com.FOD.util.DBUtil;

/**
 * 
 * @author XY
 *
 */
public class UserDaoImpl implements IUserDao{

	public List<User> findAll() {
		List<User> list = new ArrayList<User>();
		String sql = "select * from user";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setAddress(rs.getString("address"));
				user.setCarid(rs.getInt("carid"));
				user.setMoney(rs.getDouble("money"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setUid(rs.getInt("uid"));
				user.setUsername(rs.getString("username"));
				user.setUserpoints(rs.getInt("userpoints"));
				
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询数据失败!",e);
		}finally{
			DBUtil.closeConnection(con);
		}
		return list;
	}

	public List<User> findSplit(int currentPage, int lineSize) {
		List<User> list = new ArrayList<User>();
		String sql = "select * from user limit ?,?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, (currentPage-1)*lineSize);
			ps.setInt(2, lineSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setAddress(rs.getString("address"));
				user.setCarid(rs.getInt("carid"));
				user.setMoney(rs.getDouble("money"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setUid(rs.getInt("uid"));
				user.setUsername(rs.getString("username"));
				user.setUserpoints(rs.getInt("userpoints"));
				
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询数据失败!",e);
		}finally{
			DBUtil.closeConnection(con);
		}
		return list;
	}

	public User findByID(int id) {
		User user = null;
		String sql = "select * from user where id = ?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				user = new User();
				user.setAddress(rs.getString("address"));
				user.setCarid(rs.getInt("carid"));
				user.setMoney(rs.getDouble("money"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setUid(rs.getInt("uid"));
				user.setUsername(rs.getString("username"));
				user.setUserpoints(rs.getInt("userpoints"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询数据失败!",e);
		}finally{
			DBUtil.closeConnection(con);
		}
		return user;
	}

	public int doDelete(int id) {
		int executeUpdate = 0;
		String sql = "delete * from user where id = ?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			executeUpdate  = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("删除数据失败!",e);
		}finally{
			DBUtil.closeConnection(con);
		}
		return executeUpdate;
	}

	public int doAdd(User v) {
		int executeUpdate = 0;
		String sql = "insert into user(username,password,"
				+ "phone,address,userpoints,money,carid) values(?,?,?,?,?,?,?)";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, v.getUsername());
			ps.setString(2, v.getPassword());
			ps.setString(3, v.getPhone());
			ps.setString(4, v.getAddress());
			ps.setInt(5, v.getUserpoints());
			ps.setDouble(6, v.getMoney());
			ps.setInt(7, v.getCarid());
			executeUpdate = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("添加数据失败!",e);
		}finally{
			DBUtil.closeConnection(con);
		}
		return executeUpdate;
	}

	public int doUpdate(User v) {
		int executeUpdate = 0;
		String sql = "update user set username = ?,password = ?,"
				+ "phone = ?,address = ?,userpoints = ?,money = ?,carid = ? where uid = ?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, v.getUsername());
			ps.setString(2, v.getPassword());
			ps.setString(3, v.getPhone());
			ps.setString(4, v.getAddress());
			ps.setInt(5, v.getUserpoints());
			ps.setDouble(6, v.getMoney());
			ps.setInt(7, v.getCarid());
			ps.setInt(8, v.getUid());
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
