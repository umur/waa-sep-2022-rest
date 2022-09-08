import { StudentAPI } from "./student-api.js";
import { Nav } from "../components/nav/nav.js";
import { Header } from "../components/header/header.js";
import { Login } from "../components/login/login.js";
import { StudentList } from "../components/student/student-list.js";
import { CourseAPI } from "./course-api.js";
import { CourseList } from "../components/course/course-list.js";

export class Util {

    static renderStudent() {
        StudentAPI.getAll().then(students => {
            const studentList = new StudentList(students);
            studentList.render();
        })
    }

    static renderCourse() {
        CourseAPI.getAll().then(courses => {
            const courseList = new CourseList(courses);
            courseList.render();
        })
    }

    static renderApplication() {
        new Nav().render(new Login());
        new Header().render();
    }
}