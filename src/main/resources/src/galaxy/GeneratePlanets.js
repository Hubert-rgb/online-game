import React, {useState, useEffect} from 'react';
import Axios from 'axios';
import { useLocation } from 'react-router-dom';
import useAuth from '../hooks/useAuth';

export default function GeneratePlanets(props) {
    const location = useLocation();
    const [planets, setPlanets] = useState([]);
    
    useEffect((galaxyId) => { 
        async function fetchData() {
        console.log('ok');
        console.log(location, " useLocation Hook");
        console.log(location.state.data.galaxyId)
        try{
            const response = await Axios.get('http://localhost:8080/connectToGalaxy',
            JSON.stringify({userId: 1, galaxyId:location.state.data.galaxyId}), 
            {
                headers: 
              {
                'Access-Control-Allow-Origin': 'http://localhost:3000',
                'Access-Control-Allow-Methods': 'POST',
                'Access-Control-Allow-Headers': 'Content-Type',
                'Access-Control-Allow-Credentials': 'true',
                'Content-Type': 'application/json'
              }        
            });

            setPlanets(response.data);

            
        } catch (err) {

        }};

        fetchData(galaxyId);
                   
    }, []);


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
