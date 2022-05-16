package AppManager;

import java.time.LocalDate;
import java.util.Scanner;

import AccountOwner.Account;
import AccountOwner.AccountOwner;
import AccountOwner.AccountProperties;
import AccountOwner.Credentials;
import BankManager.BankManager;
import Menus.WelcomeMenu;
import Person.PhoneNumber;

/**
 * In this class the banking application start, here will show the actions to do.
 * @author Faraj
 */
public class AppManager 
{		
	static Scanner scanner = new Scanner(System.in);
	
	//Fileds
	public static AccountOwner[] usersArray;
	public static  AccountOwner currentUser;
	public static BankManager bankManager;
	protected static int numOfUsers;
	private static final int MAX_USERS = 1000;
	
	//Constructor
	public AppManager()
	{
		usersArray = new AccountOwner[MAX_USERS];
		numOfUsers = 0; //Default users number is zero.
		setBankManager();
		setUsersInArray();
	}
	
	/**
	 * Create the Default bank manager account.
	 */
	private void setBankManager()
	{
		Credentials managerUserAndPassward = new Credentials("TheManager", "faraj123");
		PhoneNumber managerPhoneNumber = new PhoneNumber("054","2459909");
		LocalDate managerBirthdate = LocalDate.of(1993, 6, 28);
		bankManager = new BankManager("Faraj", "Khanjar", managerPhoneNumber, managerBirthdate, managerUserAndPassward);
		usersArray[numOfUsers++] = bankManager;
	}
	
	/**
	 * Create four different Default bank accounts.
	 */
	private void setUsersInArray()
	{
		Credentials ownerUserAndPassward_1 = new Credentials("Wafi123", "wafi321");
		PhoneNumber ownerPhoneNumber_1 = new PhoneNumber("050","9969129");
		LocalDate ownerBirthdate_1 = LocalDate.of(1997, 8, 29);
		double ownerMonthlyIncome_1 = 1800 ;
		AccountOwner owner_1 = new AccountOwner("Wafi", "Khanjar", ownerPhoneNumber_1, ownerBirthdate_1, ownerUserAndPassward_1, ownerMonthlyIncome_1);
		double ownerBalance_1 = 30000;
		double ownerInterestRate_1 = 5;
		double ownerOperationFee_1 = 7;
		owner_1.setAccount(new Account(ownerBalance_1, AccountProperties.BRONZE, ownerInterestRate_1, ownerOperationFee_1, bankManager));
		addUserToArray(owner_1);		
		
		Credentials ownerUserAndPassward_2 = new Credentials("Nasreen267", "nm12345");
		PhoneNumber ownerPhoneNumber_2 = new PhoneNumber("050","2914848");
		LocalDate ownerBirthdate_2 = LocalDate.of(1999, 7, 26);
		double ownerMonthlyIncome_2 = 10000 ;
		AccountOwner owner_2 = new AccountOwner("Nasreen", "Madi", ownerPhoneNumber_2, ownerBirthdate_2, ownerUserAndPassward_2, ownerMonthlyIncome_2);
		double ownerBalance_2 = 25000;
		double ownerInterestRate_2 = 4;
		double ownerOperationFee_2 = 4.5;
		owner_2.setAccount(new Account(ownerBalance_2, AccountProperties.SILVER, ownerInterestRate_2, ownerOperationFee_2, bankManager));
		addUserToArray(owner_2);
		
		Credentials ownerUserAndPassward_3 = new Credentials("Doron7", "dr777");
		PhoneNumber ownerPhoneNumber_3 = new PhoneNumber("054","7462916");
		LocalDate ownerBirthdate_3 = LocalDate.of(1991, 7, 16);
		double ownerMonthlyIncome_3 = 18000 ;
		AccountOwner owner_3 = new AccountOwner("Doron", "Rainer", ownerPhoneNumber_3, ownerBirthdate_3, ownerUserAndPassward_3, ownerMonthlyIncome_3);
		double ownerBalance_3 = 150000;
		double ownerInterestRate_3 = 2;
		double ownerOperationFee_3 = 2.5;
		owner_3.setAccount(new Account(ownerBalance_3, AccountProperties.GOLD, ownerInterestRate_3, ownerOperationFee_3, bankManager));
		addUserToArray(owner_3);
		
		Credentials ownerUserAndPassward_4 = new Credentials("Anwar1812", "an1812");
		PhoneNumber ownerPhoneNumber_4 = new PhoneNumber("050","9969125");
		LocalDate ownerBirthdate_4 = LocalDate.of(1961, 12, 18);
		double ownerMonthlyIncome_4 = 35000 ;
		AccountOwner owner_4 = new AccountOwner("Anwar", "Khanjar", ownerPhoneNumber_4, ownerBirthdate_4, ownerUserAndPassward_4, ownerMonthlyIncome_4);
		double ownerBalance_4 = 300000;
		double ownerInterestRate_4 = 2;
		double ownerOperationFee_4 = 2.5;
		owner_4.setAccount(new Account(ownerBalance_4, AccountProperties.TITANIUM, ownerInterestRate_4, ownerOperationFee_4, bankManager));
		addUserToArray(owner_4);			
	}
	
	/**
	 * In this method, the system add a new account owner to the users array.
	 * @param ownerNewAccount is the new account that the system want to add to the array.
	 */
	protected static void addUserToArray(AccountOwner ownerNewAccount)
	{
		usersArray[numOfUsers++] = ownerNewAccount;
	}
	
	/**
	 * After create the default values (the manager account and 4 different accounts), 
	 * In this method the application start and show the first bank menu.
	 */
	public void start()
	{
		WelcomeMenu.welcomeMessage();		
	}
	
	
	/**
	 * For loan request, In this method we get number of monthly payments
	 * @return the number of months from user.
	 */
	public static int getNumberOfMonthsLoanRequest()
	{
		System.out.println("Enter number of monthly payments");
		int months = scanner.nextInt();
		return months;
	}
	
	public static int getNumberOfUsers() 
	{
		return numOfUsers;
	}
}