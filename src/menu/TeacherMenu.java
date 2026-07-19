package menu;

import model.Student;
import model.Teacher;
import service.StudentService;
import service.TeacherService;

import java.util.Scanner;

public class TeacherMenu {

    private final Scanner sc;
    private final TeacherService teacherService;

    public TeacherMenu(Scanner sc, TeacherService teacherService) {
        this.sc = sc;
        this.teacherService = teacherService;
    }

    private void displayTeacherMenu(){
        System.out.println();
        System.out.println("==============================================");
        System.out.println("Edutrack - Teacher Menu");
        System.out.println("==============================================");
        System.out.println("1. Add Teacher");
        System.out.println("2. Search Teacher");
        System.out.println("3. Display all Teacher");
        System.out.println("4. Update Teacher marks");
        System.out.println("5. Remove Teacher");
        System.out.println("0. Exit");
    }
    public void teacherMenu(){
        int choice;
        do {
            displayTeacherMenu();
            System.out.println("Enter your choice ");
            choice=sc.nextInt();
            if(choice==1){
                addTeacher(sc,teacherService);
            }
            else if (choice==2) {
                searchTeacher(sc, teacherService);
            } else if (choice==3) {
                teacherService.displayAllTeachers();
            } else if (choice ==4) {
                updateTeacher(sc, teacherService);
            } else if (choice==5) {
                removeTeacher(sc, teacherService);
            } else if (choice ==0) {
                System.out.println("Exiting Edutrack......");
            } else{
                System.out.println("Invalid please try again");
            }
        } while (choice != 0 );
    }
    private void addTeacher(Scanner sc, TeacherService teacherService){
        System.out.println("-Add Teacher");
        System.out.print("Enter teacher id ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter your name");
        String name=sc.nextLine();

        System.out.println("Enter your email");
        String email =sc.nextLine();

        System.out.println("Enter your phoneNumber");
        int phoneNumber= sc.nextInt();
        sc.nextLine();

        System.out.println("Enter your subject");
        String subject=sc.nextLine();

        System.out.println("Enter your salary");
        double salary=sc.nextDouble();

        System.out.println("Enter your experience");
        int experience=sc.nextInt();

        Teacher teacher = new Teacher(id,name,email,phoneNumber,subject,salary,experience);
        teacherService.addTeacher(teacher);

    }
    private void searchTeacher(Scanner sc,TeacherService teacherService ){
        System.out.print("Enter teacher id ");
        int id = sc.nextInt();
        teacherService.displayTeacherById(id);
    }

    private void updateTeacher(Scanner sc, TeacherService teacherService){
        System.out.print("Enter teacher id ");
        int id = sc.nextInt();
        System.out.print("Enter new subject ");
        String subject=sc.nextLine();
        System.out.print("Enter new salary ");
        double salary=sc.nextDouble();
        System.out.print("Enter new experience ");
        int experience=sc.nextInt();
        teacherService.updateTeacher(id, subject, salary, experience);

    }

    private void removeTeacher(Scanner sc, TeacherService teacherService){
        System.out.println("Enter teacher id");
        int id=sc.nextInt();
        teacherService.removeTeacher(id);
    }
}

//private String subject;
//
//private double salary;
//
//private  int experience;
