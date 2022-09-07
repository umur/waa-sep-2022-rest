package miu.edu.restfuldemo.service;

import miu.edu.restfuldemo.dto.CourseDTO;
import java.util.List;
public interface CourseService {
    void save(CourseDTO courseDTO);
    List<CourseDTO> findAll();
    CourseDTO getById(Integer id);
    void update(Integer id, CourseDTO courseDTO);
    void delete(Integer id);
}
