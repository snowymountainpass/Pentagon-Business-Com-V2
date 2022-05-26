import React from "react";
import { useLocation } from "react-router-dom";

// sections
// components
import NavbarLinks from "../Components/Navbar/NavbarLinks";
import HeaderImageTitleSmallCenter from "../Components/Invoice-Components/HeaderImageTitleSmallCenter";
import CardInvoice from "../Components/Invoice-Components/CardInvoice";
import Button from "../Components/Invoice-Components/Button";
// import PreFooterLarge from "components/PreFooters/PreFooterLarge.js";
import FooterSmall from "../Components/Footers/Landing/FooterSmall";

// texts as props
import navbarlinkslanding2 from "../Texts/Presentation/navbar/navbarlinkslanding2";
// import headerimagetitlesmallcenterinvoice from "_texts/e-commerce/headers/headerimagetitlesmallcenterinvoice.js";
import headerimagetitlesmallcenterinvoice from "../Texts/Ecommerce/Invoice/headerimagetitlesmallcenterinvoice";
// import cardinvoice from "_texts/e-commerce/cards/cardinvoice.js";
import cardinvoice from "../Texts/Ecommerce/Invoice/cardinvoice";
// import prefooterlarge from "_texts/presentation/prefooters/prefooterlarge.js";
import footersmall from "../Texts/Presentation/footers/footersmall";


export default function Invoice() {
  const location = useLocation();
  React.useEffect(() => {
    window.scrollTo(0, 0);
  }, [location]);




  return (
    <>
      <NavbarLinks {...navbarlinkslanding2} />
      <HeaderImageTitleSmallCenter {...headerimagetitlesmallcenterinvoice} />
      <section className="relative bg-blueGray-100 py-12 z-2">
        <div className="container mx-auto px-4 -mt-64">
          <div className="flex flex-wrap -mx-4">
            <div className="mx-auto px-4 relative w-full lg:w-10/12">
                <CardInvoice {...cardinvoice}/>
                <div className="float-right">
                <Button color="blueGray" onClick={() => {
                    window.print();
                    window.title="Pentagon Business Com";
                }}
                >
                  <i className="fas fa-save mr-2"/>
                  Save Invoice
                </Button>
              </div>
            </div>
          </div>
        </div>
      </section>
      {/*<PreFooterLarge {...prefooterlarge} />*/}
      <FooterSmall {...footersmall} />
    </>
  );
}
