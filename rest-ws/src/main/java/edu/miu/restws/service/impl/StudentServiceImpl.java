package edu.miu.restws.service.impl;

import edu.miu.restws.dto.StudentDto;
import edu.miu.restws.mapper.StudentMapper;
import edu.miu.restws.repo.StudentRepository;
import edu.miu.restws.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private final StudentMapper studentMapper;

    @Override
    public List<StudentDto> findStudentsByMajor(String major) {
        return studentMapper.toDtos(studentRepository.getStudentsByMajor(major));
    }

    @Override
    public void save(StudentDto studentDto) {
        studentRepository.save(studentMapper.toEntity(studentDto));
    }

    @Override
    public void delete(int id) {
        studentRepository.delete(id);
    }

    @Override
    public void update(StudentDto studentDto) {
        studentRepository.update(studentMapper.toEntity(studentDto));
    }

    @Override
    public List<StudentDto> findAllStudents() {
        return studentMapper.toDtos(studentRepository.getAllStudents());
    }

    @Override
    public StudentDto findById(int id) {
        return studentMapper.toDto(studentRepository.getById(id));
    }
}
