package henry.phaseiii.repo;

import henry.phaseiii.entity.Course;
import henry.phaseiii.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {
    private static List<Student> students = new ArrayList<>();
    private int seq = 2;

    static {
        Student s1 = new Student(1, "Bill", "Gates", "gates@miu.edu", "CS", 4.1, new ArrayList<>());
        students.add(s1);

        Student s2 = new Student(2, "Elon", "Musk", "musk@miu.edu", "CS", 4.5, new ArrayList<>());
        students.add(s2);
    }

    public Student add(Student student) {
        student.setId(++seq);
        students.add(student);
        return student;
    }

    public void takeCourse(int studentId, Course course) {
        students.forEach(s -> {
            if (s.getId() == studentId) {
                s.getCoursesTaken().add(course);
            }
        });
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Student> getStudentsByMajor(String major) {
        return students.stream().filter(s -> s.getMajor().equals(major)).toList();
    }

    public List<Course> getCoursesByStudentId(int studentId) {
        List<Course> courses = new ArrayList<>();
        students.stream().filter(s -> s.getId() == studentId).findFirst().ifPresent(s-> courses.addAll(s.getCoursesTaken()));
        return  courses;
    }

    public void update(int studentId, Student student) {
        students.stream().filter(s -> s.getId() == studentId).findFirst().ifPresent(s -> {
            s.setFirstName(student.getFirstName());
            s.setLastName(student.getLastName());
            s.setEmail(student.getEmail());
            s.setMajor(student.getMajor());
            s.setGpa(student.getGpa());
            s.setCoursesTaken(student.getCoursesTaken() != null ? student.getCoursesTaken() : new ArrayList<>());
        });
    }

    public Student delete(int studentId) {
        Student student = students.stream().filter(s->s.getId() == studentId).findFirst().orElse(null);

        students = students.stream().filter(s -> s.getId() != studentId).collect(Collectors.toList());

        return student;
    }
}
