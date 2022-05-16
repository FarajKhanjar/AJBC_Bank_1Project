package AppManager;

import java.time.LocalDate;

import AccountOwner.AccountOwner;
import AccountOwner.Credentials;
import Person.PhoneNumber;

public class OpenAccount 
{
	/**
	 * open a new account
	 * add new user to users array
	 * add new user to the manager's users to approve array
	 */
	public static void openAccount()
	{
		PhoneNumber newPhone = getPhoneFromInput();
		if (getOwnerByPhoneNumber(newPhone) != null)
		{
			System.out.println("We found this number in our system already. try to enter a different number or log-in");
			return;
		}
		AppManager.scanner.nextLine();

		String firstName = getFirstNameRegistration();
		String lastName = getLastNameRegistration();
		System.out.println("Enter your birthday please:");
		LocalDate birthDate = getUserBirthDateRegistration();
		String username = getUsernameRegistration();
		if (LoginAccount.getUserByUsername(username) != null)
		{
			System.out.println("You are able to login. we have this username already in our system.");
			return;
		}
		while (!Credentials.cheackUserNameIfOkay(username))
			username = getUsernameRegistration();
		String password = getPasswordRegistration();
		while (!Credentials.cheackPasswordIfOkay(password))
			password = getPasswordRegistration();
		
		Credentials newCredentials = new Credentials(username, password);
		double monthlyNncome = getMonthlyIncomeRegistration();
		AccountOwner newOwner = new AccountOwner(firstName, lastName, newPhone, birthDate, newCredentials,monthlyNncome);
		AppManager.addUserToArray(newOwner);
		newOwner.sendToManagerApproval();
		System.out.println("Registration is completed. We ask you to wait for the approval of the bank manager.");
		System.out.println("Back to the main menu.");
	}
	
	/**
	 * get phone number from user by area code and number
	 * @return the given phone number
	 */
	public static PhoneNumber getPhoneFromInput()
	{
		System.out.println("Enter phone number area code");
		String areaCode = AppManager.scanner.next();
		System.out.println("Enter phone number");
		String phoneNum = AppManager.scanner.next();
		PhoneNumber newPhone = new PhoneNumber(areaCode, phoneNum);
		return newPhone;
	}
	
	/**
	 *  get account owner by phone number
	 * @param phoneNumber the given phone number
	 * @return the account owner with the given phone number, 
	 * null if there is no user with this number
	 */
	public static AccountOwner getOwnerByPhoneNumber(PhoneNumber phoneNumber)
	{
		for (int i=0; i<AppManager.getNumberOfUsers(); i++)
		{
			if (AppManager.usersArray[i].getPhoneNumber().equals(phoneNumber))
				return AppManager.usersArray[i];
		}
		return null;
	}
	
	/** 
	 * get last name from user input
	 * @return the Registration name
	 */
	public static String getFirstNameRegistration()
	{
		System.out.println("Enter your first name please: ");
		String input = AppManager.scanner.next();
		return input;
	}
	
	/** 
	 * get first name from user input
	 * @return the Registration name
	 */
	public static String getLastNameRegistration()
	{
		System.out.println("Enter your last name please: ");
		String input = AppManager.scanner.next();
		return input;
	}
	
	/**
	 * get date from user by year, month and day of month
	 * @return the given date
	 */
	public static LocalDate getUserBirthDateRegistration()
	{
		System.out.println("Enter day of birth in month (1-31)");
		int day = AppManager.scanner.nextInt();
		System.out.println("Enter month of birth (1-12)");
		int month = AppManager.scanner.nextInt();
		System.out.println("Enter year of birth");
		int year = AppManager.scanner.nextInt();

		AppManager.scanner.nextLine();
		LocalDate date = LocalDate.of(year, month, day);
		return date;
	}
	
	
	
	/**
	 * In this method, the user asked to enter his username,
	 * Its used in case of Entering to the application OR creating a new account.
	 * @return the current username that entered.
	 */
	
	public static String getUsernameRegistration()
	{
		System.out.println("Enter username: letters and digits only");
		String username = AppManager.scanner.next();
		return username;
	}
	
	/**
	 * get password from user (for login and creating account)
	 * @return the given password
	 */
	public static String getPasswordRegistration()
	{
		System.out.println("Please enter password: 4-8 characters, must contain a digit and a letter");
		String password = AppManager.scanner.next();
		return password;
	}
	
	/**
	 * get monthly income from the user
	 * @return the monthly income
	 */
	public static double getMonthlyIncomeRegistration()
	{
		System.out.println("Please enter your monthly income");
		double income = AppManager.scanner.nextDouble();
		return income;
	}
}