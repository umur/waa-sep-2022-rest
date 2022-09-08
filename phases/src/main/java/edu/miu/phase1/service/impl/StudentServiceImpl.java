package edu.miu.phase1.service.impl;

import edu.miu.phase1.domain.Course;
import edu.miu.phase1.domain.Student;
import edu.miu.phase1.repo.StudentRepo;
import edu.miu.phase1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Student save(Student student) {
        return studentRepo.add(student);
    }

    @Override
    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    @Override
    public Student findById(int id) {
        return studentRepo.getStudentById(id);
    }

    @Override
    public Student update(int id, Student student) {
        return studentRepo.update(id, student);
    }

    @Override
    public Student delete(int id) {
        return studentRepo.delete(id);
    }

    @Override
    public List<Course> getCourseByStudentId(int studentId) {
        return studentRepo.getCourseByStudentId(studentId);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepo.getStudentsByMajor(major);
    }
}
