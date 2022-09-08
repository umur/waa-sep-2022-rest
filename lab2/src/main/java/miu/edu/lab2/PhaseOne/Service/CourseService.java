package miu.edu.lab2.PhaseOne.Service;

import miu.edu.lab2.PhaseOne.Domain.Course;

import java.util.List;

public interface CourseService {



    public Course findById(int  id);

    public List<Course> findAll();

    public void create(Course course);

    public void update(int  id, Course course);

    void delete(int  id);
}
