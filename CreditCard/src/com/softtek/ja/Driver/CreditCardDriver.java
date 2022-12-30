package com.softtek.ja.Driver;

import com.softtek.ja.Manager.CreditCardManager;
import com.softtek.ja.domainObjects.CreditCardAttributes;
import com.softtek.ja.helper.CreditCardHelper;

public class CreditCardDriver 
{
	public static void main(String[] args) 
	{
		System.out.println("Execution Started");
		CreditCardManager creditCardManager=new CreditCardManager();
		creditCardManager.requestForCreditCard();
		creditCardManager.approvedList();
		System.out.println("Execution end");
		
	}
}
