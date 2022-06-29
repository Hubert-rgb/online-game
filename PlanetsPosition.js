function planetCoordinatesGenerator(planets) {
    for (let i=1; i<5; i++)
        {
            let id = 'p' + i;
            console.log(JSON.parse(planets)[i-1].name);
            console.log(id)
            let x = JSON.parse(planets)[i-1].xCord;
            let y = JSON.parse(planets)[i-1].yCord
            document.getElementById(id).style.left = x + 'px';
            document.getElementById(id).style.top = y + 'px';
        }  
}

export {planetCoordinatesGenerator};