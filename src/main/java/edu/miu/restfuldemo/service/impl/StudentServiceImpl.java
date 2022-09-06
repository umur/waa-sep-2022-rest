package edu.miu.restfuldemo.service.impl;

import edu.miu.restfuldemo.dto.CourseDto;
import edu.miu.restfuldemo.dto.StudentDto;
import edu.miu.restfuldemo.entity.Course;
import edu.miu.restfuldemo.entity.Student;
import edu.miu.restfuldemo.repo.CourseRepo;
import edu.miu.restfuldemo.repo.StudentRepo;
import edu.miu.restfuldemo.service.StudentService;
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
        Student c = modelMapper.map(student, Student.class);
        Student newStudent =  studentRepo.add(c);
        return modelMapper.map(newStudent, StudentDto.class);
    }

    @Override
    public void update(int id, StudentDto student) {
        Student c = modelMapper.map(student, Student.class);
        studentRepo.update(id, c);
    }

    @Override
    public void delete(int id) {
        studentRepo.delete(id);
    }

    @Override
    public List<StudentDto> getStudentsByMajor(String major) {
        List<Student> students = studentRepo.getAll();
        return students.stream().filter(c -> c.getMajor().equals(major)).map(c -> modelMapper.map(c, StudentDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<CourseDto> getCoursesByStudentId(int id) {
        Student student = studentRepo.get(id);
        if (student == null) return new ArrayList<>();

        List<Integer> courseIds = student.getCoursesTaken();
        List<Course> courses = courseRepo.getAll();
        return courses.stream().filter(c -> courseIds.contains(c.getId())).map(c -> modelMapper.map(c, CourseDto.class)).collect(Collectors.toList());
    }

}
