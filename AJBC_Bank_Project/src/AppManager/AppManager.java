package AppManager;

import java.time.LocalDate;
import java.util.Scanner;

import AccountOwner.AccountOwner;
import BankManager.BankManager;
import Person.Person;
import Person.PhoneNumber;

public class AppManager 
{	
	static  Scanner scan = new Scanner(System.in);
	
	private AccountOwner currUser;
	static  AccountOwner[] users;
	//users = new AccountOwner[100];

	private BankManager bankManager;
	private Person person;
	private PhoneNumber phoneNumber;
	
	//Constructor
	public AppManager(AccountOwner currUser, AccountOwner[] users) 
	{
		setCurrUser(currUser);
		setUsers(users);
	}
		
		public AccountOwner getCurrUser() 
		{
			return currUser;
		}


		public void setCurrUser(AccountOwner currUser) 
		{
			this.currUser = currUser;
		}

		public AccountOwner[] getUsers() 
		{
			return users;
		}

		public void setUsers(AccountOwner[] users) 
		{
			for (int i = 0; i < users.length; i++) 
			{
				this.users[i]=users[i];
			}
		}
		

		
		public static LocalDate createDate() 
		{
	        
	        LocalDate date = LocalDate.of(scan.nextInt(), scan.nextInt(), scan.nextInt());
	        //DateTimeFormat ("dd. MMM. yyyy");
	        scan.close();
	        return date;
	    }		
		
		
		
	/**
	 * A method for login to the banking system using username and password.
	 * @param userName
	 * @param password
	 */
	public void login(String userName, String password)
	{
		int index=0;
		int counter=0; //The number of times the user tried to login to his account.
		boolean checkUserName=false;
		boolean checkPassword;
	
		do {
			// System.out.println("Enter you Username please:");
			// String username = scan.nextLine();
			 for (index=0 ; index < users.length; index++) 
			 {
				checkUserName=users[index].getCredentials().getUserName().equals(userName);
				if(checkUserName)
					break;
			 }
			 
		   } while(checkUserName);


		do {
			 //System.out.println("Enter a password");
			 //String password = scan.nextLine();
			 checkPassword=users[index].getCredentials().getPassword().equals(password);
			 counter++;
			} while(3>counter);

			if(checkPassword)
				setCurrUser(currUser);
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
				setCurrUser(currUser);
				return;
			}
		}
		System.out.println("Sorry.. Apparently there is a mistake, we do not have the phone number entered.");
	}
	

	/**
	 * A method for logout the system.
	 */
	private void logout() 
	{
		this.currUser=null;
	}
	
	
	
	
	/**
	 * Actor: Applicant
	 * Open a bank account
	 */
	private void OpenAccount() 
	{
		int i=0;
		System.out.println("You are welcome to our AJBC Bank, please fill this application form:\n");
		
		System.out.println("Enter your first Name:v\n"
		 		+ "Enter your Last Name:v\n"
		 		+ "Enter your Phone Number in format of:{areaCode + number} \n"
		 		+ "Enter your BitrthDate:LocalDate");
		System.out.println("Enter a Monthly-Income: \n");
		int monthlyIncome = scan.nextInt(); 
		this.person.setFirstName(scan.nextLine());
		this.person.setLastName(scan.nextLine());
		this.phoneNumber.setAreaCode(scan.nextInt());
		this.phoneNumber.setPhoneNumber(scan.nextInt());
		this.person.setPhoneNumber(this.phoneNumber);
		this.person.setBitrthDate(createDate());
		 
		Scanner sc = new Scanner(System.in);
	    System.out.println("Enter the Username");
	    String userName = sc.nextLine();
	     
	    System.out.println("Enter the Password");
	    String password = sc.nextLine();
	    
	    boolean flagUsername=users[i].getCredentials().getUserName().equals(userName);
	    if(flagUsername)
	    {
	    	login(userName,password);
            System.out.println("Welcome "+userName+" you have Logged-in Successfully");
        }
  
		bankManager.setUsersToApprove(this.person);
	
	}
	
	
	
	private static AccountOwner getOwnerByPhoneNum(PhoneNumber phoneNumber) 
	{
		return null;		
	}
	
	private void fillsApplicationForm() 
	{
		System.out.println("Enter a Phone number");
		currUser.setPhoneNumber(0);

	}

}

