package tuition_calculator;
import java.util.Scanner;

/**
 * 
 @author Aileen Wu, Rishika Bandamede
*/
public class TuitionManager {
	
	private final int residentAndNonResidentParams = 4;
	private final int tristateAndInternationalParams = 5;
	
	public void run()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Tuition Manager starts running.");
		
		Roster roster = new Roster();
		Student newStudent = new Student();
		while (scanner.hasNextLine())
		{
			String[] userInput = scanner.nextLine().split(",");
			if (userInput[0].equals("Q"))
			{
				scanner.close();
				System.out.println("Tuition Manager terminated.");
				return;
			}
		}
	}
	
	private boolean checkIfValid(String[] userInput, Roster roster)
	{

		
		if (userInput[0].equals("T"))
		{
			if (roster.convertStringToStudent(userInput[1]).getProfile().getTuition() > Integer.parseInt(userInput[3]))
			{
				System.out.println("Amount is greater than amount due.");
				return false;
			}
			else
			{
				roster.convertStringToStudent(userInput[1]).getProfile().setTuition(roster.convertStringToStudent(userInput[1]).getProfile().getTuition() - Integer.parseInt(userInput[3]));
			}
		}
		
		if (userInput[0].equals("F"))
		{
			
		}

		
		if (userInput[0].equals("S"))
			
		

		for (int i = 0; i < userInput.length; i++)
		{
		}
		
		if (userInput[3] == null) {
			System.out.println("Credit hours missing.");
			return false;
		}
		if (Integer.parseInt(userInput[3]) < 0) {
			System.out.println("Credit hours cannot be negative.");
			return false;
		}
		if (Integer.parseInt(userInput[3]) < 3) {
			System.out.println("Minimum credit hours is 3.");
			return false;
		}
		if (Integer.parseInt(userInput[3]) > 24) {
			System.out.println("Credit hours exceed the maximum 24.");
			return false;
		}
		
		return false;
	}
	
	private boolean checkFirst3Indexes(String[] userInput, Roster roster)
	{
		if (userInput[0] == null || userInput[1] == null) {
			System.out.println("Missing data in command line.");
			return false;
		}
		if (userInput[0].equals("AR") || userInput[0].equals("AN") || userInput[0].equals("AT") || userInput[0].equals("AI")) {
			if (roster.convertStringToStudent(userInput[1]) != null) {
				System.out.println("Student is already in the roster.");
				return false;
			}
		}
		else if (userInput[0].equals("R") || userInput[0].equals("T") || userInput[0].equals("S") || userInput[0].equals("F"))
		{
			if (roster.convertStringToStudent(userInput[1]) == null) {
				System.out.println("Student not in the roster.");
				return false;
			}
		}
		if (!contains(userInput[2])) {
			System.out.println("'" + userInput[2] + "' is not a valid major.");
			return false;
		}
		return true;
	}
	
	private boolean checkValidF(String[] userInput, Student student)
	{
		if (userInput[3] == null)
		{
			System.out.println("Missing the amount.");
			return false;
		}
		int userInputInt = Integer.parseInt(userInput[3]);
		if (userInputInt < 0 || userInputInt > 10000)
		{
			System.out.println("Invalid amount.");
			return false;
		}
		System.out.println("Tuition updated.");
		return true;
	}
	
	private boolean checkValidS(String[] userInput, Roster roster)
	{
		if (roster.convertStringToStudent(userInput[1]).isInternationalStudent)
		{
			roster.convertStringToStudent(userInput[1]).getProfile().setIsStudyingAbroad(true);
			return true;
		}
		System.out.println("")
	}
	
	
	private void p(Roster roster)
	{
		roster.print();
	}
	
	private void pn(Roster roster)
	{
		roster.printByNames();
	}
	
	private void pt(Roster roster)
	{
		roster.printByPayments();
	}
	
	public static boolean contains(String string)
	{
	    for (Major m : Major.values())
	    {
	        if (m.name().equals(string))
	        {
	            return true;
	        }
	    }
	    return false;
	}
}
