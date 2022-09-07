package edu.miu.restws.repo;

import edu.miu.restws.database.DataSource;
import edu.miu.restws.entity.Course;
import edu.miu.restws.entity.Student;
import edu.miu.restws.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CourseRepository {

    private static int currentId = 5;

    public void save(Course course) {
        course.setId(currentId++);
        DataSource.COURSES.add(course);
    }

    public void delete(int id) {
        Optional<Course> course = DataSource.COURSES.stream()
                .filter(c -> c.getId() == id)
                .findAny();

        course.ifPresent(DataSource.COURSES::remove);
    }

    public void update(Course course) {
        DataSource.COURSES.stream()
                .filter(c -> c.getId().intValue() == course.getId().intValue())
                .findAny()
                .ifPresent(c -> {
                    c.setCode(course.getCode());
                    c.setName(course.getName());
                });
    }

    public List<Course> getAllCourses() {
        return DataSource.COURSES;
    }

    public Course getById(int id) {
        return DataSource.COURSES.stream()
                .filter(c -> c.getId() == id)
                .findAny()
                .orElseThrow(() -> new NotFoundException("Cannot find course with id: " + id));
    }

    public List<Course> getCoursesByStudentId(int studentId) {
        return DataSource.COURSES.stream()
                .filter(c -> courseTakenByStudent(c, studentId))
                .toList();
    }

    private boolean courseTakenByStudent(Course course, int studentId) {
        return course.getStudents().stream()
                .map(Student::getId)
                .collect(Collectors.toSet())
                .contains(studentId);
    }
}
