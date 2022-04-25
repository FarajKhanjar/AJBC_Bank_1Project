package Runner;

import java.util.Scanner;

import AppManager.AppManager;

public class Menu 
{
	
	public int runner() 
	{
		
		Scanner sc = new Scanner(System.in);
		  while(true) {
		    showMenu();
		    int opt = Integer.parseInt(sc.next());
		    if(opt == 0)
		      break;
		    return opt;
		  }
		return 0;
		
	}
	
	public void showMenu() 
	{
		  System.out.println("Please select a action you want to perform:");
		  System.out.println("1. Open Account\n" + "2. Login Use\n" + "3. Check Balance\n" + "4. Produce Activity Report\n"
		+ "5. Make a deposit\n" + "6. Withdrawal\n" + "7. Transfer funds\n" + "8. Pay bill\n" + "9. Get Loan");
	}

}
