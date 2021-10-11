package tuition_calculator;

/**
 * Keeps tracks of a student's information.
 * Includes methods that can view and modify their information.
 @author Aileen Wu, Rishika Bandamede
*/
public class Profile {
	private String name;
	private Major major; //5 majors and 2-charater each: CS, IT, BA, EE, ME
	private double tuition;
	private int credits;
	private int lastPayment;
	private Date lastPaymentDate;
	private boolean isFullTime;
	private boolean isStudyingAbroad;
	
	/**
	 * Loaded constructor of Profile class.
	 * @param name				student's name
	 * @param major				student's major
	 * @param tuition			student's tuition
	 * @param credits			student's credit hours
	 * @param lastPayment		student's last payment amount
	 * @param lastPaymentDue	student's last payment due date
	 * @param isFullTime		student's full time status
	 * @param isStudyingAbroad	student's study abroad status
	*/
	public Profile(String name, Major major, double tuition, int credits, int lastPayment, Date lastPaymentDue, boolean isFullTime, boolean isStudyingAbroad) {
		this.name = name;
		this.major = major;
		this.tuition = tuition;
		this.credits = credits;
		this.lastPayment = lastPayment;
		this.lastPaymentDate = lastPaymentDue;
		this.isFullTime = isFullTime;
		this.isStudyingAbroad = isStudyingAbroad;
	}
	
	/**
	 * Gets the name of a student.
	 * @return name		student's name
	*/
	public String getName()
	{
		return name;
	}
	
	/**
	 * Gets the major of a student.
	 * @return major		student's major
	*/
	public Major getMajor()
	{
		return major;
	}
	
	/**
	 * Gets the tuition of a student.
	 * @return tuition		student's tuition
	*/
	public double getTuition()
	{
		return tuition;
	}
	
	/**
	 * Sets the tuition of a student to the specified input.
	 * @param tuition		tuition to set to
	*/
	public void setTuition(double tuition)
	{
		this.tuition = tuition;
	}
	
	/**
	 * Gets the credit hours of a student.
	 * @return credits		student's credit hours
	*/
	public int getCreditHours()
	{
		return credits;
	}
	
	/**
	 * Sets the credit hours of a student.
	 *
	*/
	public void setCreditHours(int hours)
	{
		this.credits = hours;
	}
	
	/**
	 * Gets the last payment of a student.
	 * @return lastPayment		student's last payment
	*/
	public int getLastPayment()
	{
		return lastPayment;
	}
	
	/**
	 * Sets the last payment of a student to the specified input.
	 * @param payment		payment to set to
	*/
	public void setLastPayment(String payment)
	{
		this.lastPayment = Integer.parseInt(payment);
	}
	
	/**
	 * Gets the last payment date of a student.
	 * @return lastPaymentDate		student's last payment date
	*/
	public Date getLastPaymentDate()
	{
		return lastPaymentDate;
	}
	
	/**
	 * Sets the last payment date of a student to the specified input.
	 * @param date		date to set to
	*/
	public void setLastPaymentDate(String date)
	{
		Date setDate = new Date(date);
		this.lastPaymentDate = setDate;
	}
	
	/**
	 * Checks if the student is a full time student or not.
	 * @return true 	if the student is full time, else false
	*/
	public boolean isFullTime()
	{
		return isFullTime;
	}
	
	/**
	 * Gets the study abroad status of a student.
	 * @return isStudyingAbroad		student's study abroad status
	*/
	public boolean getIsStudyingAbroad()
	{
		return isStudyingAbroad;
	}
	
	/**
	 * Sets the study abroad status of a student.
	 * @param isStudyingAbroad		study abroad status to set to
	*/
	public void setIsStudyingAbroad(boolean isStudyingAbroad)
	{
		this.isStudyingAbroad = isStudyingAbroad;
	}
}
