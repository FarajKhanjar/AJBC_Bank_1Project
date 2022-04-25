package AccountOwner;

import java.time.LocalDateTime;

public class ActivityData 
{
	protected ActivityName activityName;
	protected double balanceChange;
	protected LocalDateTime timeStamp;
	protected String info;
	
	public ActivityData(ActivityName activityName, LocalDateTime timeStamp, String info, double balanceChange) 
	{
		this.activityName = activityName;
		setBalanceChange(balanceChange);
		this.timeStamp = timeStamp;
		this.info = info;
	}
	

	private void setBalanceChange(double balanceChange) 
	{
		this.balanceChange = balanceChange;
	}

	@Override
	public String toString() {
		return "Activity data: [ activityName=" + activityName + ", timeStamp=" + timeStamp + ", info=" + info
				+ ", balanceChange=" + balanceChange + "]";
	}

}

