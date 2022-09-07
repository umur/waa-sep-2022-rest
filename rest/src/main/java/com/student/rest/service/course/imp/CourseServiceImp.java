package com.student.rest.service.course.imp;

import com.student.rest.dto.CourseDto;
import com.student.rest.exceptions.course.CourseDoesNotExistsException;
import com.student.rest.exceptions.course.CourseAlreadyExistsException;
import com.student.rest.model.Course;
import com.student.rest.repo.CourseRepo;
import com.student.rest.service.course.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImp implements CourseService {
    @Autowired
    private CourseRepo courseRepo;

    private ModelMapper mapper;

    public Course add(Course course) throws CourseAlreadyExistsException {
        if (courseRepo.exists(course.getId())) {
            throw new CourseAlreadyExistsException("Course Already Exists !!!");
        }

        mapper = new ModelMapper();
        Course mappedCourse = mapper.map(course, Course.class);

        return courseRepo.addCourse(mappedCourse);
    }

    @Override
    public List<Course> get() {
        return courseRepo.getCourses();
    }

    @Override
    public boolean updateCourse(Course course, int id) throws CourseDoesNotExistsException {
        if (!courseRepo.exists(id)) {
            throw new CourseDoesNotExistsException("Course Already Exists !!!");
        }

        mapper = new ModelMapper();
        Course mappedCourse = mapper.map(course, Course.class);

        return courseRepo.updateCourse(mappedCourse, id);
    }

    @Override
    public boolean deleteCourse(int id) throws CourseDoesNotExistsException {
        if (!courseRepo.exists(id)) {
            throw new CourseDoesNotExistsException("Course Already Exists !!!");
        }
        return courseRepo.deleteCourse(id);
    }

}
