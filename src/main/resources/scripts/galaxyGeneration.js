/* ----- fixed list of planets ----- */
const planets = [
  {
      "id": 1,
      "industryPointsMultiplier": 2,
      "sciencePointsMultiplier": 3,
      "size": 1,
      "galaxyId":1,
      "userId": 1,
      "industryPointsProduce": 1,
      "sciencePointsProduce": 2,
      "xLocation": 90,
      "yLocation": 100
  },
  {
      "id": 2,
      "industryPointsMultiplier": 2,
      "sciencePointsMultiplier": 3,
      "size": 2,
      "galaxyId":1,
      "userId": 1,
      "industryPointsProduce": 1,
      "sciencePointsProduce": 2,
      "xLocation": 240,
      "yLocation": 170
  },
  {
      "id": 3,
      "industryPointsMultiplier": 2,
      "sciencePointsMultiplier": 3,
      "size": 3,
      "galaxyId":1,
      "userId": 3,
      "industryPointsProduce": 1,
      "sciencePointsProduce": 2,
      "xLocation": 130,
      "yLocation": 310
  },
  {
    "id": 4,
    "industryPointsMultiplier": 2,
    "sciencePointsMultiplier": 3,
    "size": 3,
    "galaxyId":1,
    "userId": 1,
    "industryPointsProduce": 1,
    "sciencePointsProduce": 2,
    "xLocation": 270,
    "yLocation": 420
},
  {
      "id": 5,
      "industryPointsMultiplier": 2,
      "sciencePointsMultiplier": 3,
      "size": 2,
      "galaxyId":1,
      "userId": 2,
      "industryPointsProduce": 1,
      "sciencePointsProduce": 2,
      "xLocation": 400,
      "yLocation": 120
  }
];



/* ----- list of planets request ----- */
/* 
function getPlanets(){
    xhr.addEventListener("readystatechange", function() {
      if(this.readyState === 4) {
        console.log(this.responseText);
        return JSON.parse(this.xhr.responseText);
      }
    });

    xhr.open("GET", "http://localhost:8080/getPlanets");
    //xhr.withCredentials = true;
    xhr.send(data);
}
*/



//generating visual representation of the planets and their position
const planetListJSON = planets;
planetListJSON.forEach( gPlanet => {
  console.log(gPlanet);
  const planet = document.createElement('button');
  planet.setAttribute('class', 'planetOutside');
  planet.setAttribute('id', gPlanet.id);
  planet.setAttribute('data-size', gPlanet.size);
  planet.setAttribute('data-user-id', gPlanet.userId);
  planet.setAttribute('data-industry-points-multiplier', gPlanet.industryPointsMultiplier);
  planet.setAttribute('data-science-points-multiplier', gPlanet.sciencePointsMultiplier);
  planet.setAttribute('data-industry-points-produce', gPlanet.industryPointsProduce);
  planet.setAttribute('data-science-points-produce', gPlanet.sciencePointsProduce);
  
  const x = gPlanet.xLocation;
  const y = gPlanet.yLocation;
  planet.style.position = 'fixed';
  planet.style.left = x + 'px';
  planet.style.top = y + 'px';
  const planetsNest = document.querySelector('#planetsNest')
  planetsNest.appendChild(planet);
});

const planetOutside = document.querySelectorAll('.planetOutside');
const overlay=document.querySelector('.overlay')
planetOutside.forEach( btn =>{
  btn.onclick = () => {  
    console.log('ok');
    overlay.classList.toggle('overlayActive');
    const modalBackground = document.createElement('div');
    modalBackground.setAttribute('id', 'modalBackground');
    const modal = document.createElement('div');
    modal.setAttribute('class', 'planetInside');

    const header = document.createElement('header');
    header.setAttribute('class', 'modalHeader')
    const planetName = document.createElement('div');
    const closeButton = document.createElement('button');
    closeButton.setAttribute('class', 'closeButton');
    planetName.innerText = btn.id;
    closeButton.innerHTML = "&times;"
    header.appendChild(planetName);
    header.appendChild(closeButton);

    const planetBody = document.createElement('div');
    planetBody.setAttribute('class', 'modalBody');
    const buildingSite = document.createElement('div');
    buildingSite.setAttribute('class', 'buildingSite')
    for (i = 0; i < 2 * btn.dataset.size; i++){
      const building = document.createElement('div');
      building.setAttribute('class','building');
      buildingSite.appendChild(building);
    };
    
    const resourcePorduction = document.createElement('div');
    resourcePorduction.setAttribute('class', 'resourcesProduction');
    resourcePorduction.append("Industry Points Multiplier: " + btn.dataset.industryPointsMultiplier);
    resourcePorduction.append("Science Points Multiplier: " + btn.dataset.sciencePointsMultiplier);
    resourcePorduction.append("Industry Points Produce: " + btn.dataset.industryPointsProduce);
    resourcePorduction.append("Science Points Produce: " + btn.dataset.sciencePointsProduce);
    
    const army = document.createElement('div');
    army.setAttribute('class', 'amry');
    army.innerText = "tu jeszcze coś będzie"


    planetBody.appendChild(buildingSite);
    planetBody.appendChild(resourcePorduction);
    planetBody.appendChild(army);
    
    modal.appendChild(header);
    modal.appendChild(planetBody);
    overlay.appendChild(modal);
    overlay.appendChild(modalBackground);
    closeButton.addEventListener('click', ()=>{
      overlay.classList.toggle('overlayActive');
      overlay.removeChild(modal);
      overlay.removeChild(modalBackground);
    });
    modalBackground.addEventListener('click', ()=>{
      overlay.classList.toggle('overlayActive');
    });
}});



