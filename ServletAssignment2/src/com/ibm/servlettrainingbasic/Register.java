package com.ibm.servlettrainingbasic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class Register extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.print("please login... <br><br>") ;
		RequestDispatcher dispatcher = request.getRequestDispatcher("first.html");
		
		
		dispatcher.include(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection dbcon;
		PreparedStatement pstmt;
		
		try {
//			ServletConfig config = getServletConfig();
//			String driver = config.getInitParameter("jdbcDriver");
			Class.forName("com.mysql.jdbc.Driver");
			dbcon = DriverManager.getConnection("jdbc:mysql://localhost:3307/servletlogindata?serverTimezone=UTC", "root", "");
			System.out.println("Connector");
			
		//Insert the data:	
			String inQry = "INSERT INTO `userdata`(`User_Name`, `User_Password`) VALUES (?,?)";	
			pstmt=dbcon.prepareStatement(inQry);
			pstmt.setString(1, request.getParameter("username"));
			pstmt.setString(2,request.getParameter("password"));
			pstmt.execute();
		   }
		catch(SQLException e)
		{
			System.out.println("Exception occurred during connection : " +e.getMessage());
		}
		
		catch(ClassNotFoundException e1)
		{
			System.out.println("Exception occurred during connection 1:" +e1.getMessage());
		}
		
		response.setContentType("text/html");
		PrintWriter out1 = response.getWriter();
		
		if(request.getParameter("username").length()!=0  && request.getParameter("password").length()!=0)
		{
		if(request.getParameter("username").length()<=10 && request.getParameter("password").length()>=6)
		{
			out1.println("Welcome : " + request.getParameter("username"));
			RequestDispatcher rd1 = request.getRequestDispatcher("logged.html");
			rd1.include(request, response);
		}
		
		else {
			out1.println("please login.... <br><br>");
			RequestDispatcher rd2 = request.getRequestDispatcher("register.html");
			rd2.include(request, response);
		}
		}
		
		else
		{
			out1.print("please Register...<br><br>") ;
			RequestDispatcher dispatcher = request.getRequestDispatcher("first.html");
			
			
			dispatcher.include(request, response);
		}
		
		
	}

}
