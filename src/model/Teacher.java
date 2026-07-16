package model;

public class Teacher extends Person {
    private String subject;

    private double salary;

    private  int experience;

    //Getter

    public String getSubject(){
        return subject;
    }

    public double getSalary() {
        return salary;
    }

    public int getExperience() {
        return experience;
    }

    //Setter


    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setSubject(String subject){
        this.subject = subject;
    }

    //Constructor
    public Teacher(String subject, int id, String name, String email, int phoneNumber){
        super(id,name, email, phoneNumber);
        this.subject=  subject;
    }
}
