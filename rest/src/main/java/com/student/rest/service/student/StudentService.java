package com.student.rest.service.student;


import com.student.rest.exceptions.student.StudentAlreadyExistsException;
import com.student.rest.exceptions.student.StudentDoesNotExistException;
import com.student.rest.model.Course;
import com.student.rest.model.Student;

import java.util.List;
import java.util.stream.Collectors;

public interface StudentService {
    public void add(Student student) throws StudentAlreadyExistsException;

    public List<Student> get();

    public boolean updateStudent(Student student) throws StudentDoesNotExistException;

    public boolean deleteStudent(int id) throws StudentDoesNotExistException;

    public List<Student> getStudentsByMajor(String major);

    public List<Course> getCoursesByStudentId(int studentId);
}
