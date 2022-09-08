package uz.benom.restbackend.services.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.benom.restbackend.dto.CourseDto;
import uz.benom.restbackend.dto.StudentDto;
import uz.benom.restbackend.entities.Student;
import uz.benom.restbackend.exceptions.ResourceNotFound;
import uz.benom.restbackend.repos.StudentRepository;
import uz.benom.restbackend.services.StudentService;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {


    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;


    @Override
    public StudentDto create(StudentDto dto) {
        Student student = modelMapper.map(dto, Student.class);
        student = studentRepository.add(student);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto update(Integer id, StudentDto dto) {
        var st = studentRepository.update(id, modelMapper.map(dto, Student.class));
        if(st.isPresent()){
            return modelMapper.map(st.get(), StudentDto.class);
        }else{
            throw new ResourceNotFound("Student does not exist");
        }
    }

    @Override
    public void delete(Integer id) {
        studentRepository.delete(id);
    }

    @Override
    public StudentDto getOne(Integer id) {
        Optional<Student> optionalStudent =  studentRepository.getOne(id);
        if (optionalStudent.isPresent()){
            return modelMapper.map(optionalStudent, StudentDto.class);
        }else {
            throw new ResourceNotFound("Course does not exist");
        }
    }

    @Override
    public List<StudentDto> getAll() {
        return studentRepository.getAll().stream()
                .map(s -> modelMapper.map(s, StudentDto.class))
                .collect(Collectors.toList());
    }

    public List<StudentDto> getStudentsByMajor(String major){
        return studentRepository.getAll().stream()
                .filter(s -> s.getMajor().equals(major))
                .map(s -> modelMapper.map(s, StudentDto.class))
                .collect(Collectors.toList());
    }

    public List<CourseDto> getCoursesByStudentId(int studentId){
        return studentRepository.getOne(studentId).get().getCoursesTaken()
                .stream().map(s -> modelMapper.map(s, CourseDto.class))
                .collect(Collectors.toList());
    }

}
