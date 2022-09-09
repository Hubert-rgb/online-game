import React, {useState, useEffect} from 'react';
import Axios from 'axios';

export default function GeneratePlanets() {
    
    const [planets, setPlanets] = useState([]);

    useEffect(() => { 
        console.log('ok');
        Axios.get('http://localhost:8080/getPlanets')
        .then( response => {
            console.log(response.data);
            setPlanets(response.data);            
        })}, []);


    return (
        <>
        {planets.map((planet) => (
            <button
            key = {planet.id} 
            item = {planet.id}
            data-xlocation = {planet.xLocation}
            data-ylocation = {planet.yLocation}
            data-size = {planet.size}
            data-user-id = {planet.userId}
            data-industry-points-multiplier = {planet.industryPointsMultiplier}
            data-science-points-multiplier = {planet.sciencePointsMultiplier}
            data-industry-points-produce = {planet.industryPointsProduce}
            data-science-points-produce = {planet.sciencePointsProduce}
            >
            {planet.id}
            </button>
        ))}
        </>
    )
}
