package org.lab2.service;

import org.lab2.dto.CourseDTO;
import org.lab2.dto.StudentDTO;

import java.util.List;

public interface IStudentService {

    void save(StudentDTO courseDTO);

    List<StudentDTO> findAll();

    StudentDTO update(StudentDTO courseDTO);

    void delete(Integer id);


    List<StudentDTO> getStudentsByMajor(String major);

    List<CourseDTO> getCoursesByStudentId(Integer id);

}
