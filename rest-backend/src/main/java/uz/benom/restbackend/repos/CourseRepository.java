package uz.benom.restbackend.repos;

import org.springframework.stereotype.Repository;
import uz.benom.restbackend.entities.Course;
import uz.benom.restbackend.entities.Student;

import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepository {

    public void add(Course course){
        course.setId(Store.getNextId());
        Store.courses.add(course);
    }

    public void delete(Integer id){
        Store.courses.stream().filter(cr -> cr.getId() == id).findFirst()
                .ifPresent(cr -> Store.courses.remove(cr));
    }

    public void update(Integer id, Course body){
        Store.courses.stream().filter(cr -> cr.getId() == id).findFirst()
                .ifPresent(cr -> copyProps(body, cr));
    }

    public List<Course> getAll(Student student){
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
