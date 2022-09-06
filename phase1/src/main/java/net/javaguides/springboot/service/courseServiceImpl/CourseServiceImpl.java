package net.javaguides.springboot.service.courseServiceImpl;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.entity.Course;
import net.javaguides.springboot.repository.RepositoryCourse;
import net.javaguides.springboot.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {
 private final RepositoryCourse courseRepo;

    @Override
    public List<Course> findAll(){
        var courses= courseRepo.findAll();
        var result = new ArrayList<Course>();

        for(Course course: courses){
            result.add(course);
        }
        return result;
    }
    @Override
    public void create(Course course){
         courseRepo.create(course);
    }

    @Override
    public void delete(int id){
        courseRepo.deleteById(id);
    }

    @Override
    public void update(Course course, int id){
        courseRepo.updateById(course,id);
    }



}
