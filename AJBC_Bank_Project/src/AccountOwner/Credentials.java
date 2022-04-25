package AccountOwner;

public class Credentials 
{
	
	protected final String userName;
	protected final String password;
	
	public Credentials(String userName, String password) 
	{
		this.userName = userName;
		this.password = password;
	}
	
	public String getUserName() 
	{
		return userName;
	}

	public String getPassword() 
	{
		return password;
	}
	

}
