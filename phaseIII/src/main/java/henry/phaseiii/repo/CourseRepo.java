package henry.phaseiii.repo;

import henry.phaseiii.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CourseRepo {
    private static List<Course> courses = new ArrayList<>();
    private int seq = 2;

    static {
        Course c1 = new Course(1, "MPP", "CS401");
        courses.add(c1);
        Course c2 = new Course(2, "WAA", "CS545");
        courses.add(c2);
    }

    public Course add(Course course) {
        course.setId(++seq);
        courses.add(course);
        return course;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void update(int courseId, Course course) {
        courses.stream().filter(c -> c.getId() == courseId).findFirst().ifPresent(c -> {
            c.setCode(course.getCode());
            c.setName(course.getName());
        });
    }

    public Course delete(int courseId) {
        Course course = courses.stream().filter(c -> c.getId() == courseId).findFirst().orElse(null);
        if (course != null) {
            courses = courses.stream().filter(c -> c.getId() != courseId).collect(Collectors.toList());
        }

        return course;
    }
}
