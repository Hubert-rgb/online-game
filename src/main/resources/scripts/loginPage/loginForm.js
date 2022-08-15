

const myForm = document.getElementById('myForm')
myForm.addEventListener('submit', async e => {
    e.preventDefault();

    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    await login(username, password);
    
    myForm.submit();
});



async function login(username, password){
    const data = JSON.stringify({
        "name": username,
        "password": password      
    });
    
    const xhr = new XMLHttpRequest();


    
    //xhr.withCredentials = true;
    

    xhr.addEventListener("readystatechange", function() {
      if(this.readyState === 4) {
        const user = JSON.parse(this.responseText);
        localStorage.setItem('userid', user.id);
        localStorage.setItem('username', user.name);
        localStorage.setItem('authorisation', 1);
      }});

    xhr.open("POST", "http://localhost:8080/loginUser", true);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(data);
};

