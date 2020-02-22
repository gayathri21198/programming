package com.ibm.pp.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ibm.pp.dao.*;

@WebServlet("/transferservice")
public class FundTransferService extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FundTransfer fun = new FundTransfer();
		fun.doPost(request,response);
		
	}

}
