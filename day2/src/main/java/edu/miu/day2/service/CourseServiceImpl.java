package edu.miu.day2.service;

import edu.miu.day2.entity.Course;
import edu.miu.day2.repo.StudentAndCourseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{

    private final StudentAndCourseRepo studentAndCourseRepo;
    @Override
    public Course createCourse(Course course) {

        return StudentAndCourseRepo.createCourse(course);
    }

    @Override
    public List<Course> getCourses() {
        return StudentAndCourseRepo.getAllCourse();
    }

    @Override
    public Course getCourse(Long id) {
        return studentAndCourseRepo.getAllCourse(id);
    }

    @Override
    public Course updateCourse(Long id, Course course) {
        return studentAndCourseRepo.updateCourse(id, course);
    }

    @Override
    public Course deleteCourse(Long id) {
        return studentAndCourseRepo.deleteCourse(id);
    }
}
