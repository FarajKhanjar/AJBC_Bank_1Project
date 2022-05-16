package AccountOwner;

/**
 * In this Class we will create the Credentials info,
 *  it will help the user get info and enter the application.
 * @author Faraj
 */
public class Credentials 
{
	//fields
	private String userName;
	private String password;
	
	/**
	 * Constructor
	 * @param userName of the account
	 * @param password of the account
	 */
	public Credentials(String userName, String password) 
	{
		setUserName(userName);
		setPassword(password);
	}
	
	/**
	 * Get an Set method help us to get values of the fields or set a new values.
	 *
	 */
	public String getUserName() 
	{
		return userName;
	}

	public String getPassword() 
	{
		return password;
	}
		
	public void setUserName(String userName) 
	{
		boolean checkUserNameLD = cheackUserNameIfOkay(userName); 
		if(!checkUserNameLD)
			System.out.println("Invalid Username");
			else
				this.userName = userName;		
	}
		
	public void setPassword(String password) 
	{
		boolean checkPasswordLD = cheackPasswordIfOkay(password);
	    if(checkPasswordLD==false || password.length()>8 || password.length()<4)
	    {
	    	    System.out.println("Invalid Password");
	    }
		else {
			this.password = password;
		}	
	}
	
    /**
     * In this method will check if the user enter a correct values,
     * of the userName and the password that he write in the console.
     * @param userName: check the string input.
     * @return True or False.
     */
	public static boolean cheackUserNameIfOkay(String userName)
	{
		for (int i=0; i<userName.length(); i++)
		{
			char currentChar = userName.charAt(i);
			if (!Character.isDigit(currentChar) && !Character.isLetter(currentChar)) 
				return false;

		}
		return true;
	}
	
	public static boolean cheackPasswordIfOkay(String password)
	{
		if (password.length() > 8 || password.length() < 4)
			return false;
		boolean foundLetter = false, foundDigit = false;
		for (int i=0; i<password.length(); i++)
		{
			char currentChar = password.charAt(i);
			if (Character.isLetter(currentChar))
				foundLetter = true;
			else if (Character.isDigit(currentChar))
				foundDigit = true;

		}
		return (foundLetter && foundDigit);
	}
}