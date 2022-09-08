package miu.edu.demo11.repo;

import miu.edu.demo11.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
    List<Student> getStudentsByMajor(String major);

    List<Student> findByMajor(String major);
}
