package miu.edu.lab2.PhaseOne.Service;

import miu.edu.lab2.PhaseOne.Domain.Course;
import miu.edu.lab2.PhaseOne.Domain.Student;

import java.util.List;

public interface StudentService {
    public void create(Student student) ;


    public List<Student> getStudentsByMajor(String major) ;

    public List<Course> getCoursesByStudentId(int id) ;

    public Student findById(int id) ;


    public void update(int id, Student student) ;

    public Student deleteStudent(int id) ;

    public List<Student> findAll() ;
}
