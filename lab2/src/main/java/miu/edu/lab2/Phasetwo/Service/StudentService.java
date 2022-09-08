package miu.edu.lab2.Phasetwo.Service;

import miu.edu.lab2.Phasetwo.Domain.Course;
import miu.edu.lab2.Phasetwo.Domain.Student;
import miu.edu.lab2.Phasetwo.Dto.CourseDTO;
import miu.edu.lab2.Phasetwo.Dto.StudentDTO;

import java.util.List;

public interface StudentService {
    public void create(StudentDTO student) ;


    public List<StudentDTO> getStudentsByMajor(String major) ;

    public List<CourseDTO> getCoursesByStudentId(int id) ;

    public StudentDTO findById(int id) ;


    public void update(int id, StudentDTO student) ;

    public Student deleteStudent(int id) ;

    public List<StudentDTO> findAll() ;
}
