/* preset list of all galaxies 
const galaxyListJSON = [
    {
        "id": 1,
        "name": "galaxy1",
        "players": 4 
    },
    {
        "id": 2,
        "name": "galaxy2",
        "players": 3 
    },
    {
        "id": 3,
        "name": "galaxy3",
        "players": 5 
    },
    {
        "id": 4,
        "name": "galaxy4",
        "players": 8 
    }
]
/**/
window.onload = galaxyList();

// ----- log out button (Now: exiting the page , InF: will log out) ----- //
const logOutButton = document.getElementById('logOutButton');
logOutButton.addEventListener('click', () => {
    window.open('login.html', '_self');
});
//

//--------------------------//
//-----XML Http Request-----//
//--------------------------//

/* old one
function sendHttpRequest(method, url, data){
    const promise = new Promise((resolve, reject) => {
        const xhr = new XMLHttpRequest();
        xhr.open(method, url);
        xhr.addEventListener("readystatechange", () => {
        if(this.readyState === 4) {
            console.log(this.responseText);
            alert(xhr.responseText);
        };
        });    
        xhr.send(JSON.stringify(data));
    });
    return promise;
};
*/

function sendHttpRequest(method, url, data){
    const promise = new Promise((resolve, reject) => {
        
        const xhr = new XMLHttpRequest();
        xhr.open(method, url,);
        xhr.responseType = 'json';
        
        if(data){
        xhr.setRequestHeader('Content-Type', 'application/json')
        };
        
        xhr.onload = () =>{
            if (xhr.status >= 200 && xhr.status < 300) {
                resolve(xhr.response);
            } else {
                reject(xhr.statusText);
            }
        };
        xhr.send(JSON.stringify(data));

        xhr.onerror = () => {
            reject(xhr.response);
        }
    });
    return promise;
};

//---------------------------//
//-----adding new galaxy-----//
//---------------------------//

const createNewGalaxyButton = document.querySelector('#newGalaxyButton');
const formBackground = document.querySelector('.formBackground');
const closeFrom = document.querySelector('.closeForm')
createNewGalaxyButton.addEventListener('click', () =>{
    formBackground.classList.toggle('backgroundActive');
});
closeFrom.addEventListener('click', () => {
    formBackground.classList.toggle('backgroundActive');
});

const form = document.getElementById('form')
form.addEventListener('submit', e => {
    e.preventDefault();
    const galaxyName = document.getElementById('galaxyName').value;
    sendHttpRequest('POST', 'http://localhost:8080/createGalaxy', {
        galaxyName: galaxyName
    })
    .then(responseData => {
        console.log(responseData)
    })
    .catch(err => {
        console.log(err);
    });
    location.reload();
});


/* not needed (probably)
function newGalaxy(galaxyName){
    const data = `{"name": ${galaxyName}}`;
    const xhr = new XMLHttpRequest();
    xhr.addEventListener("readystatechange", () => {
      if(this.readyState === 4) {
        console.log(this.responseText);
        alert(xhr.responseText);
      }
    });
    xhr.open("POST", "http://localhost:8080/createGalaxy", true);
    xhr.send(data);    
};
*/



//

//-----------------------------------------//
//-----generating the list of galaxies-----//
//-----------------------------------------//

// XML request


function listGalaxies(){
    const xhr = new XMLHttpRequest();
    xhr.addEventListener("readystatechange", () => {
      if(this.readyState === 4) {
        console.log(this.responseText);
        return JSON.parse(this.xhr.responseText);
      }
    });

    xhr.open("GET", "http://localhost:8080/getGalaxies", true);
    xhr.send();

}
// DOM manipulation
async function galaxyList(){    
    const list = document.getElementById('galaxyList');
    
    /*
    const getData = async() =>{
         const galaxyListJSON = listGalaxies();
         return galaxyListJSON;
    }

    getData()*/

    const galaxyListJSON = await sendHttpRequest('GET', 'http://localhost:8080/getGalaxies');  
    
    galaxyListJSON.forEach( galaxy => {
        const li = document.createElement('li');
        li.innerText = `${galaxy.galaxyName}`;
        const players = document.createElement('p')
        players.innerText = `${galaxy.players}/8`;

        li.appendChild(players);
 
        const btn = document.createElement('button');
        btn.setAttribute('class', 'joinButton');
        btn.setAttribute('data-id', galaxy.galaxyId);
        btn.innerHTML = 'Join';
        
        li.appendChild(btn);
        li.setAttribute('class', 'listItem');
        list.appendChild(li);
    });
    
    const newGalaxyButton = document.createElement('button');
    newGalaxyButton.setAttribute('id', 'newGalaxyButton');
    newGalaxyButton.setAttribute('class', 'button');
    newGalaxyButton.innerText = 'Create new galaxy';
    list.appendChild(newGalaxyButton);
};

//----------------------------------//
// ----- Connecting to galaxy ----- //
//----------------------------------//

/*
function connectToGalaxy(userId, galaxyId)
{
    const data = `{"userId": ${userId}, "galaxyId": ${galaxyId}}`;
    const xhr = new XMLHttpRequest();
    xhr.addEventListener("readystatechange", () => {
      if(this.readyState === 4) {
        console.log(this.responseText);
        alert(xhr.responseText);
      }
    });
    xhr.open("POST", "http://localhost:8080/connectToGalaxy", true);
    xhr.send(data);
}
*/


// galaxy id is acquired from btn.dataset.id
async function connectToGalaxy(galaxy)
{
    const user = await usersendHttpRequest('GET', 'http://localhost:8000/loginUser');
    //const galaxy = await sendHttpRequest('GET', 'http://localhost:8000/getGalaxies');

    
    sendHttpRequest('POST', 'http://localhost:8000/getGalaxies', {
        userId: user.id, 
        galaxyId: galaxy
    });   
}





const joinButton = document.querySelectorAll('joinButton')

joinButton.forEach(addEventListener('click', () =>{

}));