package serviceImpl;

import model.Courses;
import model.Student;
import model.Teacher;
import service.CourseService;
import service.StudentService;
import service.TeacherService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;

public class CourseServiceImpl implements CourseService {

    private final HashMap<String, Courses> courseHashMap;

    private final StudentService studentService;

    private final TeacherService teacherService;

    public CourseServiceImpl(HashMap<String, Courses> courseHashMap, StudentService studentService, TeacherService teacherService) {
        this.courseHashMap = courseHashMap;
        this.studentService = studentService;
        this.teacherService = teacherService;
    }

    @Override
    public boolean addCourse(Courses course) {

        if (courseHashMap.containsKey(course.getCourseId())) {
            System.out.println("Course with ID " + course.getCourseId() + " already exists");
            return false;
        }
        courseHashMap.put(course.getCourseId(), course);
        System.out.println("Course added successfully");
        return true;
    }

    @Override
    public Courses getCourseById(String courseId) {
        return courseHashMap.get(courseId);
    }

    @Override
    public void displayCourseById(String courseId) {

        Courses course = getCourseById(courseId);

        if (course == null) {
            System.out.println("Course not found");
            return;
        }

        System.out.println("Course ID " + course.getCourseId());
        System.out.println("Course Name " + course.getCourseName());
        System.out.println("Course Fees " + course.getCourseFees());
        System.out.println("Duration " + course.getDurationMonths());

        if (course.getTeacher() != null) {
            System.out.println("Teacher " + course.getTeacher().getName());
        } else {
            System.out.println("Teacher Not Assigned");
        }

        System.out.println("Enrolled Students ");
        for (int i=0;i<course.getEnrolledStudents().size();i++){
            System.out.println(course.getEnrolledStudents().get(i).getName());
        }
        System.out.println("===========================================");
    }

    @Override
    public void displayAllCourses() {

        if (courseHashMap.isEmpty()) {
            System.out.println("No courses available");
            return;
        }

        System.out.println("------------------------All Courses-------------------------");

        for (Courses course : courseHashMap.values()) {

            System.out.println("Course ID " + course.getCourseId());
            System.out.println("Course Name " + course.getCourseName());
            System.out.println("Course Fees " + course.getCourseFees());
            System.out.println("Duration " + course.getDurationMonths());

            if (course.getTeacher() != null) {
                System.out.println("Teacher " + course.getTeacher().getName());
            } else {
                System.out.println("Teacher Not Assigned");
            }
            System.out.println("Enrolled Students ");
            for (int i=0;i<course.getEnrolledStudents().size();i++){
                System.out.println(course.getEnrolledStudents().get(i).getName());
            }
            System.out.println("===========================================");
        }
    }

    @Override
    public boolean updateCourse(String courseId, String courseName, double courseFees, int durationMonths) {

        Courses course = getCourseById(courseId);

        if (course == null) {
            System.out.println("Course not found");
            return false;
        }

        course.setCourseName(courseName);
        course.setCourseFees(courseFees);
        course.setDurationMonths(durationMonths);

        System.out.println("Course updated successfully");
        return true;
    }

    @Override
    public boolean removeCourse(String courseId) {

        Courses course = courseHashMap.remove(courseId);

        if (course == null) {
            System.out.println("Course not found");
            return false;
        }

        System.out.println("Course removed successfully");
        return true;
    }

    @Override
    public boolean enrollStudent(String courseId, int studentId) {

        Courses course = getCourseById(courseId);

        if (course == null) {
            System.out.println("Course not found");
            return false;
        }
        Student student=studentService.getStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found");
            return false;
        }
        ArrayList<Student> studentArrayList= new ArrayList<>();
        studentArrayList.add(student);
        course.setEnrolledStudents(studentArrayList);
        return true;

    }


    @Override
    public boolean assignTeacher(String courseId, int teacherId) {

        Courses course = getCourseById(courseId);

        if (course == null) {
            System.out.println("Course not found");
            return false;
        }

        Teacher teacher=teacherService.getTeacherById(teacherId);
        if (teacher == null){
            System.out.println("Teacher not found");
            return false;
        }
        course.setTeacher(teacher);
        return true;
    }

    @Override
    public void displayStudentsOfCourses(String courseId) {

        Courses course = getCourseById(courseId);

        if (course == null) {
            System.out.println("Course not found");
            return;
        }

        if (course.getEnrolledStudents().isEmpty()) {
            System.out.println("No students enrolled");
            return;
        }

        for (Student student : course.getEnrolledStudents()) {

            System.out.println("Student ID " + student.getId());
            System.out.println("Student Name " + student.getName());
            System.out.println("Student Email " + student.getEmail());
            System.out.println("Marks " + student.getMarks());
            System.out.println("===========================================");
        }
    }

    @Override
    public void displayCourseTeacher(String courseId) {

        Courses course = getCourseById(courseId);

        if (course == null) {
            System.out.println("Course not found");
            return;
        }

        if (course.getTeacher() == null) {
            System.out.println("No teacher assigned");
            return;
        }


        System.out.println("Teacher ID " + course.getTeacher().getId());
        System.out.println("Teacher Name " + course.getTeacher().getName());
        System.out.println("Teacher Email " + course.getTeacher().getEmail());
        System.out.println("Teacher Experience " + course.getTeacher().getExperience());
    }
}