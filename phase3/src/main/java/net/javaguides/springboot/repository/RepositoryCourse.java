package net.javaguides.springboot.repository;

import net.javaguides.springboot.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositoryCourse{
    private static List<Course> courses= new ArrayList<>();

    public RepositoryCourse(){
        Course c1= new Course(1,"WAA", "CS545");
        Course c2= new Course(2, "MWA","CS567");

        courses.add(c1);
        courses.add(c2);
    }
    public List<Course> findAll(){
        return courses;
    }

    public void create(Course c){
        courses.add(c);
    }

    public void deleteById(int id){
        courses.remove(id-1);
    }

    public void updateById(Course newCourse, int id){
        Course oldCourse =findAll()
           .stream()
           .filter(c-> c.getId()==id)
           .findFirst().get();
        oldCourse.setCode((newCourse.getCode()));
        oldCourse.setName(newCourse.getName());
    }


}
