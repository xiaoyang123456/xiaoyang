package com.FOD.service;

import java.util.Map;

public interface IGdFoodSer {
	/**
	 * 获取菜单中详细信息，调用dao层中的findKinds()和findByKind(String kind)方法，结果保存到Map集合中
	 * @return
	 */
	Map<String, Object> getInForMap();
	
	/**
	 * 对库存信息进行更新
	 * @param cut 新的订单发货数
	 * @param id 数据编号
	 * @return
	 */
	int cutStock(int cut, int id);
	
	
}
