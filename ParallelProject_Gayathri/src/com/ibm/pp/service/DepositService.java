package com.ibm.pp.service;

import com.ibm.pp.dao.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/depositservice")
public class DepositService extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		AccountFacilities1 dep = new AccountFacilities1();
		dep.doPost(request,response);
				
	}

}
