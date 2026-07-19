package serviceImpl;

import model.Student;
import service.StudentService;

import java.util.HashMap;

public class StudentServiceImpl implements StudentService {

    private final HashMap<Integer, Student> studentHashMap;

    public StudentServiceImpl(HashMap<Integer, Student> studentHashMap) {
        this.studentHashMap = studentHashMap;
    }

    @Override
    public boolean addStudent(Student student) {
        if (studentHashMap.containsKey(student.getId())){
            System.out.println("Student with Id" + student.getId()+" already exists");
            return false;
        }
        studentHashMap.put(student.getId(), student);
        System.out.println("Student added successfully");
        return true;
    }

    @Override
    public Student getStudentById(int studentId) {
        return studentHashMap.get(studentId);
    }

    @Override
    public void displayStudentById(int studentId) {
        Student student = getStudentById(studentId);
        if (student == null){
            System.out.println("Student not found");
            return;
        }
        System.out.println("Student id "+student.getId());
        System.out.println("Student email "+ student.getEmail());
        System.out.println("Student name "+ student.getName());
        System.out.println("Student age "+student.getAge());
        System.out.println("Student courseId "+ student.getCourseId());
        System.out.println("Student marks "+ student.getMarks());
        System.out.println("Student feesPaid "+ student.getFeesPaid());
        System.out.println("===========================================");


    }

    @Override
    public void displayAllStudent() {
        if (studentHashMap.isEmpty()){
            System.out.println("No students available");
        }
        System.out.println("------------------------All students-------------------------");
        for (Student student: studentHashMap.values()){
            System.out.println("Student id "+student.getId());
            System.out.println("Student email "+ student.getEmail());
            System.out.println("Student name "+ student.getName());
            System.out.println("Student age "+student.getAge());
            System.out.println("Student courseId "+ student.getCourseId());
            System.out.println("Student marks "+ student.getMarks());
            System.out.println("Student feesPaid "+ student.getFeesPaid());
            System.out.println("===========================================");


        }

    }

    @Override
    public boolean updateMarks(int studentId, int marks) {
        Student student = getStudentById(studentId);
        if (student == null){
            System.out.println("Student not found");
            return false;
        }
        student.setMarks(marks);
        return  true;
    }

    @Override
    public boolean removeStudent(int studentId) {
        Student student= studentHashMap.remove(studentId);
        if (student == null){
            return false;
        }
        return true;
    }
}
