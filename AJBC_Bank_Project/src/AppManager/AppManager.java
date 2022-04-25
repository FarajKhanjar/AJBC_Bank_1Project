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

	private BankManager bankManager;
	private Person person;
	private PhoneNumber phoneNumber;
	
	
	private void login(String username, String password) 
	{
		
		if(username.equals("BankManager")) {
			
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
		System.out.println("Enter a Monthly-Income: \n");
		 int monthlyIncome = scan.nextInt(); 
		 System.out.println("Enter your first Name:v\n"
		 		+ "Enter your Last Name:v\n"
		 		+ "Enter your Phone Number in format of:{areaCode + number} \n"
		 		+ "Enter your BitrthDate:LocalDate");
		 this.person.setFirstName(scan.nextLine());
		 this.person.setLastName(scan.nextLine());
		 this.phoneNumber.setAreaCode(scan.nextInt());
		 this.phoneNumber.setPhoneNumber(scan.nextInt());
		 this.person.setPhoneNumber(this.phoneNumber);
		 this.person.setBitrthDate(createDate());
		// bankManager.setUsersToApprove(this.person);
		
	}
	private void logout() 
	{
		
	}
	
	private static AccountOwner getOwnerByPhoneNum(PhoneNumber phoneNumber) 
	{
		return null;		
	}

}

