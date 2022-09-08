package miu.edu.lab2.PhaseThree.Service;

import miu.edu.lab2.PhaseThree.Domain.Student;
import miu.edu.lab2.PhaseThree.Dto.CourseDTO;
import miu.edu.lab2.PhaseThree.Dto.StudentDTO;

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
