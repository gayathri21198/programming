package com.ibm.pp.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class UserLogin extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html");
//		if(request.getSession().getAttribute("username")!=null)
//		{
//			new UserLogin().doPost(request, response);
//		}
//		
//		else
//		{
//			PrintWriter out = response.getWriter();
//			out.println("Home page..<br><br>");
//			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//			rd.include(request,response);
//		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Connection dbcon;
		PreparedStatement pstmt;
	//Database Connectivity
		try {
			Class.forName("com.mysql.jdbc.Driver");
			dbcon=DriverManager.getConnection("jdbc:mysql://localhost:3307/Parallel_Project?serverTimezone=UTC","root","");
			System.out.println("Connected");
			
// Compare the login data with database:
			String selQry = "SELECT * FROM `registrationdetails` WHERE user_name=?";
			pstmt=dbcon.prepareStatement(selQry);
			pstmt.setString(1, request.getParameter("username"));
			
			ResultSet rs = pstmt.executeQuery();
			String password = null;
			while(rs.next())
			{
				password = rs.getString("user_password");
			}
			 String password1 = request.getParameter("pwd");
			 if((password1).equals(password))
			 {
				 HttpSession session = request.getSession(true);
				 session.setAttribute("username", request.getParameter("username"));
				 session.setAttribute("pwd", request.getParameter("pwd"));
				 RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
				 rd.include(request, response);
			 }
			 
			 else
			 {
				 out.println("Invalid Username or Password...<br><br> Please Register...<br><br>");
				 RequestDispatcher rd1 = request.getRequestDispatcher("index.jsp");
				 rd1.include(request, response);
				 
			 }
			
		}
		
		catch(SQLException e)
		{
			System.out.println("Exception occurred while connecting to DB : " + e.getMessage());
		} 
		catch (ClassNotFoundException e) {
			
			System.out.println("Exception occurred due to class not found : " + e.getMessage());
		}
		
	}

}
