package com.FOD.daoImpl;
import java.sql.Connection;




import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.FOD.dao.IZxFoodDao;
import com.FOD.entity.ZxFood;
import com.FOD.util.DBUtil;

/**
 * 
 * @author 陈彪、肖扬
 *
 */
public class ZxFoodDaoImpl implements IZxFoodDao{
	public List<ZxFood> findAll() {
		ZxFood zf=null;
		List<ZxFood> list=new ArrayList<ZxFood>();
		Connection conn = DBUtil.getConnection();
		String sql="select * from  zxfood";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				zf=new ZxFood();
				zf.setId(rs.getInt("id"));
				zf.setFname(rs.getString("fname"));
				zf.setFprice(rs.getDouble("fprice"));
				zf.setFpoints(rs.getInt("fpoints"));
				zf.setFelement(rs.getString("felement"));
				zf.setFtaste(rs.getString("ftaste"));
				zf.setFstock(rs.getInt("fstock"));
				zf.setFintroduction(rs.getString("fintroduction"));
				zf.setFkind(rs.getString("fkind"));
				zf.setFimages(rs.getString("fimages"));
				list.add(zf);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查找失败!",e);
		}finally{
			DBUtil.closeConnection(conn);
		}
		return list;
	}
	
	
	public List<ZxFood> findSplit(int currentPage, int lineSize) {
		ZxFood zf=null;
		List<ZxFood> list=new ArrayList<ZxFood>();
		Connection conn = DBUtil.getConnection();
		String sql="select * from  zxfood limit ?,?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, (currentPage-1)*lineSize);
			ps.setInt(2, lineSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				zf=new ZxFood();
				zf.setId(rs.getInt("id"));
				zf.setFname(rs.getString("fname"));
				zf.setFprice(rs.getDouble("fprice"));
				zf.setFpoints(rs.getInt("fpoints"));
				zf.setFelement(rs.getString("felement"));
				zf.setFtaste(rs.getString("ftaste"));
				zf.setFstock(rs.getInt("fstock"));
				zf.setFintroduction(rs.getString("fintroduction"));
				zf.setFkind(rs.getString("fkind"));
				zf.setFimages(rs.getString("fimages"));
				list.add(zf);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查找失败!",e);
		}finally{
			DBUtil.closeConnection(conn);
		}
		return list;
	}

	public ZxFood  findByID(int id) {
		ZxFood zf = null;
		String sql = "select * from zxfood where id = ?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				zf=new ZxFood();
				zf.setId(rs.getInt("id"));
				zf.setFname(rs.getString("fname"));
				zf.setFprice(rs.getDouble("fprice"));
				zf.setFpoints(rs.getInt("fpoints"));
				zf.setFelement(rs.getString("felement"));
				zf.setFtaste(rs.getString("ftaste"));
				zf.setFstock(rs.getInt("fstock"));
				zf.setFintroduction(rs.getString("fintroduction"));
				zf.setFkind(rs.getString("fkind"));
				zf.setFimages(rs.getString("fimages"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查找失败!",e);
		}
		return zf;
	}

	public int doDelete(int id) {
		int a=0;
		Connection conn = DBUtil.getConnection();
		String sql="delete * from  zxfood where id=?";
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

	public int doAdd(ZxFood v) {
		int a=0;
		ZxFood zf=(ZxFood)v;
		String sql="insert into zxfood(fname,fprice,fpoints,felement,ftaste,fstock,fintroduction,fkind,fimages) values(?,?,?,?,?,?,?,?,?)";
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, zf.getFname());
			ps.setDouble(2, zf.getFprice());
			ps.setInt(3,zf.getFpoints());
			ps.setString(4, zf.getFelement());
			ps.setString(5,zf.getFtaste());
			ps.setInt(6, zf.getFstock());
			ps.setString(7,zf.getFintroduction());
			ps.setString(8,zf.getFkind());
			ps.setString(9,zf.getFimages());
			a = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("添加数据失败!",e);
		}finally{
			DBUtil.closeConnection(conn);
		}
		return a;
	}
	public int doUpdate(ZxFood zf) {
		int a=0;
		String sql="update zxfood set fname=?,fprice=?,fpoints=?,felement=?,ftaste=?,fstock=?,fintroduction=?,fkind=?,fimages=? where id=?";
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, zf.getFname());
			ps.setDouble(2, zf.getFprice());
			ps.setInt(3,zf.getFpoints());
			ps.setString(4, zf.getFelement());
			ps.setString(5,zf.getFtaste());
			ps.setInt(6, zf.getFstock());
			ps.setString(7,zf.getFintroduction());
			ps.setString(8,zf.getFkind());
			ps.setString(9,zf.getFimages());
			ps.setInt(10, zf.getId());
			a = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("更新数据失败!",e);
		}finally{
			DBUtil.closeConnection(conn);
		}
		return a;
	}


	public List<String> findKinds() {
		String sql="select fkind from zxfood group by fkind";
		Connection conn = DBUtil.getConnection();
		List<String> list=new ArrayList<String>();
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet set = pstm.executeQuery();
			while(set.next()){
				String fkind = set.getString("fkind");
				list.add(fkind);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return list;
	}
	
	
	
	public List<ZxFood> findByKind(String kind) {
		String sql="select * from zxfood where fkind=?";
		Connection conn = DBUtil.getConnection();
		List<ZxFood> list=new ArrayList<ZxFood>();
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, kind);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				ZxFood zf=new ZxFood();
				zf.setId(rs.getInt("id"));
				zf.setId(rs.getInt("id"));
				zf.setFname(rs.getString("fname"));
				zf.setFprice(rs.getDouble("fprice"));
				zf.setFpoints(rs.getInt("fpoints"));
				zf.setFelement(rs.getString("felement"));
				zf.setFtaste(rs.getString("ftaste"));
				zf.setFstock(rs.getInt("fstock"));
				zf.setFintroduction(rs.getString("fintroduction"));
				zf.setFkind(rs.getString("fkind"));
				zf.setFimages(rs.getString("fimages"));
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
	
	public int doUpdateStock(int cut,int id) {
		String sql="update zxfood set fstock=fstock-? where id=?";
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
