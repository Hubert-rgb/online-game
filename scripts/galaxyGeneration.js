/*
function galaxy(){
    const data = new FormData();
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value; 
    data.append("name", username);
    data.append("password", password);

    const xhr = new XMLHttpRequest();
    //xhr.withCredentials = true;
    

    xhr.addEventListener("readystatechange", function() {
      if(this.readyState === 4) {
        console.log(this.responseText);
        alert(xhr.responseText);
      }
    });

    xhr.open("GET", "http://localhost:8080/getGalaxy");
    //xhr.withCredentials = true;
    xhr.send(data);
}
*/

//generating visual representation of the planets and their position
function generatePlanets(planets) {
    console.log(planets);
    const planetList = JSON.parse(planets);
    for (let i=0; i<planetList.length; i++)
        {
            console.log(planetList[i].name);
            console.log(planetList[i].id);
            const planet = document.createElement('button');
            planet.setAttribute('class', 'planets');
            planet.setAttribute('id', planetList[i].id);
            const x = planetList[i].xLocation;
            const y = planetList[i].yLocation;
            planet.style.position = 'fixed';
            planet.style.left = x + 'px';
            planet.style.top = y + 'px';
            // planet.setAttribute('style', `left: ${x} + 'px'`);
            // planet.setAttribute('style', `top: ${y} + 'px'`);
            document.body.appendChild(planet);

        }  
}

export {generatePlanets};

