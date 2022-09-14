import React from 'react';
import ReactDOM from 'react-dom';

const MODAL_STYLE = {
  position: 'fixed',
  top: '50%',
  left: '50%',
  transform: 'translate(-50%, -50%)',
  backgroundColor: '#fff',
  padding: '50px',
  zIndex: 1000
}

const OVERLAY_STYLE = {
  position: 'fixed',
  top: 0,
  bottom: 0,
  left: 0,
  right: 0,
  backgroundColor: 'rgba(0, 0, 0, 0.5)',
  zIndex: 1000
}

const CLOSE_BUTTON_STYLE ={
  position: 'fixed',
  top: '10px',
  right: '10px',
  alignItems: 'center'
}

export default function Modal({open, children, onClose}) {
  if (!open) return null;
  
  return ReactDOM.createPortal(
    <>
      <div style={OVERLAY_STYLE}/>
      <div style={MODAL_STYLE}>
        <header>
          <button onClick={onClose} style={CLOSE_BUTTON_STYLE}>&times;</button> 
        </header>
        <div>
          {children}
        </div>
        
      </div>
    </>,  
  document.getElementById('portal')
  )
}
