package com.softtek.ja.lms.domainObjects;

public class LibraryVenue 
{
	private String strLibraryName;
	private String strLibraryAddress;
	
	public LibraryVenue(String strLibraryName, String strLibraryAddress) 
	{
		this.strLibraryName=strLibraryName;
		this.strLibraryAddress=strLibraryAddress;
	}

	public String getStrLibraryName() {
		return strLibraryName;
	}

	public void setStrLibraryName(String strLibraryName) {
		this.strLibraryName = strLibraryName;
	}

	public String getStrLibraryAddress() {
		return strLibraryAddress;
	}

	public void setStrLibraryAddress(String strLibraryAddress) {
		this.strLibraryAddress = strLibraryAddress;
	}
	
	public String toString()
	{
		return strLibraryName+":"+strLibraryAddress;
	}
}
