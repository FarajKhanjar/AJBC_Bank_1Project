package AccountOwner;

public class Account 
{
	protected double balance;
	protected AccountProperties accountProperties;
	protected ActivityData[] activityData;

	
	public Account(double balance, AccountProperties accountProperties) 
	{
		this.balance = balance;
		this.accountProperties = accountProperties;
	}

	
	public enum AccountProperties //The constant/enam values
	{
		BRONZE,
		SILVER,
		GOLD,
		TITANIUM;
		
		switch(accountProperties)
		{
			case BRONZE:
			{
				this.accountProperties(4.5,6,5,7.5,10000,2500);
			}
			case SILVER:
			{
				this.accountProperties(3,4.5,3.8,5,20000, 4000);
			}
			case GOLD:
				this.accountProperties(1.5,3,1.75,3.8,50000,6000);
			case TITANIUM:
			{
				this.accountProperties(0,0,0,0,0,0);
			}
			
		}
			
	}

}
