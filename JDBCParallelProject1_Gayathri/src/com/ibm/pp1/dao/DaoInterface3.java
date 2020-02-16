package com.ibm.pp1.dao;


import com.ibm.pp1.bean.CreateAccountDetails;
import com.ibm.pp1.bean.TransactionDetails;

public interface DaoInterface3 {
	void createAccount(CreateAccountDetails det);
	void deposit(int amount , int accId);
	void withdraw(int amount , int accId);
	void fetchAccountDetails(CreateAccountDetails customer);
	void checkBalance (CreateAccountDetails acc);
	void fundTransfer(int fromaccId , int toaccId , int amount);
	void printTransactionDetails(TransactionDetails tr , int accID);

}
