import ProductListingHeader from "./ProductListingHeader";
import ProductsListing from "./ProductsListing";
import ProductsListingPagination from "./ProductsListingPagination";
import SidebarComponent from "./SidebarComponent";
import {useEffect, useState} from "react";
import {element} from "prop-types";

export default function Products(){

    const [products,setProducts] = useState([])

    useEffect(
        ()=>{
            fetch("http://localhost:8080/e-shop")
                .then(res => res.json())
                .then(data => setProducts(data))
        },[] // [] => runs only once (when the page loads) and not every time
    )



    console.log(products);

    return(

        <section className="section-content padding-y">
            <div className="container">
                <div className="row">

                    <SidebarComponent/>

                    <main className="col-md-9">
                        <ProductListingHeader products={products}/>

                        <ProductsListing/>

                        {/*<ProductsListingPagination/>*/}

                    </main>
                </div>
            </div>
        </section>

    );


}