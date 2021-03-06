package AccountOwner;

import Person.Person;
import Person.PhoneNumber;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

import AppManager.AppManager;
import AppManager.LoginAccount;
import Runner.Static_Scan;

/**
 * The AccountOwner class get the basic info from "Person" class,
 * In this class we will do the most method cases of the bank application.
 * @author Faraj
 *
 */
public class AccountOwner extends Person
{

	//Fields
	private Account account = null;
	private double monthlyIncome;
	private Credentials credentials;
	private final int MAXIMUM_Payments_Number = 60; //In case the number of payments exceeds sixty...
	private LocalDateTime lock = null;
	
	//Constructor	
	public AccountOwner(String firstName, String lastName, PhoneNumber phoneNumber, LocalDate birthDate,
			Credentials credentials, double monthlyIncome) 
	{
		super(firstName, lastName, phoneNumber, birthDate);
		setCredentials(credentials);
		setMonthlyIncome(monthlyIncome);
	}
	
	/**
	 * Get an Set method help us to get values of the fields or set a new values.
	 *
	 */
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
		
	public PhoneNumber getPhoneNumber() 
	{
		return super.getPhoneNumber();
	}
	
	/**
	 * In this two methods, the user input a wrong password a three time,
	 * Because of that, the system will lock the user for 30 min,
	 * in this method we will check if the user is locked or not, 
	 * if the user locked then will check the time used "LocalDateTime".
	 * @return
	 */
	public boolean cheackIfAccountLocks() 
	{
		if(this.lock == null)
			return false;
		if(this.lock.getMinute()+30 > LocalDateTime.now().getMinute())
			return true;
		return false;
	}
	
	public void makeAccountLock() 
	{
		this.lock = LocalDateTime.now();
	}
	
	public void sendToManagerApproval()
	{
		AppManager.bankManager.setUsersToApprove(this);
	}
	
	
	/**
	 * Check account balance.
	 */
	public void checkBalance()
	{
		System.out.println("The Balance of the account is: " + account.getBalance());
	}
	
	
	/**
	 * User makes a deposit directly to an ATM box using the app authentication code.
	 */
	public void deposit()
	{
		int authenticationCode = createATMcode();
		System.out.println("Now we will send you a code, make sure that you see it alone,");
		System.out.println("Press '1' to see the code");
		Integer.parseInt(Static_Scan.scanner.next());
		System.out.println("Your code is: " + authenticationCode);
		System.out.print("Enter your authentication code to deposit cash: ");
		int enterCode = Static_Scan.scanner.nextInt();

		if (enterCode == authenticationCode) 
		{
			System.out.print("What is the amount of cash you want to deposit?");
			int cashAmount = Static_Scan.scanner.nextInt();
			account.deposit(cashAmount);
			System.out.printf("Successful deposit of: "+cashAmount);
		} 
		else 
		{
			System.out.println("Something Wrong, this code is incorrect");
		}
	}

	/**
	 * In this method we interesting in get a random ATM code.
	 * @return
	 */
	private int createATMcode() 
	{
		int finalATMcode = 0;
		Random randNumCode = new Random();		
		for (int i = 0; i < 4; i++) 
		{
			finalATMcode *= 10;
			finalATMcode += 1 + randNumCode.nextInt(9);
		}
		return finalATMcode;
	}
	
	
	/**
	 * User makes a withdrawal request through the app and get the funds when authenticated in an ATM.
	 */
	public void withdrawal()
	{
		System.out.print("What is the amount of cash you want to withdrawal? ");
		int cashAmount = Static_Scan.scanner.nextInt();
		
		if(account.checkWithdrawalSelect(cashAmount)) 
		{
			System.out.printf("Successful withdrawal of: "+cashAmount);
		}
	}
		
	
    /**
     * User makes a fast transfer to another user by providing a phone number and an amount.
     */
	public void transferFunds()
	{
		System.out.print("For transfer amount of many, Enter receiving username: ");
		String username = Static_Scan.scanner.next();
		AccountOwner receiverAccount = LoginAccount.getUserByUsername(username);

		if (receiverAccount == null) 
		{
			System.out.println("Sorry, we didnt found this Account in our system");
		} 
		else {
			System.out.print("For transfer amount of many,Enter amount of cash: ");
			int cashAmount = Static_Scan.scanner.nextInt();
			if (account.transferToAnotherAccount(cashAmount))
			{
				receiverAccount.account.accountTransferredForMe(cashAmount);
				System.out.printf("Successful transfer of: "+cashAmount);
			}
		}
	}
	
	

	public void payBill() 
	{
		System.out.println("Which bill do you want to pay: ");
		for(Payee payeeType : Payee.values()) 
		{
			System.out.println(Payee.getIndexOfPayee(payeeType) +") " + payeeType);
		}
		
		int payee = Static_Scan.scanner.nextInt();
		System.out.print("Enter the bill amount please: ");
		int cashAmount = Static_Scan.scanner.nextInt();
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
		int amountOfLoan = Static_Scan.scanner.nextInt();
		
		if(account.checkLoanAmount(amountOfLoan))
		{
			System.out.print("What is your monthly payments? ");
			int monthlyPaymentsNumber = Static_Scan.scanner.nextInt();
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
	
	/**
	 * The user is displayed with a full report of the account activity within a range of dates.
	 */
	public void produceReport() 
	{
		System.out.println("Enter start date:");
		System.out.print("day: ");
		int day = Static_Scan.scanner.nextInt();
		System.out.print("month: ");
		int month = Static_Scan.scanner.nextInt();
		System.out.print("year: ");
		int year = Static_Scan.scanner.nextInt();

		System.out.println();
		System.out.println("Activity Report:");
		getActivityReportData(LocalDateTime.of(year, month, day, 0, 0));
	}

	// Regular user report that shows the activities that were made from that date, and also current balance and summary loan if exists.
	private void getActivityReportData(LocalDateTime timestamp) 
	{
		System.out.println(timestamp);
		ActivityData[] activities = account.getHistoryFromGivenDate(timestamp);
		
		for (ActivityData data : activities) 
		{
			System.out.println(data);
		}

		System.out.println();
		checkBalance();

		if(account.getLoan() != null) 
		{
			System.out.println();
			account.getLoan().printSummary();
		}
	}
	
	
	public void logout() 
	{
		account=null;
		System.out.println("See you soon :)");
	}
}
