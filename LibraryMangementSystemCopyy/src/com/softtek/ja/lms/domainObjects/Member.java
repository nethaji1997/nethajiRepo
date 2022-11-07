 package com.softtek.ja.lms.domainObjects;

public class Member 
{
	protected int intMemberId;
	protected  String strMemberName;
	protected long memberMobileNo;
	protected String strMemberEmail;
	
	public String getStrMemberEmail() {
		return strMemberEmail;
	}
	public void setStrMemberEmail(String strMemberEmail) {
		this.strMemberEmail = strMemberEmail;
	}
	public Member() 
	{
		// TODO Auto-generated constructor stub
	}
	public Member(int intMemberId, String strMemberName, long MemberMobileNo) 
	{
		this.intMemberId=intMemberId;
		this.strMemberName=strMemberName;
		this.memberMobileNo=memberMobileNo;
	}

	public int getIntMemberId() {
		return intMemberId;
	}

	public void setIntMemberId(int intMemberId) {
		this.intMemberId = intMemberId;
	}

	public String getStrMemberName() {
		return strMemberName;
	}

	public void setStrMemberName(String strMemberName) {
		this.strMemberName = strMemberName;
	}

	public long getMemberMobileNo() {
		return memberMobileNo;
	}

	public void setMemberMobileNo(long memberMobileNo) {
		memberMobileNo = memberMobileNo;
	}

	public String toString()
	{
		return intMemberId+":"+strMemberName+":"+memberMobileNo;
	}
}
