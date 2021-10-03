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
	
	private boolean checkIfValid(String[] userInput, Student newStudent)
	{
		for (int i = 0; i < userInput.length; i++)
		{
			
		}
	}
}
