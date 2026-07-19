package menu;

import model.Student;
import service.StudentService;

import java.util.Scanner;

public class StudentMenu {
    private final Scanner sc;
    private final StudentService studentService;

    public StudentMenu(Scanner sc, StudentService studentService) {
        this.sc = sc;
        this.studentService = studentService;
    }

    private void displayStudentMenu(){
        System.out.println();
        System.out.println("==============================================");
        System.out.println("Edutrack - Student Menu");
        System.out.println("==============================================");
        System.out.println("1. Add Student");
        System.out.println("2. Search Student");
        System.out.println("3. Display all students");
        System.out.println("4. Update Student marks");
        System.out.println("5. Remove students");
        System.out.println("0. Exit");
    }
    public void studentMenu(){
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
    }
    //int id, String name, String email, int phoneNumber, int age, double feesPaid
    private void addStudent(Scanner sc, StudentService studentService){
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
    private void searchStudent(Scanner sc, StudentService studentService){
        System.out.print("Enter student id ");
        int id = sc.nextInt();
        studentService.displayStudentById(id);

    }
    private void updateStudents(Scanner sc, StudentService studentService){
        System.out.print("Enter student id ");
        int id = sc.nextInt();
        System.out.print("Enter student marks ");
        int marks = sc.nextInt();
        studentService.updateMarks(id, marks);

    }
    private void removeStudents(Scanner sc,StudentService studentService){
        System.out.println("Enter student id");
        int id=sc.nextInt();
        studentService.removeStudent(id);

    }


}
