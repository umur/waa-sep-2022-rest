package miu.edu.lab2.Phasetwo.Service;

import miu.edu.lab2.Phasetwo.Domain.Course;
import miu.edu.lab2.Phasetwo.Dto.CourseDTO;

import java.util.List;

public interface CourseService {



    public CourseDTO findById(int  id);

    public List<CourseDTO> findAll();

    public void create(CourseDTO course);

    public void update(int  id, CourseDTO course);

    void delete(int  id);
}
