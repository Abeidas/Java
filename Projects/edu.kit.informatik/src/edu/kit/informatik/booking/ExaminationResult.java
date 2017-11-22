package edu.kit.informatik.booking;


/**
 * The result of a course exam expressed as a grade between 1.0 and 5.0.
 * <p>
 * In order to prevent precision issues, this class represents the grade as an integer number. 100 corresponds to 1.0,
 * 130 corresponds to 1.3, and so on.
 * <p>
 * Grade 1.0 through 4.0 means <em>passed</em>. Grade 5.0 means the exam has <em>not been passed</em>.
 * 
 * @author Philipp Merkle <programmieren-vorlesung@ipd.kit.edu>
 * @author Ahmad Beidas
 * 
 * @version 0.1
 *
 */
public class ExaminationResult {

    private int grade;
    
    private Course course;

    /**
     * Constructs an examination result. The result is <em>immutable</em>, i.e. once constructed you cannot change the
     * {@code grade} or the {@code course}.
     * 
     * @param grade
     *            valid grades are numbers 1.0, 1.3, 1.7, 2.0, ..., 4.0, 5.0. Grades 4.3 or 4.7 do not exist.
     * @param course
     *            the course the grade refers to.
     */
    public ExaminationResult(int grade, Course course) {
        this.grade = grade;
        this.course = course;
    }

    /**
     * @return {@code true}, if the grade is 4.0 or below; {@code false} otherwise.
     */
    public boolean passed() {
        if( grade <= 4.0 && grade >= 0.0) {
            return true;
        }
        return false;
    }
 
    /**
     * Returns the grade a student achieved in a course exam. Remember that returned grades are multiplied by 100 to
     * work around potential double precision issues.
     * 
     * @return the grade of the examination, multiplied by 100 to obtain an {@code int}.
     */
    public int getGrade() {
        return grade;
    }

    /**
     * @return the {@link Course} this grade refers to.
     */
    public Course getCourse() {
        return course;
    }
    public String toString() {
        String result =  course.getName() + ":" + grade;
        return result;
    }
    }


