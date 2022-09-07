package edu.miu.rest.service.impl;
import edu.miu.rest.dto.CourseDto;
import edu.miu.rest.dto.StudentDto;
import edu.miu.rest.entity.Course;
import edu.miu.rest.entity.Student;
import edu.miu.rest.repo.StudentRepo;
import edu.miu.rest.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class StudentServiceImpl implements StudentService {
    @Autowired
    private  StudentRepo studentRepo;
    @Autowired
    private  ModelMapper modelMapper;

   // public StudentServiceImpl(StudentRepo studentRepo) {
     //   this.studentRepo = studentRepo;
   // }
//    public StudentServiceImpl(ModelMapper modelMapper) {
//        this.modelMapper = modelMapper;
//    }

    @Override
    public List<StudentDto> findAll() {
        var students = studentRepo.findAll();

        students.forEach(System.out::println);
        var result = new ArrayList<StudentDto>();
        for (Student stud : students) {
            var res = modelMapper.map(stud, StudentDto.class);
            result.add(res);
        }
        return result;
    }
    @Override
    public void create(StudentDto dto) {
       Student result=modelMapper.map(dto,Student.class);
        studentRepo.create(result);
    }

    @Override
    public void update(StudentDto std, int id) {
        Student s = studentRepo.getById(id);
        Student res = modelMapper.map(std,Student.class);
        s.setId(res.getId());
        s.setFirstName(res.getFirstName());
        s.setLastName(res.getLastName());
        s.setEmail(res.getEmail());
        s.setCourses(res.getCourses());
        s.setGpa(res.getGpa());
    }

    @Override
    public String DeleteById(int id) {
        return studentRepo.DeleteById(id);
    }

    @Override
    public StudentDto getById(int id) {
        var student= studentRepo.getById(id);
        var result=modelMapper.map(student,StudentDto.class);
        return result;
    }

    @Override
    public List<StudentDto> getStudentsByMajor(String major) {
        var result = new ArrayList<StudentDto>();
        var students = studentRepo.getStudentsByMajor(major);
        for(Student s: students) {
            var res=modelMapper.map(s,StudentDto.class);
            result.add(res);
        }
        return result;
}

    @Override
    public List<CourseDto> getCoursesByStudentId(int studentId) {
        var courses=  studentRepo.getCoursesByStudentId(studentId);
        var result = new ArrayList<CourseDto>();
        for(Course c:courses){
            var res=modelMapper.map(c,CourseDto.class);
            result.add(res);}
        return result;
    }
}
