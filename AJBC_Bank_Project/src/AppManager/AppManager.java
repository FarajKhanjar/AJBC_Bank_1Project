package AppManager;

import java.time.LocalDate;
import java.time.Period;
import java.util.Random;
import java.util.Scanner;

import AccountOwner.Account;
import AccountOwner.AccountOwner;
import AccountOwner.Credentials;
import BankManager.BankManager;
import Person.PhoneNumber;
import Runner.Menu;

public class AppManager 
{	
	static  Scanner scan = new Scanner(System.in);
	
	private AccountOwner currentUser;
	private static AccountOwner[] users = new AccountOwner[100];
	private static int index=0;

	private BankManager bankManager;
	private PhoneNumber phoneNumber;
	private Menu menu = new Menu();
	
	//Constructor
	public AppManager(AccountOwner currentUser, AccountOwner[] users) 
	{
		setCurrentUser(currentUser);
		setUsers(users);
	}
	
	public AppManager(BankManager bankManager) 
	{
		setBankManager(bankManager);
	}
	
	public AppManager() 
	{
		setBankManager(bankManager);
	}
	
	public int runner() 
	{		
		Scanner sc = new Scanner(System.in);
		  while(true) 
		  {
		    showMenu();
		    int opt = Integer.parseInt(sc.next());
		    if(opt == 0)
		      break;
		    callAppManager(opt);
		  }
		return 0;
		
	}

	public void showMenu() 
	{
		  System.out.println("Please select a action you want to perform:");
		  System.out.println("1. Open Account\n" + "2. Login Use\n" + "3. Check Balance\n" + "4. Produce Activity Report\n"
		+ "5. Make a deposit\n" + "6. Withdrawal\n" + "7. Transfer funds\n" + "8. Pay bill\n" + "9. Get Loan");
	}
	
	public void callAppManager(int opt) 
	{
		  switch(opt)
		  {
		  case 0: 
			  System.out.println("by by");
		  case 1:
			  OpenAccount();
			  System.out.println(bankManager);
			  break;
		  case 2: 
			  login();
			  System.out.println(bankManager);
			  
		  }
	}
	
	
	
	
	
	
		
	public AccountOwner getCurrUser() 
	{
		return currentUser;
	}


	public void setCurrentUser(AccountOwner currentUser) 
	{
		this.currentUser = currentUser;
	}

	public AccountOwner[] getUsers() 
	{
		return users;
	}

	public void setUsers(AccountOwner[] users) 
	{
		for (int i = 0; i < users.length; i++) 
		{
			this.users[i] = users[i];
		}
	}

	public static LocalDate createDate() 
	{

		//LocalDate date = LocalDate.of(scan.nextInt(), scan.nextInt(), scan.nextInt());
		// DateTimeFormat ("dd, MMM, yyyy");
		//return date;
		
		return LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 70))));
	}
	
	
	private void setBankManager(BankManager manager) 
	{
		this.bankManager = manager;
	}
		
		
		
	/**
	 * A method for login to the banking system using username and password.
	 * @param userName
	 * @param password
	 */
	public void login()
	{
		int index=0;
		int counter=0; //The number of times the user tried to login to his account.
		boolean checkUserName=false;
		boolean checkPassword;
	
		do {
			 System.out.println("Enter your Username please: {only letters and digits}");
			 String userName = scan.nextLine();
			 for (index=0 ; index<users.length; index++) 
			 {
				checkUserName=users[index].getCredentials().getUserName().equals(userName);
				if(checkUserName)
					break;
			 }
			 
		   } while(checkUserName);


		do {
			 System.out.println("Enter your Password please:");
			 String password = scan.nextLine();
			 checkPassword=users[index].getCredentials().getPassword().equals(password);
			 counter++;
			 
			} while(3>counter);

			if(checkPassword)
				setCurrentUser(currentUser);
			else
				System.out.println("For your safety, the account is locked for 30 minutes!");
			
			//Timer?????
	}
	

	/**
	 * A method for login to the banking system using phone number.
	 * @param phoneNumber
	 */
	public void login(PhoneNumber phoneNumber) 
	{
		for (int i = 0; i < users.length; i++) 
		{
			if(users[i].getPhoneNumber() == phoneNumber) 
			{
				setCurrentUser(currentUser);
				return;
			}
		}
		System.out.println("Sorry.. Apparently there is a mistake, we do not have the phone number entered.");
	}
	

	/**
	 * Actor: Applicant
	 * Open a bank account
	 */
	private void OpenAccount() 
	{
		int i=0;
		boolean checkUserName=false;
		System.out.println("You are welcome to our AJBC Bank, please fill this application form:\n");
		
		System.out.println("Enter your first Name:\r\n"
		 		+ "Enter your Last Name:\r\n"
		 		+ "Enter your Phone Number in format of:{areaCode,number}:\r\n"
		 	//	+ "Enter your BitrthDate:{yyyy,dd,mm,}:\r\n"
				+ "Enter a Monthly-Income: \r\n"
		 		+ "Enter a Username: {letters and digits only} \r\n"
		 		+ "Enter a Password: {4-8 chars, must contain digit and letter}: \r\n" );
		
		String firstName = scan.nextLine();
		String lastName = scan.nextLine();
		String areaCode = scan.next();
		String restNumber = scan.next();
		//this.phoneNumber.setAreaCode(areaCode);
		//this.phoneNumber.setPhoneNumber(restNumber);
		PhoneNumber.getFullPhoneNumber(areaCode+"-"+restNumber);
		PhoneNumber phoneNum = this.phoneNumber;
		double monthlyIncome = scan.nextDouble();	
		String userName = scan.next();
		String password = scan.next();
		
		LocalDate birthDate = createDate(); //TODO inputDate
		System.out.println(birthDate);
		//currentUser.setMonthlyIncome(monthlyIncome);
		Credentials credentials = new Credentials(userName,password);
	    checkUserName=users[i].getCredentials().getUserName().equals(userName);
	    if(!checkUserName)
	    {
	    	Account account = new Account(1000);
			this.bankManager = new BankManager(firstName, lastName, phoneNum, birthDate, account, monthlyIncome, credentials);
			checkUserName = true;
			System.out.println("Welcome "+userName+" you have Logged-in Successfully");
        }
	    else
	    {
	    	AccountOwner newOwner = new AccountOwner(firstName,lastName,phoneNum,birthDate,null,monthlyIncome,credentials);
	    	//this.AccountOwner[index++] = newOwner;	    		
	    	this.currentUser.setCredentials(credentials);
			bankManager.setUsersToApprove(newOwner);
			System.out.println(newOwner);	
	    }

		
	//	newOwner.getBankManager().addUserToApprove(newOwner);
		//this.AccountOwner[index++] = newOwner;
		//System.out.println(newOwner);

		
	}
	
	/**
	 * A method for logout the system.
	 */
	private void logout() 
	{
		this.currentUser=null;
	}
	
		
	public static AccountOwner getOwnerByPhoneNum(PhoneNumber phoneNumber) 
	{
		for (int i = 0; users[i]!=null; i++) 
		{
			if(users[i].getPhoneNumber() == phoneNumber) 
			{
				return users[i];
			}
		}
		return null;
	}
			
}

