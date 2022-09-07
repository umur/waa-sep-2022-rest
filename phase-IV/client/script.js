window.onload = function() {
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
                document.getElementById("students").innerHTML += `<li>${element.firstName} ${element.lastName}</li>`;
            });
        });    
    }

}
