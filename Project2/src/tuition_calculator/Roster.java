package tuition_calculator;

import project.Album;

public class Roster {
	private Student[] roster;
	private int size; //keep track of the number of students in the roster
	//...
	
	public Roster()
	{
		roster = new Student[4];
		size = 0;
	}
	
	public Student[] getRoster()
	{
		return roster;
	}
	
	public int getSize()
	{
		return size;
	}
	
	private void grow() {
		Student[] tempRoster = new Student[roster.length + 4];
		for(int i = 0; i < roster.length; i++) {
			tempRoster[i] = roster[i];
		}
		roster = tempRoster;
	}
	
	public boolean add(Student student) {
		if (size >= roster.length)
		{
			grow();
		}
		roster[size] = student;
		size++;
		return true;
	}
	
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

	public Student convertStringToStudent(String string)
	{
		for (int i = 0; i < roster.length; i++)
		{
			if (roster[i].getProfile().getName().equals(string))
			{
				return roster[i];
			}
		}
		return null; //student doesn't exist in roster
	}
	
	private boolean ifRosterEmpty()
	{
		if (size == 0)
		{
			System.out.println("Student roster is empty!");
			return true;
		}
		return false;
	}
	
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
