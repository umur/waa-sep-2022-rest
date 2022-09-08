package miu.edu.demo11.repo;

import miu.edu.demo11.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface CourseRepo extends JpaRepository <Course , Integer>{
//    List<Course> getCoursesByStudentId(int studentId);

}
