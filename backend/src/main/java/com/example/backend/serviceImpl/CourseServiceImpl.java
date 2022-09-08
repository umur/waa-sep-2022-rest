package com.example.backend.serviceImpl;

import com.example.backend.dto.CourseDTO;
import com.example.backend.dto.StudentDTO;
import com.example.backend.entity.Course;
import com.example.backend.entity.Student;
import com.example.backend.repository.CourseRepo;
import com.example.backend.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepo courseRepo;

    private final ModelMapper modelMapper;

    public List<CourseDTO> getAll(){
        return courseRepo.getAll()
                .stream().map(course -> modelMapper.map(course, CourseDTO.class))
                .collect(Collectors.toList());
    }

    public CourseDTO getById(int id){
        Course course = courseRepo.getById(id);
        if(course != null){
            return modelMapper.map(course, CourseDTO.class);
        }
        return null;
    }

    public void delete(int id){
        courseRepo.delete(id);
    }

    public void update( int id, CourseDTO course){
        courseRepo.update(id, modelMapper.map(course, Course.class));
    }

    @Override
    public CourseDTO create(CourseDTO course) {
        return modelMapper.map(courseRepo.create(modelMapper.map(course, Course.class)), CourseDTO.class);
    }
}
