package com.ibm.pp.bean;

public class AccountDetails {

		private int accId,phoneNumber;
		private String name;
		private String accType;
		private int balance;
		
		public void setAccId(int accId)
		{
			this.accId = accId;
		}
		
		public void setName(String name)
		{
			this.name=name;
		}
		
		public void setPhoneNumber(int phoneNumber)
		{
			this.phoneNumber = phoneNumber;
		}
		
		public void setAccType(String accType)
		{
			this.accType = accType;
		}
		
		public void setBalance(int balance)
		{
			this.balance = balance;
		}
		
		public int getAccId()
		{
			return accId;
		}
		
		public int getPhoneNumber()
		{
			return phoneNumber;
		}
		
		public String getName()
		{
			return name;
		}
		
		public String getAccType()
		{
			return accType;
		}
		
		public int getBalance()
		{
			return balance;
		}
		
		@Override
		
		public String toString()
		{
			return "Customer Account Details [ Account ID : " + accId + " Phone Number : " + phoneNumber + " Name : "
					+ name + " Account Type : " + accType + " Balance : " + balance + " ]";
		}
		
		
		
		
		

	}


