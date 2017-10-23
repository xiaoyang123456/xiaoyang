package com.FOD.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.FOD.entity.Tip;
import com.FOD.factory.ServiceFactory;
import com.FOD.service.ITipSer;
import com.alibaba.fastjson.JSON;

public class TipSendServelt extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		req.getParameter("list");
		int feel =Integer.parseInt( req.getParameter("feel"));
		int  score = Integer.parseInt(req.getParameter("score")) ;
		String content = req.getParameter("content");
		Date date = new Date();
		String userName=(String)req.getSession().getAttribute("username");
		Tip t = new Tip();
		t.setContent(content);
		t.setFeel(feel);
		t.setScore(score);
		t.setTime(date);
		t.setUsername(userName);
		
		ITipSer tipSer = ServiceFactory.getITipSer();
		int i = tipSer.doupdate(t);
		resp.getWriter().write(JSON.toJSONString(i));
		
	}
}
