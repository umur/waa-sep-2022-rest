package miu.edu.lab2.PhaseThree.Repository;

import miu.edu.lab2.PhaseThree.Domain.Course;
import miu.edu.lab2.PhaseThree.Domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    static List<Student> studentList=new ArrayList<>();
    int currentID=2;

    static{
        Course course=new Course(1,"waa","CS555");
        List<Course> courses=new ArrayList<>();
        courses.add(course);
        Student s=new Student(1,"abi","zaki","@zaki","player",4.0,courses);
        Student s2=new Student(2,"aa","bbb","@zazz","ddd",4.0,courses);

        studentList.add(s);
        studentList.add(s2);
    }

    public void save(Student s){
        s.setId(currentID++);
        studentList.add(s);
    }

    public Student findById(int id){

       // Student ss=studentList.stream().filter(s->s.getId()==id).findFirst().orElse(null);


        for(Student s:studentList){
            if(s.getId()==id){
                return s;
            }
        }

        return null;

    }
    public List<Student> findAll(){
        return studentList;
    }

    public void update(int id, Student student){
       int num=1;
       int index=0;

        for(Student s: studentList){

            if(s.getId()==id){

                num++;
                break;
            }
            index++;
        }
        studentList.set(index,student);
        if(num==1)throw new RuntimeException();

    }

    public Student deleteStudent(int id){
        int index=0;
        Student ss=null;
        for(Student s:studentList){

            if(id==s.getId()){
              ss =studentList.remove(index);
                break;
            }
            index++;
        }
        return ss;
    }

    public List<Student> getStudentByMajor(String major){
        List<Student> students=studentList.stream().filter(s->s.getMajor()
                .equalsIgnoreCase(major)).toList();
        return students;

    }

    public List<Course> getCoursesByStudentId(int studentId){
        Student s=studentList.stream().filter(ss->ss.getId()==studentId).findFirst().orElse(null);

    if(s!=null) return s.getCourseTaken();

    return null;
    }

}
