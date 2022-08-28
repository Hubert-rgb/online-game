import React from "react";
import Axios from "axios";
import MaximalUserNumber from "./MaximalUserNumber";


export default function CreateGalaxy() {

    const createGalaxy = async (e) => {
        e.preventDefault();
        const galaxyName = document.getElementById('galaxyName').value;
        const maximalUserNumber = document.getElementById('maximalUserNumber').value;
        if (!galaxyName) return null
    
        try{
        const response = await Axios.post('http://localhost:8080/createGalaxy', 
        JSON.stringify({galaxyName, maximalUserNumber}),
          {
          headers: 
                  {
                    'Access-Control-Allow-Origin': 'http://localhost:3000',
                    'Access-Control-Allow-Methods': 'POST',
                    'Access-Control-Allow-Headers': 'Content-Type',
                    'Access-Control-Allow-Credentials': 'true',
                    'Content-Type': 'application/json'},
                    
          });
          console.log(response.data);
        } catch {
    
        }
      };

  return (
    <form>
        <input id="galaxyName" placeholder="Galaxy Name" required></input>
            <MaximalUserNumber/>
        <button type="submit" onClick={createGalaxy}>Create Galaxy</button>
      </form>
  )
}
