package henry.phaseiii.service.impl;

import henry.phaseiii.dto.CourseDto;
import henry.phaseiii.dto.StudentDto;
import henry.phaseiii.entity.Course;
import henry.phaseiii.entity.Student;
import henry.phaseiii.repo.StudentRepo;
import henry.phaseiii.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void save(StudentDto studentDto) {
        if (studentDto.getCoursesTaken() == null) {
            studentDto.setCoursesTaken(new ArrayList<>());
        }

        studentRepo.add(modelMapper.map(studentDto, Student.class));
    }

    private List<StudentDto> getStudentDtos(List<Student> students) {
        List<StudentDto> studentDtos = new ArrayList<>();
        students.forEach(s -> {
            studentDtos.add(modelMapper.map(s, StudentDto.class));
        });

        return studentDtos;
    }

    @Override
    public List<StudentDto> findAll() {
        return getStudentDtos(studentRepo.getStudents());
    }

    @Override
    public List<StudentDto> getStudentsByMajor(String major) {
        return getStudentDtos(studentRepo.getStudentsByMajor(major));
    }

    @Override
    public List<CourseDto> getCoursesByStudentId(int studentId) {
        var courses = studentRepo.getCoursesByStudentId(studentId);
        List<CourseDto> courseDtos = new ArrayList<>();
        courses.forEach(c -> courseDtos.add(modelMapper.map(c, CourseDto.class)));

        return courseDtos;
    }

    @Override
    public void takeCourse(int studentId, CourseDto courseDto) {
        studentRepo.takeCourse(studentId, modelMapper.map(courseDto, Course.class));
    }

    @Override
    public void update(int studentId, StudentDto studentDto) {
        studentRepo.update(studentId, modelMapper.map(studentDto, Student.class));
    }

    @Override
    public StudentDto delete(int studentId) {
        Student student = studentRepo.delete(studentId);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public void updateCourse(int courseId, Course course) {
        List<Student> students = studentRepo.getStudents();
        students.stream()
                .filter(s -> s.getCoursesTaken().stream().anyMatch(c -> c.getId() == courseId))
                .forEach(s -> s.getCoursesTaken().forEach(c -> {
                    if (c.getId() == courseId) {
                        c.setName(course.getName());
                        c.setCode(course.getCode());
                    }
                }));
    }

    @Override
    public void deleteCourse(int courseId) {
        List<Student> students = studentRepo.getStudents();
        students.stream()
                .filter(s -> s.getCoursesTaken().stream().anyMatch(c -> c.getId() == courseId))
                .forEach(s -> s.setCoursesTaken(s.getCoursesTaken().stream().filter(c -> c.getId() != courseId).collect(Collectors.toList())));
    }
}
