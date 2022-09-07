package com.student.rest.service.student.imp;

import com.student.rest.dto.CourseDto;
import com.student.rest.dto.StudentDto;
import com.student.rest.exceptions.student.StudentAlreadyExistsException;
import com.student.rest.exceptions.student.StudentDoesNotExistException;
import com.student.rest.model.Course;
import com.student.rest.model.Student;
import com.student.rest.repo.StudentRepo;
import com.student.rest.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Override
    public StudentDto add(StudentDto student) throws StudentAlreadyExistsException {
        if (studentRepo.exists(student.getId())) {
            throw new StudentAlreadyExistsException("Student Already Exists !!!");
        }
        return studentRepo.addStudent(student);
    }

    @Override
    public List<StudentDto> get() {
      return studentRepo.getStudents();
    }

    @Override
    public boolean updateStudent(StudentDto student, int id) throws StudentDoesNotExistException {
        if (!studentRepo.exists(id)) {
            throw new StudentDoesNotExistException("Student does not exist !!!");
        }
        return studentRepo.updateStudent(student, id);
    }

    @Override
    public boolean deleteStudent(int id) throws StudentDoesNotExistException {
        if (!studentRepo.exists(id)) {
            throw new StudentDoesNotExistException("Student does not exist !!!");
        }
        return studentRepo.deleteStudent(id);
    }

    @Override
    public List<StudentDto> getStudentsByMajor(String major) {
        return studentRepo.getStudentsByMajor(major);
    }

    @Override
    public List<CourseDto> getCoursesByStudentId(int studentId) {
        return studentRepo.getCoursesByStudentId(studentId);
    }
}
