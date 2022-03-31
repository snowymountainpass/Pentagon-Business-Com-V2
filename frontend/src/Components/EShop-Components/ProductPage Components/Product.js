import {useEffect, useState} from "react";
import {useLocation, useParams} from "react-router-dom";

// sections
import Product1 from "../../Sections/ECommerce/Product/Product1.js"

// components
import NavbarLinks from "../../Navbar/NavbarLinks";

import FooterSmall from "../../Footers/Landing/FooterSmall.js";

// texts as props
import navbarlinkslanding2 from "../../../Texts/Presentation/navbar/navbarlinkslanding2.js";
import product1 from "../../../Texts/Ecommerce/Sections/product1.js";

import footersmall from "../../../Texts/Presentation/footers/footersmall.js";

export default function Product() {
    const {id} = useParams();
    const [product, setProduct] = useState([]);

    console.log("PRODUCT ID: "+id);


    
    const requestOptions = {
        method: 'GET',
        headers: {Accept: 'application/json', 'Content-Type': 'application/json'},

    };

    fetch("http://localhost:8080/e-shop/product-get-by-id/"+id,requestOptions)
        .then(response => response.json())
        .then(data => {
                setProduct(data);
                console.log("DATA: "+data);
            }
        );

    // useEffect(
    //     ()=>{
    //
    //         const requestOptions = {
    //             method: 'GET',
    //             headers: {Accept: 'application/json', 'Content-Type': 'application/json'},
    //
    //         };
    //
    //         fetch("http://localhost:3000/e-shop/product-id/"+id,requestOptions)
    //             .then(response => response.json())
    //             .then(data => {
    //                 setProduct(data);
    //                 console.log("DATA: "+data);
    //             }
    //         );
    //
    //     },[id]
    // )



    const location = useLocation();
    useEffect(() => {
        window.scrollTo(0, 0);

    }, [location]);



    console.log("Product content: "+product);


    // fetch(`http://localhost:3000/e-shop/get-product-by-id/${id}`)
    //     .then(response => {
    //         return response.json();
    //     })
    //     .then(data => {
    //         setProduct(data);
    //     })


    return (
        <>
            <NavbarLinks {...navbarlinkslanding2}/>
            {/*<HeaderImageTitleLeft {...headerimagetitleleft} />*/}
            <Product1 {...product1} product={product}/>
            {/*<Testimonials1 {...testimonials1} />*/}
            {/*<Hero8 {...hero8} />*/}
            {/*<PreFooterLarge {...prefooterlarge} />*/}
            <FooterSmall {...footersmall} />
        </>
    );
}


