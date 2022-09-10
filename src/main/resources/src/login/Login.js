import React, { useEffect, useRef, useState} from 'react';
import useAuth from '../hooks/useAuth';
import {useNavigate, useLocation} from 'react-router-dom';
import Axios from 'axios';
import styles from './loginStyles.module.css';
import '../styles.css';


export default function Login() {
  const {setAuth} = useAuth();

  const navigate = useNavigate();
  const location = useLocation();
  const from = location.state.from.pathname || "/";

  const userRef = useRef();
  const errorRef = useRef();

  const [user, setUser] = useState('');
  const [password, setPassword] = useState('');
  const [errorMessage, setErrorMessage] = useState('');

  useEffect(()=>{
    userRef.current.focus();
  }, [])

  useEffect(()=>{
    setErrorMessage('');
  }, [user, password])

  const handleSubmit = async (e) => {
    e.preventDefault();

    try{
        const response = await Axios.post('http://localhost:8080/user-controller/users',
            JSON.stringify({name:user, password:password}),
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
        const id = response.data.id;
        console.log(response.data);
        setAuth({id, user, password});
        setUser('');
        setPassword('');
        navigate(from, {replace: true});
    } catch (err) {
      if (!err.response){
        setErrorMessage('no server response')
      } else{
        setErrorMessage('failed')
      }
    }    
  }

    return (
    <section className={styles.body}>
        <p ref={errorRef} className={errorMessage ? "errmsg" : "offscreen"} aria-live="assertive">{errorMessage}</p>
        <h1 className={styles.heading}>Sign In</h1>
        <form id={styles.form}>
            <label htmlFor="username">Username:</label>
            <input             
            type="text" 
            id="username"
            className={styles.input}
            ref={userRef}
            autoComplete="off"
            onChange={(e) => setUser(e.target.value)}
            value={user}
            required
            />
            <label htmlFor="password">Password:</label>
            <input 
            type="password" 
            id="password"
            className={styles.input}
            autoComplete="off"
            onChange={(e) => setPassword(e.target.value)}
            value={password}
            required
            />
            <button onClick = {handleSubmit} className={styles.submitButton}>Sign In</button>
        </form>
    </section>
  )
}
