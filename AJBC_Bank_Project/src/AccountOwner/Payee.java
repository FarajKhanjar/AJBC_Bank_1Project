package AccountOwner;

/**
 * In this class we will dell with the coast values og the pay-options.
 * Its enum.
 * @author Faraj
 *
 */
public enum Payee 
{
	The_AJBC_BANK, PHONE, WATER, ELECTRIC;

	public static Payee getPayeeType(int index) 
	{
		switch (index) 
		{
		case 1:
			return The_AJBC_BANK;
		case 2:
			return PHONE;
		case 3:
			return WATER;
		case 4:
			return ELECTRIC;
		default:
			return The_AJBC_BANK;
		}
	}

	/**
	 * A method that help us get to the interested pay company/Bank that we want.
	 * @param payee, there are 4 options.
	 * @return
	 */
	public static int getIndexOfPayee(Payee payee) 
	{
		switch (payee) 
		{
		case The_AJBC_BANK:
			return 1;
		case PHONE:
			return 2;
		case WATER:
			return 3;
		case ELECTRIC:
			return 4;
		default:
			return 1;
		}
	}
}
