package tuition_calculator;

/**
 * 
 @author Aileen Wu, Rishika Bandamede
*/
public class NonResident extends Student {
	private String state;
	
	@Override
	public String toString()
	{
		return super.toString() + "non-resident";
	}
	
	@Override
	public void tuitionDue()
	{
		this.getProfile().setTuition(29737 + 3268);
		if (state.equals("NY"))
		{
			this.getProfile().setTuition(29737 + 3268 - 4000);
		}
		else if (state.equals("CT"))
		{
			this.getProfile().setTuition(29737 + 3268 - 5000);
		}
	}
}
