package com.ibm.training;
import java.sql.*;
import java.util.*;

public class EmployeeDetailsUpdate {
	
	 static Connection dbcon;
	PreparedStatement pstmt;
	static Scanner scan = new Scanner(System.in);


	public EmployeeDetailsUpdate() {
		try {
			dbcon = DriverManager.getConnection("jdbc:mysql://localhost:3306/ibm12febclass","root", "");
		}
		catch(SQLException e) {
			System.out.println("Exception occurred during connection : " +e.getMessage());
		}
	}

	public static void main(String[] args) {
		System.out.println("Enter the choice 1.Add Employee details 2.Display the table 3.Update employee datails 4.Fetch the details 5.Delete");
		
		int choice = scan.nextInt();
		
		switch(choice)
		{
		case 1:
			new EmployeeDetailsUpdate().addEmployeeDetails(dbcon);
			break;
			
		case 2:
			new EmployeeDetailsUpdate().displayEmployeeDetails(dbcon);
			break;
			
		case 3:
			new EmployeeDetailsUpdate().updateEmployeeDetails(dbcon);
			break;
			
		case 4:
			new EmployeeDetailsUpdate().fetchEmployeeDetails(dbcon);
			break;
		case 5:
			new EmployeeDetailsUpdate().deleteEmployeeRecord(dbcon);
			break;
			
		default:
			System.out.println("invalid choice");
			
			
		}
	}
	
	void addEmployeeDetails(Connection dbcon)
	{
		//Insert Query as in MYSQL
		try {
		String insertQry = "INSERT INTO `employee_details`(`Employee_ID`, `Employee_Name`, `Employee_Designation`, `Employee_Salary`)"
				            + " VALUES (?,?,?,?)";
		pstmt = dbcon.prepareStatement(insertQry);
		System.out.println("Enter the employee ID");
		int id = scan.nextInt();
		System.out.println("Enter the employee name");
		String name = scan.next();
		System.out.println("Enter the employee designation");
		String designation = scan.next();
		scan.nextLine();
		System.out.println("Enter the employee salary");
		int salary=scan.nextInt();
		pstmt.setInt(1,id);
		pstmt.setString(2, name);
		pstmt.setString(3, designation);
		pstmt.setInt(4, salary);
		
		pstmt.execute();
	}
		catch(SQLException e)
		{
			System.out.println("Exception occurred when data is inserted : "+e.getMessage());
		}
	}
	
	void displayEmployeeDetails(Connection dbcon)
	{
		
		try{
			Statement stmt = dbcon.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM employee_details");
			while(rs.next())
			{
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String designation = rs.getString(3);
				int salary = rs.getInt(4);
				
			System.out.println("ID : " + id + " Name : "+ name + "Designation : " + designation + "Salary : " + salary);
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

//		finally {
//			try {
//			if( rs !=null)
//			{
//				rs.close();
//			}
//			
//		}
//			catch(SQLException e1) {
//				System.out.println("Exception occurred while displaying the result : " + e1.getMessage());
//			}
//		
//		
//	}
//		
//	}
//	
	void updateEmployeeDetails(Connection dbcon) 
	{
		try {
//		System.out.println("Enter the Employee ID to be updated");
//		int value1 = scan.nextInt();
//		System.out.println("Enter new employee name");
//		String value2 = scan.next();
//		scan.nextLine();
//		System.out.println("Enter new designation of employee");
//		String value3=scan.next();
//		scan.nextLine();
//		System.out.println("Enter the new salary of employee");
//		int value4 = scan.nextInt();
		String updateQry = "UPDATE `employee_details` SET `Employee_Name`='Rampraveen',`Employee_Designation`='Programmer',`Employee_Salary`='36500'"
				 + "WHERE Employee_ID = 1";
		pstmt = dbcon.prepareStatement(updateQry);
		
		pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("Exception occurred during update : " + e.getMessage());
		}
	}
	
	void fetchEmployeeDetails(Connection dbcon)
	{
		try {
		//System.out.println("Enter the Employee ID");
		//int id = scan.nextInt();
		String selectQry = "SELECT * FROM `employee_details` WHERE Employee_ID = 1";
		pstmt=dbcon.prepareStatement(selectQry);
		
		ResultSet rs = pstmt.executeQuery(selectQry);
		while(rs.next())
		{
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String designation = rs.getString(3);
			int salary = rs.getInt(4);
			
		System.out.println("ID : " + id + " Name : "+ name + "Designation : " + designation + "Salary : " + salary);	
		}
		}
		catch(SQLException e)
		{
			System.out.println("Exception occurred during fetching details : "+e.getMessage());
		}
	}
	
	void deleteEmployeeRecord(Connection dbcon)
	{
		try {
			String delQry="DELETE FROM `employee_details` WHERE Employee_ID = 4";
			Statement stmt = dbcon.createStatement();
		     stmt.executeUpdate(delQry);
			ResultSet rs = stmt.executeQuery("SELECT * FROM `employee_details`");
			while(rs.next())
			{
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String designation = rs.getString(3);
				int salary = rs.getInt(4);
				
			System.out.println("ID : " + id + " Name : "+ name + "Designation : " + designation + "Salary : " + salary);	
			}
			rs.close();
			}
			
			
		catch(SQLException e)
		{
			System.out.println("Exception occurred when deleting the record : "+ e.getMessage());
		}
	}
	
}
	
	
	
