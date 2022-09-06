package com.gyawalirajiv.rest.services.impl;

import com.gyawalirajiv.rest.models.Course;
import com.gyawalirajiv.rest.models.Student;
import com.gyawalirajiv.rest.repositories.RestRepository;
import com.gyawalirajiv.rest.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final RestRepository restRepository;

    @Override
    public Student createStudent(Student student) {
        return restRepository.createStudent(student);
    }

    @Override
    public List<Student> getStudents() {
        return restRepository.getStudents();
    }

    @Override
    public Student getStudent(Long id) {
        return restRepository.getStudent(id);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        return restRepository.updateStudent(id, student);
    }

    @Override
    public Student deleteStudent(Long id) {
        return restRepository.deleteStudent(id);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return restRepository.getStudentsByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(int studentId) {
        return restRepository.getCoursesByStudentId(studentId);
    }

}
