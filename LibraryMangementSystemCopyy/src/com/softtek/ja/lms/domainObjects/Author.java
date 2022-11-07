package com.softtek.ja.lms.domainObjects;

public class Author 
{
	protected int intAuthorId;
	protected String strAuthorName;
	protected long lngAuthorMblno;
	protected String strAuthorEmail;

	public Author() 
	{
		
	}
	public int getIntAuthorId() {
		return intAuthorId;
	}

	public void setIntAuthorId(int intAuthorId) {
		this.intAuthorId = intAuthorId;
	}

	public Author(String strAuthorName, long lngAuthorMblno, String strAuthorEmail ) 
	{
	this.strAuthorName=strAuthorName;
	this.lngAuthorMblno=lngAuthorMblno;
	this.strAuthorEmail=strAuthorEmail;
	}

	public String getStrAuthorName() {
		return strAuthorName;
	}

	public void setStrAuthorName(String strAuthorName) {
		this.strAuthorName = strAuthorName;
	}

	public long getLngAuthorMblno() {
		return lngAuthorMblno;
	}

	public void setLngAuthorMblno(long lngAuthorMblno) {
		this.lngAuthorMblno = lngAuthorMblno;
	}

	public String getStrAuthorEmail() {
		return strAuthorEmail;
	}

	public void setStrAuthorEmail(String strAuthorEmail) {
		this.strAuthorEmail = strAuthorEmail;
	}
	
	public String toString()
	{
		return strAuthorName + ":"+lngAuthorMblno+ ":" +strAuthorEmail+":"+intAuthorId;
	}
}
