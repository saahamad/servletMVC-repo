package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AccessServletContextData2
 */
@WebServlet("/AccessServletContextData2")
public class AccessServletContextData2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		accessContextParam(pw);
	}

	public void accessContextParam(PrintWriter pw){
		// ATo access the address of Context object
		ServletContext context = getServletContext();
		
		// To access from xml file
		String user = (String) context.getInitParameter("username");
		String pass = (String) context.getInitParameter("password");
		
		// Programetical approch
		String classpath = (String) context.getAttribute("classpath");
		String urlpath = (String) context.getAttribute("urlpath");
		
		pw.print("<b><br>User name is:"+user+"<br>Password is:"+pass+"<br>class path is"+
		classpath+"<br>URL path:"+urlpath+"</b>");
	}
	
}
