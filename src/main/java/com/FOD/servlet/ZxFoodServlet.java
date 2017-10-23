package com.FOD.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.FOD.factory.ServiceFactory;
import com.FOD.service.IZxFoodSer;
import com.alibaba.fastjson.JSON;

public class ZxFoodServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;chaset=utf-8");
		IZxFoodSer zxSer = ServiceFactory.getIZxFoodSer();
		Map<String, Object> map = zxSer.getInForMap();
		System.out.println(map);
		resp.getWriter().write(JSON.toJSONString(map));
		
	}

}
