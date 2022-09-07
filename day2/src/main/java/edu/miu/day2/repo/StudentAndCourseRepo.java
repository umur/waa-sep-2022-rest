package edu.miu.day2.repo;

import edu.miu.day2.entity.Course;
import edu.miu.day2.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



@RequiredArgsConstructor
@Repository
public class StudentAndCourseRepo {
    private static List<Course> allCourse;
    private static List<Student> allStudent;

    static{
        allCourse =new ArrayList<>();
        allStudent = new ArrayList<>();

        Course course1= new Course(1,"STC1",10001);
        Course course2= new Course(2,"FPP",10002);
        Course course3= new Course(3,"Mpp",10003);
        Course course4= new Course(4,"WAP",10004);
        Course course5= new Course(5,"WAA",10005);
        Course course6= new Course(6,"SA",10006);
        Course course7= new Course(7,"Algo",10007);
        Course course8= new Course(8,"DBMS",10008);
        Course course9= new Course(9,"EA",10009);

        allCourse.add(course1);
        allCourse.add(course2);
        allCourse.add(course3);
        allCourse.add(course4);
        allCourse.add(course5);
        allCourse.add(course6);
        allCourse.add(course7);
        allCourse.add(course8);
        allCourse.add(course9);

        Student student1= new Student(1, "Ram","Sharma","Ramsharma@gmail.com","compro", 2,"MPP", new ArrayList<>());
        student1.getCourses().add(course1);
        student1.getCourses().add(course2);
        student1.getCourses().add(course3);

        Student student2=new Student(1,"Hari","Karki","hariKarki@gmail.com","Compro",3,
                "FPP",new ArrayList<>());
        student2.getCourses().add(course4);
        student2.getCourses().add(course2);
        student2.getCourses().add(course5);

        Student student3= new Student(1, "Pradip","DHungel", "Pradipdhungel12@gmail.com",
                "Compro",4,"WAA",new ArrayList<>());

        student3.getCourses().add(course6);
        student3.getCourses().add(course7);
        student3.getCourses().add(course8);
        student3.getCourses().add(course9);
        student3.getCourses().add(course5);
        allStudent.add(student1);
        allStudent.add(student2);
        allStudent.add(student3);
    }


    public static Course createCourse(Course course) {
        allCourse.add(course);
        return course;
    }


    public static List<Course> getAllCourse(){
        return allCourse;
    }

     public Course getAllCourse(Long id){
        return allCourse.stream().filter(c-> c.getId()==id.intValue()).findAny().orElseThrow(() -> new RuntimeException("Not Exists"));
     }

     public Course updateCourse(Long id,Course course){
        Course currentUpdate= allCourse.stream().filter(c->c.getId()==id.intValue()).findAny().orElseThrow(()->new RuntimeException("Not exists"));
        currentUpdate.setName(course.getName());
         currentUpdate.setCode(course.getCode());
         return currentUpdate;

     }
     public Course deleteCourse(Long id){
        Course course=allCourse.stream().filter(c->c.getId()==id.intValue()).findAny().orElseThrow(()->new RuntimeException("Not Exists"));
        List<Course> courseTem=allCourse.stream().filter(c->c.getId()!=id.intValue()).collect(Collectors.toList());
        allCourse=courseTem;
        return course;
     }
    public static Student createStudent(Student student) {
        allStudent.add(student);
        return student;
    }

    public static List<Student> getAllStudents() {
        return allStudent;
    }

    public static Student getStudent(Long id) {
        return allStudent.stream().filter(s -> s.getId() == id.intValue()).findAny().orElseThrow(() -> new RuntimeException("Does not Exists!"));
    }

    public static Student updateStudent(Long id, Student student) {
        Student studentUpdate = allStudent.stream().filter(s -> s.getId() == id.intValue()).findAny().orElseThrow(() -> new RuntimeException("Does not Exists!"));
        studentUpdate.setFirstName(student.getFirstName());
        studentUpdate.setLastName(student.getLastName());
        studentUpdate.setEmail(student.getEmail());
        studentUpdate.setGpa(student.getGpa());
        studentUpdate.setMajor(student.getMajor());
        studentUpdate.setCourses(student.getCourses());
        return studentUpdate;
    }

    public static Student deleteStudent(Long id) {
        Student student = allStudent.stream().filter(s -> s.getId() == id.intValue()).findAny().orElseThrow(() -> new RuntimeException("Does not Exists!"));
        List<Student> studentsTemp = allStudent.stream().filter(s -> s.getId() != id.intValue()).collect(Collectors.toList());
        allStudent = studentsTemp;
        return student;
    }

    public static List<Student> getStudentsByMajor(String major) {
        return allStudent.stream().filter(s -> s.getMajor().equals(major)).collect(Collectors.toList());
    }

    public List<Course> getCoursesByStudentId(int studentId) {
        return allStudent.stream().filter(s -> s.getId() == studentId).findAny()
                .orElseThrow(() -> new RuntimeException("Student Does not Exists"))
                .getCourses();
    }


}
