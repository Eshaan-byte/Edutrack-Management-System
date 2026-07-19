package service;

import model.Student;
import model.Teacher;

public interface TeacherService {

    boolean addTeacher(Teacher teacher);

    Teacher getTeacherById(int teacherId);

    void displayTeacherById(int teacherId);

    void displayAllTeachers();

    boolean updateTeacher(int teacherId, String subject, double salary, int experience);

    boolean removeTeacher(int teacherId);
}
