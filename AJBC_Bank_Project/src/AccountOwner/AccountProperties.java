package AccountOwner;

/**
 * In this class we will get and use  the coast values of the Account Properties types.
 * Its enum.
 * @author Faraj
 */
public enum AccountProperties 
{
	//Basic info and types.
	BRONZE(4.5f, 6f, 5f, 7.5f, 10000, 2500),
	SILVER(3f, 4.5f, 3.8f, 5f, 20000, 4000),
	GOLD(1.5f, 3f, 1.75f, 3.8f, 50000, 6000), 
	TITANIUM(0, 0, 0, 0, 100000, 100000);

	//Fields
	double minInterestRate, maxInterestRate;
	double minFee, maxFee;
	double maxLoan, maxWithdrawal;

	//Contractor
	AccountProperties(double minInterestRate, double maxInterestRate, double minFee, double maxFee,
		int maxLoanAmmount, int maxWithdrawal) {
		this.minInterestRate = minInterestRate;
		this.maxInterestRate = maxInterestRate;
		this.minFee = minFee;
		this.maxFee = maxFee;
		this.maxLoan = maxLoanAmmount;
		this.maxWithdrawal = maxWithdrawal;
	}
	
	/**
	 * using the SSD info, in this method we check if the account types is okay in relation monthlyIncome
	 * @param monthlyIncome
	 * @return
	 */
	public static AccountProperties properties(double monthlyIncome) 
	{
		if(monthlyIncome<5000)
			return BRONZE;
		if(monthlyIncome<8000)
			return SILVER;
		if(monthlyIncome<10000)
			return GOLD;
		return TITANIUM;
	}
	
	
	/**
	 * Get and Set method help us to get values of the fields or set a new values.
	 *
	 */	
	
	public double getIntresRateMin() 
	{
		return minInterestRate;
	}

	public void setIntresRateMin(double minInterestRate) 
	{
		this.minInterestRate = minInterestRate;
	}

	public double getIntresRateMax() 
	{
		return maxInterestRate;
	}

	public void setIntresRateMax(double maxInterestRate) 
	{
		this.maxInterestRate = maxInterestRate;
	}

	public double getFeeMax() 
	{
		return maxFee;
	}

	public void setFeeMax(double maxFee) 
	{
		this.maxFee = maxFee;
	}

	public double getMaxWithdrawalAmount() 
	{
		return maxWithdrawal;
	}

	public void setMaxWithdrawalAmount(double maxWithdrawal) 
	{
		this.maxWithdrawal = maxWithdrawal;
	}
	
}
