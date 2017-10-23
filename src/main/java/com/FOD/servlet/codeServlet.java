package com.FOD.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class codeServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BufferedImage image = new BufferedImage(85, 30, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		Color color = getColor();
		g.setColor(color);
		g.fillRect(0, 0, 85, 30);
		String code = getCode(4);
		HttpSession session = request.getSession();
		session.setAttribute("code", code);
		Font font = new Font("微软雅黑", Font.ITALIC, 20);
		g.setColor(Color.white);
		g.setFont(font);
		g.drawString(code, 12, 23);
		response.setContentType("image/jpeg");
		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(image, "jpeg", out);
		out.close();
	}
	
	public Color getColor(){
		Random random = new Random();
		Color color = new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
		return color;
	}
	
	public String getCode(int x){
		String str = "012346789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
		int length = str.length();
		String code = "";
		for(int i=0;i<x;i++){
			Random random = new Random();
			int index = random.nextInt(length);
			code = code+str.charAt(index);
		}
		return code;
	}
}
