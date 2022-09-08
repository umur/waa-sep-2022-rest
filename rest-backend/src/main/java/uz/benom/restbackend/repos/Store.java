package uz.benom.restbackend.repos;

import uz.benom.restbackend.entities.Course;
import uz.benom.restbackend.entities.Student;

import java.util.ArrayList;
import java.util.List;

public class Store {
    static final List<Student> students = new ArrayList<>();
    static final List<Course> courses = new ArrayList<>();
    private static int idSeq = 0;

    static int getNextId(){
        return idSeq++;
    }
}
