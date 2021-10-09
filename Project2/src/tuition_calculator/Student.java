package tuition_calculator;

/**
 * 
 @author Aileen Wu, Rishika Bandamede
*/
public class Student {
	//change to protected so subclasses can access it?
	private Profile profile;
	
	protected static final int universityFee = 3268;
		
	
	public Student(String name, Major major, int tuition, int credits, int lastPayment, Date lastPaymentDue, boolean isFullTime, boolean isStudyingAbroad) {
		this.profile = new Profile(name, major, tuition, credits, lastPayment, lastPaymentDue, isFullTime, isStudyingAbroad);
	}
	
	public void tuitionDue() {
	}
	
	@Override
	public String toString()
	{
		return profile.getName() + ":" + profile.getMajor() + ":" + profile.getCreditHours() + " credit hours:tuition due:" +
		this.getProfile().getTuition() + ":last payment:" + profile.getLastPayment() + ":payment date:" + profile.getLastPaymentDate() + ":";
	}
	
	public void setProfile(Profile profile)
	{
		this.profile = profile;
	}
	
	public Profile getProfile()
	{
		return profile;
	}
}
