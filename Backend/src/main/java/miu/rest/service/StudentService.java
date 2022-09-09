package miu.rest.service;

import miu.rest.Dto.StudentDto;
import miu.rest.model.Course;
import miu.rest.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    void save(StudentDto s);

    void put(int id, StudentDto s);

    List<StudentDto> findAll();

    StudentDto findById(int id);

    void delete(int id);

    List< StudentDto > getStudentsByMajor(String major);

    List<Course> getCoursesByStudentId(int studentId);
}
