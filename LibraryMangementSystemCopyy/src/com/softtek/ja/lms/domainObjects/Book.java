package com.softtek.ja.lms.domainObjects;

public class Book 
{
	protected int intISBN;
	protected String strTitle;
	protected String strSubject;
	protected String strLanguage;
	protected int intBookPrice;
	public String getStrAuthorName() {
		return strAuthorName;
	}
	public void setStrAuthorName(String strAuthorName) {
		this.strAuthorName = strAuthorName;
	}

	protected String strAuthorName;

	public int getIntISBN() {
		return intISBN;
	}
	public void setIntISBN(int intISBN) {
		this.intISBN = intISBN;
	}

	public String getStrRacklocationIdentifier() {
		return strRacklocationIdentifier;
	}
	public void setStrRacklocationIdentifier(String strRacklocationIdentifier) {
		this.strRacklocationIdentifier = strRacklocationIdentifier;
	}

	private String strRacklocationIdentifier; 

	public Book() 
	{

	}
	public Book(int intISBN, String strTitle, String strSubject,String strLanguage, int intBookPrice ) 
	{
		this.intISBN=intISBN;
		this.strTitle=strTitle;
		this.strSubject=strSubject;
		this.strLanguage=strLanguage;
		this.intBookPrice=intBookPrice;
	}
	public int getStrISBN() {
		return intISBN;
	}

	public void setintISBN(int intISBN) {
		this.intISBN = intISBN;
	}

	public String getStrTitle() {
		return strTitle;
	}

	public void setStrTitle(String strTitle) {
		this.strTitle = strTitle;
	}

	public String getStrSubject() {
		return strSubject;
	}

	public void setStrSubject(String strSubject) {
		this.strSubject = strSubject;
	}

	public String getStrLanguage() {
		return strLanguage;
	}

	public void setStrLanguage(String strLanguage) {
		this.strLanguage = strLanguage;
	}



	public String toString()
	{
		return intISBN+" : "+strTitle+" : "+strSubject+" : "+strLanguage+":"+intBookPrice+":"+strAuthorName;
	}
	public int getIntBookPrice() {
		return intBookPrice;
	}
	public void setIntBookPrice(int intBookPrice) {
		this.intBookPrice = intBookPrice;
	}
	
	 

}