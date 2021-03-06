package BankManager;

import AccountOwner.Account;
import AccountOwner.AccountOwner;
import AccountOwner.AccountProperties;
import AccountOwner.ActivityData;
import AccountOwner.ActivityName;
import AccountOwner.Credentials;
import Person.PhoneNumber;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * The BankManager class is create and give us a basic info of the bank manager from "Person" class,
 * The bank manager are responsible of Approve users to enter the bank, and change details
 * @author Faraj
 */
public class BankManager extends AccountOwner
{	
	//Fields
	public AccountOwner[] usersToApprove;
	public int index;
	protected int numUsersToApprove;
	public AccountProperties accountProperties;
			
	/**
	 * Contractor
	 * @param firstName of the BankManager
	 * @param lastName of the BankManager
	 * @param phoneNumber of the BankManager
	 * @param birthDate of the BankManager , LocalDate.
	 * @param credentials of the BankManager. userName and password.
	 */
	public BankManager(String firstName, String lastName, PhoneNumber phoneNumber, LocalDate birthDate, Credentials credentials) 
	{
		super(firstName, lastName, phoneNumber, birthDate, credentials, 0);
		this.usersToApprove = new AccountOwner[100];
		this.index = 0;
		createTheManagerAccount();
	}
	
	/**
	 * In this method we will create the BankManager account.
	 * It was decided that the manager doesn't have a Interest-Rate and Operation-Fee.
	 */
	private void createTheManagerAccount() 
	{
		double managerBalance = 350000;
		double managerInterestRate = 0;
		double managerOperationFee = 0;
		
		Account account = new Account(managerBalance, AccountProperties.TITANIUM, managerInterestRate, managerOperationFee, null);
		setAccount(account);
	}	

	/**
	 * Each new account that opened in the system will entered to an array.
	 * the users array length will be increased in accordance.
	 *
	 */
	public void setUsersToApprove(AccountOwner accountOwner)
	{
		usersToApprove[numUsersToApprove++] = accountOwner;		
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
	 * In this method will check the new account and approved a details.
	 * First of all, the system check if there is a new account to approved, if there is no users, the system print a message.
	 */
	public void setAndApproveAccount()
	{
		if (numUsersToApprove == 0)
		{
			System.out.println("There is no users waiting for approval by the manager.");
			return;
		}
		System.out.println("You have "+ numUsersToApprove +" to approve:");
		for (int i=0; i<numUsersToApprove; i++)
		{
			AccountOwner currentOwner = usersToApprove[i];
			AccountProperties currentOwnerInfo = AccountProperties.properties(currentOwner.getMonthlyIncome());
			double firstBalance = 0; //because its a new empty account
			Account newAccount = new Account(firstBalance, currentOwnerInfo,currentOwnerInfo.getIntresRateMax(),currentOwnerInfo.getFeeMax(),null);
			usersToApprove[i].setAccount(newAccount);
			
			System.out.println("Set the account #"+ i +": "+currentOwner.getFirstName()+" "+currentOwner.getLastName()
					+" to: "+currentOwnerInfo.toString());
			

		}
		numUsersToApprove = 0;
	}
	
	/**
	 * Gets loan amount that the manager has to give and withdrawal from the bank account.
	 * @param amount loan amount.
	 */
	public void getLoanFromBank(int amount) 
	{
		ActivityData activityData = new ActivityData(ActivityName.WITHDRAWAL, LocalDateTime.now(), "gave a loan", -amount);
		Account account = super.getAccount();
	
		account.setBalance(account.getBalance() - amount);
		account.addActivityLog(activityData);
	}
	
	/**
	 * Gets the fee payment and updates the balance.
	 * @param activityName  the type of the activity that was made.
	 * @param fee the amount of the payment.
	 */
	public static void makeFeeCollectionPayBill(ActivityName activityName, double fee,Account account) 
	{
		ActivityData activityData = new ActivityData(ActivityName.FEE_COLLECTION, LocalDateTime.now(), "fee paymente for: "+activityName.toString(), fee);
		//Account account = super.getAccount();
	
		account.setBalance(account.getBalance() + fee);
		account.addActivityLog(activityData);
	}
	

	//Print a message of the info of the person = BankManager.
	@Override
	public String toString() 
	{
		return super.toString() + "BankManager [usersToApprove=" + ", index=" + index
				+ ", accProperties=" + accountProperties + "]";
	}
}