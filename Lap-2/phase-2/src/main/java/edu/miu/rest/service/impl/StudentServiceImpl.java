package edu.miu.rest.service.impl;
import edu.miu.rest.dto.CourseDto;
import edu.miu.rest.dto.StudentDto;
import edu.miu.rest.entity.Course;
import edu.miu.rest.entity.Student;
import edu.miu.rest.repo.StudentRepo;
import edu.miu.rest.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;
    private final StudentDto dto;
    private final CourseDto dtoc;

    @Override
    public List<StudentDto> findAll() {
        var students = studentRepo.findAll();
        var result = new ArrayList<StudentDto>();
        for (Student stud : students) {
            var studentDto  = dto.toDto(stud);
            result.add(studentDto);
        }
        return result;
    }

    @Override
    public void create(StudentDto dto) {
       var entity = dto.toEntity();
        studentRepo.create(entity);
    }

    @Override
    public void update(StudentDto std, int id) {
        StudentDto s =dto.toDto(studentRepo.getById(id));
        s.setId(std.getId());
        s.setFirstName(std.getFirstName());
        s.setLastName(std.getLastName());
        s.setEmail(std.getEmail());
        s.setCourses(std.getCourses());
        s.setGpa(std.getGpa());
    }

    @Override
    public String DeleteById(int id) {
        return studentRepo.DeleteById(id);
    }

    @Override
    public StudentDto getById(int id) {
        var student= studentRepo.getById(id);
        var studentDto  = dto.toDto(student);
        return studentDto;
    }

    @Override
    public List<StudentDto> getStudentsByMajor(String major) {
        var students = studentRepo.getStudentsByMajor(major);
        var result = new ArrayList<StudentDto>();
        for (Student stud : students) {
            var studentDto  = dto.toDto(stud);
            result.add(studentDto);}
        return result;

    }

    @Override
    public List<CourseDto> getCoursesByStudentId(int studentId) {
        var courses=  studentRepo.getCoursesByStudentId(studentId);
        var result = new ArrayList<CourseDto>();
        for(Course c:courses){
            var cDTO= dtoc.toDto(c);
            result.add(cDTO);}
        return result;
    }
}
