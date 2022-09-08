package uz.benom.restbackend.repos;

import org.springframework.stereotype.Repository;
import uz.benom.restbackend.entities.Student;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepository {

    public void add(Student student){
        student.setId(Store.getNextId());
        Store.students.add(student);
    }

    public void delete(Integer id){
        Store.students.stream().filter(st -> st.getId() == id).findFirst()
                .ifPresent(st -> Store.students.remove(st));
    }

    public void update(Integer id, Student body){
        Store.students.stream().filter(st -> st.getId() == id).findFirst()
                .ifPresent(st -> copyProps(body, st));
    }

    public List<Student> getAll(Student student){
        return Store.students;
    }

    public Optional<Student> getOne(Integer id){
        return Store.students.stream().filter(st -> st.getId() == id).findFirst();
    }

    private void copyProps(Student body, Student entity){
        entity.setEmail(body.getEmail());
        entity.setFirstName(body.getFirstName());
        entity.setLastName(body.getLastName());
        entity.setGpa(body.getGpa());
        entity.setMajor(body.getMajor());
    }
}
