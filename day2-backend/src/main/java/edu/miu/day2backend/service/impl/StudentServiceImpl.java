package edu.miu.day2backend.service.impl;

import edu.miu.day2backend.domain.Student;
import edu.miu.day2backend.dto.CourseDto;
import edu.miu.day2backend.dto.StudentDto;
import edu.miu.day2backend.repo.StudentRepo;
import edu.miu.day2backend.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    private final ModelMapper modelMapper;

    @Override
    public void add(StudentDto s) {
        Student student = modelMapper.map(s, Student.class);
        studentRepo.add(student);
    }

    @Override
    public StudentDto findById(int id) {
        Student s = studentRepo.findById(id);
        StudentDto student = modelMapper.map(s, StudentDto.class);
        return student;
    }

    @Override
    public void update(StudentDto s, int id) {
        Student student = modelMapper.map(s, Student.class);
        studentRepo.update(student, id);
    }

    @Override
    public void delete(int id) {
        studentRepo.delete(id);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        return studentRepo.findAll().stream().map(s -> modelMapper.map(s, StudentDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<StudentDto> findStudentsByMajor(String major) {
        return studentRepo.findAll().stream().filter(s -> major.equals(s.getMajor()))
                .map(s -> modelMapper.map(s, StudentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CourseDto> findCourseTakenByStudent(Integer studentId) {

        return studentRepo.findAll().stream().filter(s -> studentId == s.getId())
                .map(s -> s.getCourseTaken())
                .flatMap(c -> c.stream())
                .map(c -> modelMapper.map(c, CourseDto.class))
                .collect(Collectors.toList());

    }
}
