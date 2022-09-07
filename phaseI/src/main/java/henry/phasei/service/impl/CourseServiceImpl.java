package henry.phasei.service.impl;

import henry.phasei.entity.Course;
import henry.phasei.repo.CourseRepo;
import henry.phasei.service.CourseService;
import henry.phasei.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseRepo courseRepo;

    @Autowired
    StudentService studentService;

    @Override
    public void save(Course course) {
        courseRepo.add(course);
    }

    @Override
    public List<Course> findAll() {
        return courseRepo.getCourses();
    }

    @Override
    public void update(int courseId, Course course) {
        courseRepo.update(courseId, course);
        studentService.updateCourse(courseId, course);
    }

    @Override
    public Course delete(int courseId) {
        studentService.deleteCourse(courseId);
        return courseRepo.delete(courseId);
    }
}
