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


        sc.close();
    }
}