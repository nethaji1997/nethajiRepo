package com.softtek.ja.helper;

public class CreditCardHelper 
{
	public static boolean isAgeEligibility(int intAge)
	{
		return(intAge>=21?true:false);
	}

	public static String assignType(boolean isSalaried)
	{
		return(isSalaried?"salaried":"Business");
	}

	public static int assignCvv()
	{
		return ((int)(Math.random()*1000));
	}

	public static long assignCreditCardNumber()
	{
		return((long)(Math.random()*10000000000000000L));
	}
}
