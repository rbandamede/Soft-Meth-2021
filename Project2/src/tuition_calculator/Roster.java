package tuition_calculator;

import project.Album;

/**
 * Contains Student objects that serve as records in a roster.
 * Contains methods that resize the roster, add, and delete students from the roster.
 @author Aileen Wu, Rishika Bandamede
*/
public class Roster {
	private Student[] roster;
	private int size; //keep track of the number of students in the roster
	//...
	
	/**
	 * Empty constructor for Roster class.
	*/
	public Roster()
	{
		roster = new Student[4];
		size = 0;
	}
	
	/**
	 * Returns roster variable.
	 * @return roster		collection of students
	*/
	public Student[] getRoster()
	{
		return roster;
	}
	
	/**
	 * Returns size variable.
	 * @return size		number of students in roster
	*/
	public int getSize()
	{
		return size;
	}
	
	/**
	 * Increases the size of roster by 4.
	*/
	private void grow() {
		Student[] tempRoster = new Student[roster.length + 4];
		for(int i = 0; i < roster.length; i++) {
			tempRoster[i] = roster[i];
		}
		roster = tempRoster;
	}
	
	/**
	 * Adds a student to the roster.
	 * @return true		if the student was successfully added, else false
	*/
	public boolean add(Student student) {
		if (size >= roster.length)
		{
			grow();
		}
		roster[size] = student;
		size++;
		return true;
	}
	
	/**
	 * Deletes a student to the roster.
	 * @return true		if the student was successfully deleted, else false
	*/
	public boolean remove(Student student) {
		for (int i = 0; i < roster.length; i++)
		{
			if (roster[i].getProfile().equals(student.getProfile()))
			{
				
				return true;
			}
		}
		return false; //student doesn't exist in roster
	}
	
	/**
	 * Deletes a student to the roster.
	 * @return true		if the student was successfully deleted, else false
	*/
	public boolean calculateTuition() {
		for (int i = 0; i < roster.length; i++)
		{
			roster[i].tuitionDue();
			
		}
		return true; //student doesn't exist in roster
	}
	
	
	
	/**
	 * Converts a string into a Student object that already exists in the roster.
	 * @return roster[i]		else null if the student doesn't exist in the roster
	*/
	public Student convertStringToStudent(String name, Major major)
	{
		for (int i = 0; i < roster.length; i++)
		{
			if (roster[i].getProfile().getName().equals(name) && roster[i].getProfile().getMajor().equals(major))
			{
				return roster[i];
			}
		}
		return null; //student doesn't exist in roster
	}
	
	/**
	 * Checks if the roster is empty.
	 * @return true		if the roster is empty, else false
	*/
	private boolean ifRosterEmpty()
	{
		if (size == 0)
		{
			System.out.println("Student roster is empty!");
			return true;
		}
		return false;
	}
	
	/**
	 * Prints all the students in the roster in any order.
	*/
	public void print()
	{
		if (ifRosterEmpty() == true)
			return;
		System.out.println("* list of students **");
		for (int i = 0; i < size; i++)
		{
			System.out.println(roster[i]);
		}
		System.out.println("* end of roster **");
	}
	
	/**
	 * Prints all the students in the roster ordered by name.
	*/
	public void printByNames()
	{
		if (ifRosterEmpty() == true)
			return;
		for (int i = 1; i < size - 1; i++)
		{
			Student temp = roster[i];
			while(i > 0 && roster[i-1].getProfile().getName().compareToIgnoreCase(roster[i].getProfile().getName()) > 0) {
				roster[i] = roster[i-1];
				roster[i-1] = temp;
				i--;
			}
			roster[i] = temp;
		}
		System.out.println("* list of students ordered by name **");
		for (int i = 0; i < size; i++)
		{
			System.out.println(roster[i]);
		}
		System.out.println("* end of roster **");
	}
	
	/**
	 * Only prints the students in the roster who made payments, ordered by payment date.
	*/
	public void printByPayments()
	{
		if (ifRosterEmpty() == true)
			return;
		
		Student[] paymentRoster = new Student[size];
		int counter = 0;
		for (Student student : roster)
		{
			if (student.getProfile().getLastPaymentDate() != null)
			{
				paymentRoster[counter] = student;
				counter++;
			}
		}
		
		for (int i = 1; i <= size - 1; i++)
		{
			Student temp = roster[i];
			while(i > 0 && roster[i-1].getProfile().getLastPaymentDate().compareTo(roster[i].getProfile().getLastPaymentDate()) == 1) {
				roster[i] = roster[i-1];
				roster[i-1] = temp;
				i--;
			}
			roster[i] = temp;
		}
		System.out.println("* list of students made payments ordered by payment date **");
		for (int i = 0; i < size; i++)
		{
			System.out.println(roster[i]);
		}
		System.out.println("* end of roster **");
	}
	
}
