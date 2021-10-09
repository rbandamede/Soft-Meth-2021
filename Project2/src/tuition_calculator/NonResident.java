package tuition_calculator;

/**
 * 
 @author Aileen Wu, Rishika Bandamede
*/
public class NonResident extends Student {
	private String state;
	protected static final int nonResidentFullTuition = 29737;
	protected static final int nonResidentPartTuition = 966;
	protected static final double universityPartFee = (0.8 * universityFee);
	


	
	public NonResident(String name, Major major, int tuition, int credits, int lastPayment, Date lastPaymentDue, boolean isFullTime, boolean isStudyingAbroad, String state) {
		super(name, major, tuition, credits, lastPayment, lastPaymentDue, isFullTime, isStudyingAbroad);
		this.state = state;
	}
	
	@Override
	public String toString()
	{
		return super.toString() + "non-resident";
	}
	
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
