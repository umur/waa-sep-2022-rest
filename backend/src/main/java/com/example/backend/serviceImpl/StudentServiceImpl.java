package com.example.backend.serviceImpl;

import com.example.backend.dto.CourseDTO;
import com.example.backend.dto.StudentDTO;
import com.example.backend.entity.Student;
import com.example.backend.repository.StudentRepo;
import com.example.backend.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDTO> getAll() {
        return studentRepo.getAll()
                .stream().map(student -> modelMapper.map(student, StudentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO getById(int id) {
        Student student = studentRepo.getById(id);
        if(student != null){
            return modelMapper.map(student, StudentDTO.class);
        }
        return null;
    }

    @Override
    public void delete(int id) {
        studentRepo.delete(id);
    }

    @Override
    public void update(int id, StudentDTO student) {
        studentRepo.update(id, modelMapper.map(student, Student.class));
    }

    @Override
    public List<StudentDTO> getByMajor(String major) {
        return studentRepo.getByMajor(major)
                .stream().map(student -> modelMapper.map(student, StudentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> getStudentCourses(int id) {
        return studentRepo.getStudentCourses(id)
                .stream().map(course -> modelMapper.map(course, CourseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO create(StudentDTO student) {
        return modelMapper.map(studentRepo.create(modelMapper.map(student, Student.class)), StudentDTO.class);
    }

}
