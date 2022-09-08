package miu.edu.lab2.PhaseThree.Service.impl;

import miu.edu.lab2.PhaseThree.Domain.Course;
import miu.edu.lab2.PhaseThree.Dto.CourseDTO;
import miu.edu.lab2.PhaseThree.Repository.CourseRepository;
import miu.edu.lab2.PhaseThree.Service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public CourseDTO findById(int id) {
        //return CourseDTO.changeTOCourseDTO(courseRepository.findById(id));
        return modelMapper.map(courseRepository.findById(id),CourseDTO.class);
    }

    @Override
    public List<CourseDTO> findAll() {
        return courseRepository.findAll().stream()
                .map(a-> modelMapper.map(a,CourseDTO.class)).toList();
    }

    @Override
    public void create(CourseDTO courseDTO) {
         courseRepository.save(modelMapper.map(courseDTO, Course.class));
    }

    @Override
    public void update(int id, CourseDTO course) {
        courseRepository.update(id, modelMapper.map(course,Course.class));

    }

    @Override
    public void delete(int id) {
     courseRepository.delete(id);
    }
}
