package com.ibm.pp.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ibm.pp.dao.*;

@WebServlet("/checkservice")
public class CheckBalanceService extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		AccountFacilities4 bal = new AccountFacilities4();
		bal.doPost(request,response);
	}

}
