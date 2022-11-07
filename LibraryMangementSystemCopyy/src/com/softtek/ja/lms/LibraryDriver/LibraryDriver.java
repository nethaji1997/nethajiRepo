package com.softtek.ja.lms.LibraryDriver;

public class LibraryDriver {
	public static void main(String[] args) throws Exception 
	{
		Validator v1=new Validator();
		v1.switcLogin();
		LibraryOperations lp=new LibraryOperations();		
		do
		{
			lp.execute();
		}
		while(true);

	}

}

