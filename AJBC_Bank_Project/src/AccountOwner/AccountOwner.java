package AccountOwner;

import Person.Person;
import Person.PhoneNumber;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

import AppManager.AppManager;

public class AccountOwner extends Person
{
	static  Scanner sc = new Scanner(System.in);
	//fields
	private Account account = null;
	private double monthlyIncome;
	private Credentials credentials;
	//private BankManager bankManager;
	private final int MAXIMUM_Payments_Number = 60; //In case the number of payments exceeds sixty...
	
	static  Scanner sc1 ;
	
	//constructor
	public AccountOwner(String firstName, String lastName, PhoneNumber phoneNumber ,LocalDate bitrthDate,
			Account account, double monthlyIncome, Credentials credentials) 
	{
		super(firstName, lastName, phoneNumber, bitrthDate);
		setAccount(account);
		setMonthlyIncome(monthlyIncome);
		setCredentials(credentials);
		//setManager(bankManager);
	}
	
	public AccountOwner(String firstName, String lastName, PhoneNumber phoneNumber, LocalDate birthDate,
			Credentials credentials, double monthlyIncome) 
	{
		super(firstName, lastName, phoneNumber, birthDate);
		setCredentials(credentials);
		setMonthlyIncome(monthlyIncome);
	}
	
	public int runActionsMenu() 
	{		
		  while(true) 
		  {
			actionsMenu();
		    int temp = Integer.parseInt(sc.next());
		    if(temp == 0)
		      break;
		    bankActionsCheck(temp);
		  }
		return 0;
		
	}
	
	public void actionsMenu() 
	{
		  System.out.println("Hi :),\n" 
	                         +"Here you can show our Menu activities,\n" 
				             + "Select what you are looking for:\n");
		  System.out.println("1. Check Bank Balance\n" + "2. Produce Activity Report\n"
		                      + "3. Make a deposit\n" + "4. Make a Withdrawal\n" + "5. Transfer funds\n" 
				              + "6. Pay bill\n" + "7. Get Loan\n" + "8.Exit");
		  
	}
	
	public void bankActionsCheck(int temp) 
	{
		  switch(temp)
		  {
		  case 0: 
			  System.out.println("Try again");
		  case 1:
			  checkBalance();
			  
			  break;
		  case 2: 			  
			  produceReport();
			  
		  case 3: 			  
			  deposit();
			
		  case 4: 			  
			  withdrawal();
				
		  case 5: 			  
			  transferFunds();
			  
		  case 6: 			  
			  payBill();
			 
		  case 7: 			  
			  loanRequest();
			  
		  case 8: 			  
			  logout();
						  
		  }
	}


	public Account getAccount() 
	{
		return account;
	}
		
	public void setAccount(Account account) 
	{
		this.account = account;
	}

	public double getMonthlyIncome() 
	{
		return monthlyIncome;
	}

	public void setMonthlyIncome(double monthlyIncome) 
	{
		this.monthlyIncome = monthlyIncome;
	}

	public Credentials getCredentials() 
	{
		return credentials;
	}

	public void setCredentials(Credentials credentials) 
	{
		this.credentials = credentials;
	}
		
  /*  public BankManager getManager() 
	{
		return bankManager;
	}
	

	private void setBankManager(BankManager bankManager) 
	{
		this.bankManager = bankManager;
	}
	*/
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
	
	
	/**
	 * User makes a payment to a payee.
	 */
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
	
	
	/**
	 * User makes a fast transfer to another user by providing a phone number and an amount.
	 */
	public void loanRequest() 
	{
		System.out.print("What is the amount of loan do you request?");
		int amountOfLoan = sc.nextInt();
		
		if(account.checkLoanAmount(amountOfLoan))
		{
			System.out.print("What is your monthly payments? ");
			int monthlyPaymentsNumber = sc.nextInt();
			if(MAXIMUM_Payments_Number >= monthlyPaymentsNumber) 
			{
				account.getLoanAmount(amountOfLoan, monthlyPaymentsNumber);
				System.out.printf("Yeah! you are able to receive loan amount: "+amountOfLoan);
			}
			else 
			{
				System.out.println("Sorry... your payments number larger then the maximum.");
			}
		}
		else 
		{
			System.out.println("Sorry... this amount is bigger then maximum loan.");
		}
	}
	
	private void produceReport()
	{
		sc1 = new Scanner(System.in);

		System.out.println("Enter start date:");
		System.out.print("day: ");
		int day = sc1.nextInt();
		System.out.print("month: ");
		int month = sc1.nextInt();
		System.out.print("year: ");
		int year = sc1.nextInt();

		LocalDateTime timeStamp=(LocalDateTime.of(year, month, day, 0, 0));
		ActivityData[] activities = account.getHistoryFromGivenDate(timeStamp);

		System.out.println("The Activities from: "+timeStamp);
		System.out.println();
		for (ActivityData nameOfActivity : activities) 
		{
			System.out.println(nameOfActivity);
		}
		checkBalance();
	}
	
	private void logout() 
	{
		account=null;
		System.out.println("Good Buy");
	}
}
