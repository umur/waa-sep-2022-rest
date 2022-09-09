function formUpdater(){
    console.log("working")
    document.getElementById("stdform").style.display = 'inline';
}

function addStudent() {
    let id = document.getElementById("id").value;
    let firstName = document.getElementById("firstName").value;
    let lastName = document.getElementById("lastName").value;
    let email = document.getElementById("email").value;
    let major = document.getElementById("major").value;
    let gpa = document.getElementById("gpa").value;
    let coursesTaken = document.getElementById("coursesTaken")
    const data = {
        id,
        firstName,
        lastName,
        email,
        major,
        gpa,
        coursesTaken : [
            {
                id,
                name

            }

        ]
    };

    fetch('http://localhost:8080/students', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    })
        .then((response) => response.json())
        .then((data) => {
            console.log('Success:', data);
        })
        .catch((error) => {
            console.error('Error:', error);
        });
}
    let currentPage = location.pathname.split("/").pop();;

    if (currentPage == "course.html") {
        fetch("http://localhost:8080/courses")
        .then((response) => response.json())
        .then((data) => {
            data.forEach(element => {
                document.getElementById("courses").innerHTML += `<li>${element.name}</li>`;
            });
        });    
    } else if (currentPage == "student.html") {
        fetch("http://localhost:8080/students")
        .then((response) => response.json())
        .then((data) => {
            data.forEach(element => {
                document.getElementById("students").innerHTML += `<li>${element.firstName} ${element.lastName}, ${element.coursesTaken[0].name}</li>`;
            });
        });    
    }

 