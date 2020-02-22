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


@WebServlet("/numbergenerate")
public class AccountIdGeneration extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Connection dbcon;
		PreparedStatement pstmt;
		
	//Database Connectivity
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			dbcon=DriverManager.getConnection("jdbc:mysql://localhost:3307/Parallel_Project?serverTimezone=UTC","root","");
			System.out.println("Connected");
			//String phonenumber =request.getParameter("number");
			//String name=request.getParameter("name");
			String selQry = "SELECT `account_id` FROM `account_details` WHERE PhoneNumber =?";
			pstmt=dbcon.prepareStatement(selQry);
			//pstmt.setString(1, request.getParameter("name"));
			pstmt.setString(1,request.getParameter("number"));
			ResultSet rs = pstmt.executeQuery();
			int num = 0;
			//String name1 = null;
			String num1 = null;
			while(rs.next())
			{
				num = rs.getInt("account_id");
				System.out.println(num);
				
				//name1 =rs.getString("Name");
				num1=rs.getString("PhoneNumber");
				System.out.println(num1);
				//System.out.print(name1);
			}
			if(request.getParameter("number").equals(num1))
				
			{
				out.println("Your Account Number generated is : " +num);
				RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
				rd.include(request, response);
			}
			
			else
			{
			   out.println("Account Creation is unsuccessful...");
			   RequestDispatcher rd1 = request.getRequestDispatcher("welcome.jsp");
			   rd1.include(request, response);
			}
		}
			
			catch(SQLException e)
			{
				System.out.println("Exception Occurred during connection : " +e.getMessage());
			}
			catch(ClassNotFoundException e1)
			{
				System.out.println("Exception Occurred during connection class : " +e1.getMessage());
			}
		
			
	}

}
