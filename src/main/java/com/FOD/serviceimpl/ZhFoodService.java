package com.FOD.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.FOD.dao.IZhFoodDao;
import com.FOD.dao.IZhTypeDao;
import com.FOD.entity.ZhFood;
import com.FOD.entity.ZhType;
import com.FOD.factory.DaoFactory;
import com.FOD.service.IZhFoodSer;

public class ZhFoodService implements IZhFoodSer{

	public Map<String, Object> getInForMap() {
		IZhFoodDao zhFood = DaoFactory.getIZhFoodDao();
		IZhTypeDao zhType = DaoFactory.getIZhTypeDao();
		Map<String,Object> map = new HashMap<String,Object>();
		List<ZhType> typeList = zhType.findAll();
		map.put("typeList", typeList);
		List<String> kindList = zhFood.findKinds();
		map.put("kindList", kindList);
		for (String kind : kindList) {
			List<ZhFood> listSplit = zhFood.findByKind(kind);
			map.put(kind, listSplit);
		}
		return map;
	}

}
