import React from "react";
import {useLocation} from "react-router-dom";

// sections
import Hero5 from "../Components/Sections/Presentation/Heroes/Hero5";
import Features3 from "../Components/Sections/General/Features/Features3";
import Pricing1 from "../Components/Sections/Presentation/Pricing/Pricing1";
import ContactUs2 from "../Components/Sections/Presentation/ContactUs/ContactUs2";

// components
import NavbarLinks from "../Components/Navbar/NavbarLinks";
import HeaderVideoTitle from "../Components/Headers/Presentation/HeaderVideoTitle";
import PreFooterLarge from "../Components/PreFooters/PreFooterLarge";
import FooterSmall from "../Components/Footers/Landing/FooterSmall";

// texts for sections as props

// import hero5 from "../../Texts/presentation/heroes/hero5";
import hero5 from "../Texts/Presentation/heroes/hero5";
import pricing1 from "../Texts/Presentation/pricing/pricing1";
import features3 from "../Texts/Presentation/general/features/features3";
import contactus2 from "../Texts/Presentation/contactus/contactus2";


// texts for components as props
import navbarlinkslanding2 from "../Texts/Presentation/navbar/navbarlinkslanding2";
import headervideotitle from "../Texts/Presentation/headers/headervideotitle";
import prefooterlarge from "../Texts/Presentation/prefooters/prefooterlarge";
import footersmall from "../Texts/Presentation/footers/footersmall";








export default function Landing2() {
    const location = useLocation();
    React.useEffect(() => {
        window.scrollTo(0, 0);
    }, [location]);
    return (
        <>
            <NavbarLinks {...navbarlinkslanding2} />
            <HeaderVideoTitle {...headervideotitle} />
            <div className="container mx-auto px-4">
                <Hero5 {...hero5} />
                {/*<Features3{...features3}/>*/}
                <Pricing1 {...pricing1} />
                <ContactUs2{...contactus2}/>
            </div>
            <PreFooterLarge {...prefooterlarge} />
            <FooterSmall {...footersmall} />
        </>
    );
}