export class CourseList {

    constructor(courses) {
        this.courses = courses;
    }

    render() {
        let courseList = '';
        let rows = '';

        if(this.courses) {
            this.courses.forEach((course, index) => {
                rows += `
                <tr>
                    <th scope="row">${index + 1}</th>
                    <td>${course.id}</td>
                    <td>${course.name}</td>
                    <td>${course.code}</td>
                </tr>
            `;
            });

            courseList = `
            <div class="product-list shadow-lg">
                <div class="lead mb-0">Course List</div>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">ID</th>
                        <th scope="col">Name</th>
                        <th scope="col">Code</th>
                    </tr>
                    </thead>
                    <tbody>
                    ${rows}
                    </tbody>
                </table>
            </div>
        `;
        }

        document.getElementById('product-list').innerHTML = courseList;
    }
}