package edu.miu.phase1.repo;

import edu.miu.phase1.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {
    public static List<Course> courses = new ArrayList<>();
   private static int currentId = 5;

    static {
        Course c1 = new Course(1,"FPP","CS100");
        Course c2 = new Course(2,"MPP","CS200");
        Course c3 = new Course(3,"WAP","CS300");
        Course c4 = new Course(4,"WAA","CS400");

        courses.add(c1);
        courses.add(c2);
        courses.add(c3);
        courses.add(c4);

    }

    //CRUD Operations


    // Create new Courses
    public void save(Course course){
        course.setId(currentId++);
        courses.add(course);
    }

    // Retrieve all courses
    public List<Course> getAll(){
        return courses;
    }

    //Update course
    public void updateCourse(int id, Course newCourse){
        int index = 0;
        for (Course c : courses) {
            if (c.getId() == id) {
                newCourse.setId(id);
                courses.set(index, newCourse);
                break;
            }
            index++;
        }
    }

    //Delete Course
    public void deleteCourse(int id){
        Course course = courses.stream()
                .filter(c -> c.getId() == id)
                .findFirst().orElse(null);
        courses.remove(course);
    }


    //Gets course by course code
    public Course findByCode(String code){
        return courses.stream()
                .filter(course -> course.getCode().equals(code))
                .findFirst().orElse(null);
    }
}
