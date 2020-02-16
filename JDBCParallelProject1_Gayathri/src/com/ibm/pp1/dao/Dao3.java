package com.ibm.pp1.dao;

import java.sql.*;
import java.util.*;

import com.ibm.pp1.bean.CreateAccountDetails;
import com.ibm.pp1.bean.TransactionDetails;


public class Dao3 implements DaoInterface3 {
	Connection dbcon;
	PreparedStatement pstmt;
	Scanner s = new Scanner(System.in);
	CreateAccountDetails acc1 = new CreateAccountDetails();
	public Dao3()
	{

			try {
				dbcon = DriverManager.getConnection("jdbc:mysql://localhost:3306/parallelproject1", "root", "");
				}
				catch(SQLException e)
				{
					System.out.println("Exception occurred during connection phase : " + e.getMessage());
				}
		
	}
	
	public void createAccount(CreateAccountDetails det)
	{
		String inserQry = "INSERT INTO `account_details`(`Customer_Name`, `Customer_PhoneNumber`, `Account_Type`, `Account_Balance`) "
				+ "VALUES (?,?,?,?)";
		
		try {
			pstmt = dbcon.prepareStatement(inserQry);
			System.out.println("Enter the customer name");
			String name = s.next();
			s.nextLine();
			System.out.println("Enter the Customer phoneNumber");
			String phoneNumber = s.next();
			s.nextLine();
			System.out.println("Enter the Account Type");
			String accType = s.next();
			System.out.println("Enter the Account balance");
			int balance = s.nextInt();
			
			pstmt.setString(1, name);
			pstmt.setString(2, phoneNumber);
			pstmt.setString(3, accType);
			pstmt.setInt(4, balance);
		
			
			pstmt.execute();
			
		}
		
		catch(SQLException e){
			System.out.println("Exception occurred during adding the details : " + e.getMessage());
			
		}
	}
	
	@Override
	public void deposit(int amount , int accId)
	{
		String selQry = "SELECT Account_Balance FROM `account_details` WHERE Account_ID = ?";
		
		try
		{
			pstmt = dbcon.prepareStatement(selQry);
			pstmt.setInt(1,accId);
			int updatedbalance=0;
			ResultSet rs= pstmt.executeQuery();
			while(rs.next()) {
              int currentbalance = rs.getInt("Account_Balance");
              System.out.println("Current Balance : " + currentbalance );
              updatedbalance = currentbalance + amount;
              System.out.println("Updated balance : " +updatedbalance);
			}
			String upQry = "UPDATE account_details SET account_details.Account_Balance =?" + 
					"WHERE account_details.Account_ID=?";
			pstmt = dbcon.prepareStatement(upQry);
			pstmt.setInt(1, updatedbalance);
			pstmt.setInt(2,accId);
			
			String inQry = "INSERT INTO `transaction_details`(`Transaction_Id`, `Time`, `From_Account_Id`, `To_Account_Id`) "
					+ "VALUES (NULL,current_timestamp(),?,'0')";
					
			pstmt = dbcon.prepareStatement(inQry);
			pstmt.setInt(1, accId);
			
			pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println("Exception occurred during deposit : " + e.getMessage());
		}
	}
	
	@Override
	
	public void withdraw(int amount , int accId)
	{
	
		String selQry = "SELECT Account_Balance FROM `account_details` WHERE Account_ID = ?";
		int updatedbalance = 0;
		try {
			pstmt = dbcon.prepareStatement(selQry);
			pstmt.setInt(1, accId);
			ResultSet rs= pstmt.executeQuery();
			while(rs.next()) {
              int currentbalance = rs.getInt("Account_Balance");
              System.out.println("Current Balance : " + currentbalance );
              updatedbalance = currentbalance - amount;
              System.out.println("Updated balance : " +updatedbalance);
              //rs.updateInt(1, updatedbalance);
              //rs.updateRow();
			}
			
			String upQry = "UPDATE `account_details` SET `Account_Balance`=? WHERE Account_ID=?";
			  pstmt = dbcon.prepareStatement(upQry);
     		  pstmt.setInt(2, accId);
          
			
			
			
			String insertQry ="INSERT INTO `transaction_details`(`Transaction_Id`, `Time`, `From_Account_Id`, `To_Account_Id`)"
					+ " VALUES (NULL,current_timestamp(),0,?)";
			
			pstmt = dbcon.prepareStatement(insertQry);
			
			pstmt.setInt(1, accId);
			
			pstmt.executeUpdate();
		}
		
		catch(SQLException e)
		{
			System.out.println("Exception occurred during withdrawal : " + e.getMessage());
		}
	}
	
	@Override
	
	public void fetchAccountDetails(CreateAccountDetails det)
	{
		try{
			Statement stmt = dbcon.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM `account_details`");
			while(rs.next())
			{
				int accId = rs.getInt(1);
				String name = rs.getString(2);
				String phoneNumber = rs.getString(3);
				String accType = rs.getString(4);
				int accBalance = rs.getInt(5);
				
			System.out.println("Account ID : " + accId + "Customer Name : "+ name + "Customer PhoneNumber : " 
			+ phoneNumber + "Account Type : " + accType + "Account Balance : " + accBalance);
			}
		}
		
		catch(SQLException e) {
			System.out.println("Exception occurred during displaying the table : " + e.getMessage());
		}
	}
private Statement createStatement() {
		// TODO Auto-generated method stub
		return null;
	}

public void checkBalance(CreateAccountDetails det)
{
	String chQry = "SELECT  `Account_Balance` FROM `account_details` WHERE Account_ID = ?";
	try {
		System.out.println("Enter the account number to check balance ");
		int accId = s.nextInt();
		pstmt = dbcon.prepareStatement(chQry);
		
		pstmt.setInt(1, accId);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next())
		{
			int ba = rs.getInt("Account_Balance");
			System.out.println("the account balance is : " + ba);
			if(ba<=1000)
			{
				System.out.println("The account possess low balance");
			}
		}
	}
	
	catch(SQLException e)
	{
		System.out.println("Exception occurred when checking balance : " + e.getMessage());
	}
}

public void fundTransfer(int fromaccId , int toaccId , int amount)
{
	try {
		String Qry = "SELECT Account_Balance FROM `account_details` WHERE Account_ID = ?";
         
         
         int updatedbalance1 = 0;
         pstmt = dbcon.prepareStatement(Qry);
         pstmt.setInt(1, fromaccId);
         ResultSet rs= pstmt.executeQuery();
			while(rs.next()) {
           int currentbalance1 = rs.getInt("Account_Balance");
           System.out.println("Current Balance : " + currentbalance1 );
           updatedbalance1 = currentbalance1 - amount;
           System.out.println("Updated balance : " +updatedbalance1);
			}
         
        
         String Qry1 = " UPDATE `account_details` SET account_details.Account_Balance = ? "
          		+ "WHERE account_details.Account_ID=?";   
         pstmt=dbcon.prepareStatement(Qry1);
         pstmt.setInt(1, updatedbalance1);
         pstmt.setInt(2, fromaccId);
         
         String Qryy = "SELECT Account_Balance FROM `account_details` WHERE Account_ID = ?";
         pstmt=dbcon.prepareStatement(Qryy);
         int updatedbalance2=0;
         pstmt = dbcon.prepareStatement(Qry);
         pstmt.setInt(1, toaccId);
         ResultSet rs1= pstmt.executeQuery();
			while(rs1.next()) {
        int currentbalance2 = rs1.getInt("Account_Balance");
        System.out.println("Current Balance : " + currentbalance2 );
        updatedbalance2 = currentbalance2 + amount;
        System.out.println("Updated balance : " +updatedbalance2);
			}
		
			
			
			
			String Qry2 = "UPDATE `account_details` SET account_details.Account_Balance = ?"
	          		+ " WHERE account_details.Account_ID=?";
			pstmt=dbcon.prepareStatement(Qry2);
         pstmt.setInt(1, updatedbalance2);
         pstmt.setInt(2, toaccId);
         
         String Qry3 = "INSERT INTO `transaction_details`(`Transaction_Id`, `Time`, `From_Account_Id`, `To_Account_Id`)" 
         	       + "VALUES (NULL,current_timestamp(),?,?)";
         
         pstmt = dbcon.prepareStatement(Qry3);
         pstmt.setInt(1, fromaccId);
         pstmt.setInt(2, toaccId);
         
         pstmt.executeUpdate();
	}
	
	catch(SQLException e)
	{
		System.out.println("Exception Occurred during fund transfer : " + e.getMessage());
	}
}

@Override
public void printTransactionDetails(TransactionDetails tr , int accID)
{
	try{
		Statement stmt = dbcon.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM `transaction_details`");
		while(rs.next())
		{
			if((rs.getInt("From_Account_ID")==(accID)||rs.getInt("To_Account_ID")==(accID)))
			{
			int transId = rs.getInt(1);
			String time = rs.getString(2);
			int fromacc = rs.getInt(3);
			int toacc = rs.getInt(4);
			System.out.println("Transaction ID : " + transId + "Transaction time : "+ time + "Debit Account :  "  
					+ fromacc + "Credit Account : " + toacc);
			}
			
		
		}
	}
	
	catch(SQLException e) {
		System.out.println("Exception occurred during displaying the table : " + e.getMessage());
	}
}




	}


