package miu.edu.lab2.PhaseThree.Service.impl;

import miu.edu.lab2.PhaseThree.Domain.Student;
import miu.edu.lab2.PhaseThree.Dto.CourseDTO;
import miu.edu.lab2.PhaseThree.Dto.StudentDTO;
import miu.edu.lab2.PhaseThree.Repository.StudentRepository;
import miu.edu.lab2.PhaseThree.Service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public void create(StudentDTO student) {
        studentRepository.save(modelMapper.map(student,Student.class));
    }

    @Override
    public List<StudentDTO> getStudentsByMajor(String major) {
        return studentRepository.getStudentByMajor(major).stream()
                .map(a-> modelMapper.map(a,StudentDTO.class)).toList();
    }

    @Override
    public List<CourseDTO> getCoursesByStudentId(int id) {
        return studentRepository.getCoursesByStudentId(id)
                .stream().map(a-> modelMapper.map(a,CourseDTO.class)).toList();
    }

    @Override
    public StudentDTO findById(int id) {
        return modelMapper.map(studentRepository.findById(id),StudentDTO.class);
    }

    @Override
    public void update(int id, StudentDTO student) {
        studentRepository.update(id, modelMapper.map(student,Student.class));
    }

    @Override
    public Student deleteStudent(int id) {
        return studentRepository.deleteStudent(id);
    }

    @Override
    public List<StudentDTO> findAll() {
        return studentRepository.findAll().stream().
                map(a-> modelMapper.map(a,StudentDTO.class)).
                collect(Collectors.toList());
    }
}
