package com.FOD.daoImpl;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.FOD.dao.IPageDao;
import com.FOD.entity.Page;
import com.FOD.util.DBUtil;
/**
 * 
 * @author XY
 *
 */
/*
 * 每周菜谱界面业务逻辑
 */
public class PageDaoImpl implements IPageDao{
	public List<Page> findAll() {
		List<Page> list = new ArrayList<Page>();
		String sql = "select * from page";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Page page = new Page();
				page.setAuthor(rs.getString("author"));
				page.setPid(rs.getInt("pid"));
				page.setPraize(rs.getInt("praize"));
				page.setTime(rs.getDate("time"));
				page.setTitle(rs.getString("title"));
				page.setType(rs.getString("type"));
				page.setViews(rs.getInt("views"));
				page.setContent(rs.getString("content"));
				list.add(page);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(con);
		}
		return list;
	}
	public List<Page> findSplit(int currentPage, int lineSize) {
		List<Page> list = new ArrayList<Page>();
		String sql = "select * from page limit ?,?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, (currentPage-1)*lineSize);
			ps.setInt(2, lineSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Page page = new Page();
				page.setAuthor(rs.getString("author"));
				page.setPid(rs.getInt("pid"));
				page.setPraize(rs.getInt("praize"));
				page.setTime(rs.getDate("time"));
				page.setTitle(rs.getString("title"));
				page.setType(rs.getString("type"));
				page.setViews(rs.getInt("views"));
				page.setContent(rs.getString("content"));
				list.add(page);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查找数据失败!",e);
		}finally{
			DBUtil.closeConnection(con);
		}
		return list;
	}
	public Page findByID(int id) {
		Page page = null;
		String sql = "select * from page where id = ?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				page = new Page();
				page.setAuthor(rs.getString("author"));
				page.setPid(rs.getInt("pid"));
				page.setPraize(rs.getInt("praize"));
				page.setTime(rs.getDate("time"));
				page.setTitle(rs.getString("title"));
				page.setType(rs.getString("type"));
				page.setViews(rs.getInt("views"));
				page.setContent(rs.getString("content"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查找数据失败!",e);
		}finally{
			DBUtil.closeConnection(con);
		}
		return page;
	}
	public int doDelete(int id) {
		int executeUpdate = 0;
		String sql = "delete * from page where id = ?";
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
	public int doAdd(Page v) {
		int executeUpdate = 0;
		String sql = "insert into page(pid,title,author,time,"
				+ "views,praise,type,content) values(?,?,?,?,?,?,?,?)";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, v.getPid());
			ps.setString(2, v.getTitle());
			ps.setString(3, v.getAuthor());
			ps.setDate(4, (Date) v.getTime());
			ps.setInt(5, v.getViews());
			ps.setInt(6, v.getPraize());
			ps.setString(7, v.getType());
			ps.setString(8, v.getContent());
			executeUpdate = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("添加数据失败!",e);
		}finally{
			DBUtil.closeConnection(con);
		}
		return executeUpdate;
	}
	public int doUpdate(Page v) {
		int executeUpdate = 0;
		String sql = "update page set title = ?,author = ?,time = ?,"
				+ "views = ?,praise = ?,type = ? content=? where pid = ?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, v.getTitle());
			ps.setString(2, v.getAuthor());
			ps.setDate(3, (Date) v.getTime());
			ps.setInt(4, v.getViews());
			ps.setInt(5, v.getPraize());
			ps.setString(6, v.getType());
			ps.setString(7, v.getContent());
			ps.setInt(8, v.getPid());
			executeUpdate = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("更新数据失败!",e);
		}finally{
			DBUtil.closeConnection(con);
		}
		return executeUpdate;
	}
/*陈彪
 * (non-Javadoc)
 * @see com.FOD.dao.IPageDao#findAllPage()
 */
	public List<Page> findAllPage(){
		List<Page> list=new ArrayList<Page>();
		String sql="select * from page";
		Page page=null;
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement ps= conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				page=new Page();
				page.setAuthor(rs.getString("author"));
				page.setPid(rs.getInt("pid"));
				page.setPraize(rs.getInt("praize"));
				page.setTime(rs.getTime("time"));
				page.setTitle(rs.getString("title"));
				page.setType(rs.getString("type"));
				page.setViews(rs.getInt("views"));
				page.setContent(rs.getString("content"));
				list.add(page);			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询失败！");
		}finally{
			DBUtil.closeConnection(conn);
		}
		return list;
	}
	public Page FindPage(String time) {
		String sql="select * from  page  where title=?";
		Page page=new Page();
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, time);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				page.setAuthor(rs.getString("author"));
				page.setPid(rs.getInt("pid"));
				page.setPraize(rs.getInt("praize"));
				page.setTime(rs.getTime("time"));
				page.setTitle(rs.getString("title"));
				page.setType(rs.getString("type"));
				page.setViews(rs.getInt("views"));
				page.setContent(rs.getString("content"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询失败！");
		}finally{
			DBUtil.closeConnection(conn);
		}
		return page;
	}
	public List<Page> findAllPage(int page, int pageSize) {
		List<Page> list=new ArrayList<Page>();
		String sql="select * from  page limit ?,?";
		Page p=null;
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1, (page-1)*pageSize);
			ps.setInt(2, pageSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				p=new Page();
				p.setAuthor(rs.getString("author"));
				p.setPid(rs.getInt("pid"));
				p.setPraize(rs.getInt("praize"));
				p.setTime(rs.getTime("time"));
				p.setTitle(rs.getString("title"));
				p.setType(rs.getString("type"));
				p.setViews(rs.getInt("views"));
				p.setContent(rs.getString("content"));
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询失败！");
		}finally{
			DBUtil.closeConnection(conn);
		}
		return list;
	}
	/*
	 * 下列方法是处理饮食文化页面的方法
	 * 
	 */
	public List<Page> findAllType(int page, int pageSize, String type) {
		List<Page> list=new ArrayList<Page>();
		Page p=null;
		String sql="select * from (select * from page where type=?) m limit ?,?";
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, type);
			ps.setInt(2, (page-1)*pageSize);
			ps.setInt(3, pageSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				p=new Page();
				p.setAuthor(rs.getString("author"));
				p.setPid(rs.getInt("pid"));
				p.setPraize(rs.getInt("praize"));
				p.setTime(rs.getTime("time"));
				p.setTitle(rs.getString("title"));
				p.setType(rs.getString("type"));
				p.setViews(rs.getInt("views"));
				p.setContent(rs.getString("content"));
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询失败！",e);
		}finally{
			DBUtil.closeConnection(conn);
		}
		return list;
	}
	public Page findTypeAndTitle(List<Page> list, String title) {
		Page page=new Page();
		for(Page pg:list){
			if(pg.getTitle().equals(title)){
				page=pg;
				break;
			}
		}
		return page;
	}
	//返回同一类型的文章集合
	public List<Page> findType(String type) {
		List<Page> list=new ArrayList<Page>();
		Page p=null;
		String sql="select * from page where type=?";
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, type);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				p=new Page();
				p.setAuthor(rs.getString("author"));
				p.setPid(rs.getInt("pid"));
				p.setPraize(rs.getInt("praize"));
				p.setTime(rs.getTime("time"));
				p.setTitle(rs.getString("title"));
				p.setType(rs.getString("type"));
				p.setViews(rs.getInt("views"));
				p.setContent(rs.getString("content"));
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询失败！",e);
		}finally{
			DBUtil.closeConnection(conn);
		}
		return list;
	}
}
