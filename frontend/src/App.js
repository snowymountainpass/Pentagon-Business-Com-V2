import React from "react";
import {
  BrowserRouter,
  Routes,
  Route,
} from "react-router-dom";

import Landing from "./Pages/Landing";
import EShop from "./Pages/EShop";


function App() {
  return (
      <div className="App">

        <BrowserRouter>
          <Routes>
            <Route path={"/"} element={<Landing/>}/>
            <Route path={"/about-us"} element={<Landing/>}/> //TODO: add about us page
            <Route path={"/e-shop"} element={<EShop/>}/>
          </Routes>
        </BrowserRouter>


      </div>
  );
}

export default App;
