package Person;

import java.time.LocalDate;
//import java.time.Period;
//import java.util.Random;


public class Person 
{
	private String firstName;
	private String lastName;
	private PhoneNumber phoneNumber;
	private LocalDate bitrthDate;
	//private double monthlyIncome;
	
	public Person(String firstName, String lastName, PhoneNumber phoneNumber, LocalDate bitrthDate) 
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.bitrthDate = bitrthDate;
		setPhoneNumber(phoneNumber);
	}

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


	/*
	 * public static LocalDate setRandomBirthday() { return
	 * LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 70)))); }
	 * 
	 * public void getBirthDate() { System.out.println("randomDate: " +
	 * this.birthDate); }
	 */

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", PhoneNumber=" + phoneNumber
				+ ", bitrthDate=" + bitrthDate + "]";
	}
}

