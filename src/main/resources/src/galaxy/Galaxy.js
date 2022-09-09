import React, {useState} from 'react';
import GeneratePlanets from './GeneratePlanets';
import Modal from '../Modal';
import PlanetInside from './PlanetInside';

export default function Galaxy() {
    
    const [isOpen, setIsOpen] = useState(false);    

    return (
        <>        
        <GeneratePlanets/>
        <button onClick={()=>setIsOpen(true)}>testowy</button>
        <Modal open={isOpen} onClose={()=>setIsOpen(false)}>
            <PlanetInside/>
        </Modal>
        </>
  )
}
