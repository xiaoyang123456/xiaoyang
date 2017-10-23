package com.FOD.service;


import java.util.Map;

import com.FOD.entity.Tip;

public interface ITipSer {
	
	
	/**
	 * 分页获取留言信息并存到List集合中
	 * @return
	 */
	Map<String,Object> getInfor(int currentPage);
	
	
	/**
	 * 将留言数据保存到数据库中
	 * @param t
	 * @return
	 */
	int doupdate(Tip t);

}
