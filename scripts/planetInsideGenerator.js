/*function planetInsideGenerator() {
    const planetOutside = document.getElementById("p1");
    
    const planetInside = document.createElement("div");
    planetInside.setAttribute("class", "modal");
    planetInside.setAttribute("id", "planet1");
    planetInside.setAttribute("style", "cursor: default");
    
    const header = document.createElement("div");
    header.setAttribute("class", "modalHeader");

    const planetName = document.createElement("div"); 
    const quit = document.createElement("button");
    planetName.setAttribute("class", "title");
    planetName.innerHTML = "Hoth";

    quit.setAttribute("id", "overlay");
    quit.setAttribute("class", "closeButton");
    quit.innerHTML = `&times;`;
    header.appendChild(planetName);
    header.appendChild(quit);
    
    planetInside.appendChild(header);

    const body = document.createElement("div");
    body.setAttribute("class", "modalBody");

    body.innerHTML = "Lorem ipsum dolor sit amet consectetur, adipisicing elit. Quidem architecto natus alias aliquam nulla suscipit odit ipsa saepe minima, quam amet quisquam mollitia quaerat molestias reprehenderit velit tempora dolor assumenda rerum facilis consectetur eos? Neque voluptate fugiat quod quibusdam eligendi, beatae nobis, eos dolorum nemo ipsa non. Beatae iure ea enim dolorum odit, molestiae eum ratione, distinctio aut incidunt hic impedit. Dolores temporibus ipsam odio nemo voluptates quidem quas sapiente, inventore similique dolorum error beatae aperiam et quibusdam molestiae corrupti.";
    

    planetInside.appendChild(body);

    planetOutside.appendChild(planetInside);
    
    <div class = "modal" id="planet1">
        <div class="modalHeader">
            <div class="title">Hoth</div>
            <button data-close-button class="closeButton">&times;</button>           
        </div>
        <div class="modalBody">
            Lorem ipsum dolor sit amet consectetur, adipisicing elit. Quidem architecto natus alias aliquam nulla suscipit odit ipsa saepe minima, quam amet quisquam mollitia quaerat molestias reprehenderit velit tempora dolor assumenda rerum facilis consectetur eos? Neque voluptate fugiat quod quibusdam eligendi, beatae nobis, eos dolorum nemo ipsa non. Beatae iure ea enim dolorum odit, molestiae eum ratione, distinctio aut incidunt hic impedit. Dolores temporibus ipsam odio nemo voluptates quidem quas sapiente, inventore similique dolorum error beatae aperiam et quibusdam molestiae corrupti.
        </div>
    // </div>
}
*/


const planetsOutside = document.querySelectorAll('.planetsOutside');
const overlay=document.querySelectorAll('.overlay')
planetsOutside.forEach(addEventListener('click', () =>{
    console.log('ok');
    overlay.classList.toggle('overlayActive');
    // const formBackground = document.createElement('div');
    // const form = document.createElement('form');
    // const galaxyName = document.createElement('input');
    // const submitButton = document.createElement('submit');
    
    // formBackground.setAttribute('class', 'formBackground');
    // form.setAttribute('id', 'form');
    // galaxyName.setAttribute('id','galaxyName');
    // galaxyName.setAttribute('class','galaxyNameClass');
    // galaxyName.setAttribute('type','text');
    // galaxyName.setAttribute('placeholder','galaxy name');
    // galaxyName.setAttribute('autocomplete','none');
    // submitButton.setAttribute('id', 'submitButton');
    // submitButton.setAttribute('type', 'submit')
    // submitButton.innerText = "Create new galaxy";
    // form.append(galaxyName);
    // form.append(submitButton);
    // formBackground.append(form);
    // overlay.append(formBackground);
    // <input id="username" class="usernameClass" type="text" placeholder="username" autocomplete = "none" required>
    // <button  class="submitButton" type="submit"> Log in </button>
}));