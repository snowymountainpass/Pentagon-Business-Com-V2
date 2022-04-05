import {useLocation} from "react-router-dom";
import React, {useState} from "react";

import FooterSmall from "../Components/Footers/Landing/FooterSmall";
import footersmall from "../Texts/Presentation/footers/footersmall";


import Navbar from "../Components/EShop-Components/ProductListing Components/Navbar";
import Products from "../Components/EShop-Components/ProductListing Components/Products";

export default function EShop({loginToken}) {

    const location = useLocation();
    React.useEffect(() => {
        window.scrollTo(0, 0);
    }, [location]);
    return (
        <>

            <Navbar loginToken={loginToken}/>

            <Products/>

            <FooterSmall {...footersmall} />

        </>
    );

}

{/*<NavbarLinks {...navbarlinkslanding2} />*/}
{/*<div className="container mx-auto px-4">*/}
{/*/!*    COMPONENTS*!/*/}
{/*    <Sidebar{...sidebar}/>*/}
{/*</div>*/}
{/*<PreFooterLarge {...prefooterlarge} />*/}
{/*<FooterSmall {...footersmall} />*/}

{/*<ProductListTitle/>*/}

{/*<Footer/>*/}
{/*<PreFooterLarge {...prefooterlarge} />*/}