package henry.phaseii.service;

import henry.phaseii.dto.CourseDto;

import java.util.List;

public interface CourseService {
    void save(CourseDto courseDto);
    List<CourseDto> findAll();
    void update(int courseId, CourseDto courseDto);
    CourseDto delete(int courseId);
}
