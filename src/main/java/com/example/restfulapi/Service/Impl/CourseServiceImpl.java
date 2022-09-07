package com.example.restfulapi.Service.Impl;

import com.example.restfulapi.DTO.CourseDTO;
import com.example.restfulapi.Model.Course;
import com.example.restfulapi.Repository.CourseRepo;
import com.example.restfulapi.Service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {
   private CourseRepo courseRepo;
   private ModelMapper modelMapper;
    public CourseServiceImpl(CourseRepo courseRepo, ModelMapper modelMapper){
        this.courseRepo=courseRepo;
        this.modelMapper=modelMapper;
    }

    @Override
    public void saveCourse(CourseDTO course) {
        Course crs= modelMapper.map(course,Course.class);
        courseRepo.saveCourse(crs);

    }

    @Override
    public List<CourseDTO> findAllCourses() {
        List<Course> crs=  courseRepo.getCourses();
        List<CourseDTO> coursedto =new ArrayList<>();
        for(Course c:crs){
            CourseDTO crsdto=modelMapper.map(c,CourseDTO.class);
            coursedto.add(crsdto);
        }
        return coursedto;
    }

    @Override
    public void updateCourse(int id,CourseDTO course) {
        Course crs= modelMapper.map(course,Course.class);
        courseRepo.updateCourse(id,crs);
    }
    @Override
    public void deleteCourse(int id) {
        courseRepo.deleteCourse(id);
    }



}
