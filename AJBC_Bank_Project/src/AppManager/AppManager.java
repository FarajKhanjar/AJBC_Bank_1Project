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
	users = new AccountOwner[100];

	private BankManager bankManager;
	private Person person;
	private PhoneNumber phoneNumber;
	
	
	private void login(String username, String password) 
	{
		int index = 1;
		 // loop through file and check if we find a matching email and password
	    while (index<=3) 
	    {
	        if (username.equals(users.getAccountUserName())) 
	        {
	            System.out.println("Logging in...");
	            break;
	        }
	        index++;
	    }
		
	}
	private void login(PhoneNumber phoneNumber) 
	{
		
	}
	
	public static LocalDate createDate() 
	{
        
        LocalDate date = LocalDate.of(scan.nextInt(), scan.nextInt(), scan.nextInt());
//        DateTimeFormat ("dd. MMM. yyyy");
        scan.close();
        return date;
    }
	
	/**
	 * Actor: Applicant
	 * Open a bank account
	 */
	private void OpenAccount() 
	{
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
	    boolean checkUserNameLD = cheackLettersAndDigits(userName);  
	    if(checkUserNameLD==false)
	    {
	         System.out.println("Invalid Username");
	    }
	    boolean checkPasswordLD = cheackLettersAndDigits(password);
	    if(checkUserNameLD==false || password.length()>8 || password.length()<4)
	    {
	    	    System.out.println("Invalid Password");
	    }
	     
		bankManager.setUsersToApprove(this.person);
		
	}
	
	private boolean cheackLettersAndDigits(String userName)
	{
		if(userName.matches("[a-zA-Z0-9]*")) {
			return true;
		}
		else
			return false;
	}
	private void logout() 
	{
		
	}
	
	private static AccountOwner getOwnerByPhoneNum(PhoneNumber phoneNumber) 
	{
		return null;		
	}

}

