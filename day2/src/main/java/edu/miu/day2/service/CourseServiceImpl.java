package edu.miu.day2.service;

import edu.miu.day2.entity.Course;
import edu.miu.day2.entity.DTO.CourseDTO;
import edu.miu.day2.repo.StudentAndCourseRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{

    private final ModelMapper modelMapper;
    private final StudentAndCourseRepo studentAndCourseRepo;
    @Override
    public CourseDTO createCourse(CourseDTO course) {

        return modelMapper.map(StudentAndCourseRepo.createCourse(modelMapper.map(course,Course.class)),CourseDTO.class);
    }

    @Override
    public List<CourseDTO> getCourses() {
        List<Course> courses= StudentAndCourseRepo.getAllCourse();
        return courses.stream().map(c->modelMapper.map(c,CourseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public CourseDTO getCourse(Long id) {

        return modelMapper.map(studentAndCourseRepo.getAllCourse(id),CourseDTO.class);
    }

    @Override
    public CourseDTO updateCourse(Long id, CourseDTO course) {
        return modelMapper.map(studentAndCourseRepo.updateCourse(id, modelMapper.map(course,Course.class)), CourseDTO.class);
    }

    @Override
    public CourseDTO deleteCourse(Long id) {
        return modelMapper.map(studentAndCourseRepo.deleteCourse(id),CourseDTO.class);
    }
}
