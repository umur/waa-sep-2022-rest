package waa.lab2.repository;

import org.springframework.stereotype.Repository;
import waa.lab2.dto.StudentDto;
import waa.lab2.entity.CourseEntity;
import waa.lab2.entity.StudentEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {

   public  List<StudentEntity> listOfStudent =new ArrayList<>();

    public void save(StudentEntity studentEntity) {
        listOfStudent.add(studentEntity);

    }

    public StudentEntity getStudentById(Integer id) {
        StudentEntity studentEntity=listOfStudent
                .stream()
                .filter(s->s.getId()==id)
                .findFirst()
                .orElse(null);
        return studentEntity;

    }

    public List<StudentEntity> getAllStudents() {
        return listOfStudent;
    }

    public void deleteStudentById(Integer id) {
        for(StudentEntity studentEntity:listOfStudent){
            if(studentEntity.getId()==id){
                listOfStudent.remove(studentEntity);
                return;
            }
        }
    }

    public void updateStudent(Integer id,StudentEntity studentEntity) {
        for(StudentEntity student:listOfStudent){
            if(student.getId()==id){
                deleteStudentById(id);
                studentEntity.setId(id);
                listOfStudent.add(studentEntity);
                return;

            }
        }
    }

    public List<StudentEntity> getStudentbayMajor(String major) {

        return listOfStudent
                .stream()
                .filter(s->s.getMajor().equals(major))
                .collect(Collectors.toList());
    }

    public List<CourseEntity> getCoursesByStudentId(int id) {
        List<CourseEntity> listOfCourses=null;
        for(StudentEntity student:listOfStudent){
            if(student.getId()==id){
                listOfCourses=student.getCoursesTaken();
                break;
            }
        }
        return listOfCourses;
    }
}
