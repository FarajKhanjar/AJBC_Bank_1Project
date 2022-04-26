package Person;

import java.util.Objects;

/**
 * In this class we create a phoneNumber
 * @author Faraj
 *
 */
public class PhoneNumber 
{
	//Fields:
	private String areaCode;
	private String restNumber;
	
	//Contractor:
	public PhoneNumber(String areaCode, String restNumber) 
	{
		this.areaCode = areaCode;
		this.restNumber = restNumber;
	}
	
	
	/**
	 * Get and Set method help us to get values of the fields or set a new values.
	 *
	 */	
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