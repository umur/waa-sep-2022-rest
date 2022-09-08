package uz.benom.restbackend.services;

import uz.benom.restbackend.dto.CourseDto;
import uz.benom.restbackend.dto.StudentDto;

import java.util.List;

public interface StudentService {

    public StudentDto create(StudentDto dto);

    public StudentDto update(Integer id, StudentDto dto);


    public void delete(Integer id);

    public StudentDto getOne(Integer id);

    List<StudentDto> getAll();

    List<StudentDto> getStudentsByMajor(String major);

    List<CourseDto> getCoursesByStudentId(int studentId);

}
