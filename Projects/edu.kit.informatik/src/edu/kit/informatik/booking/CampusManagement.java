package edu.kit.informatik.booking;

import edu.kit.informatik.cm.SimpleArrayList;


/**
 * The central class of our simplified campus management system.
 */
public class CampusManagement {
    private String name;
    private String buildingNumber;
    private SimpleArrayList students;
public CampusManagement(String buildingNumber) {
        super();
        this.name = name;
        this.buildingNumber = buildingNumber;
        this.students = students;
    }
    public String getName() {
        return name;
    }
    public String getBuildingNumber() {
        return buildingNumber;
        }
    public void setName(String name) {
        this.name = name;
    }

    public void setBuildingNumber(String buildingNumber) {
    this.buildingNumber = buildingNumber;
    }

    public CampusManagement(SimpleArrayList students) {
        this.setStudents(students);
    }
    
    public SimpleArrayList getStudents() {
        return students;
    }
    public void setStudents(SimpleArrayList students) {
        this.students = students;
    }
    public String toString() {
        String result = name + ":" + buildingNumber;
        return result;
    }
    public static void main(String[] args) {
        
        
        System.out.println("Welcome to the faculty of informatik");
        
        }

}
