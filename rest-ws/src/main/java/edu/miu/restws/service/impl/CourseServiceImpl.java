package edu.miu.restws.service.impl;

import edu.miu.restws.dto.CourseDto;
import edu.miu.restws.mapper.CourseMapper;
import edu.miu.restws.repo.CourseRepository;
import edu.miu.restws.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseMapper courseMapper;

    private final CourseRepository courseRepository;

    @Override
    public void save(CourseDto courseDto) {
        courseRepository.save(courseMapper.toEntity(courseDto));
    }

    @Override
    public void delete(int id) {
        courseRepository.delete(id);
    }

    @Override
    public void update(CourseDto courseDto) {
        courseRepository.update(courseMapper.toEntity(courseDto));
    }

    @Override
    public List<CourseDto> findAllCourses() {
        return courseMapper.toDtos(courseRepository.getAllCourses());
    }

    @Override
    public CourseDto findById(int id) {
        return courseMapper.toDto(courseRepository.getById(id));
    }

    @Override
    public List<CourseDto> findCoursesByStudentId(int studentId) {
        return courseMapper.toDtos(courseRepository.getCoursesByStudentId(studentId));
    }
}
