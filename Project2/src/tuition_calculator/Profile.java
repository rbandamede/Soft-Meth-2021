package tuition_calculator;

/**
 * 
 @author Aileen Wu, Rishika Bandamede
*/
public class Profile {
	private String name;
	private Major major; //5 majors and 2-charater each: CS, IT, BA, EE, ME
	private int tuition;
	private int credits;
	private int lastPayment;
	private Date lastPaymentDate;
	private boolean isFullTime;
	private boolean isStudyingAbroad;
	
	public String getName()
	{
		return name;
	}
	
	public Major getMajor()
	{
		return major;
	}
	
	public int getTuition()
	{
		return tuition;
	}
	
	public void setTuition(int tuition)
	{
		this.tuition = tuition;
	}
	
	public int getCreditHours()
	{
		return credits;
	}
	
	public int getLastPayment()
	{
		return lastPayment;
	}
	
	public Date getLastPaymentDate()
	{
		return lastPaymentDate;
	}
	
	public boolean isFullTime()
	{
		return isFullTime;
	}
	
	public boolean getIsStudyingAbroad()
	{
		return isStudyingAbroad;
	}
	
	public void setIsStudyingAbroad(boolean isStudyingAbroad)
	{
		this.isStudyingAbroad = isStudyingAbroad;
	}
}
