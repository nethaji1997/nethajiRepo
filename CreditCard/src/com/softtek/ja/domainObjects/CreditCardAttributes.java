package com.softtek.ja.domainObjects;

public class CreditCardAttributes  
{
	private long lngCCNumber;
	private double dblCCLimit;
	private int intCvvNumber;
	private String strStatus;
	
	public CreditCardAttributes() 
	{
		this.lngCCNumber=0;
		this.dblCCLimit=0;
		this.intCvvNumber=0;
		this.strStatus="";
	}

	public long getLngCCNumber() {
		return lngCCNumber;
	}

	public void setLngCCNumber(long lngCCNumber) {
		this.lngCCNumber = lngCCNumber;
	}

	public double getDblCCccLimit() {
		return dblCCLimit;
	}

	public void setDblCCccLimit(double dblCCccLimit) {
		this.dblCCLimit = dblCCccLimit;
	}

	public int getIntCvvNumber() {
		return intCvvNumber;
	}

	public void setIntCvvNumber(int intCvvNumber) {
		this.intCvvNumber = intCvvNumber;
	}

	public String getStrStatus() {
		return strStatus;
	}

	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
	}
	
	public String toString()
	{
		return lngCCNumber+" | "+dblCCLimit+" | "+intCvvNumber+" | "+strStatus +" | ";
	}
}
	