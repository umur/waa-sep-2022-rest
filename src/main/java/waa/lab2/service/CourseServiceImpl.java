package waa.lab2.service;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import waa.lab2.dto.CourseDto;
import waa.lab2.entity.CourseEntity;
import waa.lab2.repository.CourseRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements  CourseService{

    int id =0;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
     private ModelMapper mapper;
    @Override
    public void saveCourse(CourseDto courseDto) {

        var  courseEntity = mapper.map(courseDto,CourseEntity.class);
        courseEntity.setId(id++);
        courseRepository.saveCourse(courseEntity);
    }

    @Override
    public List<CourseDto> getAllCourses() {
        List <CourseDto> listOfCourses =courseRepository
                .getAllCourses()
                .stream()
                .map(c->mapper.map(c,CourseDto.class)).collect(Collectors.toList());
        return listOfCourses;
    }

    @Override
    public CourseDto getCourseById(int id) {
      CourseEntity courseEntity = courseRepository.getCourseByID(id);
      CourseDto courseDto=mapper.map(courseEntity,CourseDto.class);
      return courseDto;
    }

    @Override
    public void deleteCourseByID(int id) {
        courseRepository.deleteCourseById(id);
    }

    @Override
    public void updateCourseById(int id, CourseDto courseDto) {

        CourseEntity courseEntity=mapper.map(courseDto, CourseEntity.class);

        courseRepository.updateCourseBuId(id , courseEntity);

    }


}
