package henry.phaseii.service;

import henry.phaseii.dto.CourseDto;
import henry.phaseii.dto.StudentDto;
import henry.phaseii.entity.Course;

import java.util.List;

public interface StudentService {
    void save(StudentDto studentDto);
    List<StudentDto> findAll();
    List<StudentDto> getStudentsByMajor(String major);
    List<CourseDto> getCoursesByStudentId(int studentId);
    void takeCourse(int studentId, CourseDto courseDto);
    void update(int studentId, StudentDto studentDto);
    StudentDto delete(int studentId);

    // for CourseService
    void updateCourse(int courseId, Course course);
    void deleteCourse(int courseId);
}
