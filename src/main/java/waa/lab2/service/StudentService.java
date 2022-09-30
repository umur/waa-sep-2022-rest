package waa.lab2.service;

import waa.lab2.dto.CourseDto;
import waa.lab2.dto.StudentDto;

import java.util.List;

public interface StudentService {
     void save(StudentDto studentDto);

    StudentDto getStudentByID(Integer id);

    List<StudentDto> getAllStudents();

    void deleteStudentById(Integer id);

    void updateStudent(Integer id , StudentDto studentDto);

    List<StudentDto> getStudentByMajor(String major);

    List<CourseDto> getCoursesByStudentId(int id);
}
