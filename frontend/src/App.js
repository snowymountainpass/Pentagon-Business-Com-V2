import React, {useState} from "react";
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
import RestorePassword from "./Pages/RestorePassword";


function App() {

  const [registrationToken,setToken]=useState("");
  // console.log("Register Token in App: "+ registrationToken);

  const [loginToken,setLoginToken] = useState("");
  console.log("Login Token in App: "+ loginToken);
  return (
      <div className="App">

        <BrowserRouter>
          <Routes>
            <Route path={"/"} element={<Landing/>}/>
            <Route path={"/about-us"}
            /> //TODO: add about us page
            <Route path={"/e-shop"} element={<EShop/>}/>
            <Route path={"/e-shop/product-id/:id/*"} element={<Product/>}/>
            <Route path={"/e-shop/login"} element={<Login setLoginToken={setLoginToken}/>}/>
            <Route path={"/e-shop/register"} element={<Register setToken={setToken}/>}/>
            <Route path={"/e-shop/restore-password"} element={<RestorePassword/>}/>
          </Routes>
        </BrowserRouter>

      </div>
  );
}

export default App;
