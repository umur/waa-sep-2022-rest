package edu.miu.phase1.repo;

import edu.miu.phase1.entity.Course;
import edu.miu.phase1.entity.Student;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {
    public static List<Student> students = new ArrayList<>();
    private static int currentId = 3;

    static {
        Student s1 = new Student(1,"Zelalem","Belayneh","zola@gmail.com","CS",4.00f,CourseRepo.courses);
        Student s2 = new Student(2,"Bereket","Daniel","bereket@gmail.com","CS",4.00f,CourseRepo.courses);

        students.add(s1);
        students.add(s2);
    }

    //CRUD Operations

    // Create new Student
    public void save(Student student) {
        student.setId(currentId++);
        students.add(student);
    }

    // Retrieve All Students
    public List<Student> findAll(){
        return students;
    }

    // Update Students
    public void update(int id, Student student){
        int index = 0;
        for(Student s :students){
            if(s.getId()==id){
                student.setId(id);
                students.set(index,student);
                break;
            }
            index++;
        }
    }

    // Delete Student
    public void delete(int id){
        Student s = students.stream().filter(student -> student.getId() == id).findFirst().orElse(null);
        students.remove(s);
    }


    // Get student by ID
    public Student findById(int id){
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst().orElse(null);
    }

    // Get Student by major
    public List<Student> getStudentsByMajor(String major){
        return students.stream()
                .filter(student -> student.getMajor().equals(major))
                .toList();
    }

    // Returns all courses of the student
    public List<Course> getCoursesByStudentId(int studentId) {
            return students.stream()
                    .filter(student -> student.getId() == studentId )
                    .flatMap(c -> c.getCoursesTaken().stream())
                    .collect(Collectors.toList());
    }


}
