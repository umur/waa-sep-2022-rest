package edu.miu.phase2.service.impl;

import edu.miu.phase2.repo.StudentRepo;
import edu.miu.phase2.dto.CourseDto;
import edu.miu.phase2.dto.StudentDto;
import edu.miu.phase2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public StudentDto save(StudentDto student) {
        return studentRepo.add(student);
    }

    @Override
    public List<StudentDto> findAll() {
        return studentRepo.findAll();
    }

    @Override
    public StudentDto findById(int id) {
        return studentRepo.getStudentById(id);
    }

    @Override
    public StudentDto update(int id, StudentDto student) {
        return studentRepo.update(id, student);
    }

    @Override
    public StudentDto delete(int id) {
        return studentRepo.delete(id);
    }

    @Override
    public List<CourseDto> getCourseByStudentId(int studentId) {
        return studentRepo.getCourseByStudentId(studentId);
    }

    @Override
    public List<StudentDto> getStudentsByMajor(String major) {
        return studentRepo.getStudentsByMajor(major);
    }
}
