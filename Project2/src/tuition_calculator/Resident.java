package tuition_calculator;

/**
 * Is an instance of Student.
 * Represents a student that lives in the US.
 @author Aileen Wu, Rishika Bandamede
*/
public class Resident extends Student {
	private static final int residentFullTuition = 12536;
	private static final int residentPartTuition = 404;
	
	public Resident(String name, Major major, double tuition, int credits, int lastPayment, Date lastPaymentDue, boolean isFullTime, boolean isStudyingAbroad) {
		super(name, major, tuition, credits, lastPayment, lastPaymentDue, isFullTime, isStudyingAbroad);
		tuitionDue();
	}

	
	/**
	 * Returns the Resident object into a string.
	 @return super.toString() + "resident"
	*/
	@Override
	public String toString()
	{
		return super.toString() + "resident";
	}
	
	/**
	 * Prints the tuition of a resident student.
	*/
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
