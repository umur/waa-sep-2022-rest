package com.example.restfulapi.Service.Impl;

import com.example.restfulapi.DTO.CourseDTO;
import com.example.restfulapi.DTO.StudentDTO;
import com.example.restfulapi.Model.Course;
import com.example.restfulapi.Model.Student;
import com.example.restfulapi.Repository.StudentRepo;
import com.example.restfulapi.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepo studentRepo;

    @Override
    public List<StudentDTO> findAll() {
        List<StudentDTO> studto= new ArrayList<>();
        List<Student> stu=studentRepo.getAllStudents();
        for(Student s:stu){
            StudentDTO studentdto=new StudentDTO(s.getId(),s.getFirstName(),s.getLastName(),s.getEmail(),s.getMajor(),s.getGPA(),s.getCourseTaken());
            studto.add(studentdto);
        }
        return studto;
    }

    @Override
    public void add(StudentDTO student) {
        Student stu = new Student(student.getId(),student.getFirstName(),student.getLastName(),student.getEmail(),student.getMajor(),student.getGPA(),student.getCourseTaken());
        studentRepo.saveStudent(stu);
    }

    @Override
    public void updateStudent(int id, StudentDTO student) {
        Student stu = new Student(student.getId(),student.getFirstName(),student.getLastName(),student.getEmail(),student.getMajor(),student.getGPA(),student.getCourseTaken());
        studentRepo.updateStudent(id,stu);
    }

    @Override
    public void deleteStudent(int id){
        studentRepo.deleteStudent(id);
    }

    @Override
    public List<StudentDTO> getAllStudentsByMajor(String major) {
        List<Student> stud=studentRepo.getAllStudentByMajor(major);
        List<StudentDTO>studto=new ArrayList<>();
        for(Student s: stud){
            StudentDTO studentdto=new StudentDTO(s.getId(),s.getFirstName(),s.getLastName(),s.getEmail(),s.getMajor(),s.getGPA(),s.getCourseTaken());
            studto.add(studentdto);
        }
        return  studto;
    }

    @Override
    public List<CourseDTO>getAllCoursesByStudentId(int id){
        List<Course> crs=studentRepo.getAllCoursesByStudentId(id);
        List<CourseDTO> crsdto=new ArrayList<>();
        for(Course c: crs){
            CourseDTO coursedto=new CourseDTO(c.getId(),c.getName(),c.getCode());
            crsdto.add(coursedto);
        }
        return crsdto;
    }

}
