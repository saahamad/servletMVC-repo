package com.daolayer;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.service.User;
public class LoginDao {
	
	static String CLASS_PATH = "com.mysql.cj.jdbc.Driver";
	static String URL_PATH = "jdbc:mysql://localhost:3306/testdb";
	static String USER_NAME = "root";
	static String PASSWORD = "root";
	Connection connection = null;
	PreparedStatement prepare = null;
	static String sql = "select * from USER";
	ResultSet resultSet = null;
	
	/*
	 * static String CLASS_PATH = null; static String URL_PATH = null; static String
	 * USER_NAME = null; static String PASSWORD = null;
	 * 
	 * public LoginDao(String CLASS_PATH,String URL_PATH,String USER_NAME ,String
	 * PASSWORD) { this.CLASS_PATH = CLASS_PATH; this.URL_PATH = URL_PATH;
	 * this.USER_NAME = USER_NAME; this.PASSWORD = PASSWORD; }
	 */

	public  Connection connectTest() throws ClassNotFoundException, SQLException {
		Class.forName(CLASS_PATH);	
		connection = DriverManager.getConnection(URL_PATH,USER_NAME,PASSWORD);
		System.out.println("DB connected....");
		return connection;
	}
	
	public List<User> getUser(){
		System.out.println("DAO layer....");
		List<User> list = new ArrayList<>();
		try {
			 connection = connectTest();
			 prepare = connection.prepareStatement(sql);
			 resultSet = prepare.executeQuery();
			 
			 while (resultSet.next()) {
				 User user = new User();
				 user.setUserName(resultSet.getString("username")); 
				 user.setPassword(resultSet.getString("password"));
				 
				 list.add(user);
			}
			 
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("sending list from dao layer....");
		return list;
		
	}


}
