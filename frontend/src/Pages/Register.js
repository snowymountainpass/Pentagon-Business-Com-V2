import React from "react";
import { useLocation } from "react-router-dom";

// components
import NavbarLinks from "../Components/Navbar/NavbarLinks.js";
import CardRegister from "../Components/Cards/Register-Login-Components/CardRegister";
import FooterAuth from "../Components/Footers/Auth/FooterAuth.js";

// texts
import cardregister from "../Texts/Auth/Card/cardregister";
import navbarlinkslanding1 from "../Texts/Presentation/navbar/navbarlinkslanding2";
import footerauth from "../Texts/Auth/Footer/footerauth.js";

import backgroundImageDesign from "../Components/Cards/Register-Login-Components/register_bg_2.png";


export default function Register({setToken}) {
  const location = useLocation();
  React.useEffect(() => {
    window.scrollTo(0, 0);
  }, [location]);
  return (
    <>
      <NavbarLinks {...navbarlinkslanding1} />
      <main>
        <section className="relative w-full h-full py-40 min-h-screen">
          <div
            className="absolute top-0 w-full h-full bg-blueGray-900 bg-no-repeat bg-full"
            style={{
              backgroundImage:
              `url(${backgroundImageDesign})`,
            }}
            />
          <div className="container mx-auto px-4 h-full">
            <div className="flex content-center items-center justify-center h-full">
              <div className="w-full lg:w-4/12 px-4">
                <CardRegister{...cardregister}
                  setToken={setToken}
                />
              </div>
            </div>
          </div>
          <FooterAuth {...footerauth} />
        </section>
      </main>
    </>
  );
}
