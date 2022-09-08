package uz.benom.restbackend.repos;

import org.springframework.stereotype.Repository;
import uz.benom.restbackend.entities.Course;
import uz.benom.restbackend.entities.Student;

import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepository {

    public Course add(Course course){
        course.setId(Store.getNextId());
        Store.courses.add(course);
        return course;
    }

    public void delete(Integer id){
        Store.courses.stream().filter(cr -> cr.getId() == id).findFirst()
                .ifPresent(cr -> Store.courses.remove(cr));
    }

    public Optional<Course> update(Integer id, Course body){
        Optional<Course> courseOpt = Store.courses.stream().filter(cr -> cr.getId() == id).findFirst();
            if(courseOpt.isPresent()){
                copyProps(body, courseOpt.get());
            }
            return courseOpt;

    }

    public List<Course> getAll(){
        return Store.courses;
    }

    public Optional<Course> getOne(Integer id){
        return Store.courses.stream().filter(st -> st.getId() == id).findFirst();
    }

    private void copyProps(Course body, Course entity){
        entity.setName(body.getName());
        entity.setCode(body.getCode());
    }

}
