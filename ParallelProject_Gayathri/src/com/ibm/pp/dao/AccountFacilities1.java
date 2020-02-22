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


@WebServlet("/welcome1")
public class AccountFacilities1 extends HttpServlet {
	
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
		
//Deposit and update the balance and update in transaction table:
		
		int accid = Integer.parseInt(request.getParameter("accid"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		
	
	    String selQry = "SELECT `balance` FROM `account_details` WHERE account_id=?";
	    pstmt = dbcon.prepareStatement(selQry);
	    pstmt.setInt(1, accid);
	    int updatedbalance=0;
		ResultSet rs= pstmt.executeQuery();
		while(rs.next()) {
          int currentbalance = rs.getInt("balance");
          //System.out.println("Current Balance : " + currentbalance );
          updatedbalance = currentbalance + amount;
          //System.out.println("Updated balance : " +updatedbalance);
		}
		
		String upQry = "UPDATE `account_details` SET `balance`=? WHERE account_id=?";
		pstmt=dbcon.prepareStatement(upQry);
		pstmt.setInt(1, updatedbalance);
		pstmt.setInt(2, accid);
        pstmt.executeUpdate();	
        
        String inQry ="INSERT INTO `transaction_details`(`id`, `Time`, `From accID`, `to accID`) VALUES (NULL,current_timestamp(),?,'0')";
        pstmt=dbcon.prepareStatement(inQry);
        pstmt.setInt(1, accid);
        pstmt.executeUpdate();
        
        out.println("Amount Deposited Successfully....");
        RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
        rd.include(request, response);
		
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
