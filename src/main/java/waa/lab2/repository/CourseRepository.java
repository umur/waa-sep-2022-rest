package waa.lab2.repository;

import org.springframework.stereotype.Repository;
import waa.lab2.dto.CourseDto;
import waa.lab2.entity.CourseEntity;
import waa.lab2.entity.StudentEntity;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {

    List<CourseEntity> listOfCourses =new ArrayList<>();
    public void saveCourse(CourseEntity courseEntity) {
        listOfCourses.add(courseEntity);
    }

    public List<CourseEntity> getAllCourses() {
        return listOfCourses;
    }

    public CourseEntity getCourseByID(int id) {
        CourseEntity courseEntity=listOfCourses
                .stream()
                .filter(c->c.getId()==id)
                .findFirst()
                .orElse(null);
        return courseEntity;
    }

    public void deleteCourseById(int id) {
        for(CourseEntity courseEntity:listOfCourses){
            if(courseEntity.getId()==id){
                listOfCourses.remove(courseEntity);
                return;
            }
        }
    }

    public void updateCourseBuId(int id, CourseEntity courseEntity) {
        for(CourseEntity course:listOfCourses){
            if(course.getId()==id){
                deleteCourseById(id);
               courseEntity.setId(id);
                listOfCourses.add(courseEntity);
                return;

            }
        }
    }
}
