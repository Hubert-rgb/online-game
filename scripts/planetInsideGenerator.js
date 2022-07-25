function planetInsideGenerator() {
    const planetInside = document.createElement("div");
    planetInside.setAttribute("class", "modal");
    planetInside.setAttribute("id", "planet1");
    const planetOutside = document.getElementById("p1");
    
    const header = document.createElement("div");
    header.setAttribute("class", "modalHeader");

    const planetName = document.createElement("div"), 
    quit = document.createElement("button");
    planetName.setAttribute("class", "title");
    planetName.innerHTML = "Hoth";

    quit.setAttribute("class", "closeButton");
    quit.setAttribute("data", `[data-close-button]`);
    quit.innerHTML = `&times;`;
    header.appendChild(planetName);
    header.appendChild(quit);
    
    planetInside.appendChild(header);

    const body = document.createElement("div");
    body.setAttribute("class", "modalBody");

    body.innerHTML = "Lorem ipsum dolor sit amet consectetur, adipisicing elit. Quidem architecto natus alias aliquam nulla suscipit odit ipsa saepe minima, quam amet quisquam mollitia quaerat molestias reprehenderit velit tempora dolor assumenda rerum facilis consectetur eos? Neque voluptate fugiat quod quibusdam eligendi, beatae nobis, eos dolorum nemo ipsa non. Beatae iure ea enim dolorum odit, molestiae eum ratione, distinctio aut incidunt hic impedit. Dolores temporibus ipsam odio nemo voluptates quidem quas sapiente, inventore similique dolorum error beatae aperiam et quibusdam molestiae corrupti.";
    

    planetInside.appendChild(body);

    planetOutside.appendChild(planetInside);
    
    /*<div class = "modal" id="planet1">
        <div class="modalHeader">
            <div class="title">Hoth</div>
            <button data-close-button class="closeButton">&times;</button>           
        </div>
        <div class="modalBody">
            Lorem ipsum dolor sit amet consectetur, adipisicing elit. Quidem architecto natus alias aliquam nulla suscipit odit ipsa saepe minima, quam amet quisquam mollitia quaerat molestias reprehenderit velit tempora dolor assumenda rerum facilis consectetur eos? Neque voluptate fugiat quod quibusdam eligendi, beatae nobis, eos dolorum nemo ipsa non. Beatae iure ea enim dolorum odit, molestiae eum ratione, distinctio aut incidunt hic impedit. Dolores temporibus ipsam odio nemo voluptates quidem quas sapiente, inventore similique dolorum error beatae aperiam et quibusdam molestiae corrupti.
        </div>
    </div>*/
}

export {planetInsideGenerator};