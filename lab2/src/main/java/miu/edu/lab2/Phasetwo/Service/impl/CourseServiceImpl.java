package miu.edu.lab2.Phasetwo.Service.impl;

import miu.edu.lab2.Phasetwo.Domain.Course;
import miu.edu.lab2.Phasetwo.Dto.CourseDTO;
import miu.edu.lab2.Phasetwo.Repository.CourseRepository;
import miu.edu.lab2.Phasetwo.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;


    @Override
    public CourseDTO findById(int id) {
        return CourseDTO.changeTOCourseDTO(courseRepository.findById(id));
        //return courseRepository.findById(id);
    }

    @Override
    public List<CourseDTO> findAll() {
        return courseRepository.findAll().stream().map(a->CourseDTO.changeTOCourseDTO(a)).toList();
    }

    @Override
    public void create(CourseDTO courseDTO) {
         courseRepository.save(CourseDTO.changeToCourse(courseDTO));
    }

    @Override
    public void update(int id, CourseDTO course) {
        courseRepository.update(id,CourseDTO.changeToCourse(course));

    }

    @Override
    public void delete(int id) {
     courseRepository.delete(id);
    }
}
