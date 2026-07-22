package service;

import model.Courses;

public interface CourseService {

    boolean addCourse(Courses course);

    Courses getCourseById(String courseId);

    void displayCourseById(String courseId);

    void displayAllCourses();

    boolean updateCourse(String courseId, String courseName, double courseFees, int durationMonths);

    boolean removeCourse(String courseId);

    boolean enrollStudent(String courseId, int studentId);

    boolean assignTeacher(String courseId, int teacherId);

    void displayStudentsOfCourses(String courseId);

    void displayCourseTeacher(String courseId);

}
