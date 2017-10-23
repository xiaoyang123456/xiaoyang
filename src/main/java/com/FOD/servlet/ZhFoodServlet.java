package com.FOD.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.FOD.factory.ServiceFactory;
import com.FOD.service.IZhFoodSer;
import com.alibaba.fastjson.JSON;

public class ZhFoodServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		IZhFoodSer zhSer = ServiceFactory.getIZhFoodSer();
		Map<String, Object> map = zhSer.getInForMap();
		response.getWriter().write(JSON.toJSONString(map));
	}

}
