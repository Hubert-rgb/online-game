import React from "react";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Menu from "./menu/Menu";
import Login from "./login/Login";
import Layout from "./Layout";
import RequireAuth from "./RequireAuth";
import Galaxy from './galaxy/Galaxy';



function App() {
  
  return( 
  <BrowserRouter>
    <Routes>
      <Route path="/" element = {<Layout/>}>
        {/*public routes*/}
        <Route path="/login" element = {<Login/>}/>
    
        {/*non-public routes*/}
        <Route element={<RequireAuth/>}>
          <Route path="/" exact element = {<Menu/>}/>
          <Route path="/galaxy/:id" element= {<Galaxy/>}/>
        </Route>
      </Route>
    </Routes>
  </BrowserRouter>
  )
}

export default App;
