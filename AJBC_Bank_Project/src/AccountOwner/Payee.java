package AccountOwner;

/**
 * In this class we will dell with the coast values og the pay-options.
 * Its enum.
 * @author Faraj
 *
 */
public enum Payee 
{
	The_AJBC_BANK,
	PHONE_COMPANY,
	WATER_COMPANY,
	ELECTRIC_COMPANY;

	public static Payee getPayeeType(int index) 
	{
		switch (index) 
		{
		case 1:
			return The_AJBC_BANK;
		case 2:
			return PHONE_COMPANY;
		case 3:
			return WATER_COMPANY;
		case 4:
			return ELECTRIC_COMPANY;
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
		case PHONE_COMPANY:
			return 2;
		case WATER_COMPANY:
			return 3;
		case ELECTRIC_COMPANY:
			return 4;
		default:
			return 1;
		}
	}
}
