package tuition_calculator;

/**
 * Is an instance of NonResident.
 * Represents a student that lives in New York or Connecticut.
 @author Aileen Wu, Rishika Bandamede
*/
public class TriState extends NonResident{

	private String state;
	private static final int NYDiscount = 4000;
	private static final int CTDiscount = 5000;
	
	/**
	 * Loaded constructor of TriState class.
	*/
	public TriState(String name, Major major, int tuition, int credits, int lastPayment, Date lastPaymentDue, boolean isFullTime, boolean isStudyingAbroad, String state) {
		super(name, major,tuition, credits,lastPayment, lastPaymentDue, isFullTime, isStudyingAbroad, state);

	}
	
	/**
	 * Returns the TriState object into a string.
	 @return super.toString() + "resident"
	*/
	@Override
	public String toString()
	{
		return super.toString() + " (tri-state):" + state;
	}
	
	/**
	 * Prints the tuition of a tristate student.
	*/
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
