package com.FOD.dao;

import java.util.List;

public interface IDao<V> {
	
		/**
		 *  该方法查找出数据库中所有数据并保存到List集合中                                                                                                                                                                                                                            
		 * @return
		 */
		List<V> findAll();
		
		
		/**
		 * 分页数据查询
		 * @param currentPage 当前页
		 * @param lineSize 每页显示的行数
		 * @return
		 */
		List<V> findSplit(int currentPage,int lineSize);
		
		/**
		 * 利用id进行数据查询
		 * @return
		 */
		V findByID(int id);
		
		/**
		 * 利用id进行数据的删除工作
		 * @param id
		 * @return
		 */
		int doDelete(int id);
		
		/**
		 * 进行单个数据的添加操作
		 * @param v
		 * @return
		 */
		int doAdd(V v);
		
		/**
		 * 进行单个数据的修改操作
		 * @param v
		 * @return
		 */
		int doUpdate(V v);

}
