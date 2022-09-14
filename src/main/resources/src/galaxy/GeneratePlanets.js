import React, {useState, useEffect} from 'react';
import Axios from 'axios';
import {useParams} from 'react-router-dom';
import useAuth from '../hooks/useAuth';
import Modal from '../Modal';
import PlanetInside from './PlanetInside';

import styles from './planetOutsideStyles.module.css';
import '../styles.css';

export default function GeneratePlanets() {
    
    const {galaxyId} = useParams();
    const {auth} = useAuth();
    const [planets, setPlanets] = useState([]);

    useEffect(() => { 

        async function fetchData(userId, galaxyId) {
        
        console.log('ok');
        console.log(userId);
        console.log(galaxyId);
        
        try{
            const response = await Axios.get(`/galaxy-controller/users/${userId}/galaxies/${galaxyId}`, 
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
        
        fetchData(auth.id, galaxyId);

        
                  
    }, []);

    const [isOpen, setIsOpen] = useState(false);
    

    return (
        <>
        {planets.map((planet) => (
            <button onClick={()=>setIsOpen(true)}
            key = {planet.id} 
            item = {planet.id}
            className = {styles.planetOutside}
            style = {{position: "absolute", left: `${planet.planetLocationX}px`, top: `${planet.planetLocationY}px`}}
            data-xlocation = {planet.planetLocationX}
            data-ylocation = {planet.planetLocationY}
            data-size = {planet.size}
            data-user-id = {planet.userId}
            data-industry-points-multiplier = {planet.industryPointsMultiplier}
            data-industry-points-produce = {planet.industryPointsProduce}
            data-science-points-multiplier = {planet.sciencePointsMultiplier}
            data-science-points-produce = {planet.sciencePointsProduce}
            data-defence-points-mulitplier = {planet.defencePointsMultiplier}
            data-defence-points-produce = {planet.defencePointsProduce}
            data-attack-points-mulitplier = {planet.attackPointsMultiplier}
            data-attack-points-produce = {planet.attackPointsProduce}
            data-user = {planet.user}
            >
            {planet.id}
            </button>
        ))}        
        <Modal open={isOpen} onClose={()=>setIsOpen(false)}>
            <PlanetInside/>
        </Modal>
        </>
    )
}
