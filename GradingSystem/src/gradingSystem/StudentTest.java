package gradingSystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * @author Marc T
 * 
 *         This class contains tests for the Student class in the gradingSystem
 *         package.
 */
class StudentTest {

	/**
	 * Test method for
	 * {@link gradingSystem.Student#Student(java.lang.String, java.lang.String, int, int, int)}.
	 */
	@Test
	void testStudent() {
		Student student = new Student("Doe", "John", 85, 90, 95);
		Assertions.assertEquals("Doe", student.getLastName());
		Assertions.assertEquals("John", student.getFirstName());
	}

	/**
	 * Test method for {@link gradingSystem.Student#getLastName()}.
	 */
	@Test
	void testGetLastName() {
		Student student = new Student("Doe", "John", 85, 90, 95);
		Assertions.assertEquals("Doe", student.getLastName());
	}

	/**
	 * Test method for {@link gradingSystem.Student#getFirstName()}.
	 */
	@Test
	void testGetFirstName() {
		Student student = new Student("Doe", "John", 85, 90, 95);
		Assertions.assertEquals("John", student.getFirstName());
	}

	/**
	 * Test method for {@link gradingSystem.Student#calculateAverageGrade()}.
	 */
	@Test
	void testCalculateAverageGrade() {
		Student student = new Student("Doe", "John", 85, 90, 95);
		double average = student.calculateAverageGrade();
		Assertions.assertEquals(90, average);
	}

	/**
	 * Test method for {@link gradingSystem.Student#getGradeLetter()}.
	 */
	@Test
	void testGetGradeLetter() {
		Student student = new Student("Doe", "John", 85, 90, 95);
		student.calculateAverageGrade();
		GradeLetter gradeLetter = student.getGradeLetter();
		Assertions.assertEquals(GradeLetter.A, gradeLetter);
	}

	/**
	 * Test method for {@link gradingSystem.Student#getGradeLetter()}.
	 */
	@Test
	void testGetGradeLetter_B() {
		Student student = new Student("Doe", "Jane", 72, 84, 85);
		double averageGrade = student.calculateAverageGrade();
		System.out.println("Average grade: " + averageGrade); // print average grade
		GradeLetter gradeLetter = student.getGradeLetter();
		System.out.println("Grade letter: " + gradeLetter); // print grade letter
		Assertions.assertEquals(GradeLetter.B, gradeLetter);
	}

	/**
	 * Test method for
	 * {@link gradingSystem.Student#Student(java.lang.String, java.lang.String, int, int, int)}.
	 * Tests that the Student constructor throws an IllegalArgumentException when
	 * given an invalid grade.
	 */
	@Test
	void testInvalidGrade() {
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Student("Doe", "Jack", -10, 100, 90);
		});

		String expectedMessage = "Invalid grade";
		String actualMessage = exception.getMessage();

		Assertions.assertTrue(actualMessage.contains(expectedMessage));
	}

	/**
	 * Test method for {@link gradingSystem.Student#getGradeLetter()} and
	 * {@link gradingSystem.Student#calculateAverageGrade()}. Tests that a student
	 * with the highest possible grades gets an A grade.
	 */
	@Test
	void testHighestPossibleGrade() {
		Student student = new Student("Doe", "John", 100, 100, 100);
		student.calculateAverageGrade();
		GradeLetter gradeLetter = student.getGradeLetter();
		Assertions.assertEquals(GradeLetter.A, gradeLetter);
	}

	/**
	 * Test method for {@link gradingSystem.Student#getGradeLetter()} and
	 * {@link gradingSystem.Student#calculateAverageGrade()}. Tests that a student
	 * with the lowest possible grades gets an F grade.
	 */
	@Test
	void testLowestPossibleGrade() {
		Student student = new Student("Doe", "John", 0, 0, 0);
		student.calculateAverageGrade();
		GradeLetter gradeLetter = student.getGradeLetter();
		Assertions.assertEquals(GradeLetter.F, gradeLetter);
	}

	/**
	 * Test method for {@link gradingSystem.Student#getGradeLetter()} and
	 * {@link gradingSystem.Student#calculateAverageGrade()}. Tests that a student
	 * with grades just above a threshold gets the correct grade.
	 */
	@Test
	void testGradeJustAboveThreshold() {
		Student student = new Student("Doe", "John", 79, 80, 81); // Assume this average falls in B grade
		student.calculateAverageGrade();
		GradeLetter gradeLetter = student.getGradeLetter();
		Assertions.assertEquals(GradeLetter.B, gradeLetter);
	}

}
