package tuition_calculator;

/**
 * 
 @author Aileen Wu, Rishika Bandamede
*/
public class Resident extends Student {
	private static final int residentFullTuition = 12536;
	private static final int residentPartTuition = 404;

	
	@Override
	public String toString()
	{
		return super.toString() + "resident";
	}
	
	@Override
	public void tuitionDue()
	{
		if (this.getProfile().getCreditHours() > 16)
		{
			int extra = this.getProfile().getCreditHours() - 16;
			this.getProfile().setTuition(residentFullTuition + (extra * residentPartTuition) + universityFee);
		}else this.getProfile().setTuition(residentFullTuition + universityFee);
	}
}
