package Menus;

import java.util.Scanner;

import AppManager.AppManager;

public class ManagerMenu 
{
	public static Scanner scanner = new Scanner(System.in);
	
	public static void managerMenu()
	{
		System.out.println("1. Approve & Set accounts");
		System.out.println("2. Owner menu");
		System.out.println("3. LogOut & Back to main menu");
		int choice = scanner.nextInt();
		managerMenuActions(choice);
	}
	
	public static void managerMenuActions(int choice)
	{
	
		final int APP_SET = 1;
		final int EXIT = 3;
		while (choice != EXIT)
		{
			if (choice == APP_SET)
			{
				AppManager.bankManager.setAndApproveAccount();
			}
			else
			{
				OwnerMenu.ownerMenu();
			}
			managerMenu();
			choice = scanner.nextInt();
		}
		WelcomeMenu.bankMenu();	
		choice = scanner.nextInt();
		scanner.nextLine();
	}
}
