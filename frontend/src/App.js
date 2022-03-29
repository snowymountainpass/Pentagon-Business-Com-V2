import React from "react";
import {
  BrowserRouter,
  Routes,
  Route,
} from "react-router-dom";

import Landing from "./Pages/Landing";
import EShop from "./Pages/EShop";
import Product from "./Components/EShop-Components/ProductPage Components/Product";
import Login from "./Pages/Login";
import Register from "./Pages/Register";


function App() {
  return (
      <div className="App">

        <BrowserRouter>
          <Routes>
            <Route path={"/"} element={<Landing/>}/>
            <Route path={"/about-us"}
            /> //TODO: add about us page
            <Route path={"/e-shop"} element={<EShop/>}/>
            <Route path={"/e-shop/product-id/:id/*"} element={<Product/>}/>
            <Route path={"/e-shop/login"} element={<Login/>}/>
            <Route path={"/e-shop/register"} element={<Register/>}/>
          </Routes>
        </BrowserRouter>

      </div>
  );
}

export default App;
