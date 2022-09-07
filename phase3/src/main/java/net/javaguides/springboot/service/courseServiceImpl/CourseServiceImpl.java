package net.javaguides.springboot.service.courseServiceImpl;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.dto.CourseDto;
import net.javaguides.springboot.entity.Course;
import net.javaguides.springboot.repository.RepositoryCourse;
import net.javaguides.springboot.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {
 private final RepositoryCourse courseRepo;

    @Override
    public List<CourseDto> findAll(){
        var courses= courseRepo.findAll();
        var result = new ArrayList<CourseDto>();

        for(Course course: courses){
            CourseDto dto= new CourseDto();
            var courseDto = dto.toDto(course);
            result.add(courseDto);
        }
        return result;
    }
    @Override
    public void create(CourseDto dto){
        var entity=dto.toEntity();
        courseRepo.create(entity);
    }

    @Override
    public void delete(int id){
        courseRepo.deleteById(id);
    }

    @Override
    public CourseDto update(CourseDto courseDto, int id) {
        Course course= new Course();
        course.setName(courseDto.getName());
        course.setCode(courseDto.getCode());
        courseRepo.updateById(course, id);
        return courseDto;
    }



}
