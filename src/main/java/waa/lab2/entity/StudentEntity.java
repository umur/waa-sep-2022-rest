package waa.lab2.entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Data
@Getter
@Setter
public class StudentEntity {



        private int id;
        private String firstName;
        private String lastName;
        private String email;
        private String major;
        private List<CourseEntity> coursesTaken;
        private float gpa;

}
