package edu.miu.restfullab2.service;

import edu.miu.restfullab2.dto.StudentDto;
import edu.miu.restfullab2.entity.Student;

import java.util.List;


public interface StudentService {

    void save(Student s);

    List<StudentDto> findAll();

    StudentDto getById(int id);

    Student saveStudent(Student student);

    int deleteStudentById(int id);

    Student updateStudent(int id, Student student);

    List<Student> getStudentsByMajor(String major);
}
