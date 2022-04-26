package AccountOwner;

import java.time.LocalDateTime;

/**
 * This class create a new data activity in the account.
 * @author Faraj
 *
 */
public class ActivityData 
{
	//Fields
	protected ActivityName activityName;
	protected double balanceChange;
	protected LocalDateTime timeStamp;
	protected String info;
	
	/**
	 * Constructor:
     * @param activityName: MAKE_PAYMENT_TRANSFER, PAY_BILL, DEPOSIT, WITHDRAWAL, GET_LOAN, FEE_COLLECTION;
	 * @param info: get info using LocalDateTime.
	 * @param balanceChange: change in balance.
	 */
	public ActivityData(ActivityName activityName, LocalDateTime timeStamp, String info, double balanceChange) 
	{
		this.activityName = activityName;
		setBalanceChange(balanceChange);
		this.timeStamp = timeStamp;
		this.info = info;
	}
	
    /**
    * The balance in some cases is changed, and this method help us to update the value
    * @param balanceChange: the new value of balance.
    */
	private void setBalanceChange(double balanceChange) 
	{
		this.balanceChange = balanceChange;
	}

	//Print a message of the info of the data activity
	@Override
	public String toString() {
		return "Activity data: [ activityName=" + activityName + ", timeStamp=" + timeStamp + ", info=" + info
				+ ", balanceChange=" + balanceChange + "]";
	}

}

