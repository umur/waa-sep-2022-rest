package miu.edu.lab2.PhaseOne.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
    int id;
    String firstName;
    String lastName;
    String email;
    String major;
    double GPA;
    List<Course> courseTaken;
}
