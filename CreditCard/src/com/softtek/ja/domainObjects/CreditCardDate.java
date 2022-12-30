package com.softtek.ja.domainObjects;

public class CreditCardDate 
{
	private String strIssueDate;
	private String strExpiryDate;
	
	public CreditCardDate() 
	{
		this.strIssueDate="";
		this.strExpiryDate="";
	}

	public String getStrIssueDate() {
		return strIssueDate;
	}

	public void setStrIssueDate(String strIssueDate) {
		this.strIssueDate = strIssueDate;
	}

	public String getStrExpiryDate() {
		return strExpiryDate;
	}

	public void setStrExpiryDate(String strExpiryDate) {
		this.strExpiryDate = strExpiryDate;
	}
	
	public String toString()
	{
		return strIssueDate+" | "+strExpiryDate;
	}
}
