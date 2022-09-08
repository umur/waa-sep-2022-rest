package edu.miu.phase3.service.impl;

import edu.miu.phase3.domain.Course;
import edu.miu.phase3.domain.Student;
import edu.miu.phase3.dto.CourseDto;
import edu.miu.phase3.dto.StudentDto;
import edu.miu.phase3.repo.StudentRepo;
import edu.miu.phase3.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public StudentDto save(StudentDto student) {
        Student s = mapper.map(student, Student.class);
        Student result = studentRepo.add(s);
        return mapper.map(result, StudentDto.class);
    }

    @Override
    public List<StudentDto> findAll() {
        List<Student> students = studentRepo.findAll();
        return students.stream().map(stu -> mapper.map(stu, StudentDto.class)).toList();
    }

    @Override
    public StudentDto findById(int id) {
        Student stu = studentRepo.getStudentById(id);
        return mapper.map(stu, StudentDto.class);
    }

    @Override
    public StudentDto update(int id, StudentDto student) {
        Student stu = studentRepo.update(id, mapper.map(student, Student.class));
        return mapper.map(stu, StudentDto.class);
    }

    @Override
    public StudentDto delete(int id) {
        Student stu = studentRepo.delete(id);
        return stu != null ? mapper.map(stu, StudentDto.class) : null;
    }

    @Override
    public List<CourseDto> getCourseByStudentId(int studentId) {
        List<Course> courses = studentRepo.getCourseByStudentId(studentId);
        return courses != null ? courses.stream().map(c -> mapper.map(c, CourseDto.class)).toList() : null;
    }

    @Override
    public List<StudentDto> getStudentsByMajor(String major) {
        List<Student> students = studentRepo.getStudentsByMajor(major);
        return students != null ? students.stream().map(stu -> mapper.map(stu, StudentDto.class)).toList() : null;
    }
}
