package serviceImpl;

import model.Student;
import model.Teacher;
import service.TeacherService;

import java.util.HashMap;

public class TeacherServiceImpl implements TeacherService {
    private final HashMap<Integer, Teacher> teacherHashMap;

    public TeacherServiceImpl(HashMap<Integer, Teacher> teacherHashMap) {
        this.teacherHashMap = teacherHashMap;
    }

    @Override
    public boolean addTeacher(Teacher teacher) {
        if (teacherHashMap.containsKey(teacher.getId())){
            System.out.println("Teacher with Id" + teacher.getId()+" already exists");
            return false;
        }
        teacherHashMap.put(teacher.getId(), teacher);
        System.out.println("Teacher added successfully");
        return true;
    }

    @Override
    public Teacher getTeacherById(int teacherId) {
        return teacherHashMap.get(teacherId);
    }

    @Override
    public void displayTeacherById(int teacherId) {
        Teacher teacher = getTeacherById(teacherId);
        if (teacher == null){
            System.out.println("Teacher not found");
            return;
        }
        System.out.println("Teacher id "+teacher.getId());
        System.out.println("Teacher email "+ teacher.getEmail());
        System.out.println("Teacher name "+ teacher.getName());
        System.out.println("Teacher phoneNumber "+ teacher.getPhoneNumber());
        System.out.println("Teacher salary "+ teacher.getSalary());
        System.out.println("Teacher experience "+ teacher.getExperience());
        System.out.println("Teacher subject "+ teacher.getSubject());
        System.out.println("===========================================");
    }

    @Override
    public void displayAllTeachers() {
        if (teacherHashMap.isEmpty()){
            System.out.println("No teacher available");
        }
        System.out.println("------------------------All teachers-------------------------");
        for (Teacher teacher: teacherHashMap.values()){
            System.out.println("Teacher id "+teacher.getId());
            System.out.println("Teacher email "+ teacher.getEmail());
            System.out.println("Teacher name "+ teacher.getName());
            System.out.println("Teacher phoneNumber "+ teacher.getPhoneNumber());
            System.out.println("Teacher salary "+ teacher.getSalary());
            System.out.println("Teacher experience "+ teacher.getExperience());
            System.out.println("Teacher subject "+ teacher.getSubject());
            System.out.println("===========================================");
        }
    }

    @Override
    public boolean updateTeacher(int teacherId, String subject, double salary, int experience) {
        Teacher teacher = getTeacherById(teacherId);
        if (teacher == null){
            System.out.println("Teacher not found");
            return false;
        }
        teacher.setSubject(subject);
        teacher.setExperience(experience);
        teacher.setSalary(salary);
        return  true;
    }

    @Override
    public boolean removeTeacher(int teacherId) {
        Teacher teacher= teacherHashMap.remove(teacherId);
        if (teacher == null){
            return false;
        }
        return true;
    }
}
