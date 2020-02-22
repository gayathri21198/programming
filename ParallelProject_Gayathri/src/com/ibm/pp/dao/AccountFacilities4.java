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


@WebServlet("/welcome4")
public class AccountFacilities4 extends HttpServlet {
	
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
			
//Check Balance:
			String chQry = "SELECT  `balance` FROM `account_details` WHERE account_id = ?";
			
				int accId = Integer.parseInt(request.getParameter("accountID"));
				pstmt = dbcon.prepareStatement(chQry);
				
				pstmt.setInt(1, accId);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next())
				{
					int ba = rs.getInt("balance");
					
					if(ba<=1000)
					{
						out.println("The account possess low balance..." +ba);
						
					}
				}
				RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
		        rd.include(request, response);
			}
			
			catch(SQLException e)
			{
				System.out.println("Exception occurred when checking balance : " + e.getMessage());
			}
			catch(ClassNotFoundException e1)
			{
				System.out.println("Exception occurred when checking balance : " + e1.getMessage());
			}
		
	}

}
