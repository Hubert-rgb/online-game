//const apiUrl = 'https://jsonplaceholder.typicode.com';
//checking password confirmation
function checkPassword(){
    const password = document.getElementById("password").value;
    const confirmPassword = document.getElementById("confirm-password").value;    
    if (password.lenght!=0){
        if (password==confirmPassword){
            return true;
        }
        else{
            return false;
        }
    }
}

//posting new user to the DB
const myForm = document.getElementById('myFrom')
myForm.addEventListener('submit', e => {
    e.preventDefault();
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    if (checkPassword()==true){

    
    let user = {
        username: username,
        password: password
    }
//    fetch(`${apiUrl}/posts`, {
    fetch('../users.html', {
        method: 'post', 
        headers:{'Content-Type': 'application/json'},
        body: JSON.stringify(user)
    }).then(response => {
        return response.text();
    }).then(text => {
        console.log(text);
    }).catch(error => {
        console.error(error);
    });
    fetch('../users.html')
    .then(response => {
        return response.text();
    });
    // .then(text => {
    //     console.log(text);
    // });
    }
    else{
        const message = document.getElementById('message');
        message.textContent = "Password don't match";
    }
});

