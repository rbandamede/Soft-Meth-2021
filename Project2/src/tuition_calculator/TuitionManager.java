package tuition_calculator;
import java.util.Scanner;

/**
 * TuitionManager serves as the user's interface.
 * It handles the user's input and outputs data to the user.
 @author Aileen Wu, Rishika Bandamede
*/
public class TuitionManager {
	
	private final int residentAndNonResidentParams = 4;
	private final int tristateAndInternationalParams = 5;
	private final int minCreditHours = 3;
	private final int maxCreditHours = 24;
	private final int fullCreditHours = 12;
	private final int maxCreditHoursAbroad = 12;
	
	/**
	 * Runs the program and sets up the console where the user can input actions on the Roster.
	*/
	public void run()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Tuition Manager starts running.");
		
		Roster roster = new Roster();
//		Student newStudent = new Student();
		while (scanner.hasNextLine())
		{
			String[] userInput = scanner.nextLine().split(",");
			if (userInput[0].equals("Q"))
			{
				scanner.close();
				System.out.println("Tuition Manager terminated.");
				return;
			}
			checkIfValid(userInput, roster);
		}
		scanner.close();
	}
	/**
	 * Runs the program and sets up the console where the user can input actions on the Roster.
	 * @param userInput		a line of the user's input into the scanner
	 * @param roster		a list of students and their records
	 * @return true if userInput is valid, else false
	*/
	private boolean checkIfValid(String[] userInput, Roster roster)
	{

		
		if (userInput[0].equals("T")){
			if (roster.convertStringToStudent(userInput[1], getMajor(userInput[2])).getProfile().getTuition() < Integer.parseInt(userInput[3]))
			{
				System.out.println("Amount is greater than amount due.");
				return false;
			}
			else
			{
				Student student = roster.convertStringToStudent(userInput[1], getMajor(userInput[2]));
				student.getProfile().setTuition(roster.convertStringToStudent(userInput[1], getMajor(userInput[2])).getProfile().getTuition() - Integer.parseInt(userInput[3]));
				student.getProfile().setLastPaymentDate(userInput[4]);
				student.getProfile().setLastPayment(userInput[3]);
			}
		}else if (userInput[0].equals("AT") || userInput[0].equals("AI") ) {
			return checkValidATOrAI(userInput, roster);
		}else if (userInput[0].equals("AR") || userInput[0].equals("AN") ) {
			return checkValidAROrAN(userInput, roster);
		}else if (userInput[0].equals("F"))
		{
			Student stud = roster.convertStringToStudent(userInput[1], getMajor(userInput[2]));
			if(stud != null) return checkValidF(userInput, stud);
			else return false;
		}else if (userInput[0].equals("S")) {
			return checkValidS(userInput, roster);
			
		}else if (userInput[0].equals("R")) {
			if(userInput.length != 3) {
				System.out.println();
				return false;
			}else if(!studentExists(roster, userInput[1], getMajor(userInput[2]))) {
				System.out.println("Student not in the roster");
				return false;
			} 
			
			Student student = new Student(userInput[1], getMajor(userInput[2]), 0, 0, 0, null, false, false);
			roster.remove(student);
			return true;
			
		}else if(userInput[0].equals("C")) {
			roster.calculateTuition();
			System.out.println("Calculation completed.");
		}else if(userInput[0].equals("P")){
			p(roster);
		}else if(userInput[0].equals("PN")){
			pn(roster);
		}else if(userInput[0].equals("PT")){
			pt(roster);
		}else {
			System.out.println("Command '" + userInput[0] + "' not supported!");
		}
		
	}
			
		

//		for (int i = 0; i < userInput.length; i++)
//		{
//		}
//		
//		if (userInput[3] == null) {
//			System.out.println("Credit hours missing.");
//			return false;
//		}
//		if (Integer.parseInt(userInput[3]) < 0) {
//			System.out.println("Credit hours cannot be negative.");
//			return false;
//		}
//		if (Integer.parseInt(userInput[3]) < 3) {
//			System.out.println("Minimum credit hours is 3.");
//			return false;
//		}
//		if (Integer.parseInt(userInput[3]) > 24) {
//			System.out.println("Credit hours exceed the maximum 24.");
//			return false;
//		}
//		
//		return false;

	
	/**
	 * Checks the first 3 indexes of the tokenized user input to check if the inputs are valid.
	   @param userInput, roster		array of strings userInput that reprsents a line of user input, roster represents students in a roster
	*/
//	private boolean checkFirst3Indexes(String[] userInput, Roster roster)
//	{
//		if (userInput[0] == null || userInput[1] == null) {
//			System.out.println("Missing data in command line.");
//			return false;
//		}
//		if (userInput[0].equals("AR") || userInput[0].equals("AN") || userInput[0].equals("AT") || userInput[0].equals("AI")) {
//			if (roster.convertStringToStudent(userInput[1]) != null) {
//				System.out.println("Student is already in the roster.");
//				return false;
//			}
//		}
//		else if (userInput[0].equals("R") || userInput[0].equals("T") || userInput[0].equals("S") || userInput[0].equals("F"))
//		{
//			if (roster.convertStringToStudent(userInput[1]) == null) {
//				System.out.println("Student not in the roster.");
//				return false;
//			}
//		}
//		if (!contains(userInput[2])) {
//			System.out.println("'" + userInput[2] + "' is not a valid major.");
//			return false;
//		}
//		return true;
//	}
	
	private boolean studentExists(Roster roster, String name, Major major) {
		if (roster.convertStringToStudent(name, major) != null) {
			//System.out.println("Student is already in the roster.");
			return true;
		}else return false;
	}
	
	/**
	 * Checks if a student's credit hours input is valid.
	   @param creditInput		a string representation of a student's credit hours
	   @param isInternational	true if a student is international
	   @param studyAbroad		true if a student is studying abroad
	   @return true if the student's credit hours are valid, else false
	*/
	private boolean checkCreditHours(String creditInput, boolean isInternational, boolean studyAbroad) {
		try {
	        int creditHours = Integer.parseInt(creditInput);
	        if(creditHours < minCreditHours) {
				System.out.println("Minimum credit hours is " + minCreditHours);
				return false;
			}else if(creditHours > maxCreditHours) {
				System.out.println("Credit hours exceed the maximum " + maxCreditHours);
				return false;
				//CHECK THIS !!!!
			}else if(isInternational && ( (studyAbroad && creditHours > maxCreditHoursAbroad) || creditHours < fullCreditHours)){
				System.out.println("Invalid credit hours");
				return false;
			} 
			else return true;
	    } catch (NumberFormatException nfe) {
	    	System.out.println("Invalid credit hours.");
	    	return false;
	    }
		
		
		
		
	}
	
	/**
	 * Converts a student's major from a string to a Major object.
	   @param major		a student's major in string form
	   @return Major	a student's major as a Major object
	*/
	private Major getMajor(String major) {
		if(major.equalsIgnoreCase("cs")) return Major.CS;
		else if(major.equalsIgnoreCase("it")) return Major.IT;
		else if(major.equalsIgnoreCase("ba")) return Major.BA;
		else if(major.equalsIgnoreCase("ee")) return Major.EE;
		else if(major.equalsIgnoreCase("me")) return Major.ME;
		else return null;
	}
	
	/**
	 * Checks if the user input for AR or AN command is valid.
	   @param userInput		a line of the user's input into the scanner
	   @param roster		collection of students and their records
	   @return boolean		if the user input is valid, else false
	*/
	private boolean checkValidAROrAN(String[] userInput, Roster roster) {
		if(userInput.length != residentAndNonResidentParams) {
			System.out.println("Missing data in command line");
			return false;
		}else {
			if(studentExists(roster, userInput[1], getMajor( userInput[2]))) {
				System.out.println("Student is already in the roster");
				return false;
			}else if (getMajor(userInput[2]) == null) {
				System.out.println("'" + userInput[2] + "'" + " is not a valid major.");
				return false;
			}else if(!checkCreditHours(userInput[3], false, false)) {
				return false;
			}
			
			if(userInput[0].equals("AR")) {
				Resident newRes = new Resident(userInput[1], getMajor(userInput[2]),0.0, Integer.parseInt(userInput[3]),0, null, (Integer.parseInt(userInput[3]) == fullCreditHours), false);
				roster.add(newRes);
				return true;
			}else if(userInput[0].equals("AN")) {
				NonResident newNonRes = new NonResident(userInput[1], getMajor(userInput[2]), 0.0, Integer.parseInt(userInput[3]), 0.0, null, (Integer.parseInt(userInput[3]) == fullCreditHours), false, "");
				roster.add(newNonRes);
				return true;
			}
			
			return false;
			
		}
	}
	
	/**
	 * Checks if the user input for AT or AI command is valid.
	   @param userInput		a line of the user's input into the scanner
	   @param roster		collection of students and their records
	   @return boolean		if the user input is valid, else false
	*/
	private boolean checkValidATOrAI(String[] userInput, Roster roster) {
		if(userInput.length != tristateAndInternationalParams) {
			System.out.println("Missing data in command line");
			return false;
		}else {
			if(studentExists(roster, userInput[1], getMajor( userInput[2]))) {
				System.out.println("Student is already in the roster");
				return false;
			}else if (getMajor(userInput[2]) == null) {
				System.out.println("'" + userInput[2] + "'" + " is not a valid major.");
				return false;
			}else if(userInput[0].equals("AT")) {
				if(!checkCreditHours(userInput[3], false, false)) {
					return false;
				}else {
					TriState student = new TriState(userInput[1],getMajor(userInput[2]), 0, Integer.parseInt(userInput[3]), 0, null, (Integer.parseInt(userInput[3]) == fullCreditHours), false, userInput[4]);
					roster.add(student);
					return true;
				}
				
			}else if(userInput[0].equals("AI")) {
				if(Boolean.parseBoolean(userInput[4]) && checkCreditHours(userInput[3], true, true)) {
					//FIX THIS
					//International study abroads
					International student = new International(userInput[1], getMajor(userInput[2]), 0, Integer.parseInt(userInput[3]), 0, null, (Integer.parseInt(userInput[3]) == fullCreditHours), Boolean.parseBoolean(userInput[4]), "");
					roster.add(student);
					return true;
				}else if(checkCreditHours(userInput[3], true, false)) {
					//doesn't study abroad
					International student = new International(userInput[1], getMajor(userInput[2]), 0, Integer.parseInt(userInput[3]), 0, null, (Integer.parseInt(userInput[3]) == fullCreditHours), Boolean.parseBoolean(userInput[4]), null);
					roster.add(student);
					return true;
				}
			}else {
				return false;
			}
		}
		return false;
	}
	
	
	
	
	/**
	 * Returns true if the input setting a student's financial aid amount is valid, else false.
	 * Prints an error if it the amount is invalid.
	 @param userInput	a line of the user's input into the scanner
	 @param student 	the student to change the financial aid of
	 @return true		if the user input is valid, else false
	*/
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
	
	/**
	 * Returns true if the input setting a student's study abroad is valid, else false.
	 * Prints an error if it the amount is invalid.
	 @param userInput	a line of the user's input into the scanner
	 @param roster 		collection of students and their records
	 @return true		if the user input is valid, else false
	*/
	private boolean checkValidS(String[] userInput, Roster roster)
	{
		//FIGURE THIS SHIT OUT
		if (roster.convertStringToStudent(userInput[1], getMajor(userInput[2])).isInternationalStudent)
		{
			roster.convertStringToStudent(userInput[1], getMajor(userInput[2])).getProfile().setIsStudyingAbroad(true);
			if(roster.convertStringToStudent(userInput[1], getMajor(userInput[2])).getProfile().getCreditHours() > 12) {
				roster.convertStringToStudent(userInput[1], getMajor(userInput[2])).getProfile().setCreditHours(12);
			}
			roster.convertStringToStudent(userInput[1], getMajor(userInput[2])).getProfile().setLastPayment("0");
			roster.convertStringToStudent(userInput[1], getMajor(userInput[2])).getProfile().setLastPaymentDate("--/--/--");
			return true;
		}
		System.out.println("Couldn't find the international student.");
	}
	

	
	/**
	 * Prints the students in the roster in any order.
	 @param roster 		collection of students and their records
	*/
	private void p(Roster roster)
	{
		roster.print();
	}
	
	/**
	 * Prints the students in the roster sorted by names.
	 @param roster 		collection of students and their records
	*/
	private void pn(Roster roster)
	{
		roster.printByNames();
	}
	
	/**
	 * Only print the students in the roster who made payments, ordered by payment date.
	 @param roster 		collection of students and their records
	*/
	private void pt(Roster roster)
	{
		roster.printByPayments();
	}
	
	/**
	 * Checks if a string matches up with an enum Major.
	 @param string 		compared with enum Majors
	*/
//	public static boolean contains(String string)
//	{
//	    for (Major m : Major.values())
//	    {
//	        if (m.name().equals(string))
//	        {
//	            return true;
//	        }
//	    }
//	    return false;
//	}
}
