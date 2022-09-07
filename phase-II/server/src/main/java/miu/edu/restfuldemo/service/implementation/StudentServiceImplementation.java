package miu.edu.restfuldemo.service.implementation;

import miu.edu.restfuldemo.dto.CourseDTO;
import miu.edu.restfuldemo.dto.StudentDTO;
import miu.edu.restfuldemo.entity.Course;
import miu.edu.restfuldemo.entity.Student;
import miu.edu.restfuldemo.repository.StudentRepository;
import miu.edu.restfuldemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class StudentServiceImplementation implements StudentService {
    StudentRepository studentRepository;

    @Autowired
    public StudentServiceImplementation(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void save(StudentDTO studentDTO) {
        Student student = new Student(
                studentDTO.getId(),
                studentDTO.getFirstName(),
                studentDTO.getLastName(),
                studentDTO.getEmail(),
                studentDTO.getMajor(),
                studentDTO.getGpa(),
                studentDTO.getCoursesTaken()
        );

        studentRepository.add(student);
    }

    public List<StudentDTO> findAll() {
        return convertStudentListToStudentDTOList(studentRepository.findAll());
    }

    public StudentDTO getById(int id) {
        Student student = studentRepository.getById(id);
        StudentDTO studentDTO = new StudentDTO(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getMajor(),
                student.getGpa(),
                student.getCoursesTaken()
        );
        return studentDTO;
    }

    public void delete(int id) {
        studentRepository.delete(id);
    }

    public List<StudentDTO> getStudentsByMajor(String major) {
        return convertStudentListToStudentDTOList(studentRepository.getStudentsByMajor(major));
    }

    public List<CourseDTO> getCoursesByStudentId(int id) {

        List<Course> courses = studentRepository.getCoursesByStudentId(id);
        List<CourseDTO> courseDTOs = new ArrayList<>();

        courses.forEach(c -> {
           CourseDTO courseDTO = new CourseDTO(
             c.getId(),
             c.getName(),
             c.getCode()
           );
           courseDTOs.add(courseDTO);
        });

        return courseDTOs;
    }

    private List<StudentDTO> convertStudentListToStudentDTOList(List<Student> students) {
        List<StudentDTO> studentDTOs = new ArrayList<>();

        students.forEach(c -> {
            StudentDTO studentDTO = new StudentDTO(
                    c.getId(),
                    c.getFirstName(),
                    c.getLastName(),
                    c.getEmail(),
                    c.getMajor(),
                    c.getGpa(),
                    c.getCoursesTaken()
            );
            studentDTOs.add(studentDTO);
        });
        return studentDTOs;
    }
}
