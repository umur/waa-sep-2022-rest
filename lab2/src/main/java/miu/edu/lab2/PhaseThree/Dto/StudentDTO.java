package miu.edu.lab2.PhaseThree.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.lab2.PhaseThree.Domain.Course;
import miu.edu.lab2.PhaseThree.Domain.Student;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    int id;
    String firstName;
    String lastName;
    String email;
    String major;
    double GPA;
    List<Course> courseTaken;

    public static  StudentDTO changeToStudentDTO(Student s){
        StudentDTO  ss=new StudentDTO(s.getId(),s.getFirstName(),s.getLastName()
                                      ,s.getEmail(),s.getMajor(),s.getGPA(),s.getCourseTaken());
        return ss;
    }
    public static Student changeTOStudent(StudentDTO s){
        Student ss=new Student(s.getId(),s.getFirstName(),s.getLastName()
                ,s.getEmail(),s.getMajor(),s.getGPA(),s.getCourseTaken());
        return ss;
    }

}
