package tuition_calculator;

/**
 * 
 @author Aileen Wu, Rishika Bandamede
*/
public class Student {
	private Profile profile;
	
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
