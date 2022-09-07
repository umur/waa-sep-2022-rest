package henry.phasei.service.impl;

import henry.phasei.entity.Course;
import henry.phasei.entity.Student;
import henry.phasei.repo.StudentRepo;
import henry.phasei.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepo studentRepo;

    @Override
    public void save(Student student) {
        if (student.getCoursesTaken() == null) {
            student.setCoursesTaken(new ArrayList<>());
        }
        studentRepo.add(student);
    }

    @Override
    public List<Student> findAll() {
        return studentRepo.getStudents();
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepo.getStudentsByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(int studentId) {
        return studentRepo.getCoursesByStudentId(studentId);
    }

    @Override
    public void takeCourse(int studentId, Course course) {
        studentRepo.takeCourse(studentId, course);
    }

    @Override
    public void update(int studentId, Student student) {
        studentRepo.update(studentId, student);
    }

    @Override
    public Student delete(int studentId) {
        return studentRepo.delete(studentId);
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
