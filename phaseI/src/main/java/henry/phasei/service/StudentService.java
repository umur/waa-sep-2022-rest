package henry.phasei.service;

import henry.phasei.entity.Course;
import henry.phasei.entity.Student;

import java.util.List;

public interface StudentService {
    void save(Student student);
    List<Student> findAll();
    List<Student> getStudentsByMajor(String major);
    List<Course> getCoursesByStudentId(int studentId);
    void takeCourse(int studentId, Course course);
    void update(int studentId, Student student);
    Student delete(int studentId);

    // for CourseService
    void updateCourse(int courseId, Course course);
    void deleteCourse(int courseId);
}
