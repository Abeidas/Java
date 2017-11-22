package edu.kit.informatik.cm;

import edu.kit.informatik.booking.CourseType;
import edu.kit.informatik.booking.ExaminationResult;

/**
 * A student enrolled at and educational institution, or a student about to be enrolled.
 * <p>
 * Enrolled students have a matriuculation number. Students being enrolled might not have a matriculation number yet.
 * Use the corresponding constructor to reflect this distinction.
 * 
 * @author Philipp Merkle <programmieren-vorlesung@ipd.kit.edu>
 * @author Ahmad Beidas
 * 
 * @version 0.1
 */
public class Student {

    private String firstName;

    private String lastName;

    private int matriculationNumber;

    private StudyProgram program;

    private SimpleArrayList results;

    /**
     * Constructs a student not yet enrolled successfully. The student has not yet received a matriculation number.
     * 
     * @param firstName
     *            the student's first name
     * @param lastName
     *            the student's last name
     */
    public Student(String firstName, String lastName) {
        // this call delegates object construction to the second constructor to prevent code duplication
        this(firstName, lastName, -1);
    }

    /**
     * Constructs an enrolled student.
     * 
     * @param firstName
     *            the student's first name
     * @param lastName
     *            the the student's last name
     * @param matriculationNumber
     *            the student's matriculation number
     */
    public Student(String firstName, String lastName, int matriculationNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.matriculationNumber = matriculationNumber;
    }

    /**
     * Validates a matriculation number given as a String. A valid matriculation number is an integer number that has at
     * least 4 digits and does not exceed a maximum length of 8 digits.
     * 
     * @param matriculationNumber
     *            the matriculation number to be checked
     * @return {@code true} if the total amount of digits is in the interval [4,10]; {@code false} otherwise.
     */
    public static boolean validMatriculationNumber(String matriculationNumber) {
        if(digitCounter(Integer.parseInt(matriculationNumber)) <= 8 
                && digitCounter(Integer.parseInt(matriculationNumber)) >= 4) {
            return true;
        }
        return false;
    }

    /**
     * Returns the average grade of exams this student has passed. Converts the usual {@code int} representation to a
     * double by dividing the returned grade by 100.
     * 
     * @return the student's sum of (passed) grades, divided by the number of (passed) exams.
     */
    public double averageGrade() {
        int sum = 0;
        for( int i = 0; i < results.getActualSize(); i++) {
            sum = sum + ((ExaminationResult) results.get(i)).getGrade();
        }
        return (double) sum / 100;
    }

    /**
     * Returns the average grade of passed exams this student achieved in courses of the given {@code type}. Converts
     * the usual int representation to a double by dividing the returned grade by 100.
     * 
     * @param type
     *            the type of the courses to include into the average. Courses of other types are ignored.
     * @return the student's sum of grades in (passed) courses of the given {@code type}, divided by the number of these
     *         courses.
     */
    public double averageGrade(CourseType type) {
        return averageGrade()/results.getActualSize();
    }

    /**
     * Adds the given {@code result} to this student.
     * 
     * @param result
     *            the result to be added.
     */
    public void addResult(ExaminationResult result) {
        results.add(result);
    }

    /**
     * Calculates the sum of ECTS points from all passed exams and returns {@code true} if this sum exceeds the required
     * ECTS points of the study program (see {@link StudyProgram#getRequiredECTS()}). ECTS points from
     * {@link ExaminationResult} that have not been passed yet are excluded from this calculation.
     * 
     * @return {@code true} if the student completely passed their study program; {@code false} otherwise.
     */
    public boolean finishedStudies() {
        if( averageGrade() >= program.getRequiredECTS()) {
            return true;
        }
        return false;
    }

    /**
     * @return the student's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName
     *            the student's first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the student's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName
     *            the student's last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the student's matriculation number. Returns -1 if the student is not yet completely enrolled, i.e. has no
     *         matriculation number yet.
     */
    public int getMatriculationNumber() {
        return matriculationNumber;
    }

    /**
     * @param matriculationNumber
     *            the student's matriculation number. Should not be invoked before the student has received a
     *            matriculation number.
     */
    public void setMatriculationNumber(int matriculationNumber) {
        this.matriculationNumber = matriculationNumber;
    }
    public static int digitCounter(int number) {
        int i;
        for( i = 0; number >= 1; i++) {
            number = number/10;
        }
        return i;
    }

    /**
     * @return the study program the student is enrolled in.
     */
    public StudyProgram getProgram() {
        return program;
    }

    /**
     * @param program
     *            the study program the student is enrolled in.
     */
    public void setProgram(StudyProgram program) {
        this.program = program;
    }
    public String toString() {
        String result = firstName + lastName + ":" + matriculationNumber;
        return result;
    }

}
