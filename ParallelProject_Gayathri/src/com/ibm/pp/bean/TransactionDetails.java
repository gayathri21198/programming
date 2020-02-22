package com.ibm.pp.bean;

public class TransactionDetails {
	
	private int transactionId , fromAccountId , toAccountId;
	private String time;
	
	public void setTransactionId(int transactionId)
	{
		this.transactionId = transactionId;
	}
	
	public void setFromAccountId(int fromAccountId)
	{
		this.fromAccountId = fromAccountId;
	}
	
	public void setToAccountId(int toAccountId)
	{
		this.toAccountId = toAccountId;
	}
	
	public void setTime(String time)
	{
		this.time = time;
	}
	
	public int getTransactionId()
	{
		return transactionId;
	}
	
	public int getFromAccountId()
	{
		return fromAccountId;
	} 
	
	public int getToAccountId()
	{
		return toAccountId;
	}
	
	public String getTime()
	{
		return time;
	}
	
	@ Override
	public String toString()
	{
		return "Transaction Details : [ Transaction ID : " + transactionId + " Transaction Iime : " + time + " From Account : "
				+ fromAccountId + " To Account : " + toAccountId +  " ] ";
	}
	


}
