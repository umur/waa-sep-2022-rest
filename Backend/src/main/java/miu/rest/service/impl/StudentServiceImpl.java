package miu.rest.service.impl;

import miu.rest.Dto.CourseDto;
import miu.rest.Dto.StudentDto;
import miu.rest.model.Course;
import miu.rest.model.Student;
import miu.rest.repositories.StudentRepo;
import miu.rest.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public void save(StudentDto s){
        Student std = convertToStudent(s);
        studentRepo.add(std);
    }

    @Override
    public void put(int id, StudentDto s) {
        studentRepo.put(id, convertToStudent(s));
    }

    @Override
    public List<StudentDto> findAll(){
        List<StudentDto> studentDtos = new ArrayList<>();
//        studentDtos.forEach(std->std.);
        studentRepo.getStudents().forEach(std->studentDtos.add(convertToDto(std)));
        return studentDtos;
    }

    @Override
    public StudentDto findById(int id) {
        Student std = studentRepo.findById(id);
        return convertToDto(std);
    }

    @Override
    public void delete(int id) {

        studentRepo.deleteById(id);

    }

    @Override
    public List<Course> getCoursesByStudentId(int id) {

        return studentRepo.getCoursesByStudentId(id);
    }
    @Override
    public List<StudentDto> getStudentsByMajor(String major) {
        List<StudentDto> studentDtos = new ArrayList<>();
        studentRepo.getStudentsByMajor(major).forEach(std->studentDtos.add(convertToDto(std)));
        return studentDtos;
    }
//        return studentRepo.getStudentsByMajor(major);

    private StudentDto convertToDto(Student student) {
        StudentDto studentDto = modelMapper.map(student, StudentDto.class);
        return studentDto;
    }

    private Student convertToStudent(StudentDto studentDto) {
        Student student = modelMapper.map(studentDto, Student.class);
        return student;
    }


}
