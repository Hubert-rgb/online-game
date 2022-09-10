import React, {useState} from "react";
import Axios from "axios";
import MaximalUserNumber from "./MaximalUserNumber";


export default function CreateGalaxy() {

    const [maximalUserNumber, setMaxiamlUserNumber] = useState(2);  
    const changeCount = (count) =>{
      setMaxiamlUserNumber(count);
    }

    const createGalaxy = async (e) => {
        e.preventDefault();
        const galaxyName = document.getElementById('galaxyName').value;
        
        if (!galaxyName) return null
    
        try{
          const response = await Axios.post('http://localhost:8080/galaxy-controller/galaxies', 
          JSON.stringify({maximalUserNumber:maximalUserNumber, galaxyName:galaxyName}),
          {
          headers: 
                  {
                    'Access-Control-Allow-Origin': 'http://localhost:3000',
                    'Access-Control-Allow-Methods': 'GET',
                    'Access-Control-Allow-Headers': 'Content-Type',
                    'Access-Control-Allow-Credentials': 'true',
                    'Content-Type': 'application/json'}
          });
          console.log(response.data);
          console.log(JSON.stringify({maximalUserNumber:maximalUserNumber, galaxyName:galaxyName}));
        } catch { 
          console.log(JSON.stringify({maximalUserNumber:maximalUserNumber, galaxyName:galaxyName}));
        }

        
    };
      
  return (
    <form>
        <input id="galaxyName" placeholder="Galaxy Name" required></input>
            <MaximalUserNumber changeCount={changeCount}/>
        <button type="submit" onClick={createGalaxy}>Create Galaxy</button>
      </form>
  )
}
