package AccountOwner;

import java.time.LocalDateTime;

public class Account 
{
	
	protected double balance;
	protected AccountProperties accountProperties;
	protected ActivityData[] activityDataArray;	
	private Double intrestRate; //TODO add it to class diagram.
	private Double operationFee; //TODO add it to class diagram.
	private int index=0;
	
	public Account(double balance, AccountProperties accountProperties, Double intrestRate, Double operationFee) 
	{
		this.balance = balance;
		this.accountProperties = accountProperties;
		activityDataArray = new ActivityData[100];
		this.intrestRate = intrestRate;
		this.operationFee = operationFee;
		setBalance(0); //empty account.
	}
	
	private void setBalance(double balance) 
	{
		this.balance = balance;
	}

	public double getBalance()
	{
		return balance;
	}
	
	public void deposit(int cashAmount) 
	{
		setBalance(balance + cashAmount);
		activityOfData(ActivityName.DEPOSIT, "none",cashAmount);
	}
	
	private void activityOfData(ActivityName activityName, String info,double balanceChange) 
	{
		ActivityData activityData = new ActivityData(activityName, LocalDateTime.now() ,info ,balanceChange);
		activityDataArray(activityData);
	}
	
	private void activityDataArray(ActivityData activityData) 
	{
		if (activityDataArray.length <= index) 
		{
			System.out.println("Its the maximum array right now.");
			return;
		}
		activityDataArray[index++] = activityData;
	}
	
	public boolean withdrawalCash(int cashAmount) 
	{
		if (accountProperties.maxWithdrawal >= cashAmount) 
		{
			setBalance(balance - cashAmount);
			activityOfData(ActivityName.WITHDRAWAL, "none", (cashAmount*(-1)));
			return true;
		} 
		else 
		{
			System.out.println("Sorry! Its the maximun daily maximum amount.");
			return false;
		}
	}


}
