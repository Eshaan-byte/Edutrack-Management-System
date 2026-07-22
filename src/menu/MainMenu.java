package menu;

import service.StudentService;

import java.util.Scanner;

public class MainMenu {

    private final Scanner sc;
    private final StudentMenu studentMenu;

    private final TeacherMenu teacherMenu;

    private final CourseMenu courseMenu;

    public MainMenu(Scanner sc, StudentMenu studentMenu, TeacherMenu teacherMenu, CourseMenu courseMenu) {
        this.sc = sc;
        this.studentMenu = studentMenu;
        this.teacherMenu = teacherMenu;
        this.courseMenu = courseMenu;
    }

    public void start(Scanner sc, StudentService studentService){
        int choice;
        do {
            displayMainMenu();
            System.out.println("Enter your choice ");
            choice=sc.nextInt();
            if(choice==1){
                studentMenu.studentMenu();
            }
            else if (choice==2) {
                teacherMenu.teacherMenu();
            } else if (choice==3) {
                courseMenu.courseMenu();
            } else if (choice ==4) {
                System.out.println("Attendance module is not ready");
            }
             else if (choice ==0) {
                System.out.println("Exiting Edutrack......");
            } else{
                System.out.println("Invalid please try again");
            }
        } while (choice != 0 );
    }



    private void displayMainMenu(){
        System.out.println();
        System.out.println("==============================================");
        System.out.println("Edutrack");
        System.out.println("==============================================");
        System.out.println("1. Student Menu");
        System.out.println("2. Teacher Menu");
        System.out.println("3. Course Menu");
        System.out.println("4. Attendance Menu");
        System.out.println("0. Exit");
    }

}
