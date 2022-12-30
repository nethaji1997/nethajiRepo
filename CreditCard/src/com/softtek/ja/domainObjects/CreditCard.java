package com.softtek.ja.domainObjects;

public class CreditCard 
{
	private Customer customer;
	private CreditCardAttributes creditCardAttributes;
	private CreditCardDate creditCardDate;
	
	public CreditCard() 
	{
		this.customer=new Customer();
		this.creditCardAttributes=new CreditCardAttributes();
		this.creditCardDate=new CreditCardDate();
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public CreditCardAttributes getCreditCardAttributes() {
		return creditCardAttributes;
	}
	public void setCreditCardAttributes(CreditCardAttributes creditCardAttributes) {
		this.creditCardAttributes = creditCardAttributes;
	}
	public CreditCardDate getCreditCardDate() {
		return creditCardDate;
	}
	public void setCreditCardDate(CreditCardDate creditCardDate) {
		this.creditCardDate = creditCardDate;
	}
}
