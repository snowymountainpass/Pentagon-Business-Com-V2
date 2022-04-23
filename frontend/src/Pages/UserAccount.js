import React from "react";
import { useLocation } from "react-router-dom";

// components
import NavbarLinks from "../Components/Navbar/NavbarLinks";
// import HeaderImageTitleSmallCenter from "components/Headers/Auth/HeaderImageTitleSmallCenter.js";
import HeaderImageTitleSmallCenter from "../Components/EShop-Components/UserAccount Components/HeaderImageTitleSmallCenter";
import FooterSmall from "../Components/Footers/Landing/FooterSmall";
import CardUserAccount from "../Components/EShop-Components/UserAccount Components/CardUserAccount.js";

// texts as props
import navbarlinkslanding2 from "../Texts/Presentation/navbar/navbarlinkslanding2";
import headerimagetitlesmallcentercheckout from "../Texts/Ecommerce/UserAccount/headerimagetitlesmallcentercheckout";
import footersmall from "../Texts/Presentation/footers/footersmall";
import carduseraccount from "../Texts/Ecommerce/UserAccount/carduseraccount";

export default function UserAccount() {
    const location = useLocation();
    React.useEffect(() => {
        window.scrollTo(0, 0);
    }, [location]);
    return (
        <>
            <NavbarLinks {...navbarlinkslanding2} />
            <HeaderImageTitleSmallCenter {...headerimagetitlesmallcentercheckout} />
            <section className="relative bg-blueGray-100 py-12 z-2">
                <div className="container mx-auto px-4 -mt-64">
                    <div className="flex flex-wrap justify-center">

                        <div className=" px-4 relative w-full lg:w-8/12">
                            <CardUserAccount {...carduseraccount} />
                        </div>
                    </div>
                </div>
                <FooterSmall {...footersmall} />
            </section>

        </>
    );
}

// <main>
//     <section className="relative py-16 bg-blueGray-100">
//         <div className="container mx-auto px-4 -mt-64">
//             <CardUserAccount {...cardbilling} />
//         </div>
//     </section>
// </main>

// <div className="-mt-20">
//     <FooterSmall {...footersmall} />
// </div>


// <>
//     <NavbarLinks {...navbarlinkslanding2} />
//     <HeaderImageTitleSmallCenter {...headerimagetitlesmallcentercheckout} />
//     <section className="relative bg-blueGray-100 py-12 z-2">
//         <div className="container mx-auto px-4 -mt-64">
//             <div className="flex flex-wrap -mx-4">
//
//                 <div className="px-4 relative w-full lg:w-8/12">
//                     <CardUserAccount {...carduseraccount} />
//                 </div>
//             </div>
//         </div>
//         <FooterSmall {...footersmall} />
//     </section>
//
// </>