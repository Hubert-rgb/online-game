import * as variables from './variables.js';
import {planetInsideGenerator} from './planetInsideGenerator.js';
import {generatePlanets} from './galaxyGeneration.js';

generatePlanets(variables.planets)

/*
const tClass = "modal", tId="planet1";
        const test = document.createElement("div");
        test.setAttribute("class", tClass);
        test.setAttribute("id", tId);
        const planeta = document.getElementById("p1")
        planeta.appendChild(test);
*/

function openModal(modal){
    if (modal==null) return;
    modal.classList.add('active');
    overlay.classList.add('active');
}

function closeModal(modal){
    if (modal==null) return;
    modal.classList.remove('active');
    overlay.classList.remove('active');
}

const openModalButtons = document.querySelectorAll('[data-modal-target]');
const closeModalButtons = document.querySelectorAll('[data-close-button]')
const overlay=document.getElementById('overlay');

openModalButtons.forEach(button=> {
    button.addEventListener('click', () => {
        
        planetInsideGenerator();
        const modal = document.querySelector(button.dataset.modalTarget);
        openModal(modal);
    })
})

closeModalButtons.forEach(button => {
    button.addEventListener('click', () => {
        planetInsideGenerator();
        const modal = button.closest('.modal.active');
        closeModal(modal);
    })
})

overlay.addEventListener('click', () =>{
    const modals = document.querySelectorAll('.modal.active');
    modals.forEach(modal => {
        closeModal(modal);
    })
})


