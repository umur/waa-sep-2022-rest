package com.ultrates.restfullab2Phase2.repository;

import com.ultrates.restfullab2Phase2.dto.CourseDto;
import com.ultrates.restfullab2Phase2.model.Course;
import com.ultrates.restfullab2Phase2.model.Student;
import com.ultrates.restfullab2Phase2.service.CourseService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {
    private static List<Student> students;

    private final   CourseService courseService;

    public StudentRepo(CourseService courseService) {
        this.courseService=courseService;
        List<Course> result = new ArrayList<Course>();
        List<CourseDto> entityList = courseService.getAll();
        entityList.forEach(dto->{
            //convert
            Course c = new Course();
            c.setId(dto.getId());
            c.setName(dto.getName());
            c.setCode(dto.getCode());

            result.add(c);
        });
        students =  new ArrayList<>();
        var s = new Student();
        s.setId(1);
        s.setFirstName("Haile");
        s.setLastName("Tesfay");
        s.setEmail("htesfay@miu.edu");
        s.setMajor("ComPro");

        s.setCoursesTaken(result);
        students.add(s);
    }

    public void save(Student s) {
        var checkIfExists = students
                .stream()
                .noneMatch(l -> l.getId()==s.getId());
        if(checkIfExists) {
            students.add(s);
        }
    }

    public void delete(int id) {
        students.stream()
                .filter( l-> l.getId() == id)
                .forEach( l ->students.remove(l));
    }

    public Student getById(int id) {
        return students.stream()
                .filter( l -> l.getId() == id)
                .findFirst()
                .orElse(null);
    }
    public List<Student> getAll() {
        return students;
    }

    public List<Student> getStudentsByMajor(String major) {
        return students.stream()
                .filter( s -> s.getMajor().equals(major))
                .collect(Collectors.toList());
    }

    public List<Course> getCoursesByStudentId(int id) {
        return students.stream()
                .filter( s -> s.getId() == id)
                .findFirst().orElse(null).getCoursesTaken();

    }

}
