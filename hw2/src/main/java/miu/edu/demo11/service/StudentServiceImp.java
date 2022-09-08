package miu.edu.demo11.service;

import lombok.RequiredArgsConstructor;
import miu.edu.demo11.entity.Course;
import miu.edu.demo11.entity.Student;
import miu.edu.demo11.repo.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImp implements StudentService{

    private final StudentRepo studentRepo;

    @Override
    public List<Student> findAll() {
        return studentRepo.findAll();
    }



    public Student save(Student student){
        return studentRepo.save(student);
    }



    public Student update(Integer id , Student body){
        Optional<Student> updating = studentRepo.findById(id);
        if(updating.isPresent()){
            return  studentRepo.save(updating.get());
        }
        throw new NoSuchElementException("Could not found");
    }

    public Student findOne(Integer id){
        Optional<Student> found = studentRepo.findById(id);
        if(found.isPresent()){
            return found.get();
        }
        throw new NoSuchElementException("Not found");
    }

    public void delete(Integer id ){
         studentRepo.deleteById(id);
    }

    public List<Student> getStudentsByMajor(String major){
       return  this.studentRepo.findByMajor(major);
    }

    public  List<Course> getCoursesByStudentId(Integer id){
        return this.findOne(id).getCoursesTaken();
    }





}
