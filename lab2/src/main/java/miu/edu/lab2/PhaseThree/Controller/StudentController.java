package miu.edu.lab2.PhaseThree.Controller;

import miu.edu.lab2.PhaseThree.Dto.CourseDTO;
import miu.edu.lab2.PhaseThree.Dto.StudentDTO;
import miu.edu.lab2.PhaseThree.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public List<StudentDTO> getAllStudents(){
        return studentService.findAll();

    }
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id){


        studentService.deleteStudent(id);
    }

    @PostMapping

    public void update(@RequestBody StudentDTO student, int id){

        studentService.update(id,student);
    }

@GetMapping("/{id}")
    public StudentDTO findById(@PathVariable int id){
        return studentService.findById(id);
}

@GetMapping("/{id}")
    public List<CourseDTO> findCoursesById(@PathVariable int id){
        return studentService.getCoursesByStudentId(id);
}


@GetMapping({"/{major}"})

     public List<StudentDTO> getStudentsByMajor(@PathVariable String major){
        return studentService.getStudentsByMajor(major);
}

}
