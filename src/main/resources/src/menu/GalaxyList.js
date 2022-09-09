import Axios from 'axios';
import React, {useState, useEffect} from 'react';
import {Link} from 'react-router-dom';
import styles from './menuStyles.module.css';

export default function GalaxyList() {
    const [galaxyList, setGalaxyList] = useState([])

    useEffect(() => { 
        console.log('ok');
        Axios.get('http://localhost:8080/getGalaxies')
        .then( response => {
            console.log(response.data);
            setGalaxyList(response.data);
            
        })}, []);
          
return (
    <ul id={styles.galaxyList}>
    {galaxyList.map((galaxy) => (        
            <li key={galaxy.id} item={galaxy.id} className={styles.listItem}>
                <Link to={`/galaxy/${galaxy.id}`}>
                    {galaxy.galaxyName}
                </Link>
            </li>        
      ))}
    </ul>
  )
};
