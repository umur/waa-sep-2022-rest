package Com.Restful.Ass2.Repo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import Com.Restful.Ass2.Models.Course;
import Com.Restful.Ass2.Models.Student;


@Repository

public class StudentRepo {
    private static Map<Integer, Student> students = new HashMap();
    
    public Student createStudent(Student student) {
        return students.put(student.id, student);
    }
    
    public Student findStudentOne(int id) {
        return students.get(id);
    }
    public void deleteStudentOne(int id) {
        students.remove(id);
    }
    public Student updateStudent(Student student) {
       return students.put(student.id, student);
    }
    public List<Student> findAllStudents() {
        return students.values().stream().collect(Collectors.toList());
    }
    public List<Student> getStudentsByMajor(String major) {
        return students.values()
                .stream()
                .filter(student ->student.getMajor() == major)
                .collect(Collectors.toList());
    }

    public List<Course> getCoursesByStudentId(int id) {
        return students.get(id).getCourseTaken();
    }
}
