package com.softtek.ja.lms.domainObjects;

import java.util.Date;

public class Fine 
{
	private double dblFineAmount;
	public Fine() 
	{
		
	}
	public Fine(double dblFineAmount) 
	{
		this.dblFineAmount=dblFineAmount;
	}

	public double getDblFineAmount() {
		return dblFineAmount;
	}

	public void setDblFineAmount(double dblFineAmount) {
		this.dblFineAmount = dblFineAmount;
	}

}
