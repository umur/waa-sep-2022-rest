package miu.edu.demo11.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.demo11.entity.Student;
import miu.edu.demo11.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> getStudents() {
        return studentService.findAll();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student save (@RequestBody Student body ){
        return studentService.save(body);
    }


    @PutMapping("{id}")
    public Student update(@PathVariable Integer id , @RequestBody Student body){
        return studentService.update(id,body);
    }


    @GetMapping("{id}")
    public Student getStudent(@PathVariable Integer id){
        return studentService.findOne(id);
    }


    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id ){
         studentService.delete(id);
    }



@GetMapping("filter-by-major/{major}")
    public void filterByMajor(@PathVariable String major){
        studentService.getStudentsByMajor(major);
}

@GetMapping("courses/{id}")
    public void filterByMajor(@PathVariable Integer id){
        studentService.getCoursesByStudentId(id);
}














}
