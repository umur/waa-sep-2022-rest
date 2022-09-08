window.onload = function () {
  //check authorized then loading the right content
  ///authenticationChecking();


  renderCourseList();
  
  renderStudentList();
}


var host = 'http://localhost:8080';

function renderSeperationLine() {
  const seperate = document.createElement('div');
  seperate.style = 'margin-top: 20px;';
  seperate.innerHTML = '<hr/>';
  return seperate;
}

async function renderCourseList() {
  const courses = await fetch(`${host}/courses`, {
    method: 'GET',
    cache: 'no-cache',
    headers: headersGeneration()
  }).then(response => response.json());
  
  if (courses) {
    const contentDiv = document.getElementById('content');

    const courseDiv = document.createElement('div');
    courseDiv.id = 'course';
    const pTitle = document.createElement('p');
    pTitle.innerHTML = 'Course List';
    courseDiv.appendChild(pTitle);

    if (courses.length === 0) {
      const pInfo = renderNoCourse();
      courseDiv.appendChild(pInfo);
    } else {
      let grid = document.createElement('div');
      grid.classList = 'grid';
      grid.id = 'course-grid';
      
      grid = renderCourseGrid(courses, grid);
      
      courseDiv.appendChild(grid);
    }
    contentDiv.appendChild(courseDiv);
    const seperate = renderSeperationLine();
    contentDiv.appendChild(seperate);
  }
}

async function renderStudentList() {
  const students = await fetch(`${host}/students`, {
    method: 'GET',
    cache: 'no-cache',
    headers: headersGeneration()
  }).then(response => response.json());
  
  console.log(students)
  
  if (students) {
    const contentDiv = document.getElementById('content');

    const studentDiv = document.createElement('div');
    studentDiv.id = 'student';
    const pTitle = document.createElement('p');
    pTitle.innerHTML = 'Student List';
    studentDiv.appendChild(pTitle);

    if (students.length === 0) {
      const pInfo = renderNoStudent();
      studentDiv.appendChild(pInfo);
    } else {
      let grid = document.createElement('div');
      grid.classList = 'grid';
      grid.id = 'student-grid';
      
      grid = renderStudentGrid(students, grid);
      
      studentDiv.appendChild(grid);
    }
    
    contentDiv.appendChild(studentDiv);
  }
}

function headersGeneration() {
  return {
    'Content-Type': 'application/json'
  };
}

function renderNoCourse() {
  const pInfo = document.createElement('p');
  pInfo.classList = 'no-item-cart';
  pInfo.style.textTransform = 'initial';
  pInfo.innerHTML = 'There is no course!';
  return pInfo;
}

function renderNoStudent() {
  const pInfo = document.createElement('p');
  pInfo.classList = 'no-item-cart';
  pInfo.style.textTransform = 'initial';
  pInfo.innerHTML = 'There is no student!';
  return pInfo;
}

function renderCourseGrid(courses, grid) {
  const rowHead = document.createElement('div');
  rowHead.classList = 'row';
  rowHead.innerHTML = `
    <div class="head cell">Id</div>
    <div class="head cell">Name</div>
    <div class="head cell">Code</div>
  `;
  grid.appendChild(rowHead);

  courses.forEach(item => {
    const row = document.createElement('div');
    row.classList = 'row';
    row.id = 'itemid-' + item.id;
    row.dataset.id = item.id;

    const divId = document.createElement('div');
    divId.classList = 'cell itemId';
    divId.innerHTML = item.id;
    row.appendChild(divId);

    const divName = document.createElement('div');
    divName.classList = 'cell itemName';
    divName.innerHTML = item.name;
    row.appendChild(divName);

    const divCode = document.createElement('div');
    divCode.classList = 'cell code';
    divCode.innerHTML = item.code;
    row.appendChild(divCode);

    grid.appendChild(row);

  });

  return grid;
}

function renderStudentGrid(students, grid) {
  const rowHead = document.createElement('div');
  rowHead.classList = 'row';
  rowHead.innerHTML = `
    <div class="head cell">Id</div>
    <div class="head cell">FullName</div>
    <div class="head cell">Email</div>
    <div class="head cell">Major</div>
    <div class="head cell number">GPA</div>
    <div class="head cell">Taken Course</div>
  `;
  grid.appendChild(rowHead);

  students.forEach(item => {
    const row = document.createElement('div');
    row.classList = 'row';
    row.id = 'itemid-' + item.id;
    row.dataset.id = item.id;

    const divId = document.createElement('div');
    divId.classList = 'cell itemId';
    divId.innerHTML = item.id;
    row.appendChild(divId);

    const divName = document.createElement('div');
    divName.classList = 'cell itemName';
    divName.innerHTML = item.firstName + ' ' + item.lastName;
    row.appendChild(divName);

    const divEmail = document.createElement('div');
    divEmail.classList = 'cell email';
    divEmail.innerHTML = item.email;
    row.appendChild(divEmail);

    const divMajor = document.createElement('div');
    divMajor.classList = 'cell major';
    divMajor.innerHTML = item.major;
    row.appendChild(divMajor);

    const divGPA = document.createElement('div');
    divGPA.classList = 'cell gpa';
    divGPA.innerHTML = item.gpa.toFixed(2);
    row.appendChild(divGPA);

    const divCourse = document.createElement('div');
    divCourse.classList = 'cell course-taken';
    let courseStr = [];

    item.coursesTaken.forEach(item => {
      courseStr.push(item.code + ': ' + item.name);
    });
    divCourse.innerHTML = courseStr.join("; ");
    row.appendChild(divCourse);

    grid.appendChild(row);

  });

  return grid;
}
