package tuition_calculator;

/**
 * 
 @author Aileen Wu, Rishika Bandamede
*/
public class TriState extends NonResident{

	private String state;
	private static final int NYDiscount = 4000;
	private static final int CTDiscount = 5000;
	
	public TriState(String name, Major major, int tuition, int credits, int lastPayment, Date lastPaymentDue, boolean isFullTime, boolean isStudyingAbroad, String state) {
		super(name, major,tuition, credits,lastPayment, lastPaymentDue, isFullTime, isStudyingAbroad, state);

	}
	
	@Override
	public String toString()
	{
		return super.toString() + " (tri-state):" + state;
	}
	
	@Override
	public void tuitionDue()
	{
		if (state.equals("NY"))
		{
			if(!this.getProfile().isFullTime()) {
				this.getProfile().setTuition(nonResidentPartTuition * this.getProfile().getCreditHours() + universityPartFee - NYDiscount); 
			}else 
				this.getProfile().setTuition(nonResidentFullTuition + universityFee - NYDiscount);
		}
		else if (state.equals("CT"))
		{
			if(!this.getProfile().isFullTime()) {
				this.getProfile().setTuition(nonResidentPartTuition * this.getProfile().getCreditHours() + universityPartFee - CTDiscount); 
			}else {
				this.getProfile().setTuition(nonResidentFullTuition + universityFee - CTDiscount);
		
	}
}
