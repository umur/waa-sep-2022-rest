package miu.edu.restfuldemo.service.implementation;

import miu.edu.restfuldemo.dto.CourseDTO;
import miu.edu.restfuldemo.dto.StudentDTO;
import miu.edu.restfuldemo.entity.Course;
import miu.edu.restfuldemo.entity.Student;
import miu.edu.restfuldemo.repository.StudentRepository;
import miu.edu.restfuldemo.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class StudentServiceImplementation implements StudentService {
    private StudentRepository studentRepository;
    private ModelMapper mapper;

    @Autowired
    public StudentServiceImplementation(StudentRepository studentRepository, ModelMapper mapper) {
        this.studentRepository = studentRepository;
        this.mapper = mapper;
    }

    public void save(StudentDTO studentDTO) {
        var student = mapper.map(studentDTO, Student.class);
        studentRepository.add(student);
    }

    public List<StudentDTO> findAll() {
        return convertStudentListToStudentDTOList(studentRepository.findAll());
    }

    public StudentDTO getById(int id) {
        Student student = studentRepository.getById(id);
        var studentDTO = mapper.map(student, StudentDTO.class);
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
            var courseDTO = mapper.map(c, CourseDTO.class);
            courseDTOs.add(courseDTO);
        });

        return courseDTOs;
    }

    private List<StudentDTO> convertStudentListToStudentDTOList(List<Student> students) {
        List<StudentDTO> studentDTOs = new ArrayList<>();

        students.forEach(c -> {
            var studentDTO = mapper.map(c, StudentDTO.class);
            studentDTOs.add(studentDTO);
        });
        return studentDTOs;
    }
}
