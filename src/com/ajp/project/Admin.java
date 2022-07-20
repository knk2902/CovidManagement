package com.ajp.project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Handle")
public class Admin extends HttpServlet  {
	
	private static final long serialVersionUID = 1L;
	public static String mob;
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, NullPointerException{
		
		String u = req.getParameter("admin");
		String ps = req.getParameter("pass");
	
	try {
		
		Connection connect = DbConnection.Connectiontodatabase();
		
		String query = "SELECT * FROM admin_details WHERE UserName = '"+u+"' and Password = '"+ps+"';";

		Statement st = connect.createStatement();
		ResultSet rs =  st.executeQuery(query);
		
		int flag = 0;
		while(rs.next()){
			flag = 1;	
			res.sendRedirect("Info.jsp");
		}
			
		if(flag!=1){
			res.sendRedirect("AFail.html");
		}
		
	}
	 catch(Exception e) {}
}
}