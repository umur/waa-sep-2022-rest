package edu.miu.phase2.service.impl;

import edu.miu.phase2.repo.CourseRepo;
import edu.miu.phase2.dto.CourseDto;
import edu.miu.phase2.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepo courseRepo;

    @Override
    public CourseDto save(CourseDto course) {
        return courseRepo.add(course);
    }

    @Override
    public List<CourseDto> findAll() {
        return courseRepo.findAll();
    }

    @Override
    public CourseDto findById(int id) {
        return courseRepo.getCourseById(id);
    }

    @Override
    public CourseDto update(int id, CourseDto course) {
        return courseRepo.updateCourse(id, course);
    }

    @Override
    public CourseDto delete(int id) {
        return courseRepo.deleteCourseById(id);
    }
}
