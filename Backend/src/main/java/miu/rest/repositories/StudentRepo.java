package miu.rest.repositories;

import miu.rest.model.Course;
import miu.rest.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {

    @Autowired
    private CourseRepo courseRepo;
    private static List<Student> students = new ArrayList<>();
    static{
        List<Course> coursesTaken = new ArrayList<>();

        Course c1 = new Course(1,"WAA", "CS545");
        Course c2 = new Course(2,"WAP", "CS472");
        coursesTaken.add(c1);
        coursesTaken.add(c2);
        Student s1 = new Student(1, "Abdulhakim", "Sirko", "abedi715@gmail.com", "ComPro", 3.90, coursesTaken);
        Student s2 = new Student(2, "Ab", "ed", "abedi@gmail.com", "ComPro", 3.95, coursesTaken);
        students.add(s1);
        students.add(s2);
    }

    public void add(Student s){
        students.add(s);
    }

    public void put(int id, Student s){
        Student std = students.stream().filter(sid->(sid.getId()==id)).findAny().get();
        students.set(id-1, std);
    }
    public List<Student> getStudents(){
        return students;
    }

    public Student findById(int id){
        return students.stream().filter(sid->(sid.getId()==id)).findAny().get();
    }

    public void deleteById(int id) {
        Student s = students.stream().filter(sid->(sid.getId()==id)).findAny().get();
        students.remove(s);
    }

    public List<Course> getCoursesByStudentId(int studentId) {
        return students.stream().filter(s->s.getId()==studentId).findAny().get().getCoursesTaken();
    }
    public List<Student> getStudentsByMajor(String major) {
        return students.stream().filter(s->s.getMajor().equals(major)).collect(Collectors.toList());
    }
}
