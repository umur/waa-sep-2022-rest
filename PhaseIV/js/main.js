const BASE_URL = "http://localhost:8080/";

window.onload = function () {
    getCourses();
    getStudents();

    document.getElementById('course-btn').onclick = function (event) {
        event.preventDefault();
        if (!document.getElementById('course-btn').dataset.id) {
            addCourse();
        } else {
            editCourse();
        }
    }

    document.getElementById('std-btn').onclick = function (event) {
        event.preventDefault();
        if (!document.getElementById('std-btn').dataset.id) {
            addStudent();
        } else {
            editStudent();
        }
    }
}

async function getCourses() {
    let courses = await fetch(BASE_URL + 'courses').then(response => response.json());
    courses.forEach(c => renderCourse(c));
}

async function getStudents() {
    let students = await fetch(BASE_URL + 'students').then(response => response.json());
    students.forEach(std => renderStudent(std));
}

function renderCourse(course) {
    const div = document.createElement('div');
    div.classList = 'col-lg-4';
    div.id = course.id;

    const cid = document.createElement('h2');
    cid.textContent = course.id;

    const name = document.createElement('p');
    name.textContent = course.name;

    const code = document.createElement('p');
    code.textContent = course.code;

    div.appendChild(cid);
    div.appendChild(name);
    div.appendChild(code);

    const actions = document.createElement('p');
    const updateBtn = document.createElement('a');
    updateBtn.classList = 'btn btn-secondary';
    updateBtn.textContent = 'Update';
    updateBtn.addEventListener('click', function (event) {
        event.preventDefault();
        document.getElementById('course-heading').textContent = 'Edit Course';
        document.getElementById('course-name').value = course.name;
        document.getElementById('course-code').value = course.code;
        document.getElementById('course-btn').dataset.id = course.id;
    });

    const deleteBtn = document.createElement('a');
    deleteBtn.classList = 'btn btn-secondary';
    deleteBtn.textContent = 'Delete';
    deleteBtn.addEventListener('click', function (event) {
        event.preventDefault();

        fetch(BASE_URL + 'courses/' + course.id, {
            method: 'DELETE',
        }).then(response => {
            alert('Delete Successfully!');
            div.remove();
        });
    });

    actions.appendChild(updateBtn);
    actions.appendChild(deleteBtn);

    div.appendChild(actions);

    document.getElementById('courses').appendChild(div);
}


async function addCourse() {
    let result = await fetch(BASE_URL + 'courses/', {
        method: 'POST',
        headers: {
            'Content-type': 'application/json',
        },
        body: JSON.stringify({
            name: document.getElementById('course-name').value,
            code: document.getElementById('course-code').value
        })
    }).then(res => res.json());
    console.log(result);
    document.getElementById('course-form').reset();
    renderCourse(result);
}

function editCourse() {
    const courseId = document.getElementById('course-btn').dataset.id;
    const name = document.getElementById('course-name').value;
    const code = document.getElementById('course-code').value;
    fetch(BASE_URL + 'courses/' + courseId, {
        method: 'PUT',
        headers: {
            'Content-type': 'application/json',
        },
        body: JSON.stringify({
            name: name,
            code: code
        })
    }).then(() => {
        const courseDiv = document.getElementById(courseId);
        courseDiv.querySelector('h2').textContent = courseId;
        const paragraphArr = courseDiv.querySelectorAll('p');
        paragraphArr[0].textContent = name;
        paragraphArr[1].textContent = code;

        document.getElementById('course-heading').textContent = 'Add a new Course';
        document.getElementById('course-btn').dataset.id = '';
        document.getElementById('course-form').reset();
    });
}

function renderStudent(std) {
    const div = document.createElement('div');
    div.classList = 'col-lg-4';
    div.id = 'std' + std.id;

    const sid = document.createElement('h2');
    sid.textContent = std.id;

    const name = document.createElement('p');
    name.textContent = std.firstName + " " + std.lastName;

    const email = document.createElement('p');
    email.textContent = std.email;

    const major = document.createElement('p');
    major.textContent = std.major;

    const gpa = document.createElement('p');
    gpa.textContent = std.gpa;

    let takenCourses = "";
    for (let c of std.coursesTaken) {
        takenCourses += c.name + "; ";
    }
    const courses = document.createElement('p');
    courses.textContent = takenCourses;

    div.appendChild(sid);
    div.appendChild(name);
    div.appendChild(email);
    div.appendChild(email);
    div.appendChild(major);
    div.appendChild(gpa);
    div.appendChild(courses);

    const actions = document.createElement('p');
    const updateBtn = document.createElement('a');
    updateBtn.classList = 'btn btn-secondary';
    updateBtn.textContent = 'Update';
    updateBtn.addEventListener('click', function (event) {
        event.preventDefault();
        document.getElementById('std-heading').textContent = 'Edit Student';
        document.getElementById('std-first-name').value = std.firstName;
        document.getElementById('std-last-name').value = std.lastName;
        document.getElementById('std-email').value = std.email;
        document.getElementById('std-major').value = std.major;
        document.getElementById('std-gpa').value = std.gpa;
        document.getElementById('std-btn').dataset.id = std.id;
        document.getElementById('std-btn').dataset.coursesTaken = JSON.stringify(std.coursesTaken);
    });

    const deleteBtn = document.createElement('a');
    deleteBtn.classList = 'btn btn-secondary';
    deleteBtn.textContent = 'Delete';
    deleteBtn.addEventListener('click', function (event) {
        event.preventDefault();

        fetch(BASE_URL + 'students/' + std.id, {
            method: 'DELETE',
        }).then(response => {
            alert('Delete Successfully!');
            div.remove();
        });
    });

    actions.appendChild(updateBtn);
    actions.appendChild(deleteBtn);

    div.appendChild(actions);

    document.getElementById('students').appendChild(div);
}

async function addStudent() {
    let result = await fetch(BASE_URL + 'students/', {
        method: 'POST',
        headers: {
            'Content-type': 'application/json',
        },
        body: JSON.stringify({
            firstName: document.getElementById('std-first-name').value,
            lastName: document.getElementById('std-last-name').value,
            email: document.getElementById('std-email').value,
            major: document.getElementById('std-major').value,
            gpa: document.getElementById('std-gpa').value
        })
    }).then(res => res.json());
    console.log(result);
    document.getElementById('std-form').reset();
    renderStudent(result);
}

function editStudent() {
    const sid = document.getElementById('std-btn').dataset.id;
    const firstName = document.getElementById('std-first-name').value;
    const lastName = document.getElementById('std-last-name').value;
    const email = document.getElementById('std-email').value;
    const major = document.getElementById('std-major').value;
    const gpa = document.getElementById('std-gpa').value;
    let coursesTaken = document.getElementById('std-btn').dataset.coursesTaken;
    console.log(sid, coursesTaken);
    coursesTaken = JSON.parse(coursesTaken);
    fetch(BASE_URL + 'students/' + sid, {
        method: 'PUT',
        headers: {
            'Content-type': 'application/json',
        },
        body: JSON.stringify({
            firstName: firstName,
            lastName: lastName,
            email: email,
            major: major,
            gpa: gpa,
            coursesTaken: coursesTaken
        })
    }).then(() => {
        const stdDiv = document.getElementById('std' + sid);
        stdDiv.querySelector('h2').textContent = sid;
        const paragraphArr = stdDiv.querySelectorAll('p');
        paragraphArr[0].textContent = firstName + " " + lastName;
        paragraphArr[1].textContent = email;
        paragraphArr[2].textContent = major;
        paragraphArr[3].textContent = gpa;
        let takenCourses = "";
        for (let c of coursesTaken) {
            takenCourses += c.name + "; ";
        }
        paragraphArr[4].textContent = takenCourses;

        document.getElementById('std-heading').textContent = 'Add a new Student';
        document.getElementById('std-btn').dataset.id = '';
        document.getElementById('std-btn').dataset.coursesTaken = '';
        document.getElementById('std-form').reset();
    });
}
