package com.FOD.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.FOD.dao.IGdFoodDao;
import com.FOD.entity.GdFood;
import com.FOD.factory.DaoFactory;
import com.FOD.service.IGdFoodSer;

public class GdFoodService implements IGdFoodSer{

	public Map<String, Object> getInForMap() {
		IGdFoodDao gdDao = DaoFactory.getIGdFoodDao();
		Map<String,Object> map = new HashMap<String,Object>();
		List<String> kindList = gdDao.findKinds();
		map.put("kindList", kindList);
		for (String kind : kindList) {
			List<GdFood> splitList = gdDao.findByKind(kind);
			map.put(kind, splitList);
			
		}
		return map;
	}

	public int cutStock(int cut, int id) {
		IGdFoodDao gdDao = DaoFactory.getIGdFoodDao();
		return gdDao.doUpdateStock(cut,id);
	}

}
