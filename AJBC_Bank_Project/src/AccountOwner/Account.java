package AccountOwner;

import java.time.LocalDateTime;

public class Account 
{
	
	protected double balance;
	protected AccountProperties accountProperties;
	protected ActivityData[] activityDataArray;	
	private double intrestRate; //TODO add it to class diagram.
	private double operationFee; //TODO add it to class diagram.
	private int index=0;
	private final int MAXIMUM_TRANSFER_CASH = 2000;
	private final int MAX_BILL_AMOUNT = 5000;
	private int count = 0;
	private final long accountNumber;
	
	public Account(double balance, AccountProperties accountProperties, double intrestRate, double operationFee) 
	{
		this.balance = balance;
		this.accountProperties = accountProperties;
		activityDataArray = new ActivityData[100];
		this.intrestRate = intrestRate;
		this.operationFee = operationFee;
		setBalance(0); //empty account.
		this.accountNumber = count++;
	}
	
	public Account(double balance) 
	{
		this.accountNumber = count++;
		this.balance = balance;
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
			System.out.println("Sorry! Its the maximum daily amount.");
			return false;
		}
	}
	
	public boolean transferToAnotherAccount(int cashAmount) 
	{
		if (cashAmount <= MAXIMUM_TRANSFER_CASH) {
			setBalance(balance - cashAmount);
			activityOfData(ActivityName.MAKE_PAYMENT_TRANSFER, "transfer to the second user", (cashAmount*(-1)));
			return true;
		} else 
		{
			System.out.printf("Sorry! Its the maximum daily amount for transfer, ("+ MAXIMUM_TRANSFER_CASH+").");
			return false;
		}
	}
	
	public void accountTransferredForMe(int cashAmount) 
	{
		setBalance(balance + cashAmount);
		activityOfData(ActivityName.MAKE_PAYMENT_TRANSFER, "transferred to me from other user", cashAmount);
	}
	
	public boolean payBill(int cashAmount, String payeeType) 
	{
		if (MAX_BILL_AMOUNT>=cashAmount) 
		{
			setBalance(balance - cashAmount);
			activityOfData(ActivityName.PAY_BILL, "Payee a bill of: " + payeeType, (cashAmount*(-1)));
			return true;
		} 
		else 
		{
			System.out.printf("Sorry! Its the maximum daily amount to pay a bill, ("+MAX_BILL_AMOUNT+").");
			return false;
		}
	}
	
	
	public boolean checkLoanAmount(int cashAmount) 
	{
		return cashAmount <= accountProperties.maxLoan;
	}
	
	public void getLoanAmount(int cashAmount, int paymentsNumber) 
	{
		setBalance(balance + cashAmount);
		activityOfData(ActivityName.GET_LOAN, "num of the payments is: " + paymentsNumber, cashAmount);
	}
	
	
	public ActivityData[] getHistoryFromGivenDate(LocalDateTime timeStamp) 
	{
		return new ActivityData[0];
	}

}
