package com.ibm.servelettraining1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Logic")
public class Logic extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get the input from the form:
		response.setContentType("text/html");
		
		String firstname = request.getParameter("fname");
		String lastname = request.getParameter("lname");
		String age = request.getParameter("age");
		System.out.println("Name of the student : " + firstname + lastname);
		String gender = request.getParameter("Gender");
		
		if(gender.equals("male"))
		{
			System.out.println("Gender :"+gender);
		}
		
		if(gender.equals("female"))
			{
			System.out.println("Gender : " +gender);
			}
		
		String dept= request.getParameter("Department");

        System.out.println("Department : " + dept);
            
        PrintWriter out = response.getWriter(); 
        out.println("Name of the student : " + firstname + " " + lastname);
		out.println("Gender : " +gender);
		out.println("Age : " +age);
        out.println("Department : " + dept);
		
		String subject[] = request.getParameterValues("subjects");
		out.println("The subjects studied are : ");
		for(String value : subject)
		{
		out.println( value);
		}
		
}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
