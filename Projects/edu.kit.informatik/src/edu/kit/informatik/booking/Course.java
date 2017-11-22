package edu.kit.informatik.booking;


/**
 * A course offered at an educational institution.
 * 
 * @author Philipp Merkle <programmieren-vorlesung@ipd.kit.edu>
 * @author Ahmad Beidas
 * 
 * @version 0.1
 */
public class Course {

    private String name;

    private int number;

    private int ects;

    private CourseType type;
    

    public Course(String name, int number, int ects, CourseType type) {
        this.name = name;
        this.number = number;
        this.ects = ects;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public int getEcts() {
        return ects;
    }

    public CourseType getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }

    public void setType(CourseType type) {
        this.type = type;
    }
    public String toString() {
        String result = name + ":" + number;
        return result;
    }

}
