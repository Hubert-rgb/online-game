const apiUrl = 'https://jsonplaceholder.typicode.com';
async function fetchUsers(){
    try {
        const response = await fetch(`${apiUrl}/posts`);
        if (!response.ok){
            throw new Error('Failed to fetck posts: $response.status');
        }
        return response.json();
    }   catch (e) {
        console.log(e);
    }
}
//list of existing users
function listUsers(){
    fetchUsers().then(users =>{
        
    }).catch(error=> {
        console.error(error);
    });
}

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
            "username": "Wysok",
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
            window.open('index.html')
            return; 
        }
    }
    const message = document.getElementById('message');
    message.textContent = "Incorrect username or password";
}


const myForm = document.getElementById('myFrom')
myForm.addEventListener('submit', e => {
    e.preventDefault();
    login();
});