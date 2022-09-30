package waa.lab2.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import waa.lab2.dto.CourseDto;
import waa.lab2.dto.StudentDto;
import waa.lab2.entity.CourseEntity;
import waa.lab2.entity.StudentEntity;
import waa.lab2.repository.StudentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
   private StudentRepository studentRepository;
    @Autowired
    private  ModelMapper mapper;
    private int id =0;

    public void save(StudentDto studentDto) {
     var studentEntity  =mapper.map(studentDto, StudentEntity.class);
        studentEntity.setId(id++);
     studentRepository.save(studentEntity);

    }

    @Override
    public StudentDto getStudentByID(Integer id) {
        StudentEntity student =studentRepository.getStudentById(id);
        var studentDto =mapper.map(student,StudentDto.class);
        return studentDto;
    }

    @Override
    public List<StudentDto> getAllStudents() {
       List<StudentEntity> listOfAllStudents=studentRepository.getAllStudents();

      List<StudentDto> listOfStudents = listOfAllStudents.stream()
               .map(s->mapper.map(s,StudentDto.class)).collect(Collectors.toList());

       return listOfStudents;
    }

    @Override
    public void deleteStudentById(Integer id) {
        studentRepository.deleteStudentById(id);
    }

    @Override
    public void updateStudent(Integer id, StudentDto studentDto) {
        StudentEntity studentEntity=mapper.map(studentDto,StudentEntity.class);
        studentRepository.updateStudent(id,studentEntity);
    }

    @Override
    public List<StudentDto> getStudentByMajor(String major) {
        List<StudentEntity> listOfStudents = studentRepository.getStudentbayMajor(major);
       return listOfStudents
               .stream()
               .map(s->mapper.map(s,StudentDto.class))
               .collect(Collectors.toList());

    }

    @Override
    public List<CourseDto> getCoursesByStudentId(int id) {

       List<CourseEntity> listOfCourses=studentRepository.getCoursesByStudentId( id);

        return listOfCourses
                .stream()
                .map(s->mapper.map(s,CourseDto.class))
                .collect(Collectors.toList());
    }


}
