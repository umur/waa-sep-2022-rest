package com.example.restfulapi.Repository;

import com.example.restfulapi.Model.Course;
import com.example.restfulapi.Model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CourseRepo {
    private int courseId=4;
    public static  List<Course> courses =new ArrayList<>();


    static{
        Course c1= new Course(1,"WAA","CS545");
        Course c2= new Course(2,"WAP","CS472");
        Course c3= new Course(3,"EA","CS578");
        courses.add(c1);
        courses.add(c2);
        courses.add(c3);

    }

    public List<Course> getCourses(){
        return courses;
    }
    public Course saveCourse(Course course){
        course.setId(courseId);
        courses.add(course);
        courseId++;
        return course;
    }
    public void updateCourse(int id, Course course){
        int index=0;
        for(Course c: courses){
            if(id==c.getId()){
                courses.set(index,course);
                break;
            }
            index++;
        }
    }
    public void deleteCourse(int id){
        int index=0;
        for(Course c:courses){
            if(c.getId()==id){
                courses.remove(index);
                break;
            }
            else index++;
        }

    }








}
