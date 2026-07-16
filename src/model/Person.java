package model;

public class Person {
    private int id;
    private String name;
    private String email;
    private int phoneNumber;

    public  Person(){

    }
    public Person(int id, String name, String email, int phoneNumber){
        this.id = id;
        this.name= name;
        this.email= email;
        this.phoneNumber= phoneNumber;
    }
    //Getter
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public  String getEmail(){
        return  email;
    }
    public int getPhoneNumber(){
        return phoneNumber;
    }

    //Setter
    public void setId(int id){
        this.id = id;
    }
    public  void setName(String name){
        this.name= name;
    }
    public void setEmail(String email){
        this.email= email;
    }
    public  void  setPhoneNumber(int phoneNumber){
        this.phoneNumber= phoneNumber;
    }
}
