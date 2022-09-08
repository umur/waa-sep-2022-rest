package miu.edu.lab2.PhaseOne.Service.impl;

import miu.edu.lab2.PhaseOne.Domain.Course;
import miu.edu.lab2.PhaseOne.Domain.Student;
import miu.edu.lab2.PhaseOne.Repository.StudentRepository;
import miu.edu.lab2.PhaseOne.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;


    @Override
    public void create(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepository.getStudentByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(int id) {
        return studentRepository.getCoursesByStudentId(id);
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public void update(int id, Student student) {
        studentRepository.update(id,student);
    }

    @Override
    public Student deleteStudent(int id) {
        return studentRepository.deleteStudent(id);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}
