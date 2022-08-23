import React from "react";
import Menu from "./menu/Menu";
import Login from "./login/Login";
import Layout from "./Layout";
import RequireAuth from "./RequireAuth";
import {Route, Routes} from "react-router-dom";


function App() {
  
  return( 
  <Routes>
    <Route path="/" element={<Layout/>}>
      {/*public routes*/}
      <Route path="login" element = {<Login/>}/>

      {/*non-public routes*/}
      <Route element={<RequireAuth/>}>
        <Route path="/" element= {<Menu/>}/>
      </Route>
    </Route>
  </Routes>
  )
}

export default App;
