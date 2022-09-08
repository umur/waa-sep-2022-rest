package edu.miu.restfullab2.repo;

import edu.miu.restfullab2.entity.Course;
import edu.miu.restfullab2.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    private static List<Course> courses1= new ArrayList<>();
    private static List<Course> courses2= new ArrayList<>();

    static {
        Course c1 =new Course(1, "WAA", "CS545");
        Course c2 =new Course(2, "WAP", "CS472");
        Course c3 =new Course(3, "SA", "CS590");

        courses1.add(c1);
        courses1.add(c3);
        courses2.add(c2);
    }

    private static List<Student>students =new ArrayList<>();
    private static int currStuId= 2;

    static {
        Student s1 =new Student(1, "Abedur", "Rahman", "abedur@gmail.com", "CSE", 3.6, courses1);
        Student s2 =new Student(2, "Adyan", "Rahman", "adyan.eit@gmail.com", "CSE", 3.5, courses2);

        students.add(s1);
        students.add(s2);
    }

    public void add(Student s){
        s.setId(currStuId++);
        students.add(s);
    }

    public static List<Student> getStudents() {
        return students;
    }

    public Student getById(int id) {
        return students.get(id);
    }

    public Student saveStudent(Student student) {
        students.add(student);
        return student;
    }

    public int deleteById(int id) {
        students =students.stream().filter(e -> e.getId() != id).toList();
        students.remove(id);
        return id;
    }

    public Student updateStudent(int id, Student student) {
        students.set(id, student);
        return student;
    }

    public List<Student> getStudentsByMajor(String major) {
        List<Student> tmp = students.stream().filter(std->std.getMajor().equalsIgnoreCase(major)).toList();
        return tmp;
    }
}
