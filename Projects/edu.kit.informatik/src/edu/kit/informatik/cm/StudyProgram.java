package edu.kit.informatik.cm;

import edu.kit.informatik.booking.Course;

/**
 * A study program such as <em>informatics</em> or <em>information engineering</em>.
 * <p>
 * A study program consists of {@link Course}s, each of which is assigned a certain number of ECTS points. Once a
 * {@link Student} exceeds a certain number of required ECTS ({@link #getRequiredECTS()}), the student successfully
 * finished the study program.
 *
 * @author Philipp Merkle <programmieren-vorlesung@ipd.kit.edu>
 * @author Ahmad Beidas
 * 
 * @version 0.1
 */
public class StudyProgram {

    private String name;

    private int requiredECTS;

    private SimpleArrayList courses;

    /**
     * Constructs a study program.
     * 
     * @param name
     *            the study program's name.
     * @param requiredECTS
     *            the amount of ECTS points required for a student to finish their studies successfully.
     */
    public StudyProgram(String name, int requiredECTS) {
        this.name = name;
        this.requiredECTS = requiredECTS;
        this.courses = new SimpleArrayList();
    }

    /**
     * Adds the specified {@code course} to this study program.
     * 
     * @param course
     *            the course to be added
     */
    public void addCourse(Course course) {
        courses.add(course);
    }

    /**
     * Removes the specified {@code course} from this study program. If there is no course with the specified number,
     * this method has no effect and returns {@code false}.
     * 
     * @param number
     *            the course's number
     * @return {@code true}, if the specified course has been removed; {@code false}, if no course with the specified
     *         number could be found.
     */
    public boolean removeCourse(int number) {
        if(number < courses.getActualSize() && courses.get(number)!= null) {
            courses.remove(number);
            return true;
        }
        return false;
    }

    /**
     * @return the study program's name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the study program's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the amount of ECTS points required to pass this study program.
     */
    public int getRequiredECTS() {
        return requiredECTS;
    }

    /**
     * @param requiredECTS
     *            the amount of ECTS points required to pass this study program.
     */
    public void setRequiredECTS(int requiredECTS) {
        this.requiredECTS = requiredECTS;
    }

    /**
     * @return the courses offered in the study program.
     */
    public SimpleArrayList getCourses() {
        return courses;
    }

    /**
     * @return the number of courses offered in this study program.
     */
    public int getNumberOfCourses() {
        return courses.size();
    }

}
