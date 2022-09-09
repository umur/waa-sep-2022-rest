package miu.rest.service.impl;

import miu.rest.model.Course;
import miu.rest.repositories.CourseRepo;
import miu.rest.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public void save(Course c){
        courseRepo.add(c);
    }

    public List<Course> findAll(){
        return courseRepo.getCourses();
    }

    @Override
    public Course findById(int id) {
        return courseRepo.findById(id);
    }

    @Override
    public void delete(int id) {
        courseRepo.deleteById(id);

    }
}
