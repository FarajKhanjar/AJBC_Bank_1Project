package AccountOwner;

import BankManager.BankManager;
import Person.Person;
import java.time.LocalDate;

public class AccountOwner extends Person
{
	protected Account account = null;
	protected double monthlyIncome;
	private Credentials credentials;
	private BankManager bankManager;
	
	public AccountOwner(String firstName, String lastName, int areaCode, float number, LocalDate bitrthDate,
			Account account, double monthlyIncome, Credentials credentials) {
		super(firstName, lastName, areaCode, number, bitrthDate);
		this.account = account;
		this.monthlyIncome = monthlyIncome;
		this.credentials = credentials;
	}
	
	private void checkBalance()
	{
		
	}
	
	private void produceReport(LocalDate start)
	{
		
	}
	
	private void deposit()
	{
		
	}
	
	private void withdrawal()
	{
		
	}
	
	private void transferFunds()
	{
		
	}	
}
