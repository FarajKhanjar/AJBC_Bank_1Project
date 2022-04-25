package AccountOwner;

import BankManager.BankManager;
import Person.Person;
import Person.PhoneNumber;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class AccountOwner extends Person
{
	//fields
	private Account account = null;
	private double monthlyIncome;
	private Credentials credentials;
	private BankManager bankManager;
	static  Scanner sc = new Scanner(System.in);
	
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
	
	
	/**
	 * User makes a deposit directly to an ATM box using the app authentication code.
	 */
	public void deposit()
	{
		int authenticationCode = createATMcode();
		//System.out.println("Your code is: " + authenticationCode);
		System.out.print("Enter your authentication code to deposit cash: ");
		int enterCode = sc.nextInt();

		if (enterCode == authenticationCode) 
		{
			System.out.print("What is the amount of cash you want to deposit?");
			int cashAmount = sc.nextInt();
			account.deposit(cashAmount);
			System.out.printf("Successful deposit of: "+cashAmount);
		} 
		else 
		{
			System.out.println("Your code incorrect.");
		}
	}

	/**
	 * In this method we interesting in get a random ATM code.
	 * @return
	 */
	private int createATMcode() 
	{
		Random randNumCode = new Random();
		int finalATMcode = 0;

		for (int i = 0; i < 4; i++) {
			finalATMcode *= 10;
			finalATMcode += 1 + randNumCode.nextInt(9);
		}
		return finalATMcode;
	}
	
	
	
	
	private void produceReport(LocalDate start)
	{
		
	}

	
	private void transferFunds()
	{
		
	}
			
}
