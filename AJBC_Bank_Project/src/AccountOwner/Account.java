package AccountOwner;

import java.time.LocalDate;
import java.time.LocalDateTime;

import AppManager.AppManager;
import BankManager.BankManager;

/**
 * In This class we create an account of bank that base on many values.
 * @author Faraj
 *
 */
public class Account 
{	
	//Fields:
	protected double balance;
	protected AccountProperties accountProperties;
	protected ActivityData[] activityDataArray;	
	private double intrestRate; //TODO add it to class diagram.
	private double operationFee; //TODO add it to class diagram.
	private int index;
	private final int MAXIMUM_TRANSFER_CASH = 2000;
	private final int MAXIMUM_BILL_AMOUNT = 5000;
	protected LocalDateTime lockReleaseTime;
	private Loan loan;
	private static final int ACTIVITY_LOG_SIZE = 100;
	private int activityLogIndex;
	private BankManager bankManager;

	/**
	 * Contractor:
	 * @param balance of the account.
	 * @param accountProperties = The account type (Bronze or Silver or Gold or Titanium)
	 * @param intrestRate = a value who belongs to any bank account and based on his type.
	 * @param operationFee = a value who belongs to any bank account and based on his type.
	 */	
	public Account(double balance, AccountProperties accountProperties, double intrestRate, double operationFee,BankManager bankManager) 
	{
		this.accountProperties = accountProperties;
		activityDataArray = new ActivityData[ACTIVITY_LOG_SIZE];
		this.intrestRate = intrestRate;
		this.operationFee = operationFee;
		setBalance(balance); 
		activityLogIndex = 0;
		loan = null;
		setManager(bankManager);
	}
	
	private void setManager(BankManager bankManager) 
	{
		this.bankManager = bankManager;
	}
	
	public LocalDateTime getReleaseTime() 
	{
		return lockReleaseTime;
	}
	
	public void setLockReleaseTime(LocalDateTime lockReleaseTime) 
	{
		this.lockReleaseTime = lockReleaseTime;
	}
	
	/**
	 * After create one activity we intrested to push in a array of data activity.
	 * @param addActivityLog - in the same length of the number of users.
	 */
	public void addActivityLog(ActivityData activityData) 
	{	
		if (activityLogIndex >= ACTIVITY_LOG_SIZE) {
			System.out.println("Activity log full, can't add logs");
			return;
		}	
		activityDataArray[activityLogIndex] = activityData;
		activityLogIndex ++;
	}
	
	/**
	 * Get and Set method help us to get values of the fields or set a new values.
	 *
	 */	
	public void setBalance(double balance) 
	{
		this.balance = balance;
	}

	public double getBalance()
	{
		return balance;
	}
	
	/**
	 *  user clicks on the make a deposit button and by using an authentication 4 digits code,
	 *  he will deposit cash.
	 * @param cashAmount: its the value of money that the user want to deposit.
	 */
	public void deposit(int cashAmount) 
	{
		setBalance(balance + cashAmount);
		activityOfData(ActivityName.DEPOSIT, "none",cashAmount);
	}
	
	/**
	 * In this method we will create one activity data of one account
	 * @param activityName: MAKE_PAYMENT_TRANSFER, PAY_BILL, DEPOSIT, WITHDRAWAL, GET_LOAN, FEE_COLLECTION;
	 * @param info: get info using LocalDateTime.
	 * @param balanceChange: change in balance.
	 */
	private void activityOfData(ActivityName activityName, String info,double balanceChange) 
	{
		ActivityData activityData = new ActivityData(activityName, LocalDateTime.now() ,info ,balanceChange);
		addActivityLog(activityData);
	}
	


	
	/**
	 * In this method will check if to user able to get a cash by Withdrawal.
	 * @param cashAmount: its the value of money that the user want to Withdrawal.
	 * @return True or False and print a message.
	 */
	public boolean checkWithdrawalSelect(int cashAmount) 
	{
		boolean flag=true; //default value
		System.out.println(accountProperties.maxWithdrawal);
		System.out.println(accountProperties);
		if (accountProperties.maxWithdrawal >= cashAmount) 
		{
			setBalance(balance - cashAmount);
			activityOfData(ActivityName.WITHDRAWAL, "none", (cashAmount*(-1)));			
		} 
		else 
		{
			System.out.println("Sorry! Its the maximum daily amount.");
			flag=false;
		}
		return flag;
	}
	
	/**
	 * In this method will check if to user able to transfer a cash to another account
	 * @param cashAmount: its the value of money that the user want to Withdrawal.
	 * the balance of the account of course change if its True.
	 * @return True or False and print a message.
	 */
	public boolean transferToAnotherAccount(int cashAmount) 
	{
		if (cashAmount <= MAXIMUM_TRANSFER_CASH) 
		{
			setBalance(balance - cashAmount);
			activityOfData(ActivityName.MAKE_PAYMENT_TRANSFER, "transfer to the second user", (cashAmount*(-1)));
			return true;
		} else 
		{
			System.out.printf("Sorry! Its the maximum daily amount for transfer, ("+ MAXIMUM_TRANSFER_CASH+").");
			return false;
		}
	}
	
	/**
	 * This method show us the case that there is a account that transfer money for me
	 * @param cashAmount: its the value of money that the user want to transfer to me.
	 * the balance of the account of course change if its True.
	 */
	public void accountTransferredForMe(int cashAmount) 
	{
		setBalance(balance + cashAmount);
		activityOfData(ActivityName.MAKE_PAYMENT_TRANSFER, "transferred to me from other user", cashAmount);
	}
	
	/**
	 * In this method will check if to user able to pay a Bill.
	 * @param cashAmount: its the value of money that the user want to Withdrawal.
	 * the balance of the account of course change if its True.
	 * @param payeeType its the kind of the bill that the user want to pay:
	 * It can be The_AJBC_BANK, PHONE, WATER, ELECTRIC Company
	 * @return True or False and print a message.
	 */
	public boolean payBill(int cashAmount, String payeeType) 
	{
		if (MAXIMUM_BILL_AMOUNT>=cashAmount) 
		{
			setBalance(balance - cashAmount);
			activityOfData(ActivityName.PAY_BILL, "Payee a bill of: " + payeeType, (cashAmount*(-1)));
			return true;
		} 
		else 
		{
			System.out.printf("Sorry! Its the maximum daily amount to pay a bill, ("+MAXIMUM_BILL_AMOUNT+").");
			return false;
		}
	}
	
	/**
	 * In this method will check if to user able to get a loan
	 * @param cashAmount: its the value of money that the user want to get a loan of.
	 * the balance of the account of course change if its True.
	 * @return True or False and print a message.
	 */
	public boolean checkLoanAmount(int cashAmount) 
	{
		return cashAmount <= accountProperties.maxLoan;
	}
	
	/**
	 * If the user able to get a loan, in this method we will set the new balance and print a massage,
	 * In case the number of payments exceeds sixty, the user is prompt with a message and the operation terminates.
	 * @param cashAmount: its the value of money that the user want to get a loan of.
	 * @param paymentsNumber: 
	 */
/*	public void getLoanAmount(int cashAmount, int paymentsNumber) 
	{
		setBalance(balance + cashAmount);
		activityOfData(ActivityName.GET_LOAN, "num of the payments is: " + paymentsNumber, cashAmount);
	}
*/	
	
	/**
	 * In this method we interested to get the history of the actions in the account by a start date.
	 * @param timeStamp
	 * @return
	 */
	public ActivityData[] getHistoryFromGivenDate(LocalDateTime timeStamp) 
	{
		LocalDateTime activityTimestamp;
		int i = 0;

		while (i < index) 
		{
			activityTimestamp = activityDataArray[i].getTimeStamp();
			if (isDateAfterOrEqual(timeStamp, activityTimestamp)) {
				break;
			}
			i++;
		}

		ActivityData[] resultActivityData = new ActivityData[index - i];

		for (int j = 0; j < resultActivityData.length; j++, i++) {
			resultActivityData[j] = activityDataArray[i];
		}
		return resultActivityData;
	}
	
	// is date of timestamp2 after or equal date of timestamp1
	private boolean isDateAfterOrEqual(LocalDateTime timestamp1, LocalDateTime timestamp2) {
		LocalDate date1 = LocalDate.of(timestamp1.getYear(), timestamp1.getMonth(), timestamp1.getDayOfMonth());
		LocalDate date2 = LocalDate.of(timestamp2.getYear(), timestamp2.getMonth(), timestamp2.getDayOfMonth());

		return date2.isAfter(date1) || date2.isEqual(date1);
	}

	
	public Loan getLoan() 
	{
		return this.loan;
	}
	
	/**
	 * Creates new object of Loan class and updates the balance, and the manager.
	 * @param amount loan amount the account gets.
	 * @param numOfPayments number of payments to return the loan.
	 */
	public void getLoanAmount(int amount, int numOfPayments) 
	{
		this.loan = new Loan(amount, numOfPayments);
		System.out.printf("The amount of the monthly return: %.2f\n" , loan.getMonthlyPayment());
		setBalance(balance + amount);
		handleNewActivityData(ActivityName.GET_LOAN, "numOfPayments: " + numOfPayments, amount);
		bankManager.getLoanFromBank(amount);
	}
	
	// Creates new activities, adds them to the array, updates the balance and call the manager to take the fee collection. 
	private void handleNewActivityData(ActivityName activityName, String info, double balanceChange) 
	{
		ActivityData activityData;

		setBalance(balance - this.operationFee);
		activityData = new ActivityData(activityName, LocalDateTime.now(), info, balanceChange);
		addActivityLog(activityData);
		activityData = new ActivityData(ActivityName.FEE_COLLECTION, LocalDateTime.now(), "Fee operation to bank",
				-this.operationFee);
		addActivityLog(activityData);
		BankManager.makeFeeCollectionPayBill(activityName, this.operationFee,this);
	}
	
	public void printActivityLog() 
	{
		if (activityLogIndex <= 0) 
		{
			System.out.println("No activity log found");
			return;
		}
		
		System.out.println(activityLogIndex + " activities in log:");
		for (int i=0; i<activityLogIndex; i++)
			System.out.println(activityDataArray[i]);
	}
	
	public void printLoan() 
	{
		if (loan == null) return;
		System.out.println(loan);
	}
	
	public AccountProperties getAccountProperties() 
	{
		return accountProperties;
	}
}