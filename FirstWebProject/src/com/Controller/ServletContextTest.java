package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletContextTest")
public class ServletContextTest extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter pw = response.getWriter();
		setByProgrammeticalApproach(pw);
		
		pw.print("<br><a href=AccessContextData1>AccessContextData1<a>");
		pw.print("<br><a href=AccessServletContextData2>AccessServletContextData2<a>");
		
	}	
	public void accessXMLContextParam(PrintWriter pw){
		// ATo access the address of Context object
		ServletContext context = getServletContext();
		
		// To access from xml file
		String user =  context.getInitParameter("username");
		String pass =  context.getInitParameter("password");
		
		pw.print("<b><br>User name is:"+user+"<br>Password is:"+pass+"</b>");
		
	}
	
	public void setByProgrammeticalApproach(PrintWriter pw){
		// ATo access the address of Context object
		ServletContext context = getServletContext();
	
		context.setAttribute("classpath", "com.mysql.jdbc.Driver");
		context.setAttribute("urlpath", "jdbc:mysql://localhost:3306/testdb");
		
		pw.print("<b><br>Data set to Context</b>");
	}
}











