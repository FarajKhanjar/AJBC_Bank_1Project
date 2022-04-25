package Person;

/*import java.util.Random;

public final class PhoneNumber 
{
    private final int area;   // area code (3 digits)
    private final int mid;   // exchange  (3 digits)
    private final int last;    // extension (4 digits)
    Random random = new Random();

    public PhoneNumber() 
    {
        this.area = random.nextInt(900)+100;
        this.mid = random.nextInt(643)+100;
        this.last  = random.nextInt(9000)+1000;
    }
    
    public void getPhoneNumber()
	{
    	System.out.println(area+"-"+mid+"-"+last);
    }

}
*/

public class PhoneNumber 
{

	private int areaCode;
	private float number;
	
	public PhoneNumber(int areaCode, float number) {
		super();
		this.areaCode = areaCode;
		this.number = number;
	}
	
	public int getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}
	public float getPhoneNumber() {
		return number;
	}
	public void setPhoneNumber(float number) {
		this.number = number;
	}
}

