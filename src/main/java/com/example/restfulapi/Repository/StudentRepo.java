package com.example.restfulapi.Repository;

import com.example.restfulapi.Model.Course;
import com.example.restfulapi.Model.Student;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {

    public static List<Student> students = new ArrayList<>();
    public static List<Course> courses = new ArrayList<>();
    private int studentID=4;

    static{
        Course c1= new Course(1,"WAA","CS556");
        Course c2= new Course(2,"EA","CS537");
        Course c3 = new Course(3,"MWA","CS599");
        courses.add(c1);
        courses.add(c2);
        courses.add(c3);

        Student s1 = new Student(1,"john","doe","john.doe@john.com","CS",3.56,courses);
        Student s2 = new Student(2,"doe","john","doe.john@doe.com","CS",3.96,courses);
        Student s3 = new Student(3,"jane","doe","jane.doe@jane.com","CS",4,courses);
        students.add(s1);
        students.add(s2);
        students.add(s3);
    }

    public List<Student> getAllStudents(){
        return students;
    }
    public Student saveStudent(Student student){
       student.setId(studentID);
        students.add(student);
        studentID++;
        return student;
    }
    public void updateStudent(int id, Student student){
        int index=0;
        for(Student s: students){
            if(s.getId()==id){
              students.set(index,student);
              break;
            }else index++;
        }
    }

    public void deleteStudent(int id){
        int index=0;
        for(Student s : students){
            if(id==s.getId()){
                students.remove(index);
                break;
            }else index++;
        }
    }
    public List<Student>getAllStudentByMajor(String major){
      return students.stream()
                .filter(s->s.getMajor().equals(major))
                .collect(Collectors.toList());
    }

    public List<Course>getAllCoursesByStudentId(int id){
        return students.stream()
                .filter(s->s.getId()==id)
                .flatMap(s -> s.getCourseTaken().stream())
                .collect(Collectors.toList());
    }





}
