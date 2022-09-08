package uz.benom.restbackend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.benom.restbackend.dto.CourseDto;
import uz.benom.restbackend.dto.StudentDto;
import uz.benom.restbackend.services.CourseService;
import uz.benom.restbackend.services.StudentService;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @PostMapping(path = "")
    public StudentDto create(@RequestBody StudentDto dto){
        return studentService.create(dto);
    }

    @PutMapping(path = "/{id}")
    public StudentDto update(@PathVariable Integer id, @RequestBody StudentDto dto){
        return studentService.update(id, dto);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable(required = true) Integer id){
        studentService.delete(id);
    }

    @GetMapping(path = "/{id}")
    public StudentDto getOne(@PathVariable(required = true) Integer id){
        return studentService.getOne(id);
    }

    @GetMapping(path = "")
    List<StudentDto> getAll(){
        return studentService.getAll();
    }

    @GetMapping(path = "{id}/courses")
    List<CourseDto> getStudentCourses(@PathVariable Integer id){
        return studentService.getCoursesByStudentId(id);
    }

    @GetMapping(path = "/filter")
    List<StudentDto> getStudentCourses(@RequestParam String major){
        return studentService.getStudentsByMajor(major);
    }

}
