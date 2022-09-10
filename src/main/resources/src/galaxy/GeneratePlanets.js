import React, {useState, useEffect} from 'react';
import Axios from 'axios';
import { useParams } from 'react-router-dom';
import useAuth from '../hooks/useAuth';

export default function GeneratePlanets() {

    const {auth} = useAuth();
    const [planets, setPlanets] = useState([]);
    const {galaxyId}=useParams();
    useEffect(() => { 
        async function fetchData() {
        console.log('ok');
        console.log(auth.id);
        console.log(galaxyId);
        
        try{
            const response = await Axios.get(`http://localhost:8080/galaxy-controller/users/${auth.id}/galaxies/${{galaxyId}}`, 
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
