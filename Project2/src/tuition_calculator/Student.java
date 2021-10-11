package tuition_calculator;

/**
 * The superclass that serves as a foundation of all students in the roster.
 @author Aileen Wu, Rishika Bandamede
*/
public class Student {
	//change to protected so subclasses can access it?
	private Profile profile;
	
	protected static final int universityFee = 3268;
		
	
	public Student(String name, Major major, double tuition, int credits, int lastPayment, Date lastPaymentDue, boolean isFullTime, boolean isStudyingAbroad) {
		this.profile = new Profile(name, major, tuition, credits, lastPayment, lastPaymentDue, isFullTime, isStudyingAbroad);
		//this.tuition = ;
	}
	
	/**
	 * Empty method to print a student's tuition.
	*/
	public void tuitionDue() {
	}
	
	/**
	 * Returns the Student object into a string.
	 @return profile.getName() + ":" + profile.getMajor() + ":" + profile.getCreditHours() + " credit hours:tuition due:" +
			 this.getProfile().getTuition() + ":last payment:" + profile.getLastPayment() + ":payment date:" + profile.getLastPaymentDate() + ":"
	*/
	@Override
	public String toString()
	{
		return profile.getName() + ":" + profile.getMajor() + ":" + profile.getCreditHours() + " credit hours:tuition due:" +
		this.getProfile().getTuition() + ":last payment:" + profile.getLastPayment() + ":payment date:" + profile.getLastPaymentDate() + ":";
	}
	
	/**
	 * Sets the profile of a student to the specified input.
	 * @param profile		profile to set to the student
	*/
	public void setProfile(Profile profile)
	{
		this.profile = profile;
	}
	
	/**
	 * Gets the profile of a student.
	 * @return profile		student's profile to get
	*/
	public Profile getProfile()
	{
		return profile;
	}
}
