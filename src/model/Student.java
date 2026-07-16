package model;

import java.util.ArrayList;

public class Student extends  Person{
    private int age;
    private double feesPaid;

    private  String courseId;

    private int marks;

    private ArrayList<Attendance> attendanceRecords;

    //Getter


    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public ArrayList<Attendance> getAttendanceRecords() {
        return attendanceRecords;
    }

    public void setAttendanceRecords(ArrayList<Attendance> attendanceRecords) {
        this.attendanceRecords = attendanceRecords;
    }

    public int getAge() {
        return age;
    }

    public double getFeesPaid(){
        return feesPaid;
    }

    //Setter

    public  void  setAge(int age){
        this.age=age;
    }

    public  void  setFeesPaid(double feesPaid){
        this.feesPaid=feesPaid;
    }

    //Constructor

    public Student(int id, String name, String email, int phoneNumber, int age, double feesPaid){
        super(id,name, email, phoneNumber);
        this.age= age;
        this.feesPaid=feesPaid;



    }

}
