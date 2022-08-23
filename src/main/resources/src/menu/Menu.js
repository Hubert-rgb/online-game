import React, {useState} from "react";
import Axios from "axios";
import Modal from "../Modal";
import MaximalUserNumber from "./MaximalUserNumber";

function App() {
  
  const [galaxyList, setGalaxyList] = useState([])

  const getGalaxies = () => {
    Axios.get('http://localhost:8080/getGalaxies')
    .then((response)=>{
        console.log(response);
        setGalaxyList(response.data); 
    });
  };

  var galaxies = [];
  const displayGalaxies = galaxyList.forEach( galaxy => {
    galaxies.push(galaxy);
  });

  const list = galaxies.map((galaxy) =>
    <li key={galaxy.id}>{galaxy.galaxyName}</li>
  );

  const [isOpen, setIsOpen] = useState(false);

  const createGalaxy = (e) => {
    e.preventDefault();
    const galaxyName = document.getElementById('galaxyName');
    const maximalUserNumber = document.getElementById('maximalUserNumber')
    if (!galaxyName) return null
    Axios.post('http://localhost:8080/createGalaxy', 
    JSON.stringify({galaxyName, maximalUserNumber}),
    { 
      headers: {'Content-Type':'application/json'},
      withCredentials: true
    })
    .then(function (response) {
      console.log(response);
    })
    .catch(function (error) {
      console.log(error);
    });
  };

  return( 
  <>
    <button onClick={getGalaxies}>Click me</button>

    {displayGalaxies}
    <ul>{list}</ul>
    
    <button onClick={()=>setIsOpen(true)}>New galaxy</button>
    <Modal open={isOpen} onClose={()=> setIsOpen(false)}>
      <form>
        <input id="galaxyName" placeholder="Galaxy Name" required></input>
        <MaximalUserNumber/>
        <button type="submit" onClick={createGalaxy}>Create Galaxy</button>
      </form>
    </Modal>
  </>
  )
}

export default App;
