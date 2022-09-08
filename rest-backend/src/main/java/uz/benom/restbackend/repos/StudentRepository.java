package uz.benom.restbackend.repos;

import org.springframework.stereotype.Repository;
import uz.benom.restbackend.entities.Student;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepository {

    public Student add(Student student){
        student.setId(Store.getNextId());
        Store.students.add(student);
        return student;
    }

    public void delete(Integer id){
        Store.students.stream().filter(st -> st.getId() == id).findFirst()
                .ifPresent(st -> Store.students.remove(st));
    }

    public Optional<Student> update(Integer id, Student body){
        Optional<Student> student = Store.students.stream().filter(st -> st.getId() == id).findFirst();
        if(student.isPresent()){
            copyProps(body, student.get());
            return student;
        }
        return Optional.empty();
    }

    public List<Student> getAll(){
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
