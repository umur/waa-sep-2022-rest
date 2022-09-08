fetch("http://localhost:8080/courses", {
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

            const nameElement = document.createElement("td");
            const nameText = document.createTextNode(row.name);
            nameElement.appendChild(nameText);

            const codeElement = document.createElement("td");
            const codeText = document.createTextNode(row.code);
            codeElement.appendChild(codeText);

            tr.appendChild(idElement);
            tr.appendChild(nameElement);
            tr.appendChild(codeElement);
            tableBody.append(tr)
        }

    })
    .catch(error => {
        console.log(error);
    })

let studentForm = document.getElementById("course-form");
studentForm.addEventListener("submit", (event)=> {
    event.preventDefault();
    const formData = new FormData(event.target)
    fetch("http://localhost:8080/courses", {
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

            const nameElement = document.createElement("td");
            const nameText = document.createTextNode(response.name);
            nameElement.appendChild(nameText);

            const codeElement = document.createElement("td");
            const codeText = document.createTextNode(response.code);
            codeElement.appendChild(codeText);

            tr.appendChild(idElement);
            tr.appendChild(nameElement);
            tr.appendChild(codeElement);
            tableBody.append(tr)

        })
        .catch(error => {
            console.log(error);
        })
    return false;
})