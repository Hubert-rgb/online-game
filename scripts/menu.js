//log out button (Now: exiting the page , InF: will log out)
const logOutButton = document.getElementById('logOutButton');
logOutButton.addEventListener('click', () => {
    window.open('login.html', self);
});
//

//list of all galaxies (InF: function JSON => array of objects)
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
//


//1st option
function galaxyList(){
    const list = document.getElementById('galaxyList');
    galaxyListJSON.forEach( function(e) {
        const li = document.createElement('li');
        li.innerText = `${e.name}`;

        const players = document.createElement('p')
        players.innerText = `${e.players}/8`;

        li.appendChild(players);

        const btn = document.createElement('button');
        btn.setAttribute('class', 'joinButton');
        btn.innerHTML = 'Join';
        li.appendChild(btn);

        li.setAttribute('class', 'listItem');

        list.appendChild(li);
    });
    //<button id = "newGalaxyButton" class="button">Create new galaxy</button>
    const newGalaxyButton = document.createElement('button');
    newGalaxyButton.setAttribute('id', 'newGalaxyButton');
    newGalaxyButton.setAttribute('class', 'button');
    newGalaxyButton.innerText = 'Create new galaxy';
    list.appendChild(newGalaxyButton);
}
galaxyList();

/* 2nd option

//generating the list of galaxies 
function galaxyList(){
    const list = document.getElementById('galaxyList');
    galaxyListJSON.forEach( function(e) {
        const li = document.createElement('li');
        li.innerText = `${e.name}`;
        const ul= document.createElement('ul');
        ul.setAttribute('class', 'smallList');
        ul.setAttribute('style', 'display: none');

        const playerCount = document.createElement('li')
        playerCount.innerText = `${e.players}/8`;
        ul.appendChild(playerCount);

        const buttonSocket = document.createElement('li');
        const btn = document.createElement('button');
        btn.innerHTML = 'Join';
        buttonSocket.appendChild(btn);

        ul.appendChild(buttonSocket);

        li.appendChild(ul);
        li.setAttribute('class', 'listItem');

        list.appendChild(li);
    });
}
galaxyList();
//

//opening and closing galaxy data
const listButton = document.querySelectorAll('.listItem');
listButton.forEach(listHeader => {
    listHeader.addEventListener('click', () => {
        const parrent = listHeader.querySelector('.smallList');
        if (parrent.style.display === 'none'){
            parrent.style.display = 'block';
        }
        else{
            parrent.style.display = 'none'; 
        }
    });
});
*/
//

