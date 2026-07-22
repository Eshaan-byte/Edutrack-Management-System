package menu;

import model.Courses;
import model.Student;
import service.CourseService;
import service.StudentService;

import java.util.Scanner;

public class CourseMenu {
    private final Scanner sc;

    private final CourseService courseService;

    public CourseMenu(Scanner sc, CourseService courseService) {
        this.sc = sc;
        this.courseService = courseService;
    }
    private void displayCourseMenu(){
        System.out.println();
        System.out.println("==============================================");
        System.out.println("Edutrack - Course Menu");
        System.out.println("==============================================");
        System.out.println("1. Add Course");
        System.out.println("2. Search Course");
        System.out.println("3. Display all Courses");
        System.out.println("4. Update Course");
        System.out.println("5. Remove Course");
        System.out.println("6. Assign Teacher to course");
        System.out.println("7. Enroll students in course");
        System.out.println("8. Display students of course");
        System.out.println("9. Display course teacher");
        System.out.println("0. Exit");
    }
    public void courseMenu(){
        int choice;
        do {
            displayCourseMenu();
            System.out.println("Enter your choice ");
            choice=sc.nextInt();
            if(choice==1){
                addCourse(sc,courseService);
            }
            else if (choice==2) {
                searchCourse(sc, courseService);
            } else if (choice==3) {
                courseService.displayAllCourses();
            } else if (choice ==4) {
                updateCourses(sc, courseService);
            } else if (choice==5) {
                removeCourses(sc, courseService);
            } else if (choice==6) {
                assignTeacher(sc, courseService);
            } else if (choice==7) {
                enrollStudent(sc, courseService);
            } else if (choice==8) {
                displayStudentOfCourse(sc, courseService);
            }else if (choice==9) {
                displayCourseTeacher(sc, courseService);
            }
            else if (choice ==0) {
                System.out.println("Exiting Edutrack......");
            } else{
                System.out.println("Invalid please try again");
            }
        } while (choice != 0 );
    }


    //int id, String name, String email, int phoneNumber, int age, double feesPaid
    private void addCourse(Scanner sc, CourseService courseService){
        System.out.println("-Add Course");
        System.out.print("Enter course id ");
        String id = sc.nextLine();
        sc.nextLine();

        System.out.println("Enter course name");
        String courseName=sc.nextLine();

        System.out.println("Enter your course fees");
        double feesPaid=sc.nextDouble();

        System.out.print("Enter duration in months ");
        int duration = sc.nextInt();

        Courses courses =  new Courses(id,courseName,feesPaid,duration);
        courseService.addCourse(courses);

    }
    private void searchCourse(Scanner sc, CourseService courseService){
        System.out.print("Enter course id ");
        String id = sc.nextLine();
        courseService.displayCourseById(id);

    }

    //String courseId, String courseName, double courseFees, int durationMonths
    private void updateCourses(Scanner sc, CourseService courseService){
        System.out.print("Enter course id ");
        String id = sc.nextLine();
        System.out.print("Enter course name ");
        String courseName = sc.nextLine();
        System.out.print("Enter course fees ");
        double feesPaid=sc.nextDouble();
        System.out.print("Enter duration in months ");
        int duration = sc.nextInt();
        courseService.updateCourse(id,courseName,feesPaid,duration);
    }
    private void removeCourses(Scanner sc,CourseService courseService){
        System.out.print("Enter course id ");
        String id = sc.nextLine();
        courseService.removeCourse(id);
    }

    public void assignTeacher(Scanner sc,CourseService courseService){
        System.out.print("Enter course id ");
        String courseId = sc.nextLine();
        sc.nextLine();
        System.out.println("Enter teacher id");
        int teacherId = sc.nextInt();
        courseService.assignTeacher(courseId,teacherId);
    }
    private void displayCourseTeacher(Scanner sc, CourseService courseService) {
        System.out.print("Enter course id ");
        String courseId = sc.nextLine();
        courseService.displayCourseTeacher(courseId);
    }

    private void displayStudentOfCourse(Scanner sc, CourseService courseService) {
        System.out.print("Enter course id ");
        String courseId = sc.nextLine();
        courseService.displayStudentsOfCourses(courseId);

    }

    private void enrollStudent(Scanner sc, CourseService courseService) {
        System.out.print("Enter course id ");
        String courseId = sc.nextLine();
        sc.nextLine();
        System.out.println("Enter student id");
        int studentId = sc.nextInt();
        courseService.enrollStudent(courseId, studentId);

    }


}
