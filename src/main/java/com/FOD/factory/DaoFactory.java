package com.FOD.factory;

import com.FOD.dao.IComplainDao;
import com.FOD.dao.IGdFoodDao;
import com.FOD.dao.IGiftDao;
import com.FOD.dao.IJudgeDao;
import com.FOD.dao.IMenuDao;
import com.FOD.dao.IOrderDao;
import com.FOD.dao.IPageDao;
import com.FOD.dao.ISavePageDao;
import com.FOD.dao.ITipDao;
import com.FOD.dao.IUserDao;
import com.FOD.dao.IZhFoodDao;
import com.FOD.dao.IZhTypeDao;
import com.FOD.dao.IZxFoodDao;
import com.FOD.daoImpl.ComplainDaoImpl;
import com.FOD.daoImpl.GdFoodDaoImpl;
import com.FOD.daoImpl.GiftDaoImpl;
import com.FOD.daoImpl.JudgeDaoImpl;
import com.FOD.daoImpl.MenuDaoImpl;
import com.FOD.daoImpl.OrderDaoImpl;
import com.FOD.daoImpl.PageDaoImpl;
import com.FOD.daoImpl.SavePageDaoImpl;
import com.FOD.daoImpl.TipDaoImpl;
import com.FOD.daoImpl.UserDaoImpl;
import com.FOD.daoImpl.ZhFoodDaoImpl;
import com.FOD.daoImpl.ZhTypeDaoImpl;
import com.FOD.daoImpl.ZxFoodDaoImpl;

public class DaoFactory {
	/**
	 * 获得IGdFoodDao对象
	 * @return
	 */
	public static IGdFoodDao getIGdFoodDao(){
		return  new GdFoodDaoImpl();
	}
	
	
	/**
	 * 获得IZxFoodDao对象
	 * @return
	 */
	public static IZxFoodDao getIZxFoodDao(){
		return  new ZxFoodDaoImpl();
	}
	
	/**
	 * 获得IZhFoodDao对象
	 * @return
	 */
	public static IZhFoodDao getIZhFoodDao(){
		return  new ZhFoodDaoImpl();
	}
	
	/**
	 * 获得IZhTypeDao对象
	 * @return
	 */
	public static IZhTypeDao getIZhTypeDao(){
		return  new ZhTypeDaoImpl();
	}
	
	/**
	 * 获得IComplainDao对象
	 * @return
	 */
	public static IComplainDao getIComplainDao(){
		return new ComplainDaoImpl();
	}
	
	public static IGiftDao getIGiftDao(){
		return new GiftDaoImpl();
	}
	
	public static IJudgeDao getIJudgeDao(){
		return new JudgeDaoImpl();
	}
	
	public static IMenuDao getIMenuDao(){
		return new MenuDaoImpl();
	}
	
	public static IOrderDao getIOrderDao(){
		return new OrderDaoImpl();
	}
	
	public static IPageDao getIPageDao(){
		return new PageDaoImpl();
	}
	
	public static ISavePageDao getISavePageDao(){
		return new SavePageDaoImpl();
	}
	
	public static ITipDao getITipDao(){
		return new TipDaoImpl();
	}
	
	public static IUserDao getIUserDao(){
		return new UserDaoImpl();
	} 
	
}
