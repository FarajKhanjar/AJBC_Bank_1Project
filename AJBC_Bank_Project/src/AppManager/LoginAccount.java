package AppManager;

import java.time.LocalDateTime;

import AccountOwner.AccountOwner;
import AccountOwner.Credentials;

public class LoginAccount 
{
	/**
	 * A method for login to the banking system using username and password.
	 * @param username of the account owner 
	 * @param password of the account owner 
	 * @return the logged in account owner or block account or null.
	 */
	public static AccountOwner login(String username, String password)
	{		
		AccountOwner loggingOwner = getUserByUsername(username);
		
		if (loggingOwner == null)
		{
			System.out.println("No account owner with the given username.");
			return null;
		}
		if (!isUserApproved(loggingOwner))
			return null;
		Credentials ownerCredentials = loggingOwner.getCredentials();
		LocalDateTime currentRelease = loggingOwner.getAccount().getReleaseTime();
		if (currentRelease != null)
		{
			if (!checkLockRelease(currentRelease))
			{
				System.out.println("For your safety, the system blocked you account.\nYou can try againe at: " +currentRelease);
				return null;
			}
			loggingOwner.getAccount().setLockReleaseTime(null);
		}
		
		if (checkPasswordThatUserEnter(password, ownerCredentials.getPassword()))
		{
			System.out.println("Successfully logged in.");
			return loggingOwner;
		}
		if (tryingEnterSystemByPassword(loggingOwner))
		{
			System.out.println("Successfully logged in.");
			return loggingOwner;
		}
		blockThisAccount(loggingOwner);
		return null;
	}
	
	/** 
	 * get user by username
	 * @param username
	 * @return the account owner with the given username,
	 * null if no user with the given username
	 */
	public static AccountOwner getUserByUsername(String username)
	{
		for (int i=0; i<AppManager.getNumberOfUsers(); i++)
		{
			if (AppManager.usersArray[i].getCredentials().getUserName().equals(username))
				return AppManager.usersArray[i];
		}
		return null;
	}
	
	/**
	 * checks if the account owner has been approved by tha bank manager
	 * @param owner the account owner
	 * @return false if the account is null, true otherwise
	 */
	public static boolean isUserApproved(AccountOwner owner)
	{
		if (owner.getAccount() == null)
		{
			System.out.println("The bank manager didnt approved your opening account request.");
			return false;
		}
		return true;
	}
	
	/**
	 * check if release lock of the account time has passed
	 * @param releaseTime the account release time 
	 * @return true if release time has passed, false otherwise
	 */
	public static boolean checkLockRelease(LocalDateTime releaseTime)
	{
		if (releaseTime.isAfter(LocalDateTime.now()))
			return false;
		return true;			
	}
	
	/**
	 * check if the password  that user entered by input is equal to the real password
	 * @return true if passwords are equal, false otherwise
	 */
	public static boolean checkPasswordThatUserEnter(String passwordByInput, String realPassword)
	{
		return passwordByInput.equals(realPassword);
	}
		
	/**
	 * The user have to enter a correct password, in case he enter a wrong one, 
	 * he have maximum more 2 tries. (In total 3 tries).
	 * @param user that  trying to enter system.
	 * @return true if user succeeds, false if its a wrong password, and get account lock of it more then 3 tries.
	 */
	public static boolean tryingEnterSystemByPassword(AccountOwner user)
	{
		Credentials userCredentials = user.getCredentials();
		int attempts = 3;
		while (attempts > 0)
		{
			System.out.printf("Is There any mistake?, its a wrong password!\nYou have %d more attempts\n", attempts);
			System.out.println("Please enter your password ");
			String currentTry = AppManager.scanner.next();
			if (checkPasswordThatUserEnter(currentTry, userCredentials.getPassword()))
			{
				return true;
			}
			else
			{
				attempts--;
			}
		}
		return false;
	}
	
	/**
	 * block account of user
	 * @param userAccount 
	 */
	public static void blockThisAccount(AccountOwner userAccount)
	{
		LocalDateTime current_time = LocalDateTime.now();
		LocalDateTime release_time = current_time.plusMinutes(30);
		userAccount.getAccount().setLockReleaseTime(release_time);
		System.out.println("For your safety, the account is locked for 30 minutes!. you can try againe at: "+release_time);
	}
}