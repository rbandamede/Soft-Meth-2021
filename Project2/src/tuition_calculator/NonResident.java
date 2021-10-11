package tuition_calculator;

/**
 * Is an instance of Student.
 * Represents a nonresident student.
 @author Aileen Wu, Rishika Bandamede
*/
public class NonResident extends Student {
	//private String state;
	protected static final int nonResidentFullTuition = 29737;
	protected static final int nonResidentPartTuition = 966;
	protected static final double universityPartFee = (0.8 * universityFee);
	


	
	public NonResident(String name, Major major, double tuition, int credits, double lastPayment, Date lastPaymentDue, boolean isFullTime, boolean isStudyingAbroad, String state) {
		super(name, major, tuition, credits, lastPayment, lastPaymentDue, isFullTime, isStudyingAbroad);
//		this.state = state;
		tuitionDue();

	}
	
	/**
	 * Returns the NonResident object into a string.
	 @return super.toString() + "non-resident"
	*/
	@Override
	public String toString()
	{
		return super.toString() + "non-resident";
	}
	
	/**
	 * Prints the tuition of a non resident student.
	*/
	@Override
	public void tuitionDue()
	{
//		this.getProfile().setTuition(29737 + 3268);
		if(this.getProfile().getCreditHours() > 16) {
			int tuition = nonResidentFullTuition + ((this.getProfile().getCreditHours() - 16) * nonResidentPartTuition);
			this.getProfile().setTuition(tuition + universityFee);
		}else if(!this.getProfile().isFullTime()) {
			this.getProfile().setTuition(nonResidentPartTuition * this.getProfile().getCreditHours() + universityPartFee); 
		}else {
			this.getProfile().setTuition(nonResidentFullTuition + universityFee);
		}
		
	}
}
