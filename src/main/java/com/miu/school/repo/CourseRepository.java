package com.miu.school.repo;

import com.miu.school.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class CourseRepository  {

     public static List<Course> courses = new ArrayList<>();
     static {
         Course c1 = new Course(1, "Web Application and Architecture", "WAA");
         Course c2 = new Course(2, "Wep Programming", "WAp");
         Course c3 = new Course(3, "Algorithm", "Alg");
         courses.add(c1);
         courses.add(c2);
         courses.add(c3);
     }

       public List<Course> getAllCourse(){
         return courses;
       }

       public Optional<Course> findCourseById(int id){
         return courses.stream().filter(course -> course.getId() == id).findAny();
       }

       public void save(Course course){
         courses.add(course);
       }

       public void deleteCourseById(int id){
            Optional<Course> toBedeleted = courses.stream().filter(course -> course.getId() == id).findAny();
            courses.remove(toBedeleted.get());
        }

        public void updateCourseById(Course course,int id){
            courses.stream().filter(course1 -> course1.getId() == id).map(course1 -> {course1.setId(course.getId());
                course1.setName(course.getName());
                course1.setCode(course.getCode());
                System.out.println(course1.getName());
                return courses.add(course1);
            });

        }





}
