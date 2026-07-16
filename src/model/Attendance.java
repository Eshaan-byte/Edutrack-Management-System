package model;

public class Attendance {
    private String date;
    private boolean present;
    private String remarks;

    private String courseId;


    //Getter

    public String getData(){
        return date;
    }

    public boolean isPresent(){

        return  present;
    }

    public  String getRemarks(){
        return remarks;
    }

    public String getCourseId(){
        return  courseId;
    }

    //Setter

    public void setData(String data){
        this.date=data;
    }

    public void setPresent(boolean present){
        this.present= present;
    }

    public void setRemarks(String remarks){
        this.remarks= remarks;
    }
    public  void setCourseId(String courseId){
        this.courseId=courseId;
    }

    //Constructor
    public Attendance(String data, boolean present, String remarks, String courseId){
        this.date = data;
        this.present = present;
        this.remarks = remarks;
        this.courseId=courseId;

    }

}
