package BankManager;

import AccountOwner.Account;
import AccountOwner.AccountOwner;
import AccountOwner.AccountProperties;
import AccountOwner.Credentials;
import Person.PhoneNumber;
import java.time.LocalDate;
import java.util.Arrays;

public class BankManager extends AccountOwner
{	
	private AccountOwner[] usersToApprove;
	private int index = 0;
	private AccountProperties accountProperties;
			
	public BankManager(String firstName, String lastName, PhoneNumber phoneNumber,
			LocalDate bitrthDate, Account account, double monthlyIncome, Credentials credentials) 
	{
		super(firstName, lastName, phoneNumber, bitrthDate, account, monthlyIncome, credentials);
		this.usersToApprove = new AccountOwner[100];
	}
	

	public void setUsersToApprove(AccountOwner accountOwner) 
	{
		this.usersToApprove[index] = accountOwner;
		index++;
	}

	private void setAndApproveAcc() 
	{
		for (int i = 0; this.usersToApprove[i]!=null; i++) 
		{
			accountProperties = AccountProperties.properties(this.usersToApprove[i].getMonthlyIncome());
			Account account = new Account(0d,accountProperties,accountProperties.getIntresRateMax(),accountProperties.getFeeMax());
			this.usersToApprove[i].setAccount(account);
		}
		usersToApprove = null;
	}
	
	private void addUserToApprove(AccountOwner accountOwner) 
	{
		
	}
	
	private void produceReport(LocalDate start) 
	{
		
	}
	
	@Override
	public String toString() 
	{
		return super.toString() + "BankManager [usersToApprove=" + ", index=" + index
				+ ", accProperties=" + accountProperties + "]";
	}

}
