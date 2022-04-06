import {useLocation} from "react-router-dom";
import React, {useState} from "react";

import FooterSmall from "../Components/Footers/Landing/FooterSmall";
import footersmall from "../Texts/Presentation/footers/footersmall";


import Products from "../Components/EShop-Components/ProductListing Components/Products";
import navbarlinkslanding2 from "../Texts/Presentation/navbar/navbarlinkslanding2";
import NavbarLinks from "../Components/Navbar/NavbarLinks";

export default function EShop({loginToken}) {

    const location = useLocation();
    React.useEffect(() => {
        window.scrollTo(0, 0);
    }, [location]);
    return (
        <>

            <NavbarLinks  {...navbarlinkslanding2}/>

            <Products/>

            <FooterSmall {...footersmall} />

        </>
    );

}

