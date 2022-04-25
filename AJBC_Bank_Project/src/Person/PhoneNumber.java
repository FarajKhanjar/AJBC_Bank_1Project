package Person;

import java.util.Objects;

//import java.util.Random;

public class PhoneNumber 
{
	private String areaCode;
	private String restNumber;
	
	//Random random = new Random();
	
	public PhoneNumber(String areaCode, String restNumber) 
	{
		this.areaCode = areaCode;
		this.restNumber = restNumber;
	}
	
	public void setAreaCode(String areaCode) 
	{
		this.areaCode = areaCode;
	}
	
	public void setPhoneNumber(String restNumber) 
	{
		this.restNumber = restNumber;
	}
	
	public String getPhoneNumber()
	{
		return String.format(areaCode+"-"+restNumber);
    }
	
	/**
	 * In this method I build the full phonenumber
	 * @param String phoneNumber
	 * @return the full phonenumber in type "PhoneNumber"
	 */
	public static PhoneNumber getFullPhoneNumber(String phoneNumber) 
	{
		return new PhoneNumber("","");
	}
	

	/**
	 * Check if the phoneNumber is equal to the input phoneNumber. using Objects class.
	 */
	@Override
	public boolean equals(Object phoneNumber) 
	{
		if (this == phoneNumber)
			return true;
		if (phoneNumber == null)
			return false;
		if (getClass() != phoneNumber.getClass())
			return false;
		PhoneNumber other = (PhoneNumber) phoneNumber;
		return Objects.equals(restNumber, other.restNumber) && Objects.equals(areaCode, other.areaCode);
	}
		
}

