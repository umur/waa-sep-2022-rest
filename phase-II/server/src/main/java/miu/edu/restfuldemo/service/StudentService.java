package miu.edu.restfuldemo.service;

import miu.edu.restfuldemo.dto.CourseDTO;
import miu.edu.restfuldemo.dto.StudentDTO;
import java.util.List;

public interface StudentService {
    void save(StudentDTO studentDTO);
    List<StudentDTO> findAll();
    StudentDTO getById(int id);
    void delete(int id);
    List<StudentDTO> getStudentsByMajor(String major);
    List<CourseDTO> getCoursesByStudentId(int id);
}
