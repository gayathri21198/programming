package com.ibm.servlettrainingbasic;

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

import sun.security.util.Password;


@WebServlet("/login")
public class LoginPage extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		if(request.getSession().getAttribute("username")!=null) {
			new LoginPage().doPost(request,response);
		}
		else {
		
		PrintWriter out = response.getWriter();
		out.println("please login..<br><br>");
		RequestDispatcher rd = request.getRequestDispatcher("first.html");
		rd.include(request,response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out1 = response.getWriter();
		
		Connection dbcon;
		PreparedStatement pstmt;
		
		try {
//			ServletConfig config = getServletConfig();
//			String driver = config.getInitParameter("jdbcDriver");
			Class.forName("com.mysql.jdbc.Driver");
			dbcon = DriverManager.getConnection("jdbc:mysql://localhost:3307/servletlogindata?serverTimezone=UTC", "root", "");
			System.out.println("Connector");
			
			
// Compare the login data with the table:
			String sql ="SELECT * FROM `userdata` WHERE User_Name = ?";
			pstmt = dbcon.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("username"));
			
			ResultSet rs = pstmt.executeQuery();
		String password = null;

			while (rs.next())
			{
				
			 password = rs.getString("User_Password");
			}
			
			String pwd1 = request.getParameter("pwd");
			if((password).equals (pwd1))
			{
				HttpSession session = request.getSession(true);
				session.setAttribute("username",request.getParameter("username"));
				session.setAttribute("pwd", pwd1);
				//out1.println("Welcome : " +session.getAttribute("username"));
				RequestDispatcher rd1 = request.getRequestDispatcher("logged.html");
				response.getWriter().println("Welcome : " + request.getSession().getAttribute("username"));
				rd1.include(request,response);
				//rd1.include(request, response);
			}
			else {
				out1.println("Invalid Credentials...<br><br>");
				RequestDispatcher rd2 = request.getRequestDispatcher("login.html");
				rd2.include(request, response);
			}
				
			
		}
		
		catch(SQLException e)
		{
			System.out.println("Exception occurred during connection : " + e.getMessage());
		}
		
		catch(ClassNotFoundException e1)
		{
			System.out.println("Exception occurred during connection 1 : " + e1.getMessage());
		}
	}

}
