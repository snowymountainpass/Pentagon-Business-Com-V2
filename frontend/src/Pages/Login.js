import React from "react";
import { useLocation } from "react-router-dom";

// components
import NavbarLinks from "../Components/Navbar/NavbarLinks.js";
// import CardLoginSocial from "components/Cards/Auth/CardLoginSocial.js";
import CardLoginSocial from "../Components/Cards/Register-Login-Components/CardLoginSocial.js";
// import FooterAuth from "components/Footers/Auth/FooterAuth.js";
import FooterAuth from "../Components/Footers/Auth/FooterAuth.js";
// texts
// import cardloginsocial from "_texts/auth/cards/cardloginsocial.js";
import cardloginsocial from "../Texts/Auth/Card/cardloginsocial.js";
// import navbarlinkslanding1 from "_texts/presentation/navbars/navbarlinkslanding1.js";
import navbarlinkslanding1 from "../Texts/Presentation/navbar/navbarlinkslanding2";
// import footerauth from "_texts/auth/footers/footerauth.js";
import footerauth from "../Texts/Auth/Footer/footerauth.js";

import backgroundImageDesign from "../Components/Cards/Register-Login-Components/register_bg_2.png";

export default function Login({setLoginToken}) {
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
      // backgroundImage:
      //     "url(" + require(backgroundImageDesign).default + ")",
        backgroundImage:
            `url(${backgroundImageDesign})`
    }}
    />
          <div className="container mx-auto px-4 h-full">
            <div className="flex content-center items-center justify-center h-full">
              <div className="w-full lg:w-4/12 px-4">

                <CardLoginSocial
                    {...cardloginsocial}
                    setLoginToken={setLoginToken}
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
