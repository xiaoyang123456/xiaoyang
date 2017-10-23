package com.FOD.dao;

import java.util.List;

import com.FOD.entity.ZxFood;

public interface IZxFoodDao extends IDao<ZxFood>{
	
	/**
	 * 该方法用于找到数据库中ZxFood菜系的种类，并以List集合的形式返回
	 * @return
	 */
	List<String> findKinds(); 
	
	/**
	 * 根据菜系种类进行数据查找
	 * @param kind
	 * @return
	 */
	List<ZxFood> findByKind(String kind);
	
	/**
	 * 对菜品库存进行更新
	 * @param cut
	 * @return
	 */
	int doUpdateStock(int cut,int id);

}
