package net.javaguides.springboot.repository;

import net.javaguides.springboot.entity.Course;
import net.javaguides.springboot.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class RepositoryStudent {
    private static List<Student> students = new ArrayList<>();

    public RepositoryStudent(){
        List<Course> courses = new ArrayList<>();
        Course c1 = new Course(1, "MWA", "CS572");
        Course c2 = new Course(2, "WAA", "CS545");
        courses.add(c1);
        courses.add(c2);

        Student s1 = new Student(1, "Zaya", "Ganaa", "zaya@gmail.com",  "CS",  new ArrayList<>(courses), 4.0);
        Student s2 = new Student(1, "Ari", "Tom", "Tom@gmail.com",  "MBA", new ArrayList<>(courses), 4.0);
        students.add(s1);
        students.add(s2);
    }


    public List<Student> findAll(){
        return students;
    }

    public void create(Student s){
        students.add(s);
    }

    public void deleteById(int id){
        var found= students.stream().filter(s-> s.getId()==id).findFirst().get();
        students.remove(found);
    }

    public void update(Student newStudent, int id){
        Student oldStudent=findAll().stream().filter(s-> s.getId()==id).findFirst().get();

        oldStudent.setFistName(newStudent.getFistName());
        oldStudent.setLastName(newStudent.getLastName());
        oldStudent.setEmail(newStudent.getEmail());
        oldStudent.setGpa(newStudent.getGpa());
        oldStudent.setMajor(newStudent.getMajor());
        oldStudent.setCourseTaken(newStudent.getCourseTaken());
    }

    public Student findById(int id){
        return students
                .stream()
                .filter(s-> s.getId()== id)
                .findFirst()
                .orElse(null);
    }
}
