package com.FOD.service;

import java.util.Map;

public interface IZhFoodSer {
	
	
	/**
	 * 该方法是得到组合套餐的全部相关数据，map中存有多个List
	 * @return
	 */
	Map<String, Object> getInForMap();
}
