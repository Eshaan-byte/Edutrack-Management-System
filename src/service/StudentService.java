package service;

import model.Student;

public interface StudentService {

    boolean addStudent(Student student);

    Student getStudentById(int studentId);

    void displayStudentById(int studentId);

    void displayAllStudent();

    boolean updateMarks(int studentId, int marks);

    boolean removeStudent(int studentId);
}
