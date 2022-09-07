export class StudentList {

    constructor(students) {
        this.students = students;
    }

    render() {
        let studentList = '';
        let rows = '';

        if(this.students) {
            this.students.forEach((student, index) => {
                rows += `
                <tr>
                    <th scope="row">${index + 1}</th>
                    <td>${student.firstName}</td>
                    <td>${student.lastName}</td>
                    <td>${student.email}</td>
                    <td>${student.major}</td>
                    <td>${student.gpa}</td>
                </tr>
            `;
            });

            studentList = `
            <div class="product-list shadow-lg">
                <div class="lead mb-0">Student List</div>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">First Name</th>
                        <th scope="col">Last Name</th>
                        <th scope="col">Email</th>
                        <th scope="col">Major</th>
                        <th scope="col">GPA</th>
                    </tr>
                    </thead>
                    <tbody>
                    ${rows}
                    </tbody>
                </table>
            </div>
        `;
        }

        document.getElementById('product-list').innerHTML = studentList;
    }
}