package Runner;

import AppManager.AppManager;

public class Runner 
{			
	public static void main(String[] args) 
	{		
		AppManager bankSystem = new AppManager();
		bankSystem.start();
	}
}