import React, {useState} from "react";
import {
  BrowserRouter,
  Routes,
  Route,
} from "react-router-dom";

import Landing from "./Pages/Landing";
import EShop from "./Pages/EShop";
import Login from "./Pages/Login";
import Register from "./Pages/Register";
import RestorePassword from "./Pages/RestorePassword";
import ShoppingCart from "./Pages/ShoppingCart";
import UserAccount from "./Pages/UserAccount";
// import Checkout from "./Pages/Checkout";


function App() {

  const [registrationToken,setToken]=useState("");

  const [loginToken,setLoginToken] = useState("");
  return (
      <div className="App">

        <BrowserRouter>
          <Routes>
            <Route path={"/"} element={<Landing/>}/>
            <Route path={"/about-us"}
            /> //TODO: add about us page

            <Route path={"/e-shop"} element={<EShop loginToken={loginToken}/>}/>
            <Route path={"/e-shop/shopping-cart"} element={<ShoppingCart/>}/>
            {/*<Route path={"/e-shop/checkout"} element={<Checkout/>}/>*/}
            <Route path={"/e-shop/login"} element={<Login setLoginToken={setLoginToken}/>}/>
            <Route path={"/e-shop/register"} element={<Register setToken={setToken}/>}/>
            <Route path={"/e-shop/restore-password"} element={<RestorePassword/>}/>
            <Route path={"/e-shop/user-account"} element={<UserAccount/>}/>
          </Routes>
        </BrowserRouter>

      </div>
  );
}

export default App;
