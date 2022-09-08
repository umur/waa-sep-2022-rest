fetch("http://localhost:8080/students", {
    method: "get"
})
.then(response=>response.json())
.then(response => {
    let tableBody = document.getElementById("table-body");
    for(let row of response){
        let tr = document.createElement("tr");

        const idElement = document.createElement("th");
        const idText = document.createTextNode(row.id);
        idElement.appendChild(idText);

        const firstnameElement = document.createElement("td");
        const firstnameText = document.createTextNode(row.firstname);
        firstnameElement.appendChild(firstnameText);

        const lastnameElement = document.createElement("td");
        const lastnameText = document.createTextNode(row.lastname);
        lastnameElement.appendChild(lastnameText);

        const emailElement = document.createElement("td");
        const emailText = document.createTextNode(row.email);
        emailElement.appendChild(emailText);

        const majorElement = document.createElement("td");
        const majorText = document.createTextNode(row.major);
        majorElement.appendChild(majorText);

        const gpaElement = document.createElement("td");
        const gpaText = document.createTextNode(row.gpa);
        gpaElement.appendChild(gpaText);

        tr.appendChild(idElement);
        tr.appendChild(firstnameElement);
        tr.appendChild(lastnameElement);
        tr.appendChild(emailElement);
        tr.appendChild(majorElement);
        tr.appendChild(gpaElement);
        tableBody.append(tr)
    }

})
.catch(error => {
    console.log(error);
})

let studentForm = document.getElementById("student-form");
studentForm.addEventListener("submit", (event)=> {
    event.preventDefault();
    const formData = new FormData(event.target)
    fetch("http://localhost:8080/students", {
        method: "post",
        body: JSON.stringify(Object.fromEntries(formData.entries())),
        headers:{
            "Content-type": "application/json"
        }
    })
        .then(response=>response.json())
        .then(response => {
            let tableBody = document.getElementById("table-body");
            let tr = document.createElement("tr");

            const idElement = document.createElement("th");
            const idText = document.createTextNode(response.id);
            idElement.appendChild(idText);

            const firstnameElement = document.createElement("td");
            const firstnameText = document.createTextNode(response.firstname);
            firstnameElement.appendChild(firstnameText);

            const lastnameElement = document.createElement("td");
            const lastnameText = document.createTextNode(response.lastname);
            lastnameElement.appendChild(lastnameText);

            const emailElement = document.createElement("td");
            const emailText = document.createTextNode(response.email);
            emailElement.appendChild(emailText);

            const majorElement = document.createElement("td");
            const majorText = document.createTextNode(response.major);
            majorElement.appendChild(majorText);

            const gpaElement = document.createElement("td");
            const gpaText = document.createTextNode(response.gpa);
            gpaElement.appendChild(gpaText);

            tr.appendChild(idElement);
            tr.appendChild(firstnameElement);
            tr.appendChild(lastnameElement);
            tr.appendChild(emailElement);
            tr.appendChild(majorElement);
            tr.appendChild(gpaElement);
            tableBody.append(tr)

        })
        .catch(error => {
            console.log(error);
        })
    return false;
})