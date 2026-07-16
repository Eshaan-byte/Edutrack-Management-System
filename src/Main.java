import jdk.jshell.SourceCodeAnalysis;
import model.Student;
import service.StudentService;
import serviceImpl.StudentServiceImpl;

import java.util.HashMap;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Student> studentHashMap = new HashMap<>();
        StudentService studentService = new StudentServiceImpl(studentHashMap);
        int choice;
        do {
            displayStudentMenu();
            System.out.println("Enter your choice ");
            choice=sc.nextInt();
            if(choice==1){
                addStudent(sc,studentService);
            }
            else if (choice==2) {
                searchStudent(sc, studentService);
            } else if (choice==3) {
                studentService.displayAllStudent();
            } else if (choice ==4) {
                updateStudents(sc, studentService);
            } else if (choice==5) {
                removeStudents(sc, studentService);
            } else if (choice ==0) {
                System.out.println("Exiting Edutrack......");
            } else{
                System.out.println("Invalid please try again");
            }
        } while (choice != 0 );
        sc.close();
    }
    private  static void displayStudentMenu(){
        System.out.println();
        System.out.println("==============================================");
        System.out.println("Edutrack - Student");
        System.out.println("==============================================");
        System.out.println("1. Add Student");
        System.out.println("2. Search Student");
        System.out.println("3. Display all students");
        System.out.println("4. Update Student marks");
        System.out.println("5. Remove students");
        System.out.println("0. Exit");
    }
    //int id, String name, String email, int phoneNumber, int age, double feesPaid
    private  static void addStudent(Scanner sc, StudentService studentService){
        System.out.println("-Add Student");
        System.out.print("Enter student id ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter your name");
        String name=sc.nextLine();

        System.out.println("Enter your email");
        String email =sc.nextLine();

        System.out.println("Enter your phoneNumber");
        int phoneNumber= sc.nextInt();

        System.out.println("Enter your age");
        int age= sc.nextInt();

        System.out.println("Enter your fees paid");
        double feesPaid=sc.nextDouble();

        Student student = new Student(id,name,email,phoneNumber,age,feesPaid);
        studentService.addStudent(student);

    }
    private static void searchStudent(Scanner sc, StudentService studentService){

    }
    private static void updateStudents(Scanner sc, StudentService studentService){

    }
    private static void removeStudents(Scanner sc,StudentService studentService){

    }
}