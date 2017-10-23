package com.FOD.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.FOD.dao.IZxFoodDao;
import com.FOD.entity.ZxFood;
import com.FOD.factory.DaoFactory;
import com.FOD.service.IZxFoodSer;

public class ZxFoodService implements IZxFoodSer{
	
    
	public Map<String, Object> getInForMap() {
		IZxFoodDao zxDao = DaoFactory.getIZxFoodDao();
		Map<String,Object> map = new HashMap<String,Object>();
		List<String> kindList = zxDao.findKinds();
		map.put("kindList", kindList);
		for (String kind : kindList) {
			List<ZxFood> splitList = zxDao.findByKind(kind);
			map.put(kind, splitList);
			
		}
		return map;
	}

	public int cutStock(int cut, int id) {
		IZxFoodDao zxDao = DaoFactory.getIZxFoodDao();
		return zxDao.doUpdateStock(cut,id);
	}
}
