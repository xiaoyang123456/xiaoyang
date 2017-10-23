package com.FOD.dao;

import com.FOD.entity.Tip;

public interface ITipDao extends IDao<Tip> {
	
	/**
	 * 查询总的数据条数
	 */
	
	int getCount();
	
}
