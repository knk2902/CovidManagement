package com.ajp.project;

import java.io.IOException;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String mob;
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
		mob = req.getParameter("mob");
		String password = req.getParameter("password");
		
		try {
			
			Connection connect = DbConnection.Connectiontodatabase();
			
			String query = "SELECT * FROM user_details WHERE MobileNo = '"+mob+"' and Password = '"+password+"';";

			Statement st = connect.createStatement();
			ResultSet rs =  st.executeQuery(query);
			
			int flag = 0;
			while(rs.next()){
				flag = 1;	
				res.sendRedirect("Main.html");
			}
				
			if(flag!=1){
				res.sendRedirect("fail.html");
			}
			
		}
		 catch(Exception e) {}
	}

}