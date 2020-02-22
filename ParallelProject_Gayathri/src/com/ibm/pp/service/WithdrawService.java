package com.ibm.pp.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.pp.dao.AccountFacilities2;


@WebServlet("/withdrawservice")
public class WithdrawService extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AccountFacilities2 wid = new AccountFacilities2();
		wid.doPost(request,response);
	}

}
