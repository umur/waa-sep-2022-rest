package uz.benom.restbackend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.benom.restbackend.dto.CourseDto;
import uz.benom.restbackend.services.CourseService;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @PostMapping(path = "")
    public CourseDto create(@RequestBody CourseDto dto){
        return courseService.create(dto);
    }

    @PutMapping(path = "/{id}")
    public CourseDto update(@PathVariable Integer id, @RequestBody CourseDto dto){
       return courseService.update(id, dto);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable(required = true) Integer id){
        courseService.delete(id);
    }

    @GetMapping(path = "/{id}")
    public CourseDto getOne(@PathVariable(required = true) Integer id){
        return courseService.getOne(id);
    }

    @GetMapping(path = "")
    List<CourseDto> getAll(){
        return courseService.getAll();
    }

}
