/*
//logging
function login(){
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value; 
    //const users = listUsers();
    const users = [
        {
            "id": 1,
            "username": "Hubert",
            "password": "bert123"
        },
        {
            "id": 2,
            "username": "Michal",
            "password": "michujas"
        },
        {
            "id": 3,
            "username": "wysok",
            "password": "krzeslo"
        },
        {
            "id": 4,
            "username": "sympatyk",
            "password": "pawel"
        }
    ];
    for (i = 0; i < users.length; i ++){
        if (username == users[i].username && password == users[i].password){
            console.log("you are logged in");
            window.open('menu.html', self)
            return; 
        }
    }
    const message = document.getElementById('message');
    message.textContent = "Incorrect username or password";
}
*/

const myForm = document.getElementById('myForm')
myForm.addEventListener('submit', e => {
    e.preventDefault();
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    login(username, password);
});


function login(username, password){
    const data = JSON.stringify({
        "name": username,
        "password": password
    });


    const xhr = new XMLHttpRequest();
    //xhr.withCredentials = true;


    xhr.addEventListener("readystatechange", function() {
      if(this.readyState === 4) {
        console.log(this.responseText);
      }});

    xhr.open("POST", "http://localhost:8080/loginUser", true);
    //xhr.withCredentials = true;
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(data);
}