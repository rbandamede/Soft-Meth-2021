package tuition_calculator;

/**
 * 
 @author Aileen Wu, Rishika Bandamede
*/
public class Resident extends Student {
	@Override
	public String toString()
	{
		return super.toString() + "resident";
	}
	
	@Override
	public void tuitionDue()
	{
		this.getProfile().setTuition(12536);
		if (this.getProfile().getCreditHours() > 16)
		{
			int extra = this.getProfile().getCreditHours();
			this.getProfile().setTuition(12536 + (extra * 404));
		}
	}
}
