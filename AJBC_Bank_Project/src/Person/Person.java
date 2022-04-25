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
	private double monthlyIncome;
	
	public Person(String firstName, String lastName, int areaCode, float number, LocalDate bitrthDate) 
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber.setAreaCode(areaCode);
		this.phoneNumber.setPhoneNumber(number);
		this.bitrthDate = bitrthDate;
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

	public double getMonthlyIncome() 
	{
		return monthlyIncome;
	}

	public void setMonthlyIncome(double monthlyIncome) 
	{
		this.monthlyIncome = monthlyIncome;
	}
	
	/*
	 * public static LocalDate setRandomBirthday() 
	{
		return LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 70))));
	}
	
	public void getBirthDate()
	{
	   System.out.println("randomDate: " + this.birthDate);	
	}
	 */

}

