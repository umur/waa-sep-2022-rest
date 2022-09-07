package edu.miu.day2.service;

import edu.miu.day2.entity.Course;
import edu.miu.day2.entity.Student;
import edu.miu.day2.repo.StudentAndCourseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    @Override
    public Student createAStudent(Student student) {
        return StudentAndCourseRepo.createStudent(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return StudentAndCourseRepo.getAllStudents();
    }

    @Override
    public Student getAStudent(Long id) {
        return (Student) StudentAndCourseRepo.getStudent(id);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        return StudentAndCourseRepo.updateStudent(id,student);
    }

    @Override
    public Student deleteStudent(Long id) {
        return StudentAndCourseRepo.deleteStudent(id);
    }

    @Override
    public List<Student> getAllStudentsByMajor(String major) {
        return StudentAndCourseRepo.getStudentsByMajor(major);
    }

    @Override
    public List<Course> getAllCourseByStudentId(int studentId) {
        return StudentAndCourseRepo.getStudent(Long.valueOf(studentId)).getCourses();
    }
}
