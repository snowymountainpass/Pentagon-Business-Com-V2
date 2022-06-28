import React from "react";
import ProductsTable from "../Components/ShoppingCart-Components/ProductsTable";
import AmountSummary from "../Components/ShoppingCart-Components/AmountSummary";
import Coupon from "../Components/ShoppingCart-Components/Coupon";
import navbarlinkslanding2 from "../Texts/Presentation/navbar/navbarlinkslanding2";
import NavbarLinks from "../Components/Navbar/NavbarLinks";
import footersmall from "../Texts/Presentation/footers/footersmall";
import FooterSmall from "../Components/Footers/Landing/FooterSmall";

import {TOTAL_VALUE_IN_CART} from "../Components/ShoppingCart-Components/ProductRow";
import {useAtom} from "jotai";

export default function ShoppingCart() {
    const [totalAmount] = useAtom(TOTAL_VALUE_IN_CART);


    return (

        <>
            <NavbarLinks  {...navbarlinkslanding2}/>

            <section className="section-pagetop bg-white ">
                <div className="container "/>
            </section>

            <section className="section-pagetop bg ">
                <div className="container  align-content-center">
                    <h2 className="title-page">Shopping cart</h2>
                </div>
            </section>

            <section className="section-content padding-y">
                <div className="container">

                    <div className="row">
                        <main className="col-md-9">

                            <ProductsTable/>

                            <div className="alert alert-success mt-3">
                                <p className="icontext"><i className="icon text-success fa fa-truck"/> Free Delivery for
                                    orders above €10.000</p>
                            </div>

                        </main>
                        <aside className="col-md-3">
                            <Coupon/>

                            <AmountSummary totalAmount={totalAmount} discount={(totalAmount * 5) / 100}/>
                        </aside>
                    </div>

                </div>
            </section>

            <section className="section-name bg padding-y">
                <div className="container">
                    <h6>Payment and refund policy</h6>
                    <p>Payment must be done by into the bank account that appears on the invoice.Proof of payment must be
                    sent to office@pentagon.ro.
                    </p>

                </div>
            </section>
            <FooterSmall {...footersmall} />
        </>

    );

}