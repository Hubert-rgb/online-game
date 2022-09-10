import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import { AuthProvider } from './context/AuthProvider';
import {Routes, Route, BrowserRouter} from 'react-router-dom'; 



const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <BrowserRouter>
        <AuthProvider>
            <Routes>
                <Route path="/*" element = {<App/>}/>
            </Routes>
        </AuthProvider>    
    </BrowserRouter>
);

