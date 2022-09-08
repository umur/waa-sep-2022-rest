package edu.miu.restfullab2.service.impl;

import edu.miu.restfullab2.dto.StudentDto;
import edu.miu.restfullab2.entity.Student;
import edu.miu.restfullab2.repo.StudentRepo;
import edu.miu.restfullab2.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo studentRepo;

    private ModelMapper modelMapper;

    public StudentServiceImpl(StudentRepo studentRepo, ModelMapper modelMapper) {
        this.studentRepo = studentRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public void save(Student s){
        studentRepo.add(s);
    }

    @Override
    public List<StudentDto> findAll() {
        return studentRepo.getStudents().stream().map(s -> modelMapper.map(s, StudentDto.class)).collect(Collectors.toList());
    }

    @Override
    public StudentDto getById(int id) {
        StudentDto studentDto = modelMapper.map(studentRepo.getById(id), StudentDto.class);
        return studentDto;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepo.saveStudent(student);
    }

    @Override
    public int deleteStudentById(int id) {
        return studentRepo.deleteById(id);
    }

    @Override
    public Student updateStudent(int id, Student student) {
        return studentRepo.updateStudent(id, student);
    }

    @Override
    public List<Student> getStudentsByMajor(String courseName) {
        return studentRepo.getStudentsByMajor(courseName);
    }


}
