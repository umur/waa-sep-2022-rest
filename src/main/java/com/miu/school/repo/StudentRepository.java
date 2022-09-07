package com.miu.school.repo;

import com.miu.school.entity.Course;

import com.miu.school.entity.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class StudentRepository  {





    private static List<Student> students = new ArrayList<>();
    static {
        List<Course> courses =CourseRepository.courses;
        Student s1= new Student(1,"Hiwot","Reta","hiwireta3@gmail.com","Computer Science",3.83,courses);
        Student s2= new Student(2,"Kidist","Reta","kidireta@gmail.com","Computer Science",3.86,courses);
        Student s3= new Student(3,"Dawit","Neguse","hiwireta3@gmail.com","Computer Science",3.85,courses.subList(0,1));
        students.add(s1);
        students.add(s2);
        students.add(s3);
        }
        public List<Student> getAllStudents(){
            return students;
        }
        public Optional<Student> getStudent(int id){
            return students.stream().filter(student -> student.getId() == id).findAny();
        }
        public void save(Student student){
            students.add(student);
        }

        public void updateStudent(Student student,int id){

            Student studen = students.stream().filter(student1 -> student1.getId() == id).findAny().get();
            studen.setId(studen.getId());
            studen.setFirstName(studen.getFirstName());

        }

        public void deleteStudentById(int id){
            Optional<Student> toBedeleted = students.stream().filter(student -> student.getId() == id).findAny();
            students.remove(toBedeleted.get());
        }


    public List<Student> getStudentByMajor(String major) {
        return students.stream().filter(student -> student.getMajor().equals(major)).collect(Collectors.toList());
    }

    public List<Course> getCourseByStudentId(int id) {
        return students.stream().filter(student -> student.getId() == id).findAny().get().getCourses();
    }
}
