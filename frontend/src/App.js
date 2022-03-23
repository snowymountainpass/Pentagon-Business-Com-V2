import React from "react";
import {
  BrowserRouter,
  Routes,
  Route,
} from "react-router-dom";

import Landing from "./Pages/Landing";
import EShop from "./Pages/EShop";
import ProductDetails from "./Components/EShop-Components/ProductPage Components/Product";


function App() {
  return (
      <div className="App">

        <BrowserRouter>
          <Routes>
            <Route path={"/"} element={<Landing/>}/>
            <Route path={"/about-us"}
            /> //TODO: add about us page
            <Route path={"/e-shop"} element={<EShop/>}/>
              <Route path="/e-shop/product/:id" element={<ProductDetails/>}/>
            <Route path={"/product-page"} element={<ProductDetails/>}/>
          </Routes>
        </BrowserRouter>

      </div>
  );
}

export default App;
