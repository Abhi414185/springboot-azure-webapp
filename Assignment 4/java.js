
var row = 1;
let check = 0;


var entry = document.getElementById('btn');
entry.addEventListener("click", displayDetails);


function displayDetails() {
    if (check == 0) {
        var heading = document.getElementById('Show');
        var rowHead = heading.insertRow(0);
        var cell1 = rowHead.insertCell(0);
        var cell2 = rowHead.insertCell(1);
        cell1.style.columnWidth = '350px'
        cell2.style.columnWidth = '100px'
        rowHead.style.backgroundColor = '#b1eb34';
        cell1.innerHTML = `<div><h6 class="text-white">Description</h6></div>`
        cell2.innerHTML = `<div><h6 class="text-white">Image</h6></div>`
        check = 1;
    }

    console.log('hello');
    var name = document.getElementById('Name').value;
    var email = document.getElementById('emailID').value;
    var website = document.getElementById('websiteURL').value;
    var imgLink = document.getElementById('imgURL').value;
    var gender = document.getElementsByName('gender');
    var gen;
    var skills = document.getElementsByName('skill');
    var skill = [];
    for (var x = 0; x < skills.length; x++) {
        if (skills[x].checked) {
            skill.push(skills[x]);
        }
    }


    for (var i = 0; i < gender.length; i++) {
        if (gender[i].checked) {
            gen = gender[i].value;
        }
    }
    if(!name || !email || !website || !imgLink || !gen){
        alert("All fields are mandatory!");
        return;
    }

    var display = document.getElementById('Show');

    var newRow = display.insertRow(row);
    var cell1 = newRow.insertCell(0);
    var cell2 = newRow.insertCell(1);

    cell1.innerHTML += `<div><strong>${name}</strong></div>
 <div>${email}</div><div class = "px-6"><a href = "${website}" target = "_blank">${website}</a></div><div>Gender : ${gen}</div>`;
    for (var p = 0; p < skill.length; p++) {
        cell1.innerHTML += `${skill[p].value} - `
    }
    cell2.innerHTML = `<div><img src="${imgLink}"></div>`;
    
    if (row % 2 != 0) {
        newRow.style.backgroundColor = '#e5e8df';
    }
    else {
        newRow.style.backgroundColor = '#e9f5d5';
    }
    row++;

}





