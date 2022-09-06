package org.lab2.service.impl;

import lombok.RequiredArgsConstructor;
import org.lab2.dto.CourseDTO;
import org.lab2.dto.StudentDTO;
import org.lab2.entity.Course;
import org.lab2.entity.Student;
import org.lab2.repository.StudentRepo;
import org.lab2.service.IStudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements IStudentService {

    private StudentRepo studentRepo;
    private ModelMapper modelMapper;
    @Override
    public void save(StudentDTO courseDTO) {
        studentRepo.add(modelMapper.map(courseDTO, Student.class));
    }

    @Override
    public List<StudentDTO> findAll() {
        return studentRepo.getStudents().stream().map(stu -> modelMapper.map(stu,StudentDTO.class)).collect(Collectors.toList());
    }

    @Override
    public StudentDTO update(StudentDTO courseDTO) {
        return   modelMapper.map(studentRepo.update(modelMapper.map(courseDTO, Student.class)),StudentDTO.class);
    }

    @Override
    public void delete(Integer id) {
        studentRepo.delete(id);
    }

    @Override
    public List<StudentDTO> getStudentsByMajor(String major) {
        return  studentRepo.getStudents().stream().filter(student -> student.getMajor().equals(major)).map(stu->modelMapper.map(stu,StudentDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> getCoursesByStudentId(Integer id) {
        Optional<StudentDTO> student = studentRepo.getStudents().stream().filter(stu->stu.getId().equals(id)).map(stu->modelMapper.map(stu,StudentDTO.class)).findFirst();
        return student.map(studentDTO -> studentDTO.getCoursesTaken().stream().map(c -> modelMapper.map(c, CourseDTO.class)).collect(Collectors.toList())).orElse(null);
    }
}
