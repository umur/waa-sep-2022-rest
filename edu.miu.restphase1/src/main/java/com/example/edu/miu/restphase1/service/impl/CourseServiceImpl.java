package com.example.edu.miu.restphase1.service.impl;

import com.example.edu.miu.restphase1.entity.Course;
import com.example.edu.miu.restphase1.repository.CourseRepo;
import com.example.edu.miu.restphase1.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;

    @Override
    public void save(Course course){
        courseRepo.save(course);
    }
    @Override
    public void update(Course course){
        courseRepo.update(course);
    }
    @Override
    public void delete(int id){
        courseRepo.delete(id);
    }
    @Override
    public Course getById(int id){
        return courseRepo.getById(id);
    }
    @Override
    public List<Course> getAll(){
        return courseRepo.getAll();
    }
}
