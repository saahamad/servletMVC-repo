package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Product
 */
//@WebServlet("/Product")
public class Product extends HttpServlet {
	
	String unm = null;
	String psw = null;
	@Override
	public void init() throws ServletException {
		
		ServletConfig sc = getServletConfig();
		 unm= sc.getInitParameter("user");
		 psw = sc.getInitParameter("password");
		 System.out.println("*********"+unm);
		 System.out.println("*********"+psw);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw = resp.getWriter();	
		String name = req.getParameter("fnm");
		pw.print("<b>This is your first servlet.."+name);
		
		
		  RequestDispatcher dispather = req.getRequestDispatcher("Order");
		  dispather.include(req,resp);
		 
		pw.print("<br>End of 1st servlet</b>");
		
		//pw.print("<a href=Order>Order</a>");
	}

}
