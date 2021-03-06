package Menus;

import java.util.Scanner;

import AppManager.AppManager;
import AppManager.LoginAccount;
import AppManager.OpenAccount;
import BankManager.BankManager;

public class WelcomeMenu 
{	
	public static Scanner scanner = new Scanner(System.in);
	
	public static void welcomeMessage() 
	{
		System.out.println("You are welcome to our AJBC Bank :)");		
		bankMenu();
	}
	
	/**
	 * The first Menu is the three actions of login, logout, and create new account.
	 * here the user will enter a number input and the system will do the action.
	 */
	public static void bankMenu() 
	{
		System.out.println("===================================");
		System.out.println("How our servise can help you? :)");
		System.out.println("=============================");
		System.out.println("1. Login\n"+ "2. Open Account\n" + "3. Exit");
		int choice = scanner.nextInt();
		bankMenuActions(choice);
	}
	
	/**
	 * With the help of Switch-case the system will go the action that the user choose as input.
	 * @param choice is the input that selected by the user, actually its the the action from the menu.
	 */
	public static void bankMenuActions(int choice)
	{		
		final int ENTER = 1;
		final int NEW = 2;
		final int EXIT = 3;
		String inputUsername, inputPassword;
		
		while (choice != EXIT)
		{
			switch (choice)
			{
			
			case ENTER:
			{
				inputUsername = OpenAccount.getUsernameRegistration();
				inputPassword = OpenAccount.getPasswordRegistration();
				AppManager.currentUser = LoginAccount.login(inputUsername, inputPassword);
				if (AppManager.currentUser != null)
				{
					if (AppManager.currentUser instanceof BankManager) //check if the login account is the bank manager.
					{
						ManagerMenu.managerMenu();
					}
					else
					{
						OwnerMenu.welcomeOwnerMessage(inputUsername);
					}
				}
				break;
			}
			
			case NEW:
			{
				OpenAccount.openAccount();
				break;				
			}
			default:
				break;
			}
			bankMenu();
			choice = scanner.nextInt();
			scanner.nextLine();
		}
		System.out.println("Bye Bye :)");
	}	
}