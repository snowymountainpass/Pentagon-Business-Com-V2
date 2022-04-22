import React from "react";
import { useLocation } from "react-router-dom";

// components
import NavbarLinks from "../Components/Navbar/NavbarLinks";
import FooterSmall from "../Components/Footers/Landing/FooterSmall";
// import CardBilling from "components/Cards/ECommerce/CardBilling.js";
import CardBilling from "../Components/EShop-Components/UserAccount Components/CardBilling.js";

// texts as props
import navbarlinkslanding2 from "../Texts/Presentation/navbar/navbarlinkslanding2";
import footersmall from "../Texts/Presentation/footers/footersmall";
import cardbilling from "../Texts/Ecommerce/UserAccount/cardbilling";

export default function UserAccount() {
    const location = useLocation();
    React.useEffect(() => {
        window.scrollTo(0, 0);
    }, [location]);
    return (
        <>
            <NavbarLinks {...navbarlinkslanding2} />
            <main>
                <section className="relative py-16 bg-blueGray-100">
                    <div className="container mx-auto px-4 -mt-64">
                        <CardBilling {...cardbilling} />
                    </div>
                </section>
            </main>
            <div className="-mt-20">
                <FooterSmall {...footersmall} />
            </div>
        </>
    );
}