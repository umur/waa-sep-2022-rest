package miu.edu.lab2.Phasetwo.Service.impl;

import miu.edu.lab2.Phasetwo.Domain.Course;
import miu.edu.lab2.Phasetwo.Domain.Student;
import miu.edu.lab2.Phasetwo.Dto.CourseDTO;
import miu.edu.lab2.Phasetwo.Dto.StudentDTO;
import miu.edu.lab2.Phasetwo.Repository.StudentRepository;
import miu.edu.lab2.Phasetwo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;


    @Override
    public void create(StudentDTO student) {
        studentRepository.save(StudentDTO.changeTOStudent(student));
    }

    @Override
    public List<StudentDTO> getStudentsByMajor(String major) {
        return studentRepository.getStudentByMajor(major).stream()
                .map(a->StudentDTO.changeToStudentDTO(a)).toList();
    }

    @Override
    public List<CourseDTO> getCoursesByStudentId(int id) {
        return studentRepository.getCoursesByStudentId(id)
                .stream().map(a->CourseDTO.changeTOCourseDTO(a)).toList();
    }

    @Override
    public StudentDTO findById(int id) {
        return StudentDTO.changeToStudentDTO(studentRepository.findById(id));
    }

    @Override
    public void update(int id, StudentDTO student) {
        studentRepository.update(id,StudentDTO.changeTOStudent(student));
    }

    @Override
    public Student deleteStudent(int id) {
        return studentRepository.deleteStudent(id);
    }

    @Override
    public List<StudentDTO> findAll() {
        return studentRepository.findAll().stream().
                map(a->StudentDTO.changeToStudentDTO(a)).
                collect(Collectors.toList());
    }
}
