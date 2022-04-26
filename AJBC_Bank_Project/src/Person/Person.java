package Person;

import java.time.LocalDate;

/**
 * The Person Class its the basic class that create a person with the basic info,
 * its the "father" class of "AccountOwner".
 * @author Faraj
 */
public class Person 
{
	//Fields
	private String firstName;
	private String lastName;
	private PhoneNumber phoneNumber;
	private LocalDate bitrthDate;
	
	/**
	 * Contractor - Person class
	 * @param firstName of the person.
	 * @param lastName of the person.
	 * @param phoneNumber of the person, using the phoneNumber class.
	 * @param bitrthDate of the person. in LocalDate format.
	 */
	public Person(String firstName, String lastName, PhoneNumber phoneNumber, LocalDate bitrthDate) 
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.bitrthDate = bitrthDate;
		setPhoneNumber(phoneNumber);
	}

	/**
	 * Get an Set method help us to get values of the fields or set a new values.
	 *
	 */
	public String getFirstName() 
	{
		return firstName;
	}

	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	public String getLastName() 
	{
		return lastName;
	}

	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}

	public PhoneNumber getPhoneNumber() 
	{
		return phoneNumber;
	}
	
	public PhoneNumber getPhoneNumber(PhoneNumber phoneNumber) 
	{
		return phoneNumber;
	}

	public void setPhoneNumber(PhoneNumber phoneNumber) 
	{
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getBitrthDate() 
	{
		return bitrthDate;
	}

	public void setBitrthDate(LocalDate bitrthDate) 
	{
		this.bitrthDate = bitrthDate;
	}


	//Print a message of the info of the person.
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", PhoneNumber=" + phoneNumber
				+ ", bitrthDate=" + bitrthDate + "]";
	}
}

