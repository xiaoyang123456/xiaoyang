package com.FOD.factory;



import com.FOD.service.IGdFoodSer;
import com.FOD.service.ITipSer;
import com.FOD.service.IZhFoodSer;
import com.FOD.service.IZxFoodSer;
import com.FOD.serviceimpl.GdFoodService;
import com.FOD.serviceimpl.TipService;
import com.FOD.serviceimpl.ZhFoodService;
import com.FOD.serviceimpl.ZxFoodService;

public class ServiceFactory {
	
	public static IZxFoodSer getIZxFoodSer(){
		return new ZxFoodService();
	}
	
	public static IGdFoodSer getIGdFoodSer(){
		return new GdFoodService();
	}
	
	public static IZhFoodSer getIZhFoodSer(){
		return new ZhFoodService();
	}
	
	public static ITipSer getITipSer(){
		return new TipService();
	}

}
