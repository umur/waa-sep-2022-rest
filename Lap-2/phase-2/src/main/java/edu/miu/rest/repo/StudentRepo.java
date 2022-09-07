package edu.miu.rest.repo;

import edu.miu.rest.entity.Course;
import edu.miu.rest.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository

public class StudentRepo {

        private static List<Course> courses = new ArrayList<>();
        private static List<Student> students = new ArrayList<>();
        private static List<Course> courseone = new ArrayList<>();

        public StudentRepo() {
            Course c1 = new Course(1, "WAA", "CS545");
            Course c2 = new Course(2, "WAP", "CS472");
            Course c3 = new Course(3, "MPP", "CS404");
            courses.add(c1);
            courses.add(c2);
            courseone.add(c3);
            Student s1 = new Student(1, "Ibrahim", "Imam", "iimam@miu.edu", "Java", courses, 3.6);
           // Student s2 = new Student(2, "Mohammed ", "Salim", "salim@miu.edu", "Python", 3.74);
            Student s3 = new Student(2, "Peter ", "Solomon", "Tewolde@miu.edu", "C++", courseone, 2.74);
            students.add(s1);
            //students.add(s2);
            students.add(s3);
        }

        public List<Student> findAll() {
            return students;
        }

        public void create(Student c) {
            students.add(c);
        }

        public Student getById(int id) {
            for (Student s : students) {
                if (s.getId() == id) {
                    return s;
                }
            }
            return null;
        }

        public String DeleteById(int id) {
            for (Student s : students) {
                if (s.getId() == id) {
                    students.remove(s);
                    System.out.println("Deleted");
                    return "Deleted";
                }
            }
            return "NotFound";
        }

        public String update(Student st1, int id) {
            StudentRepo make = new StudentRepo();
            Student old = make.getById(id);
            old.setFirstName(st1.getFirstName());
            old.setLastName(st1.getLastName());
            old.setEmail(st1.getEmail());
            old.setCourses(st1.getCourses());
            old.setGpa(st1.getGpa());
            students.add(old);
            return "Updated";
        }

        public List<Student> getStudentsByMajor(String major) {
            List<Student> studentWithMajor = new ArrayList<>();
            for (Student s : students) {
                if (s.getMajor().equals(major)) {
                    studentWithMajor.add(s);
                }

            }
            System.out.print(studentWithMajor);
            return studentWithMajor;

        }

        public List<Course> getCoursesByStudentId(int studentId) {
            for (Student s : students) {
                if (s.getId() == studentId) {
                    return s.getCourses();
                }

            }
            System.out.print("Student is  not  found");
            return null;
        }
    }


