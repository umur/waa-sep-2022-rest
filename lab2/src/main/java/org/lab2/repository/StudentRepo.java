package org.lab2.repository;

import lombok.RequiredArgsConstructor;
import org.lab2.entity.Course;
import org.lab2.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class StudentRepo {
    private static final List<Student> students = new ArrayList<>();
    private static int studentID=1;

    static {


        List<Course> courses = new ArrayList<>();
        Student c1 = new Student(1,"a","bold","bold@gmail.com","CS",3.3,courses);

        students.add(c1);

    }

    public void add(Student student){
        student.setId(++studentID);
        students.add(student);
    }

    public  List<Student> getStudents()
    {
        return  students;
    }
    public Student update(Student student){
        for (Student stu:students){
            if(stu.getId().equals(student.getId())){

                int index = students.indexOf(stu);
                students.set(index,student);
                break;
            }
        }
        return student;

    }
    public void delete(Integer studentID){
        students.removeIf(c -> c.getId().equals(studentID));

    }
}
