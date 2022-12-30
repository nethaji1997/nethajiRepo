package com.softtek.ja.domainObjects;

import com.softtek.ja.helper.CreditCardHelper;

public class Customer 
{
	private String strName;
	protected int intAge;
	private boolean isSalaried;
	private double dbIncome;
	private String strType;
	public Customer() 
	{
		this.strName="";
		this.intAge=0;
		this.isSalaried=false;
		this.dbIncome=0.0;
		this.strType="";
	}

	public Customer(String strName, int intAge, boolean isSalaried, double dbIncome) 
	{
		this.strName=strName;
		this.intAge=intAge;
		this.isSalaried=isSalaried;
		this.dbIncome=dbIncome;
		this.strType=CreditCardHelper.assignType(isSalaried);
	}


	public String getStrName() {
		return strName;
	}


	public void setStrName(String strName) {
		this.strName = strName;
	}


	public int getIntAge() {
		return intAge;
	}


	public void setIntAge(int intAge) {
		this.intAge = intAge;
	}


	public boolean isSalaried() {
		return isSalaried;
	}


	public void setSalaried(boolean isSalaried) {
		this.isSalaried = isSalaried;
	}


	public double getDbIncome() {
		return dbIncome;
	}


	public void setDbIncome(double dbIncome) {
		this.dbIncome = dbIncome;
	}


	public String getStrType() {
		return strType;
	}


	public void setStrType(String strType) {
		this.strType = strType;
	}

	public String toString()
	{
		return strName+" | "+intAge+" | "+isSalaried+" | " +dbIncome+" | "+strType +" | ";
	}

}