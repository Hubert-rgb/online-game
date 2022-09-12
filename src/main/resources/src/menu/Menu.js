import React, {useState} from "react";
import Modal from "../Modal";
import GalaxyList from "./GalaxyList";
import CreateGalaxy from "./CreateGalaxy";
import styles from './menuStyles.module.css';

export default function Menu() {

  const [isOpen, setIsOpen] = useState(false);
  

  return( 
  <>
    <GalaxyList/>  
    <button onClick={()=>setIsOpen(true)} id={styles.newGalaxyButton}>New galaxy</button>
    <Modal open={isOpen} onClose={()=>setIsOpen(false)}>
      <CreateGalaxy/>
    </Modal>
  </>
  )
};

