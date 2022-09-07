package henry.phaseii.service.impl;

import henry.phaseii.dto.CourseDto;
import henry.phaseii.dto.StudentDto;
import henry.phaseii.entity.Course;
import henry.phaseii.entity.Student;
import henry.phaseii.repo.StudentRepo;
import henry.phaseii.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Override
    public void save(StudentDto studentDto) {
        if (studentDto.getCoursesTaken() == null) {
            studentDto.setCoursesTaken(new ArrayList<>());
        }

        Student student = new Student(studentDto.getId(), studentDto.getFirstName(), studentDto.getLastName(),
                studentDto.getEmail(), studentDto.getMajor(), studentDto.getGpa(), studentDto.getCoursesTaken());
        studentRepo.add(student);
    }

    private List<StudentDto> getStudentDtos(List<Student> students) {
        List<StudentDto> studentDtos = new ArrayList<>();
        students.forEach(s -> {
            studentDtos.add(new StudentDto(s.getId(), s.getFirstName(), s.getLastName(),
                    s.getEmail(), s.getMajor(), s.getGpa(), s.getCoursesTaken()));
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
        courses.forEach(c -> courseDtos.add(new CourseDto(c.getId(), c.getName(), c.getCode())));

        return courseDtos;
    }

    @Override
    public void takeCourse(int studentId, CourseDto courseDto) {
        Course course = new Course(courseDto.getId(), courseDto.getName(), courseDto.getCode());
        studentRepo.takeCourse(studentId, course);
    }

    @Override
    public void update(int studentId, StudentDto studentDto) {
        Student student = new Student(studentDto.getId(), studentDto.getFirstName(), studentDto.getLastName(),
                studentDto.getEmail(), studentDto.getMajor(), studentDto.getGpa(), studentDto.getCoursesTaken());
        studentRepo.update(studentId, student);
    }

    @Override
    public StudentDto delete(int studentId) {
        Student student = studentRepo.delete(studentId);
        return new StudentDto(student.getId(), student.getFirstName(), student.getLastName(),
                student.getEmail(), student.getMajor(), student.getGpa(), student.getCoursesTaken());
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
