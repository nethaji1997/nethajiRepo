package com.softtek.ja.lms.domainObjects;

public class Rack extends Book
{
	private int intRackNumber;
	private String strRacklocationIdentifier;

	public Rack() 
	{

	}
	public Rack(int intRackNumber, String strRacklocationIdentifier) 
	{
		this.intRackNumber=intRackNumber;
		this.strRacklocationIdentifier=strRacklocationIdentifier;
	}

	public int getIntRackNumber() {
		return intRackNumber;
	}

	public void setIntRackNumber(int intRackNumber) {
		this.intRackNumber = intRackNumber;
	}

	public String getStrRacklocationIdentifier() {
		return strRacklocationIdentifier;
	}

	public void setStrRacklocationIdentifier(String strRacklocationIdentifier) {
		this.strRacklocationIdentifier = strRacklocationIdentifier;
	}

	public String toString()
	{
		return intRackNumber+" : "+strRacklocationIdentifier;
	}


}
