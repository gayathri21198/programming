package com.ibm.pp1.ui;
import java.util.*;

import com.ibm.pp1.bean.CreateAccountDetails;
import com.ibm.pp1.bean.TransactionDetails;
import com.ibm.pp1.service.*;

public class WalletSystem {

	public static void main(String[] args) {
		System.out.println("Enter the choice 1.Create Account 2.FetchDetails 3.Deposit 4.Withdraw 5.Check Balance 6.Fund Transfer 7.Print Transaction ");
		Scanner s = new Scanner(System.in);
		int choice = s.nextInt();
		Service4 service = new Service4();
		CreateAccountDetails det = new CreateAccountDetails();
		TransactionDetails det1 = new TransactionDetails();
		
		switch(choice)
		{
		case 1:
			service.createAccount(det);
			
			
		case 2:
			service.fetchAccountDetails(det);
			break;
			
		case 3:
			System.out.println("Enter the amount to be deposited : ");
			int amount1 = s.nextInt();
			System.out.println("Enter the account ID where the amount to be deposited : ");
			int accId1 = s.nextInt();
			service.deposit(amount1, accId1);
			break;
			
		case 4:
			System.out.println("Enter the amount to be withdrawn : ");
			int amount2 = s.nextInt();
			System.out.println("Enter the account ID from where the amount is withdrawn : ");
			int accId2 = s.nextInt();
			service.withdraw(amount2, accId2);
			break;
			
		case 5:
			service.checkBalance(det);
			break;
			
		case 6:
			System.out.println("Enter the account number where the amount is debited: ");
			int accID1=s.nextInt();
			System.out.println("Enter the account number where the amount is credited : ");
			int accID2=s.nextInt();
			System.out.println("Enter the amount to be transferred");
			int amount3 = s.nextInt();
			service.fundTransfer(accID1, accID2, amount3);
			break;
			
		case 7:
			System.out.println("enter the account number to view the transaction details : ");
			int accID3=s.nextInt();
			service.printTransactionDetails(det1,accID3);
			break;
			
			default :
				System.out.println("No account no transaction details");
			
			
			
		}
		
		
		


	}

}
