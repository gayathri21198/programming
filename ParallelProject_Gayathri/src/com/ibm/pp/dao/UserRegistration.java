package com.ibm.pp.dao;

import java.sql.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class UserRegistration extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
        response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.print("please login... <br><br>") ;
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		
		
		dispatcher.include(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection dbcon;
		PreparedStatement pstmt;
	//Database Connectivity
		try {
			Class.forName("com.mysql.jdbc.Driver");
			dbcon=DriverManager.getConnection("jdbc:mysql://localhost:3307/Parallel_Project?serverTimezone=UTC","root","");
			System.out.println("Connected");
			
  //Insert the data into the database:
			String inQry = "INSERT INTO `registrationdetails`(`user_name`, `user_email id`, `user_password`) VALUES (?,?,?)";
			pstmt = dbcon.prepareStatement(inQry);
			pstmt.setString(1, request.getParameter("name"));
			pstmt.setString(2, request.getParameter("email"));
			pstmt.setString(3, request.getParameter("password"));
			pstmt.execute();
			
//			
			
			
		}
		
		catch(SQLException e)
		{
			System.out.println("Exception occurred while connecting to DB : " + e.getMessage());
		} 
		catch (ClassNotFoundException e) {
			
			System.out.println("Exception occurred due to class not found : " + e.getMessage());
		}
		
		//
		response.setContentType("text/html");
		PrintWriter out1 = response.getWriter();
		
		if(request.getParameter("name")!=null && request.getParameter("email")!=null && request.getParameter("password")!=null)
		{
			out1.println("Registered Successfully...<br><br> Continue by login...<br><br>" + request.getParameter("name"));
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.include(request,response);
		}
		
		else {
			out1.println("Registration Unsuccessful..." + request.getParameter("name"));
			RequestDispatcher rd1 = request.getRequestDispatcher("index.jsp");
			rd1.include(request, response);
		}	
		
	}

}
