import jdk.jshell.SourceCodeAnalysis;
import menu.CourseMenu;
import menu.MainMenu;
import menu.StudentMenu;
import menu.TeacherMenu;
import model.Courses;
import model.Student;
import model.Teacher;
import service.CourseService;
import service.StudentService;
import service.TeacherService;
import serviceImpl.CourseServiceImpl;
import serviceImpl.StudentServiceImpl;
import serviceImpl.TeacherServiceImpl;

import java.util.HashMap;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Student> studentHashMap = new HashMap<>();
        HashMap<Integer, Teacher> teacherHashMap= new HashMap<>();
        HashMap<String, Courses> coursesHashMap=new  HashMap<>();

        StudentService studentService = new StudentServiceImpl(studentHashMap);
        TeacherService teacherService = new TeacherServiceImpl(teacherHashMap);
        CourseService courseService = new CourseServiceImpl(coursesHashMap,studentService,teacherService);

        StudentMenu studentMenu = new StudentMenu(sc, studentService);
        TeacherMenu teacherMenu = new TeacherMenu(sc,teacherService );
        CourseMenu courseMenu = new CourseMenu(sc, courseService);
        MainMenu mainMenu = new MainMenu(sc, studentMenu, teacherMenu, courseMenu);
        mainMenu.start(sc, studentService);
        sc.close();
    }
}