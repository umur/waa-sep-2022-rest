package miu.rest.repositories;

import miu.rest.model.Course;
import miu.rest.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CourseRepo {
    private static List<Course> courses = new ArrayList<>();
//    private List<Student> students = new ArrayList<>();

    static{
        Course c1 = new Course(1,"WAA", "CS545");
        Course c2 = new Course(2,"WAP", "CS472");
        courses.add(c1);
        courses.add(c2);

    }




    public void add(Course c){
        courses.add(c);
    }

    public List<Course> getCourses(){
        return courses;
    }

    public Course findById(int id) {
        Course c = courses.stream().filter(cid->(cid.getId()==id)).findAny().get();
        return c;
    }

    public void deleteById(int id) {
        Course c = courses.stream().filter(cid->(cid.getId()==id)).findAny().get();
        courses.remove(c);
    }

    public List<Course> findAll(){
        return courses;
    }


}
