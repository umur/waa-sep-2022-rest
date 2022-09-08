package miu.edu.lab2.PhaseOne.Repository;

import miu.edu.lab2.PhaseOne.Domain.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {

    static List<Course> courses=new ArrayList<>();

    int currentId=2;
    static{
        Course course2=new Course(2,"mwa","CS554");
        Course course1=new Course(1,"waa","CS555");
        courses.add(course1);
        courses.add(course2);
    }

    public List<Course> findAll(){
        return courses;
    }

    public void save(Course course){
        course.setId(currentId++);
        courses.add(course);
    }

    public void update(int id,Course course){
        int index=0;
        int num=-1;
        for(Course c:courses){
            if(c.getId()==id){
                num++;
                break;
            }
            index++;
        }
        if(num!=-1) {
            courses.set(index,course);
        }
    }

    public Course findById(int id) {
        return courses.stream().filter(c->c.getId()==id).findFirst().orElse(null);

    }


    public void delete(int id){
        int num=-1;
        int index=0;
        for(Course c:courses){
            if(c.getId()==id){
                num++;
                break;
            }
            index++;
        }
        if(num!=-1)courses.remove(index);
    }

}
