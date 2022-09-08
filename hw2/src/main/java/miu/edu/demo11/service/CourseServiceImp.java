package miu.edu.demo11.service;

import miu.edu.demo11.entity.Course;
import miu.edu.demo11.repo.CourseRepo;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class CourseServiceImp {

    private CourseRepo courseRepo;

    List<Course> findAll(){
        return courseRepo.findAll();
    }

    public Course save(Course course){
        return courseRepo.save(course);
    }

    public Course update(Integer id, Course body){
        Optional<Course> updating = courseRepo.findById(id);
        if(updating.isPresent()){
            return courseRepo.save(updating.get());
        }throw new NoSuchElementException("Could not found");
    }



    public Course findOne(Integer id){
        Optional<Course> found = courseRepo.findById(id);
        if(found.isPresent()){
            return found.get();
        }throw new NoSuchElementException("Not found");
    }


    public void delete(Integer id ){
        courseRepo.deleteById(id);
    }




}
