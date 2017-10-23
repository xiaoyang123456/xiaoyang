package com.FOD.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.FOD.dao.ITipDao;
import com.FOD.entity.Tip;
import com.FOD.factory.DaoFactory;
import com.FOD.service.ITipSer;

public class TipService implements ITipSer{

	public Map<String,Object> getInfor(int currentPage) {
		Map<String,Object> map = new HashMap<String ,Object>();
		ITipDao td = DaoFactory.getITipDao();
		int count = td.getCount();
		int lineSize=8;
		int page=count%lineSize==0?(count/lineSize):(count/lineSize+1);
		map.put("page", page);
		List<Tip> list = td.findSplit(currentPage, lineSize);
		map.put("list", list);
		
		return null;
	}

	public int doupdate(Tip t) {
		ITipDao td = DaoFactory.getITipDao();
		return td.doAdd(t);
	}

	
}
