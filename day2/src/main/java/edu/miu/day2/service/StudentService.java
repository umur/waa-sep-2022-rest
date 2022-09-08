package edu.miu.day2.service;

import edu.miu.day2.entity.Course;
import edu.miu.day2.entity.DTO.CourseDTO;
import edu.miu.day2.entity.DTO.StudentDTO;
import edu.miu.day2.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    public StudentDTO createAStudent(StudentDTO student);

    List<StudentDTO>  getAllStudents();

    StudentDTO getAStudent(Long id);

    StudentDTO updateStudent(Long id, StudentDTO student);

    StudentDTO deleteStudent(Long id);
    public List<StudentDTO> getAllStudentsByMajor(String major);
    public List<CourseDTO> getAllCourseByStudentId(int studentId);

}
