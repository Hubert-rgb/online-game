import Axios from 'axios';
import React, {useState, useEffect} from 'react';
import {Link} from 'react-router-dom';
import styles from './menuStyles.module.css';

export default function GalaxyList() {
    const [galaxyList, setGalaxyList] = useState([])
    
    const [galaxyId, setGalaxyId] = useState();

    const getGalaxyId = (id) =>{
        setGalaxyId(id)
    }

    useEffect(() => { 
        console.log('ok');
        Axios.get('/galaxy-controller/galaxies/')
        .then( response => {
            console.log(response.data);
            setGalaxyList(response.data);
            
        })}, []);

          
return (
    <ul id={styles.galaxyList}>
    {galaxyList.map((galaxy) => {        
        getGalaxyId(galaxy.id);
            <li key={galaxy.id} item={galaxy.id} className={styles.listItem}>
                <Link to = {`/galaxy/${galaxy.id}`} state={galaxyId}>
                    {galaxy.galaxyName}
                </Link>
            </li>        
    })}
    </ul>
  )
};
