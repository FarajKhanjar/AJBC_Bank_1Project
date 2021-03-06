package Menus;

import java.util.Scanner;

import AccountOwner.AccountOwner;
import AppManager.AppManager;
import AppManager.OpenAccount;
import Person.PhoneNumber;

public class OwnerMenu 
{
	public static Scanner scanner = new Scanner(System.in);
	
	public static void welcomeOwnerMessage(String username) 
	{
		System.out.println("\n\nHello "+username+" :) \n" 
                +"Here you can show our Menu activities,\n" 
	             + "Select what you are looking for:");
		ownerMenu(); 
	}
	
	public static void ownerMenu() 
	{
		System.out.println("\n1. Check Bank Balance\n"  
	                       + "2. Make a deposit\n" 
	                       + "3. Make a Withdrawal\n" 
	                       + "4. Transfer funds\n" 
				           + "5. Pay bill\n" 
	                       + "6. Get Loan\n" 
				           + "7. Produce Activity Report\n" 
	                       + "8. LogOut & Back to main menu"); 
		ownerMenuActions();
	}

	
	public static void ownerMenuActions()
	{
		final int EXIT = 8;
		int choice = scanner.nextInt();
		PhoneNumber phoneNumber;
		while (choice != EXIT)
		{
			switch (choice)
			{
			case 1:
				AppManager.currentUser.checkBalance();
				break;
			case 2:
				AppManager.currentUser.deposit();
				break;
			case 3:
				AppManager.currentUser.withdrawal();
				break;
			case 4:
				System.out.println("Enter phone number of receiver:");
				phoneNumber = OpenAccount.getPhoneFromInput();
				AccountOwner receiver = OpenAccount.getOwnerByPhoneNumber(phoneNumber);
				if (receiver == null)
				{
					System.out.println("We didnt fount this user in our system, try again!");
					break;
				}
				AppManager.currentUser.transferFunds();
				break;
			case 5:
				AppManager.currentUser.payBill();
				break;
			case 6:
				AppManager.currentUser.loanRequest();
				break;
			case 7: 
				System.out.println("Enter start date for report:");
				AppManager.currentUser.produceReport();
				break;
			default:
				break;
			}
			moreOwnerActionMessage();
			choice = scanner.nextInt();
			scanner.nextLine();
		}
		AppManager.currentUser.logout();
		WelcomeMenu.bankMenu();
		choice = scanner.nextInt();
		scanner.nextLine();
	}
	
	public static void moreOwnerActionMessage() 
	{
		System.out.println("\nHow can we help you right now? :)");
		ownerMenu(); 
	}
}