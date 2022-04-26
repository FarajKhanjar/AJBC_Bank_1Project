package AppManager;

import java.time.LocalDate;
import java.time.Period;
import java.util.Random;
import java.util.Scanner;

import AccountOwner.Account;
import Runner.Runner;
import AccountOwner.AccountOwner;
import AccountOwner.Credentials;
import BankManager.BankManager;
import Person.PhoneNumber;
import Runner.Static_Scan;

public class AppManager 
{	
	
	private static  Scanner scan = new Scanner(System.in);
	
	public  AccountOwner[] usersArray  = {};
	
	Scanner sc = new Scanner(System.in);
	//Fileds
	private AccountOwner currentUser = null;
	private static int index=0;
	private BankManager bankManager;
	private PhoneNumber phoneNumber;
	
	//Constructors
	/*
	public AppManager(AccountOwner currentUser, AccountOwner[] users) 
	{
		setCurrentUser(currentUser);
		setUsers(users);
	}
	*/
	
	public AppManager(BankManager bankManager) 
	{
		setBankManager(bankManager);
	}
	
	public int runner() 
	{		
		  while(true) 
		  {
		    bankMenu();
		    int temp = Integer.parseInt(sc.next());
		    if(temp == 0)
		      break;
		    bankManagerCheck(temp);
		  }
		return 0;
		
	}

	public void bankMenu() 
	{
		  System.out.println("You are welcome to our AJBC Bank :) ,\n");
		  System.out.println("1. Login\n"+ "2. Open Account\n" + "3. Exit");
	}
	
	public void bankManagerCheck(int temp) 
	{
		  switch(temp)
		  {
		  case 0: 
			  System.out.println("Try again");
		  case 1:
			  login();
			  System.out.println(bankManager);
			  break;
		  case 2: 			  
			  OpenAccount();
			  System.out.println(bankManager);
		  case 3: 			  
			  logout();
			  
			  System.out.println(bankManager);		
		  }
	}
	
	
	public AccountOwner getCurrentUser() 
	{
		return currentUser;
	}

	private void setBankManager(BankManager manager) 
	{
		this.bankManager = manager;
	}
		
	public void setCurrentUser(AccountOwner currentUser) 
	{
		this.currentUser = currentUser;
		if (index >= Runner.usersArray.length) {
			System.out.println("its full");
			return;
		}

		Runner.usersArray[index++] = currentUser;
	}

	public AccountOwner[] getUsers() 
	{
		return Runner.usersArray;
	}

	public void setUsers(AccountOwner[] users) 
	{
		for (int i = 0; i < users.length; i++) 
		{
			Runner.usersArray[i] = users[i];
		}
	}

	public static LocalDate createDate() 
	{

		//LocalDate date = LocalDate.of(scan.nextInt(), scan.nextInt(), scan.nextInt());
		// DateTimeFormat ("dd, MMM, yyyy");
		//return date;
		
		return LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 70))));
	}
	
	
			
	/**
	 * A method for login to the banking system using username and password.
	 * @param userName
	 * @param password
	 */
/*	public void login()
	{
		int index=0;
		int counter=0; //The number of times the user tried to login to his account.
		boolean checkUserName=false;
		boolean checkPassword;
		System.out.println("number of users: "+Runner.usersArray.length);
		System.out.println(Runner.usersArray[index]+"\n");
		
		System.out.println("Enter your Username please: {only letters and digits}");
		String userName = scan.nextLine();
		for (index=0 ; index<Runner.usersArray.length; index++) 
		{
			System.out.println(Runner.usersArray[index].getCredentials().getUserName());
			checkUserName=Runner.usersArray[index].getCredentials().getUserName().equals(userName);
			if(checkUserName) 
			{
				while(counter < 3) 
				{
					System.out.println("Enter your Password please:  {4-8 chars, must contain digit and letter}");
					String password = scan.nextLine();
					System.out.println(Runner.usersArray[index].getCredentials().getPassword());
					checkPassword = Runner.usersArray[index].getCredentials().getPassword().equals(password);
					if (checkPassword) 
					{
						currentUser = Runner.usersArray[index];
						break;
					} 
					else 
					{
						counter++;						
					}
				}
			}
			
			if(counter == 3) 
			{
				System.out.println("For your safety, the account is locked for 30 minutes!");
			}
			else
			{
				currentUser.runActionsMenu();
				break;
			}
		}
	}
	
*/	
	private void login() 
	{
		int counter = 3;
		String checkUserName,checkPassword = null;
		int loginNumber = 0;
		while(loginNumber<=counter) {
			System.out.println("Enter your Username please: {only letters and digits}");
			String userName = Static_Scan.scanner.next();
			System.out.println("Enter your Password please:  {4-8 chars, must contain digit and letter}");
			String password = Static_Scan.scanner.next();
			
			for (int i=0 ; i<Runner.usersArray.length ; i++)
			{
				System.out.println(Runner.usersArray[i]);
				checkUserName = Runner.usersArray[i].getCredentials().getUserName();
				if(userName.matches(checkUserName)) 
					 checkPassword = Runner.usersArray[i].getCredentials().getPassword();
					if(password.matches(checkPassword)) 
						currentUser = Runner.usersArray[i];			
			}
			if(currentUser!=null)
				break;
			else {
				System.out.println("Try one more time, you have "+loginNumber+" tumes for try.");
				loginNumber++;
			}		
		}
		if(loginNumber==3) 
			System.out.println("For your safety, the account is locked for 30 minutes!");
		else 
			currentUser.runActionsMenu();
	}
	

	/**
	 * A method for login to the banking system using phone number.
	 * @param phoneNumber
	 */
	public void login(PhoneNumber phoneNumber) 
	{
		for (int i = 0; i < Runner.usersArray.length; i++) 
		{
			if(Runner.usersArray[i].getPhoneNumber() == phoneNumber) 
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
		System.out.println("\nYou are welcome to open an account in our bank!\n");
		
		System.out.print("Enter your phone number please: ");
		String numberStr = scan.next();
		PhoneNumber phoneNumber = PhoneNumber.getFullPhoneNumber(numberStr);
		if (phoneNumber == null)
		{
			return;
		}
		AccountOwner openUser = getOwnerByPhoneNum(phoneNumber);
		if (openUser == null) 
		{
			System.out.print("Enter your first Name:");
			String firstName = scan.next();
			System.out.print("Enter your Last Name:");
			String lastName = scan.next();
			//String areaCode = scan.next();
			//String restNumber = scan.next();
			//this.phoneNumber.setAreaCode(areaCode);
			//this.phoneNumber.setPhoneNumber(restNumber);
			//PhoneNumber.getFullPhoneNumber(areaCode+"-"+restNumber);
			PhoneNumber phoneNum = phoneNumber;
			//System.out.print("Enter againe your Phone Number in format of:{areaCode,number}:");
			 	//	+ "Enter your BitrthDate:{yyyy,dd,mm,}:\r\n"
			LocalDate birthDate = createDate(); //TODO inputDate
			System.out.print("Birthday at:"+birthDate+"\n");
			System.out.print("Enter a Monthly-Income:");
			double monthlyIncome = scan.nextDouble();
			System.out.print("Enter a Username: {letters and digits only}");
			String userName = scan.next();
			System.out.print("Enter a Password: {4-8 chars, must contain digit and letter}" );
			String password = scan.next();
			
			//currentUser.setMonthlyIncome(monthlyIncome);
			Credentials credentials = new Credentials(userName,password);
		    checkUserName=Runner.usersArray[i].getCredentials().getUserName().equals(userName);
		    if(!checkUserName)
		    {
		    	Account account = new Account(1000);
				this.bankManager = new BankManager(firstName, lastName, phoneNum, birthDate,credentials);
				checkUserName = true;
				System.out.println("Welcome "+userName+" you have Logged-in Successfully");
				(Runner.usersArray[i]).runActionsMenu();
	        }
		    else
		    {
		    	AccountOwner newOwner = new AccountOwner(firstName,lastName,phoneNum,birthDate,null,monthlyIncome,credentials);
		    	//this.AccountOwner[index++] = newOwner;
		    	
		    	this.currentUser.setCredentials(credentials);
		    	setCurrentUser(newOwner);
				bankManager.setUsersToApprove(newOwner);
				System.out.println(newOwner);	
		    }
			
		}
		else 
		{
			System.out.println("The system found your bank account! ");
			login();
		}		
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
		for (int i = 0; Runner.usersArray[i]!=null; i++) 
		{
			if(Runner.usersArray[i].getPhoneNumber() == phoneNumber) 
			{
				return Runner.usersArray[i];
			}
		}
		return null;
	}
			
}

