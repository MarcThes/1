package gradingSystem;


import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Marc T
 * 
 *         This class represents a grading system.
 */
public class GradingSystem {

	private static final int MAX_STUDENTS = 10;
	private static final int PASSING_GRADE = 60;
	private static Scanner scanner = new Scanner(System.in);

	public static List<Integer> getGradesFromUser(int numGrades) {
		List<Integer> grades = new ArrayList<>();
		for (int i = 0; i < numGrades; i++) {
			grades.add(getExamGradeFromUser());
		}
		return grades;
	}

	/**
	 * Main method for the grading system.
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {

		int numStudents = 0;
		boolean isValid;
		do {
			isValid = true;
			System.out.print("Enter the number of students (max " + MAX_STUDENTS + ") : ");
			try {
				numStudents = Integer.parseInt(scanner.nextLine());
				if (numStudents < 1 || numStudents > MAX_STUDENTS) {
					System.out
							.println("Invalid number of students. Please enter a number between 1 and " + MAX_STUDENTS);
					isValid = false;
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a number.");
				isValid = false;
			}
		} while (!isValid);

		Student[] students = new Student[numStudents];

		// Input student info
		for (int i = 0; i < numStudents; i++) {

			System.out.print("Enter the last name : ");
			String lastName = scanner.nextLine();

			System.out.print("Enter the first name : ");
			String firstName = scanner.nextLine();

			List<Integer> studentGrades = getGradesFromUser(3);
			students[i] = new Student(lastName, firstName, studentGrades.get(0), studentGrades.get(1),
					studentGrades.get(2));

		}

		// Display results
		for (Student student : students) {
			double averageGrade = student.calculateAverageGrade();
			GradeLetter gradeLetter = student.getGradeLetter();
			System.out.printf("Name : %s %s - Average : %.2f - Grade : %s", student.getLastName(),
					student.getFirstName(), averageGrade, gradeLetter);
			if (averageGrade >= PASSING_GRADE) {
				System.out.print(" - Success!");
			}
			System.out.println();
		}
	}

	/**
	 * Method to get the exam grade from the user.
	 * 
	 * @param scanner Scanner object to read user input
	 * @return the grade entered by the user
	 */
	public static int getExamGradeFromUser() {

		int grade;
		do {
			System.out.print("Enter the grade : ");
			grade = scanner.nextInt();
			scanner.nextLine();
		} while (grade < 0 || grade > 100);

		return grade;
	}

}
