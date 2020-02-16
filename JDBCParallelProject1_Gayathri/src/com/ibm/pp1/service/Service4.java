package com.ibm.pp1.service;


import com.ibm.pp1.bean.CreateAccountDetails;
import com.ibm.pp1.bean.TransactionDetails;
import com.ibm.pp1.dao.Dao3;

public class Service4 {
	Dao3 dao = new Dao3();
	
	public void createAccount(CreateAccountDetails q1)
	{
		dao.createAccount(q1);
	}
	
	public void deposit(int amount , int accId)
	{
		dao.deposit(amount, accId);
	}
	
	public void withdraw(int amount , int accId)
	{
		dao.withdraw(amount,accId);
	}
	
	public void fetchAccountDetails(CreateAccountDetails q2)
	{
		dao.fetchAccountDetails(q2);
	}
	
	public void checkBalance(CreateAccountDetails q3)
	{
		dao.checkBalance(q3);
	}
	
	public void fundTransfer(int acc1 , int acc2 , int amount)
	{
		dao.fundTransfer(acc1, acc2, amount);
	}
	
	public void printTransactionDetails(TransactionDetails tr , int accID)
	{
		dao.printTransactionDetails(tr,accID);
	}


		
	}
	


