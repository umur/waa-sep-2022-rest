package uz.benom.restbackend.services;

import uz.benom.restbackend.dto.CourseDto;

import java.util.List;

public interface CourseService {

    public CourseDto create(CourseDto dto);

    public CourseDto update(Integer id, CourseDto dto);


    public void delete(Integer id);

    public CourseDto getOne(Integer id);

    List<CourseDto> getAll();


}
