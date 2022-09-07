package miu.edu.restfuldemo.service.implementation;

import miu.edu.restfuldemo.entity.Course;
import miu.edu.restfuldemo.entity.Student;
import miu.edu.restfuldemo.repository.StudentRepository;
import miu.edu.restfuldemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImplementation implements StudentService {
    StudentRepository studentRepository;

    @Autowired
    public StudentServiceImplementation(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void save(Student student) {
        studentRepository.add(student);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student getById(int id) {
        return studentRepository.getById(id);
    }

    public void delete(int id) {
        studentRepository.delete(id);
    }

    public List<Student> getStudentsByMajor(String major) {
        return studentRepository.getStudentsByMajor(major);
    };

    public List<Course> getCoursesByStudentId(int id) {
        return studentRepository.getCoursesByStudentId(id);
    }
}
