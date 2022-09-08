package edu.miu.lab2.service.impl;

import edu.miu.lab2.dto.CourseDto;
import edu.miu.lab2.dto.StudentDto;
import edu.miu.lab2.entity.Student;
import edu.miu.lab2.repo.CourseRepo;
import edu.miu.lab2.repo.StudentRepo;
import edu.miu.lab2.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;
    private final CourseRepo courseRepo;
    private final ModelMapper modelMapper;

    public StudentServiceImpl(StudentRepo studentRepo, CourseRepo courseRepo, ModelMapper modelMapper) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<StudentDto> get() {
        List<Student> students = studentRepo.getAll();
        return students.stream().map(p -> modelMapper.map(p, StudentDto.class)).toList();
    }

    @Override
    public StudentDto get(int id) {
        Student student = studentRepo.get(id);
        return student == null ? null : modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto add(StudentDto student) {
        Student s = modelMapper.map(student, Student.class);
        Student newStudent =  studentRepo.add(s);
        return modelMapper.map(newStudent, StudentDto.class);
    }

    @Override
    public void update(int id, StudentDto student) {
        Student s = modelMapper.map(student, Student.class);
        s.setId(id);
        studentRepo.update(id, s);
    }

    @Override
    public void delete(int id) {
        studentRepo.delete(id);
    }

    @Override
    public List<StudentDto> getStudentsByMajor(String major) {
        Student s = studentRepo.filter(c -> c.getMajor().equalsIgnoreCase(major)).findFirst().orElse(null);
        return studentRepo.filter(c -> c.getMajor().equals(major)).map(c -> modelMapper.map(c, StudentDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<CourseDto> getCoursesByStudentId(int id) {
        Student student = studentRepo.get(id);
        if (student == null) return new ArrayList<>();

        List<Integer> courseIds = student.getCoursesTaken();
        return courseRepo.filter(c -> courseIds.contains(c.getId())).map(c -> modelMapper.map(c, CourseDto.class)).collect(Collectors.toList());
    }

}
