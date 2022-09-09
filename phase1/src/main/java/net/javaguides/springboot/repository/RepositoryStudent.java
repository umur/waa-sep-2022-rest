package net.javaguides.springboot.repository;

import net.javaguides.springboot.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class RepositoryStudent {
    private static List<Student> students = new ArrayList<>();

//    public RepositoryStudent(){
//        Student s1 = new Student(1,"Zaya","Ganaa","Zaya@gmail.com","Computer Science",100, "WAA");
//        Student s1 = new Student(1,"Zaya","Ganaa","Zaya@gmail.com","Computer Science",100, "WAA");
//
//    }


    public List<Student> findAll(){
        return students;
    }

    public void create(Student s){
        students.add(s);
    }

    public void deleteById(int id){
        students.remove(id-1);
    }

    public Student findById(int id){
        return students
                .stream()
                .filter(s-> s.getId()== id)
                .findFirst()
                .orElse(null);
    }
}
