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
	public AccountOwner[] usersToApprove;
	public int index = 0;
	public AccountProperties accountProperties;
			
	
	public BankManager(String firstName, String lastName, PhoneNumber phoneNumber,
			LocalDate birthDate, Credentials credentials) 
	{
			super(firstName, lastName,phoneNumber, birthDate, credentials, 0);
			this.usersToApprove = new AccountOwner[100];
			this.index = 0;
			createTheManagerAccount();
	}
	

	public void setUsersToApprove(AccountOwner accountOwner) 
	{
		this.usersToApprove[index] = accountOwner;
		index++;
	}
	
	public AccountOwner[] getUsersToApprove() 
	{
		return usersToApprove;
	}

	public void setAndApproveAccount() 
	{
		for (int i = 0; this.usersToApprove[i]!=null; i++) 
		{
			accountProperties = AccountProperties.properties(this.usersToApprove[i].getMonthlyIncome());
			Account account = new Account(0d,accountProperties,accountProperties.getIntresRateMax(),accountProperties.getFeeMax());
			this.usersToApprove[i].setAccount(account);
		}
		usersToApprove = null;
	}
	
	private void createTheManagerAccount() 
	{
		Account account = new Account(500000d,AccountProperties.TITANIUM, 0, 0);
		setAccount(account);
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
