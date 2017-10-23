package com.FOD.dao;

import java.util.List;

import com.FOD.entity.ZhFood;

public interface IZhFoodDao extends IDao<ZhFood>{
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
	List<ZhFood> findByKind(String kind);
}
