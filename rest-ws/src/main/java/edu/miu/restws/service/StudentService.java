package edu.miu.restws.service;

import edu.miu.restws.dto.StudentDto;
import edu.miu.restws.entity.Student;

import java.util.List;

public interface StudentService {

    List<StudentDto> findStudentsByMajor(String major);

    void save(StudentDto studentDto);

    void delete(int id);

    void update(StudentDto studentDto);

    List<StudentDto> findAllStudents();

    StudentDto findById(int id);

}
