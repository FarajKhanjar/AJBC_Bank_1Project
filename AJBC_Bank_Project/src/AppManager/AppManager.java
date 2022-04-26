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

/**
 * In this class the banking application start, here will shoe the actions to do.
 * @author Faraj
 *
 */
public class AppManager 
{	
	
	private static Scanner scan = new Scanner(System.in);
	public  AccountOwner[] usersArray  = {};
	public  AccountOwner currentUser ;
	
	//Fileds
	private static int index=0;
	private BankManager bankManager;
	private PhoneNumber phoneNumber;
	
	/**
	 * Contractor of:
	 * @param bankManager
	 */
	public AppManager(BankManager bankManager) 
	{
		setBankManager(bankManager);
	}
	
	/**
	 * Contractor of:
	 * @param accountOwner
	 */
	public AppManager(AccountOwner accountOwner) 
	{
		setCurrentUser(accountOwner);
	}
	
	/**
	 * In this method will run the Menu show in the application.
	 * @return number input that sign of action in the application.
	 */
	public int runner() 
	{		
		  while(true) 
		  {
		    bankMenu();
		    int temp = Integer.parseInt(Static_Scan.scanner.next());
		    if(temp == 3)
		    {
		    	System.out.println("Good Buy");
		      break;
		     }
		    bankManagerCheck(temp);
		  }
		return 3;
		
	}

	/**
	 * The first Menu is the three actions of login, logout, and create new account.
	 * here the user will enter a number input and because of this the system will do the action
	 * @return the number of action
	 */
	public void bankMenu() 
	{
		  System.out.println("You are welcome to our AJBC Bank :) ,\n");
		  System.out.println("1. Login\n"+ "2. Open Account\n" + "3. Exit\n");
	}
	
	/**
	 * With the help of Switch-case the system will go the action that the user choose as input.
	 * @param inputNumber = a helper to choose the action from the menu.
	 */
	public void bankManagerCheck(int inputNumber) 
	{
		  switch(inputNumber)
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
		  case 4: 			  
			  login(this.phoneNumber);		
		  }
	}
	
	/**
	 * Get an Set method help us to get values of the fields or set a new values.
	 *
	 */
	public AccountOwner getCurrentUser() 
	{
		return currentUser;
	}


	public AccountOwner[] getUsers() 
	{
		return Runner.usersArray;
	}

	/**
	 * in this method will insert the manager of the bank account to the dataBase array.
	 * @param manager
	 */
	private void setBankManager(BankManager manager) 
	{
		this.bankManager = manager;
		for (int i = 0; i < usersArray.length; i++) 
		{
			Runner.usersArray[i] = usersArray[i];
		}
	}
		
	/**
	 * in this method will insert the currentUser of the bank account to the dataBase array.
	 * @param currentUser
	 */
	public void setCurrentUser(AccountOwner currentUser) 
	{
		this.currentUser = currentUser;
		for (int i = 0; i < usersArray.length; i++) 
		{
			Runner.usersArray[i] = usersArray[i];
		}
	}
	
	/**
	 * In this method we will get a random Date as a LocalDate format.
	 * @return
	 */
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
	public void login()
	{
		int index=0;
		int counter=0; //The number of times the user tried to login to his account.
		boolean checkUserName=false;
		boolean checkPassword;
		//System.out.println("number of users: "+Runner.usersArray.length);
		System.out.println("Enter your Username please: {only letters and digits}");
		String userName = scan.nextLine();
		for ( index=0 ; Runner.usersArray[index]!=null; index++) 
		{
			//System.out.println(Runner.usersArray[index].getCredentials().getUserName());
			checkUserName=Runner.usersArray[index].getCredentials().getUserName().equals(userName);
			if(checkUserName) 
			{
				if(Runner.usersArray[index].cheackIfAccountLocks()) 
				{
					System.out.println("For your safety, the account is locked for 30 minutes!");
				}
				else 
				{
				   while(counter < 3) 
				  {
					counter++;
					System.out.println("Enter your Password please:  {4-8 chars, must contain digit and letter}");
					String password = scan.nextLine();
					//System.out.println(Runner.usersArray[index].getCredentials().getPassword());
					checkPassword = Runner.usersArray[index].getCredentials().getPassword().equals(password);
					if (checkPassword) 
					{
						currentUser = Runner.usersArray[index];
						if(Runner.usersArray[index].getCredentials().getUserName().equals("bankManager")) 
						{
							if(this.bankManager.getUsersToApprove()!=null)
								this.bankManager.setAndApproveAccount();
						}						
						break;
					} 					
				  }
				}
				if(counter==3) 
				{
					Runner.usersArray[index].makeAccountLock();					
				}
				Runner.usersArray[index].runActionsMenu();
			}	
		}
		
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
			
			Credentials credentials = new Credentials(userName,password);
		    checkUserName=Runner.usersArray[i].getCredentials().getUserName().equals(userName);
		    if(!checkUserName)
		    {
				this.bankManager = new BankManager(firstName, lastName, phoneNum, birthDate,credentials);
				checkUserName = true;
				System.out.println("\n===>Welcome "+userName+" you have Logged-in Successfully\n");
				(Runner.usersArray[i]).runActionsMenu();
	        }
		    else
		    {
		    	AccountOwner newOwner = new AccountOwner(firstName,lastName,phoneNum,birthDate,credentials,monthlyIncome);
		    	
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
	 * A method for logout from the system.
	 */
	private void logout() 
	{
		this.currentUser=null;
		Static_Scan.scanner.close();
	}
	
	/**
	 * In this method we will get the owner of a account by the user phoneNumber.	
	 * @param phoneNumber
	 * @return the bank account.
	 */
	public static AccountOwner getOwnerByPhoneNum(PhoneNumber phoneNumber) 
	{
		for (int i = 0; Runner.usersArray[i]!=null; i++) 
		{
			if(Runner.usersArray[i].getPhoneNumber().equals(phoneNumber)) 
			{
				return Runner.usersArray[i];
			}
		}
		return null;
	}
	
	/**
	 * In this method we will get the owner of a account by the userName.	
	 * @param userName
	 * @return the bank account.
	 */
	public static AccountOwner getOwnerByUserName(String userName) 
	{
		for (int i = 0; Runner.usersArray[i]!=null; i++) 
		{
			System.out.println(Runner.usersArray[i].getCredentials().getUserName());
			if(Runner.usersArray[i].getCredentials().getUserName().equals(userName)) 
			{
				return Runner.usersArray[i];
			}
		}
		return null;
	}			
}