

const myForm = document.getElementById('myForm')
myForm.addEventListener('submit', e => {
    e.preventDefault();

    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    
    login(username, password);
    myForm.submit();


    
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
        const user = JSON.parse(this.responseText);
        console.log(user);
        const id = user.id;
        const name = user.name;
        localStorage.setItem('auth', 1);
        localStorage.setItem('userid', id);
        localStorage.setItem('username', name);
      }});

    xhr.open("POST", "http://localhost:8080/loginUser", true);
    //xhr.withCredentials = true;
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(data);
};
