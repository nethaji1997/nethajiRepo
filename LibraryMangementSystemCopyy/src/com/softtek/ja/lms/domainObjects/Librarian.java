package com.softtek.ja.lms.domainObjects;

public class Librarian
{
	protected  int intLibrarianId;
	protected String strLibrarianName;
	protected String strLibrarianEmail;
	protected String librarianUserName1="vinith";
	protected String librarianUserName2="supriya";
	protected String librarianPassword1="abc1234";
	protected String librarianPassword2="xyz1234";
	public String getStrLibrarianEmail() {
		return strLibrarianEmail;
	}

	public String getLibrarianUserName1() {
		return librarianUserName1;
	}

	public String getLibrarianUserName2() {
		return librarianUserName2;
	}

	public String getLibrarianPassword1() {
		return librarianPassword1;
	}

	public String getLibrarianPassword2() {
		return librarianPassword2;
	}

	public String getStrLibrarianName() {
		return strLibrarianName;
	}

	public void setStrLibrarianName(String strLibrarianName) {
		this.strLibrarianName = strLibrarianName;
	}

	public Librarian(int intLibrarianId,  String strLibrarianName, String strLibrarianEmail) 
	{
		this.intLibrarianId=intLibrarianId;
		this.strLibrarianEmail=strLibrarianEmail;
		this.strLibrarianName=strLibrarianName;
	}

	public Librarian() 
	{

	}

	public int getIntLibrarianId() {
		return intLibrarianId;
	}

	public void setIntLibrarianId(int intLibrarianId) {
		this.intLibrarianId = intLibrarianId;
	}

	public String getStrLibrarianPassword() {
		return strLibrarianEmail;
	}

	public void setStrLibrarianPassword(String strLibrarianPassword) {
		this.strLibrarianEmail = strLibrarianEmail;
	}

	public String toString()
	{
		return intLibrarianId+":"+strLibrarianName+":"+strLibrarianEmail;
	}
}

