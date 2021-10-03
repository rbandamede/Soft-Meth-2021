package tuition_calculator;

public class Roster {
	private Student[] roster;
	private int size; //keep track of the number of students in the roster
	//...
	
	public Roster()
	{
		roster = new Student[4];
		size = 4;
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
	
}
