package AccountOwner;

public class Credentials 
{
	//fields
	private String userName;
	private String password;
	
	//Contractor
	public Credentials(String userName, String password) 
	{
		setUserName(userName);
		setPassword(password);
		
		//System.out.printf("User %s has been created \n", userName);
	    //System.out.printf("Enter 'login' to log in or 'register' to open another account");
	}
	
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
	
    private boolean cheackLettersAndDigits(String userName)
	{
		if(userName.matches("[a-zA-Z0-9]*")) {
			return true;
		}
		else
			return false;
	}
	
}
