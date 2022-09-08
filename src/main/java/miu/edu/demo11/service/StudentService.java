package miu.edu.demo11.service;

import miu.edu.demo11.entity.Course;
import miu.edu.demo11.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();


    Student save(Student body);

    Student update(Integer id , Student body);


    Student findOne(Integer id);

    void delete(Integer id );



    List<Student> getStudentsByMajor(String major);

    List<Course> getCoursesByStudentId(Integer id);


}
