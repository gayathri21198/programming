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


@WebServlet("/welcome5")
public class FundTransfer extends HttpServlet {
	
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
			
//Fund Transfer
			int fromacc = Integer.parseInt(request.getParameter("from accountID"));
			int toacc = Integer.parseInt(request.getParameter("to accountID"));
			int amount = Integer.parseInt(request.getParameter("amount"));
			
			String Qry = "SELECT balance FROM `account_details` WHERE account_id = ?";
	         
	         
	         int updatedbalance1 = 0;
	         pstmt = dbcon.prepareStatement(Qry);
	         pstmt.setInt(1, fromacc);
	         ResultSet rs= pstmt.executeQuery();
				while(rs.next()) {
	           int currentbalance1 = rs.getInt("balance");
	           //System.out.println("Current Balance : " + currentbalance1 );
	           updatedbalance1 = currentbalance1 - amount;
	           //System.out.println("Updated balance : " +updatedbalance1);
				}
	         
	        
	         String Qry1 = " UPDATE `account_details` SET account_details.balance = ? "
	          		+ "WHERE account_details.account_id=?";   
	         pstmt=dbcon.prepareStatement(Qry1);
	         pstmt.setInt(1, updatedbalance1);
	         pstmt.setInt(2, fromacc);
	         
	         pstmt.executeUpdate();
	         
	         String Qryy = "SELECT balance FROM `account_details` WHERE account_id = ?";
	         pstmt=dbcon.prepareStatement(Qryy);
	         int updatedbalance2=0;
	         pstmt = dbcon.prepareStatement(Qry);
	         pstmt.setInt(1, toacc);
	         ResultSet rs1= pstmt.executeQuery();
				while(rs1.next()) {
	        int currentbalance2 = rs1.getInt("balance");
	        //System.out.println("Current Balance : " + currentbalance2 );
	        updatedbalance2 = currentbalance2 + amount;
	        //System.out.println("Updated balance : " +updatedbalance2);
				}
			
				
				
				
				String Qry2 = "UPDATE `account_details` SET account_details.balance = ?"
		          		+ " WHERE account_details.account_id=?";
				pstmt=dbcon.prepareStatement(Qry2);
	         pstmt.setInt(1, updatedbalance2);
	         pstmt.setInt(2, toacc);
	         pstmt.executeUpdate();
	         
	         String Qry3 = "INSERT INTO `transaction_details`(`id`, `Time`, `From accID`, `to accID`) VALUES (NULL,current_timestamp(),?,?)";
	         
	         pstmt = dbcon.prepareStatement(Qry3);
	         pstmt.setInt(1, fromacc);
	         pstmt.setInt(2, toacc);
	         
	         pstmt.executeUpdate();
	         
	         out.println("funds transferred successfully...");
	         RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
	         rd.include(request, response);
		}
		catch(SQLException e)
		{
			System.out.println("Exception Occurred during fund transfer : " + e.getMessage());
		}
		
		catch(ClassNotFoundException e1)
		{
			System.out.println("Exception Occurred during fund transfer : " + e1.getMessage());
		}
	}

}
