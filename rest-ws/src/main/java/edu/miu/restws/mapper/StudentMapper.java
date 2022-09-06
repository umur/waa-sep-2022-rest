package edu.miu.restws.mapper;

import edu.miu.restws.dto.StudentDto;
import edu.miu.restws.entity.Student;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StudentMapper {

    private final ModelMapper modelMapper;

    public StudentDto toDto(Student student) {
        return modelMapper.map(student, StudentDto.class);
    }

    public List<StudentDto> toDtos(List<Student> students) {
        return students.stream()
                .map(this::toDto)
                .toList();
    }

    public Student toEntity(StudentDto studentDto) {
        return modelMapper.map(studentDto, Student.class);
    }

    public List<Student> toEntities(List<StudentDto> studentDtos) {
        return studentDtos.stream()
                .map(this::toEntity)
                .toList();
    }
}
