package tuition_calculator;

/**
 * 
 @author Aileen Wu, Rishika Bandamede
*/
public class TriState extends NonResident{

	private String state;
	
	@Override
	public String toString()
	{
		return super.toString() + " (tri-state):" + state;
	}
	
	@Override
	public void tuitionDue()
	{
		
	}
}
