package com.FOD.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.FOD.dao.ICarDao;
import com.FOD.entity.Car;
import com.FOD.util.DBUtil;

public class CarDaoImpl implements ICarDao{
	
	public List<Car> findAll() {
		List<Car> list = new ArrayList<Car>();
		String sql = "select * from car";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Car car = new Car();
				car.setCarvastock(rs.getInt("carvastock"));
				car.setCarvelments(rs.getString("carvelments"));
				car.setCarvimages(rs.getString("carvimages"));
				car.setCarvintro(rs.getString("carvintro"));
				car.setCarvkind(rs.getString("carvkind"));
				car.setCarvname(rs.getString("carvname"));
				car.setCarvpoints(rs.getInt("carvpoints"));
				car.setCarvprice(rs.getDouble("carvprice"));
				car.setCarvtaste(rs.getString("carvtaste"));
				car.setId(rs.getInt("id"));
				car.setUid(rs.getInt("uid"));
				
				list.add(car);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查找数据失败!",e);
		}finally{
			DBUtil.closeConnection(con);
		}
		
		return list;
	}

	public List<Car> findSplit(int currentPage, int lineSize) {
		List<Car> list = new ArrayList<Car>();
		String sql = "select * from car limit ?,?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, (currentPage-1)*lineSize);
			ps.setInt(2, lineSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Car car = new Car();
				car.setCarvastock(rs.getInt("carvastock"));
				car.setCarvelments(rs.getString("carvelments"));
				car.setCarvimages(rs.getString("carvimages"));
				car.setCarvintro(rs.getString("carvintro"));
				car.setCarvkind(rs.getString("carvkind"));
				car.setCarvname(rs.getString("carvname"));
				car.setCarvpoints(rs.getInt("carvpoints"));
				car.setCarvprice(rs.getDouble("carvprice"));
				car.setCarvtaste(rs.getString("carvtaste"));
				car.setId(rs.getInt("id"));
				car.setUid(rs.getInt("uid"));
				
				list.add(car);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查找数据失败!",e);
		}finally{
			DBUtil.closeConnection(con);
		}
		return list;
	}

	public Car findByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int doDelete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int doAdd(Car v) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int doUpdate(Car v) {
		// TODO Auto-generated method stub
		return 0;
	}

}
