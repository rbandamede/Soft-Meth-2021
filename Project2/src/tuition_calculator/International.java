package tuition_calculator;

/**
 * 
 @author Aileen Wu, Rishika Bandamede
*/
public class International extends NonResident{
	private static final int internationalFullTuition = 29737;
	private static final int additionalFee = 2650;

	
	@Override
	public String toString()
	{
		
	}
	
	@Override
	public void tuitionDue()
	{
		
//		if (this.getProfile().isStudyingAbroad() == true)
//			this.getProfile().setTuition(this.getProfile().getTuition() - 29737);
		if(profile.getIsStudyingAbroad() == true)
			this.getProfile().setTuition(universityFee + additionalFee);
		else this.getProfile().setTuition(internationalFullTuition + universityFee + additionalFee);
	}
}
