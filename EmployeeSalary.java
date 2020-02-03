// package com.cg.eis.exception;
import java.util.*;


class EmployeeSalary{
	public static void main(String[] args) {
	  Scanner s=new Scanner(System.in);
	  System.out.println("Enter the salary of the employee");
	  int n=s.nextInt();
	  try{
	  	if(n>=3000)
	  	{
	  		throw new EmployeeException("Valid Salary");
	  	}
	  	else
	  	{
	  		throw new EmployeeException("Invalid Salary");
	  	}
	  }
	  catch(EmployeeException ref)
	  {
	  	System.out.println(ref);
	  }	
	}
}

class EmployeeException extends Exception{
public EmployeeException(String str)
{
	System.out.println(str);
}
}
