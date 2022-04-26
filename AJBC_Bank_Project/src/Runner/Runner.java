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
		//System.out.println(AJBC_manager);
		
		/**
		 * Create default data in array.
		 */		
		AccountOwner AJBC_userAccount1 = createUserAccount(); 
		createUserDataBase(AJBC_userAccount1);
		AppManager appManager1 = new AppManager(AJBC_userAccount1);
		//System.out.println(AJBC_userAccount1);
		
		AccountOwner AJBC_userAccount2 = createUserAccount1(); 
		createUserDataBase(AJBC_userAccount2);
		AppManager appManager2 = new AppManager(AJBC_userAccount2);
		//System.out.println(AJBC_userAccount2);
		
		//bankOwner.setAccount(account);
		//index++;
		//usersArray[index] = bankOwner;
		//createUserDataBase(bankOwner);
		//System.out.println(bankOwner);

		appManager.runner();
				
	}
	
	public static BankManager createTheManagerAccount() 
	{
		Credentials credentials = new Credentials("Themanager", "m123456");
		PhoneNumber phoneNumber = new PhoneNumber("050", "9909129");
		LocalDate birthDate = LocalDate.of(1990, 07, 26);
		double monthlyIncome = 15000;
		double balance = 75000;
		BankManager AJBC_manager = new BankManager("Guy", "Turgi",phoneNumber, birthDate, credentials);
		AccountOwner bankOwner = new AccountOwner("Guy", "Turgi" ,phoneNumber, birthDate,monthlyIncome, credentials ,AJBC_manager);
		Account account = new Account(balance,AccountProperties.TITANIUM, 0d, 0d);
		return AJBC_manager;
	}
	
	public static AccountOwner createUserAccount() 
	{
		LocalDate birthDate = LocalDate.of(1993, 06, 28);
		Credentials credentials = new Credentials("FarajKH", "f12345");
		PhoneNumber phoneNumber = new PhoneNumber("054", "2459909");
        //System.out.println(phoneNumber.getPhoneNumber());	
		double monthlyIncome = 20000;
		String firstName = "Faraj";
		String lastName = "Khanjar";		
		double balance = 25000;

		AccountOwner bankOwner = new AccountOwner(firstName, lastName ,phoneNumber, birthDate,credentials,monthlyIncome);
		Account account = new Account(balance,AccountProperties.GOLD, 2d, 3d);
		return bankOwner;
	}
	
	public static AccountOwner createUserAccount1() 
	{
		LocalDate birthDate = LocalDate.of(1980, 05, 20);
		Credentials credentials = new Credentials("sami123", "s12345");
		PhoneNumber phoneNumber = new PhoneNumber("050", "9969125");
        //System.out.println(phoneNumber.getPhoneNumber());	
		double monthlyIncome = 7500;
		String firstName = "Sami";
		String lastName = "levi";		
		double balance = 15000;

		AccountOwner bankOwner = new AccountOwner(firstName, lastName ,phoneNumber, birthDate,credentials,monthlyIncome);
		Account account = new Account(balance,AccountProperties.SILVER, 4d, 4.5d);
		return bankOwner;
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