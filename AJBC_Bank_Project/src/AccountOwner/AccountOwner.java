package AccountOwner;

import BankManager.BankManager;
import Person.Person;
import Person.PhoneNumber;

import java.time.LocalDate;
//import java.util.Random;

public class AccountOwner extends Person
{
	//fields
	private Account account = null;
	private double monthlyIncome;
	private Credentials credentials;
	private BankManager bankManager;
	
	//constructor
	public AccountOwner(String firstName, String lastName, PhoneNumber phoneNumber ,LocalDate bitrthDate,
			Account account, double monthlyIncome, Credentials credentials, BankManager bankManager) 
	{
		super(firstName, lastName, phoneNumber, bitrthDate);
		setAccount(account);
		setMonthlyIncome(monthlyIncome);
		setCredentials(credentials);
		setManager(bankManager);
	}


	public Account getAccount() 
	{
		return account;
	}
		
	private void setAccount(Account account) 
	{
		this.account = account;
	}

	public double getMonthlyIncome() 
	{
		return monthlyIncome;
	}

	private void setMonthlyIncome(double monthlyIncome) 
	{
		this.monthlyIncome = monthlyIncome;
	}

	public Credentials getCredentials() 
	{
		return credentials;
	}

	private void setCredentials(Credentials credentials) 
	{
		this.credentials = credentials;
	}
		
	public BankManager getManager() 
	{
		return bankManager;
	}

	private void setManager(BankManager bankManager) 
	{
		this.bankManager = bankManager;
	}
	
	public PhoneNumber getPhoneNumber() 
	{
		return super.getPhoneNumber();
	}
	
	/**
	 * Check account balance.
	 */
	public void checkBalance()
	{
		System.out.println("Balance: " + account.getBalance());
	}
	
	private void produceReport(LocalDate start)
	{
		
	}

	
	private void transferFunds()
	{
		
	}
			
}
