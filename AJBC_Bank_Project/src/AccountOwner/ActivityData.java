package AccountOwner;

import java.time.LocalDateTime;

public class ActivityData 
{

	protected ActivityName activityName;
	protected Double balanceChange;
	protected LocalDateTime timeStamp;
	protected String info;
	
	public ActivityData(ActivityName activityName, double balanceChange, LocalDateTime timeStamp, String info) {
		super();
		this.activityName = activityName;
		this.balanceChange = balanceChange;
		this.timeStamp = timeStamp;
		this.info = info;
	}
	

	public enum ActivityName //The constant/enam values
	{
		DEPOSIT,
		WITHDRAWAL,
		GET_LOAN,
		MAKE_PAYMENT,
		TRANSFER,
		FEE_COLLECTION,
		PAY_BILL;	
	}

}

