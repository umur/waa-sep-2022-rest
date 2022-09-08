package com.gyawalirajiv.rest.services.impl;

import com.gyawalirajiv.rest.models.Course;
import com.gyawalirajiv.rest.models.DTOs.CourseDTO;
import com.gyawalirajiv.rest.models.DTOs.StudentDTO;
import com.gyawalirajiv.rest.models.Student;
import com.gyawalirajiv.rest.repositories.RestRepository;
import com.gyawalirajiv.rest.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final RestRepository restRepository;

    private final ModelMapper modelMapper;

    @Override
    public StudentDTO createStudent(StudentDTO student) {
        return modelMapper.map(restRepository.createStudent(modelMapper.map(student, Student.class)), StudentDTO.class);
    }

    @Override
    public List<StudentDTO> getStudents() {
        List<Student> students = restRepository.getStudents();
        return students.stream().map(s -> modelMapper.map(s, StudentDTO.class)).collect(Collectors.toList());
    }

    @Override
    public StudentDTO getStudent(Long id) {
        return modelMapper.map(restRepository.getStudent(id), StudentDTO.class);
    }

    @Override
    public StudentDTO updateStudent(Long id, StudentDTO student) {
        return modelMapper.map(restRepository.updateStudent(id, modelMapper.map(student, Student.class)), StudentDTO.class);
    }

    @Override
    public StudentDTO deleteStudent(Long id) {
        return modelMapper.map(restRepository.deleteStudent(id), StudentDTO.class);
    }

    @Override
    public List<StudentDTO> getStudentsByMajor(String major) {
        List<Student> students = restRepository.getStudentsByMajor(major);
        return students.stream().map(s -> modelMapper.map(s, StudentDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> getCoursesByStudentId(int studentId) {
        List<Course> courses = restRepository.getCoursesByStudentId(studentId);
        return courses.stream().map(c -> modelMapper.map(c, CourseDTO.class)).collect(Collectors.toList());
    }

}
