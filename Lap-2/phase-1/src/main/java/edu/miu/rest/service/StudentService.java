package edu.miu.rest.service;
import edu.miu.rest.entity.Course;
import edu.miu.rest.entity.Student;
import java.util.List;
public interface StudentService {
    List<Student> findAll();
    public void create(Student student);
    public void update(Student std, int id);
    public String DeleteById(int id);
    public Student getById(int id);
    public List<Student > getStudentsByMajor(String major);
    public List<Course> getCoursesByStudentId(int studentId);

}
