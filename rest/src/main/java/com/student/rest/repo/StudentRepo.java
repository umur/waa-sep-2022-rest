package com.student.rest.repo;

import com.student.rest.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {
    private static int id = 4;
    private static List<Student> students = new ArrayList<>() {{
        new Student(1, "Asjad", "Anis", "xyz@gmail.com", "Compro", 4.00, new ArrayList<String>(){{
            add("FPP"); add("MPP"); add("WAP"); add("WAA");
        }});
        new Student(2, "John", "Doe", "xyz1@gmail.com", "Compro", 3.90, new ArrayList<String>(){{
            add("FPP"); add("MPP"); add("EA"); add("SA");
        }});
        new Student(3, "Jane", "Doe", "xyz123@gmail.com", "Compro", 4.00, new ArrayList<String>(){{
            add("FPP"); add("MPP"); add("Algo"); add("EA");
        }});
        new Student(4, "Bob", "Lee", "xyz128@gmail.com", "Compro", 3.44, new ArrayList<String>(){{
            add("FPP"); add("MPP"); add("MWA"); add("ASD");
        }});
    }};

    public void addStudent(Student std) {
        std.setId(id++);
        students.add(std);
    }

    public List<Student> getStudents () {
        return students;
    }

    public boolean updateStudent (Student course) {
        int index = 0;
        for (Student s : students) {
            if (s.getId() == course.getId()) {
                students.set(index, course);
                return true;
            }
            index++;
        }
        return false;
    }

    public boolean deleteStudent (int id) {
        int index = 0;
        for (Student c : students) {
            if (c.getId() == id) {
                students.remove(index);
                return true;
            }
            index++;
        }
        return false;
    }
}
