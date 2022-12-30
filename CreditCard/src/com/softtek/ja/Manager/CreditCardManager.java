package com.softtek.ja.Manager;

import java.util.ArrayList;
import java.util.Scanner;

import com.softtek.ja.domainObjects.CreditCard;
import com.softtek.ja.domainObjects.Customer;
import com.softtek.ja.helper.CreditCardHelper;

public class CreditCardManager 
{
	private Customer customer;
	ArrayList<CreditCard> requesterList = new ArrayList<CreditCard>(2);
	ArrayList<CreditCard> approvedList = new ArrayList<CreditCard>(2);
	public CreditCardManager() 
	{

	}

	public void requestForCreditCard() {
		customer =new Customer("Reject1",21,true,25000);//request
		CreditCard ccReq1 = new CreditCard();
		ccReq1.setCustomer(customer);
		requesterList.add(ccReq1);

		customer =new Customer("Reject2",18,true,50000);//request
		CreditCard ccReq2 = new CreditCard();
		ccReq2.setCustomer(customer);
		requesterList.add(ccReq2);

		customer =new Customer("Approved salary",22,true,75000);//request
		CreditCard ccReq3 = new CreditCard();
		ccReq3.setCustomer(customer);
		requesterList.add(ccReq3);


		customer =new Customer("Reject3",18,false,20000);//request
		CreditCard ccReq4 = new CreditCard();
		ccReq4.setCustomer(customer);
		requesterList.add(ccReq4);

		customer =new Customer("Reject4",18,false,12000);//request
		CreditCard ccReq5 = new CreditCard();
		ccReq5.setCustomer(customer);
		requesterList.add(ccReq5);

		customer =new Customer("Approved Business",25,false,500000);//request
		CreditCard ccReq6 = new CreditCard();
		ccReq6.setCustomer(customer);
		requesterList.add(ccReq6);
//		System.out.println(requesterList.toString());

		System.out.println("Requester list Begin ===>");
		printData(requesterList);
		System.out.println("===> Requester List Ends");

		System.out.println("RequesterList count [Before Approval];"+requesterList.size());
	}

	public void approvedList()
	{
		System.out.println("Approval status begin");

		for(int i=0; i<requesterList.size(); i++)
		{
			CreditCard tempElement=new CreditCard();
			tempElement=requesterList.get(i);
			if(CreditCardHelper.isAgeEligibility(tempElement.getCustomer().getIntAge()))
			{
				if(tempElement.getCustomer().getDbIncome()>=50000 &&
						tempElement.getCustomer().getStrType().equals("salaried"))
				{
					tempElement.getCreditCardAttributes().setLngCCNumber(CreditCardHelper.assignCreditCardNumber());
					tempElement.getCreditCardAttributes().setDblCCccLimit(tempElement.getCustomer().getDbIncome()*10);
					tempElement.getCreditCardAttributes().setIntCvvNumber(CreditCardHelper.assignCvv());

					tempElement.getCreditCardAttributes().setStrStatus("Approved");
					tempElement.getCreditCardDate().setStrIssueDate("09/22");
					tempElement.getCreditCardDate().setStrExpiryDate("09/25");
					approvedList.add(tempElement);
					System.out.println("ApprovedList-Size(): "+approvedList.size());
					requesterList.remove(tempElement);
					System.out.println("RequestorList-Size(): "+requesterList.size());
				}
				if(tempElement.getCustomer().getDbIncome()>=100000 &&
						tempElement.getCustomer().getStrType().equals("Business"))
				{
					tempElement.getCreditCardAttributes().setLngCCNumber(CreditCardHelper.assignCreditCardNumber());
					tempElement.getCreditCardAttributes().setDblCCccLimit(tempElement.getCustomer().getDbIncome()*5);
					tempElement.getCreditCardAttributes().setIntCvvNumber(CreditCardHelper.assignCvv());

					tempElement.getCreditCardAttributes().setStrStatus("Approved");
					tempElement.getCreditCardDate().setStrIssueDate("09/22");
					tempElement.getCreditCardDate().setStrExpiryDate("09/25");
					approvedList.add(tempElement);
					System.out.println("ApprovedList-Size(): "+approvedList.size());
					requesterList.remove(tempElement);
					System.out.println("RequestorList-Size(): "+requesterList.size());
				}
			}
		}
		System.out.println("Approved Credit Card Member["+approvedList.size()+"] ::::");
		System.out.println();
		printData(approvedList);

		System.out.println("Rejected Credit Card Member[" + requesterList.size()+"]:::");
		System.out.println();
		printData(requesterList);

		System.out.println("Approval status End");
	}
	public void printData(ArrayList<CreditCard> arrayList)
	{
		for(int i=0; i<arrayList.size(); i++)
		{
			CreditCard tempElement=new CreditCard();
			tempElement=arrayList.get(i);
			System.out.println(tempElement.getCustomer().toString()+
					tempElement.getCreditCardAttributes().toString()+
					tempElement.getCreditCardDate().toString());
		}
	}

	Customer acceptCustomerData()
	{
		String strName;
		int intAge;
		boolean isSalaried;
		double dbSalary;
		String moreData="Y";
		Scanner scanner=new Scanner(System.in);
		do
		{
			System.out.println("Enter Name: ");
			strName=scanner.next();

			System.out.println("Enter Age: ");
			intAge=scanner.nextInt();

			System.out.println("Enter Salaried[true/false]: ");
			isSalaried=scanner.nextBoolean();

			System.out.println("Enter Income: ");
			dbSalary=scanner.nextDouble();

			System.out.println();

			System.out.println("More Requests[Y/N]: ");
			moreData=scanner.next();

			return(new Customer(strName, intAge, isSalaried, dbSalary));
		}
		while(moreData=="Y");
	}
}
