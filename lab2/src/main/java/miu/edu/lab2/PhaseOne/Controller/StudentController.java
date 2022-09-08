package miu.edu.lab2.PhaseOne.Controller;

import miu.edu.lab2.PhaseOne.Domain.Course;
import miu.edu.lab2.PhaseOne.Domain.Student;
import miu.edu.lab2.PhaseOne.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.findAll();

    }
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id){


        studentService.deleteStudent(id);
    }

    @PostMapping

    public void update(@RequestBody Student student,int id){

        studentService.update(id,student);
    }

//@GetMapping("/{id}")
//    public Student findById(@PathVariable int id){
//        return studentService.findById(id);
//}

@GetMapping("/{id}")
    public List<Course> findCoursesById(@PathVariable int id){
        return studentService.getCoursesByStudentId(id);
}


@GetMapping({"/{major}"})

     public List<Student> getStudentsByMajor(@PathVariable String major){
        return studentService.getStudentsByMajor(major);
}

}
