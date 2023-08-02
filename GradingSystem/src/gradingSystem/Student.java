package gradingSystem;

/**
 * @author Marc T
 * 
 * Represents a student with their grades and calculation of the average.
 */
class Student {

	private String lastName; // Last name of the student
	private String firstName; // First name of the student

	private int exam1Grade; // Grade of exam 1
	private int exam2Grade; // Grade of exam 2
	private int exam3Grade; // Grade of exam 3

	private double averageGrade; // Average of grades

	/**
	 * Constructor for the Student class.
	 * 
	 * @param lastName   The last name of the student.
	 * @param firstName  The first name of the student.
	 * @param exam1Grade The grade of exam 1.
	 * @param exam2Grade The grade of exam 2.
	 * @param exam3Grade The grade of exam 3.
	 */
	public Student(String lastName, String firstName, int exam1Grade, int exam2Grade, int exam3Grade) {
	    if (exam1Grade < 0 || exam1Grade > 100 || exam2Grade < 0 || exam2Grade > 100 || exam3Grade < 0 || exam3Grade > 100) {
	        throw new IllegalArgumentException("Invalid grade");
	    }
	    this.lastName = lastName;
	    this.firstName = firstName;
	    this.exam1Grade = exam1Grade;
	    this.exam2Grade = exam2Grade;
	    this.exam3Grade = exam3Grade;
	}

	/**
	 * Gets the last name of the student.
	 * 
	 * @return The last name of the student.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Gets the first name of the student.
	 * 
	 * @return The first name of the student.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Calculates the average grade of the student.
	 * 
	 * @return The average grade of the student.
	 */
	public double calculateAverageGrade() {
		averageGrade = (exam1Grade + exam2Grade + exam3Grade) / 3.0;
		return averageGrade;
	}

	/**
	 * Gets the grade letter corresponding to the student's average.
	 * 
	 * @return The grade letter corresponding to the student's average.
	 */
	public GradeLetter getGradeLetter() {
		if (averageGrade == 0) {
			calculateAverageGrade();
		}
		if (averageGrade >= 90) {
			return GradeLetter.A;
		} else if (averageGrade >= 80) {
			return GradeLetter.B;
		} else if (averageGrade >= 70) {
			return GradeLetter.C;
		} else if (averageGrade >= 60) {
			return GradeLetter.D;
		} else {
			return GradeLetter.F;
		}
	}

}
