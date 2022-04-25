package AccountOwner;

import BankManager.BankManager;
import Person.Person;
import Person.PhoneNumber;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

import AppManager.AppManager;

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
	
	
	/**
	 * User makes a withdrawal request through the app and get the funds when authenticated in an ATM.
	 */
	private void withdrawal()
	{
		System.out.print("What is the amount of cash you want to withdrawal? ");
		int cashAmount = sc.nextInt();
		
		if(account.withdrawalCash(cashAmount)) 
		{
			System.out.printf("Successful withdrawal of: "+cashAmount);
		}		
	}
		
	
    /**
     * User makes a fast transfer to another user by providing a phone number and an amount.
     */
	private void transferFunds()
	{
		System.out.print("For transfer amount of many, Enter receiving user phone number: ");
		String receiveNumber = sc.next();
		PhoneNumber phoneNumber = PhoneNumber.getFullPhoneNumber(receiveNumber);
		AccountOwner receiverAccount = AppManager.getOwnerByPhoneNum(phoneNumber);

		if (receiverAccount == null) 
		{
			System.out.println("Sorry, we didnt found this Account in our system");
		} 
		else {
			System.out.print("For transfer amount of many,Enter amount of cash: ");
			int cashAmount = sc.nextInt();
			if (account.transferToAnotherAccount(cashAmount)) 
			{
				receiverAccount.account.accountTransferredForMe(cashAmount);
				System.out.printf("Successful transfer of: "+cashAmount);
			}
		}
	}
	
	
	public void payBill() 
	{
		System.out.println("Choose which bill you want to pay: ");
		for(Payee payeeType : Payee.values()) 
		{
			//print the types of bills
			System.out.println(Payee.getIndexOfPayee(payeeType) +" . " + payeeType);
		}
		
		int payee = sc.nextInt();
		System.out.print("Who mush the bill is ? ");
		int cashAmount = sc.nextInt();
		if(account.payBill(cashAmount, Payee.getPayeeType(payee).toString())) 
		{
			System.out.printf("Successful to pay the bill of: "+cashAmount);
		}
	}
	
	private void produceReport(LocalDate start)
	{
		
	}
			
}
