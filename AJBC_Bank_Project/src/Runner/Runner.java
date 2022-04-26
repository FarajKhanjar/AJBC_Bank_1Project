package Runner;

import java.time.LocalDate;
import java.util.Scanner;

import AccountOwner.Account;
import AccountOwner.AccountOwner;
import AccountOwner.AccountProperties;
import AccountOwner.Credentials;
import AppManager.AppManager;
import BankManager.BankManager;
import Person.PhoneNumber;

public class Runner 
{			
	public static int lengthOfData = 100;
	public static AccountOwner[] usersArray  = new AccountOwner[lengthOfData];
	private static int index;
	
	public static void main(String[] args) 
	{
		Scanner scanner = Static_Scan.scanner;
		
		/**
		 * Create database of the AJBC bank.
		 */		
		BankManager AJBC_manager = createTheManagerAccount(); 
		createUserDataBase(AJBC_manager);
		AppManager appManager = new AppManager(AJBC_manager);		
		System.out.println(AJBC_manager);
		
		/**
		 * Create default data in array.
		 */
		LocalDate birthDate = LocalDate.of(1993, 06, 28);
		Credentials credentials = new Credentials("FarajKH", "f12345");
		PhoneNumber phoneNumber = new PhoneNumber("054", "2459909");
        //System.out.println(phoneNumber.getPhoneNumber());		
		String firstName = "Faraj";
		String lastName = "Khanjar";
		double monthlyIncome = 20000d;
		AccountOwner bankOwner = new AccountOwner(firstName, lastName ,phoneNumber, birthDate, credentials ,monthlyIncome);
		Account account = new Account(monthlyIncome,AccountProperties.GOLD, 0d, 0d);

		bankOwner.setAccount(account);
		createUserDataBase(bankOwner);
		System.out.println(bankOwner);

		appManager.runner();
				
	}
	

	public static BankManager createTheManagerAccount() 
	{
		Credentials credentials = new Credentials("Themanager", "m123321");
		PhoneNumber phoneNumber = new PhoneNumber("050", "9909129");
		LocalDate birthDate = LocalDate.of(1990, 07, 26);
		
		BankManager AJBC_manager = new BankManager("Guy", "Turgi",phoneNumber, birthDate, credentials);		
		return AJBC_manager;
	}
	
	public static void createUserDataBase(BankManager AJBC_manager) 
	{		
		usersArray[index] = AJBC_manager;
	}
	
	public static void createUserDataBase(AccountOwner bankOwner) 
	{					
		index+=1;
		usersArray[index] = bankOwner;
	}


}