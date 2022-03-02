import {useLocation} from "react-router-dom";
import React from "react";
import NavbarLinks from "../Components/Navbar/NavbarLinks";
import navbarlinkslanding2 from "../Texts/Presentation/navbar/navbarlinkslanding2";
// import HeaderVideoTitle from "../../Components/Headers/Presentation/HeaderVideoTitle";
// import headervideotitle from "../../Texts/presentation/headers/headervideotitle";
// import Hero5 from "../../Components/Sections/Presentation/Heroes/Hero5";
// import hero5 from "../../Texts/presentation/heroes/hero5";
// import Features3 from "../../Components/Sections/Misc/Features/Features3";
// import features3 from "../../Texts/misc/features/features3";
// import Pricing1 from "../../Components/Sections/Presentation/Pricing/Pricing1";
// import pricing1 from "../../Texts/presentation/pricing/pricing1";
// import ContactUs2 from "../../Components/Sections/Presentation/ContactUs/ContactUs2";
// import contactus2 from "../../Texts/presentation/contactus/contactus2";
import PreFooterLarge from "../Components/PreFooters/PreFooterLarge";
import prefooterlarge from "../Texts/Presentation/prefooters/prefooterlarge";
import FooterSmall from "../Components/Footers/Landing/FooterSmall";
import footersmall from "../Texts/Presentation/footers/footersmall";
import Sidebar from "../Components/Sidebar/Sidebar";
import sidebar from "../Texts/General/sidebar/sidebar";

//

import Navbar from "../Components/EShop-Components/Navbar";
import ProductListTitle from "../Components/EShop-Components/ProductListTitle"
import Products from "../Components/EShop-Components/Products";
import Footer from "../Components/EShop-Components/Footer";

export default function EShop(){

    const location = useLocation();
    React.useEffect(() => {
        window.scrollTo(0, 0);
    }, [location]);
    return (
        <>
            {/*<NavbarLinks {...navbarlinkslanding2} />*/}
            {/*<div className="container mx-auto px-4">*/}
            {/*/!*    COMPONENTS*!/*/}
            {/*    <Sidebar{...sidebar}/>*/}
            {/*</div>*/}
            {/*<PreFooterLarge {...prefooterlarge} />*/}
            {/*<FooterSmall {...footersmall} />*/}

            <Navbar/>
            <ProductListTitle/>
            <Products/>
            <Footer/>


        </>
    );

}