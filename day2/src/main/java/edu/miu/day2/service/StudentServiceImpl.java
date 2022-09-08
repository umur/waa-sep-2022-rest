package edu.miu.day2.service;

import edu.miu.day2.entity.Course;
import edu.miu.day2.entity.DTO.CourseDTO;
import edu.miu.day2.entity.DTO.StudentDTO;
import edu.miu.day2.entity.Student;
import edu.miu.day2.repo.StudentAndCourseRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.text.Collator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentAndCourseRepo studentAndCourseRepo;

    private final ModelMapper modelMapper;

    @Override
    public StudentDTO createAStudent(StudentDTO student) {
        Student mapIt = modelMapper.map(student, Student.class);
        return modelMapper.map(studentAndCourseRepo.createStudent(mapIt), StudentDTO.class);
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> students= StudentAndCourseRepo.getAllStudents();
        return  students.stream().map(se-> {
            StudentDTO map = modelMapper.map(se, StudentDTO.class);
            return map;
        }).collect(Collectors.toList());
    }

    @Override
    public StudentDTO getAStudent(Long id) {

        return modelMapper.map(StudentAndCourseRepo.getStudent(id),StudentDTO.class);
    }

    @Override
    public StudentDTO updateStudent(Long id, StudentDTO student) {
        Student  mapIt= modelMapper.map(student, Student.class);
        return modelMapper.map(StudentAndCourseRepo.updateStudent(id, mapIt),StudentDTO.class);
    }

    @Override
    public StudentDTO deleteStudent(Long id) {
        return modelMapper.map(studentAndCourseRepo.deleteStudent(id),StudentDTO.class);
    }

    @Override
    public List<StudentDTO> getAllStudentsByMajor(String major) {
        List<Student> students= studentAndCourseRepo.getStudentsByMajor(major);
        return students.stream().map(stu->modelMapper.map(stu,StudentDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> getAllCourseByStudentId(int studentId) {
        List<Course> courses=studentAndCourseRepo.getCoursesByStudentId(studentId);
        Stream<CourseDTO> courseDTOStream = courses.stream().map(cc -> modelMapper.map(cc, CourseDTO.class));
        return courseDTOStream.collect(Collectors.toList());
    }
}
