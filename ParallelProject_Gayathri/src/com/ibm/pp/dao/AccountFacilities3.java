package com.ibm.pp.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/welcome3")
public class AccountFacilities3 extends HttpServlet {
	
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
			
	//Fetch Details
			String selQry = "SELECT * FROM `account_details` WHERE PhoneNumber=?";
			pstmt=dbcon.prepareStatement(selQry);
			pstmt.setString(1, request.getParameter("number"));
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				int accId = rs.getInt(1);
				String name = rs.getString(2);
				String phoneNumber = rs.getString(3);
				String accType = rs.getString(4);
				int accBalance = rs.getInt(5);
				
			out.println("Account ID : " + accId + "Customer Name : "+ name + "Customer PhoneNumber : " 
			+ phoneNumber + "Account Type : " + accType + "Account Balance : " + accBalance);
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
	        rd.include(request, response);
	    }
		
		catch(SQLException e) {
			System.out.println("Exception occurred during displaying the table : " + e.getMessage());
		}
		catch(ClassNotFoundException e1)
		{
			System.out.println("Exception occurred during displaying the table : " + e1.getMessage());
	}
	}

}

