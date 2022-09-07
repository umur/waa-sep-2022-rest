package edu.miu.rest.service;

import edu.miu.rest.dto.CourseDto;
import edu.miu.rest.dto.StudentDto;
import edu.miu.rest.entity.Course;
import edu.miu.rest.entity.Student;

import java.util.List;

public interface StudentService {
    List<StudentDto> findAll();
    void create(StudentDto dto);
    public void update(StudentDto std, int id);
    public String DeleteById(int id);
    public StudentDto getById(int id);
    public List<StudentDto > getStudentsByMajor(String major);
    public List<CourseDto> getCoursesByStudentId(int studentId);

}
