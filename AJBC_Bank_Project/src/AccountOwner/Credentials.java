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
		boolean checkUserNameLD = cheackLettersAndDigits(userName); 
		if(!checkUserNameLD)
			System.out.println("Invalid Username");
			else
				this.userName = userName;		
	}
		
	public void setPassword(String password) 
	{
		boolean checkPasswordLD = cheackLettersAndDigits(password);
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
	private boolean cheackLettersAndDigits(String userStr)
	{
		if(userStr.matches("[a-zA-Z0-9]*")) {
			return true;
		}
		else
			return false;
	}
}