package model;

import java.util.ArrayList;

public class Courses {

    private String courseId;
    private String courseName;
    private double courseFees;

    private Teacher teacher;

    private  int durationMonths;

    private ArrayList<Student> enrolledStudents;

    //Getter


    public Teacher getTeacher() {
        return teacher;
    }

    public int getDurationMonths() {
        return durationMonths;
    }

    public ArrayList<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public String getCourseId(){
        return courseId;
    }

    public String getCourseName(){
        return courseName;
    }

    public double getCourseFees(){
        return courseFees;
    }

    public Teacher teacher(){
        return teacher;
    }

    //Setter


    public void setDurationMonths(int durationMonths) {
        this.durationMonths = durationMonths;
    }

    public void setEnrolledStudents(ArrayList<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public  void  setCourseId(String courseId){
        this.courseId=courseId;

    }

    public void setCourseName(String courseName){
        this.courseName= courseName;
    }

    public void  setCourseFees(double courseFees){
        this.courseFees= courseFees;
    }

    public void setTeacher(Teacher teacher){
        this.teacher = teacher;
    }

    //Constructor


    public Courses(String courseId, String courseName, double courseFees, int durationMonths) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseFees = courseFees;
        this.durationMonths = durationMonths;
    }
}
