import { Util } from "../../modules/util.js";

export class Login {

    render() {
        let login = `
            <button id="btn-student" class="btn btn-primary btn-login">Student</button>
            <button id="btn-course" class="btn btn-primary btn-login">Course</button>
        `;
        document.title = 'MyStore - Login';
        document.getElementById('login').innerHTML = login;

        let btnStudent = document.getElementById('btn-student');
        btnStudent.addEventListener('click', e => {
            e.preventDefault();
            Util.renderStudent();
        })

        let btnCourse = document.getElementById('btn-course');
        btnCourse.addEventListener('click', e => {
            e.preventDefault();
            Util.renderCourse();
        })


    }

}