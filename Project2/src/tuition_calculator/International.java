package tuition_calculator;

/**
 * Is an instance of Student and NonResident.
 * Represents an international student.
 @author Aileen Wu, Rishika Bandamede
*/
public class International extends NonResident{
	private static final int internationalFullTuition = 29737;
	private static final int additionalFee = 2650;

	
	/**
	 * Returns the International object into a string.
	 @return !!!FILL THIS OUT!!!
	*/
	@Override
	public String toString()
	{
		
	}
	
	/**
	 * Prints the tuition of an international student.
	*/
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
