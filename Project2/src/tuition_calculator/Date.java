package project;
import java.util.StringTokenizer;
import java.util.Calendar;

/**
 * The Date class represents a student's payment date for their tuition in year, month, and day form.
 * It is necessary to check whether or not the date is valid before storing it in the variable.
 @author Aileen Wu, Rishika Bandamede
*/
public class Date implements Comparable<Date> {
	public static final int JANUARY = 1;
	public static final int FEBRUARY = 2;
	public static final int MARCH = 3;
	public static final int APRIL = 4;
	public static final int MAY = 5;
	public static final int JUNE = 6;
	public static final int JULY = 7;
	public static final int AUGUST = 8;
	public static final int SEPTEMBER = 9;
	public static final int OCTOBER = 10;
	public static final int NOVEMBER = 11;
	public static final int DECEMBER = 12;
	public static final int INVALID_YEAR = 2021;
	
	private int year;
	private int month;
	private int day;
	
	/**
	 * Loaded constructor.
	 * Creates a Date object according to the parameter String date.
	 @param date		date in string form
	*/
	public Date(String date) {
		StringTokenizer st = new StringTokenizer(date,"/");
		
		this.month = Integer.parseInt(st.nextToken());
		this.day = Integer.parseInt(st.nextToken());
		this.year = Integer.parseInt(st.nextToken());
	}
	
	/**
	 * Constructor.
	 * Creates a Calendar object and uses it to get the current day, year, and month.
	 * Creates a Date object that represents the current day, year, and month.
	*/
	public Date() {
		Calendar calendar = Calendar.getInstance();
		this.day = calendar.get(Calendar.DATE);
		this.year = calendar.get(Calendar.YEAR);
		this.month = calendar.get(Calendar.MONTH) + 1;
	}
	
	/**
	 * Checks if a date is valid, which means:
	 * It is no less than 1980;
	 * January, March, May, July, August, October and December, each has 31 days; April, June, September and November, each has 30 days;
	 * February has 28 days on leap years;
	 * The month can only be between 1 and 12
	 @return true 		if the date is valid, else false
	*/
	public boolean isValid() {
		if (this.year < INVALID_YEAR || (this.compareTo(new Date()) == 1))
			return false;
		if (this.month > DECEMBER || this.month < JANUARY)
			return false;
		if (this.month == JANUARY || this.month == MARCH || this.month == MAY || this.month == JULY || this.month == AUGUST || this.month == OCTOBER || this.month == DECEMBER)
		{
			if (this.day > 31 || this.day < 1)
				return false;	
		}
		else if (this.month == APRIL ||this.month == JUNE || this.month == SEPTEMBER || this.month == NOVEMBER)
		{
			if (this.day > 30 || this.day < 1)
				return false;
		}
		else
		{
			if (leapYear() ==  true)
			{
				if (this.day > 29 || this.day < 1)
					return false;
			}
			else
			{
				if (this.day > 28 || this.day < 1)
					return false;
			}
		}
		return true;
	}
	
	/**
	 * Returns true if the year is a leap year, else false
	 @return true 		if the year is a leap year, else false
	*/
	public boolean leapYear()
	{
		return step1();
	}
	
	/**
	 * Helper method for leapYear().
	 * Checks if the year is divisible by 4.
	 @return step 2()		if the year is divisible by 4, else calls step 5
	*/
	public boolean step1()
	{
		if (this.year % 4 == 0)
		{
			return step2();
		}
		else
		{
			return step5();
		}
	}
	
	/**
	 * Helper method for leapYear().
	 * Checks if the year is divisible by 100.
	 @return step3() 		if the year is divisible by 100, else calls step4()
	*/
	public boolean step2()
	{
		if (this.year % 100 == 0)
		{
			return step3();
		}
		else
		{
			return step4();
		}
	}
	
	/**
	 * Helper method for leapYear().
	 * Checks if the year is divisible by 400.
	 @return step4()		if the year is divisible by 400, else calls step5()
	*/
	public boolean step3()
	{
		if (this.year % 400 == 0)
		{
			return step4();
		}
		else
		{
			return step5();
		}
	}
	
	/**
	 * Helper method for leapYear().
	 * Returns true.
	 @return true
	*/
	public boolean step4()
	{
		return true;
	}
	
	/**
	 * Helper method for leapYear().
	 * Returns false.
	 @return false
	*/
	public boolean step5()
	{
		return false;
	}
	
	/**
	 * Compares two dates and returns an integer that represents which one is greater (farther in the future) than the other or if they are equal
	 @param date		date to compare to
	 @return -1			if this date is less than the parameter date, 1 if greater, and 0 if they are equal
	*/
	public int compareTo(Date date) {
		if (this.year < date.year || (this.year == date.year && this.month < date.month) || (this.year == date.year && this.month == date.month && this.day < date.day) )
		{
			return -1;
		}
		else if (this.year > date.year || (this.year == date.year && this.month > date.month) || (this.year == date.year && this.month == date.month && this.day > date.day) )
		{ 
			return 1;
		}else return 0;
	}
	
	/**
	 * Compares two dates and returns an integer that represents which one is greater (farther in the future) than the other or if they are equal
	 @return this.month + "/" + this.day + "/" + this.year		date in string form
	*/
	public String toString()
	{
		return this.month + "/" + this.day + "/" + this.year;
	}
	
	/**
	 * Testbed main method for Date class.
	*/
	public static void main(String[] args)
	{
		Date d = new Date("1/25/1970");
		System.out.println("Test case 1: " + d.isValid());
		
		Date d2 = new Date("9/30/2021");
		System.out.println("Test case 2: " + d2.isValid());
		
		Date d3 = new Date("10/26/2021");
		System.out.println("Test case 3: " + d3.isValid());
		
		Date d4 = new Date("9/26/2022");
		System.out.println("Test case 4: " + d4.isValid());
		
		Date d5 = new Date("2/29/2020");
		System.out.println("Test case 5: " + d5.isValid());
		
		Date d6 = new Date("2/29/2021");
		System.out.println("Test case 6: " + d6.isValid());
		
		Date d7 = new Date("10/32/2021");
		System.out.println("Test case 7: " + d7.isValid());
		
		Date d8 = new Date("4/31/2021");
		System.out.println("Test case 8: " + d8.isValid());
		
		Date d9 = new Date("13/26/2021");
		System.out.println("Test case 9: " + d9.isValid());
		
		Date d10 = new Date("0/26/2021");
		System.out.println("Test case 10: " + d10.isValid());
	}
}
