package model.enums;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum Course {
    MATH( "Mathematics", 1),
    PSY("Psychology", 2),
    SOC("Sociology", 3),
    CS("Computer Science", 4),
    EC("Economics", 5);

    private String courseName;
    private int courseCode;

    Course(String courseName, int courseCode) {
        this.courseName = courseName;
        this.courseCode = courseCode;
    }


    private static Set<Course> courses = new HashSet<>(Arrays.asList(Course.values()));

    public static void addCourse(String courseName) {
        courses.add(Course.valueOf(courseName.toUpperCase()));
    }

    public static Set<Course> getCourses() {
        return courses;
    }


    public String getCourseName() {
        return courseName;
    }

    public int getCourseCode() {
        return courseCode;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseCode(int courseCode) {
        this.courseCode = courseCode;
    }




}
