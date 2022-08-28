import React, { useEffect, useRef, useState} from "react";
import useAuth from "../hooks/useAuth";
import {useNavigate,useLocation} from "react-router-dom";
import Axios from "axios";


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
        const response = await Axios.post('http://localhost:8080/loginUser',
            JSON.stringify({name:user, password:password}),
            {
              headers: 
              {
                'Access-Control-Allow-Origin': 'http://localhost:3000',
                'Access-Control-Allow-Methods': 'POST',
                'Access-Control-Allow-Headers': 'Content-Type',
                'Access-Control-Allow-Credentials': 'true',
                'Content-Type': 'application/json'},                
            });
        console.log(response.data);
        setAuth({user, password});
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
    <section>
        <p ref={errorRef} className={errorMessage ? "errmsg" : "offscreen"} aria-live="assertive">{errorMessage}</p>
        <h1>Sign In</h1>
        <form>
            <label htmlFor="username">Username:</label>
            <input 
            type="text" 
            id="username"
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
            autoComplete="off"
            onChange={(e) => setPassword(e.target.value)}
            value={password}
            required
            />
            <button onClick = {handleSubmit}>Sign In</button>
        </form>
    </section>
  )
}
