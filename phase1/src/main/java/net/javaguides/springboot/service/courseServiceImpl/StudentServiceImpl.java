package net.javaguides.springboot.service.courseServiceImpl;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.entity.Course;
import net.javaguides.springboot.entity.Student;
import net.javaguides.springboot.repository.RepositoryStudent;
import net.javaguides.springboot.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private  final RepositoryStudent studentRepo;

    @Override
    public List<Student> findAll() {
        var students= studentRepo.findAll();
        var result = new ArrayList<Student>();

        for (Student student: students) {
            result.add(student);
        }
        return result;
    }

    @Override
    public void create(Student student) { studentRepo.create(student);}

    @Override
    public void delete(int id) {studentRepo.deleteById(id);}

    @Override
    public List<Student> findByMajor(String major) {
        var students = studentRepo.findAll();
        var result = new ArrayList<Student>();

        String variable = major.substring(1, major.length()-1);
        for (Student student: students) {
            if (student.getMajor().contentEquals(variable)) {
                result.add(student);
            }
        }
        return result;
    }



    @Override
    public List<Course> findByIdCourse(int id) {
        var student = studentRepo.findById(id);
        return student.getCourseTaken();
    }
}
