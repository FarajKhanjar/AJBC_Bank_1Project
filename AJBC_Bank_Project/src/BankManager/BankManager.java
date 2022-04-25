package BankManager;

import AccountOwner.Account;
import AccountOwner.AccountOwner;
import AccountOwner.Credentials;
import Person.Person;
import java.time.LocalDate;

public class BankManager extends AccountOwner
{
	
	static Person[] usersToApprove;
	static int index = 0;
			
	public BankManager(String firstName, String lastName, int areaCode, float number,
			LocalDate bitrthDate, Account account, double monthlyIncome, Credentials credentials) 
	{
		super(firstName, lastName, areaCode, number, bitrthDate, account, monthlyIncome, credentials);
		this.usersToApprove = new AccountOwner[100];
	}
	

	public static void setUsersToApprove(Person usersToApprove) {
		BankManager.usersToApprove[index] = usersToApprove;
		index++;
	}


	private void setAndApproveAcc() {
		
	}
	private void addUserToApprove(AccountOwner accountOwner) {
		
	}
	private void produceReport(LocalDate start) {
		
	}

}
