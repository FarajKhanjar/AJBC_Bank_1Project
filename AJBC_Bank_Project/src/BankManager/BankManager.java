package BankManager;

import AccountOwner.Account;
import AccountOwner.AccountOwner;
import AccountOwner.AccountProperties;
import AccountOwner.Credentials;
import Person.PhoneNumber;
import java.time.LocalDate;
import java.util.Arrays;

/**
 * The BankManager class is create and give us a basic info of the bank manager from "Person" class,
 * The bank manager are responsible of Approve users to enter the bank, and change details
 * @author Faraj
 */
public class BankManager extends AccountOwner
{	
	//Fields
	public AccountOwner[] usersToApprove;
	public int index = 0;
	public AccountProperties accountProperties;
			
	/**
	 * Contractor
	 * @param firstName of the BankManager
	 * @param lastName of the BankManager
	 * @param phoneNumber of the BankManager
	 * @param birthDate of the BankManager , LocalDate.
	 * @param credentials of the BankManager. userName and password.
	 */
	public BankManager(String firstName, String lastName, PhoneNumber phoneNumber,
			LocalDate birthDate, Credentials credentials) 
	{
			super(firstName, lastName,phoneNumber, birthDate, credentials, 0);
			this.usersToApprove = new AccountOwner[100];
			this.index = 0;
			createTheManagerAccount();
	}
	
	/**
	 * Get an Set method help us to get values of the fields or set a new values.
	 *
	 */
	public void setUsersToApprove(AccountOwner accountOwner) 
	{
		this.usersToApprove[index] = accountOwner;
		index++;
	}
	
	/**
	 * The bank manager are responsible of Approve users to enter the bank,
	 * @return in this method will return that users in the array of users.
	 */
	public AccountOwner[] getUsersToApprove() 
	{
		return usersToApprove;
	}

	/**
	 * The bank manager are responsible of Approve users to enter the bank,
	 * in this method will check each user in the array and approved a details in the account.
	 */
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
	
	/**
	 * In this method we will create the BankManager account.
	 */
	private void createTheManagerAccount() 
	{
		Account account = new Account(250000,AccountProperties.TITANIUM, 0, 0);
		setAccount(account);
	}	
	
	//Print a message of the info of the person = BankManager.
	@Override
	public String toString() 
	{
		return super.toString() + "BankManager [usersToApprove=" + ", index=" + index
				+ ", accProperties=" + accountProperties + "]";
	}
}