import ProductListingHeader from "./ProductListingHeader";
import ProductsListing from "./ProductsListing";
import ProductsListingPagination from "./ProductsListingPagination";
import SidebarComponent from "./SidebarComponent";
import {useEffect, useState} from "react";
import {element} from "prop-types";

export default function Products(){

    const [products,setProducts] = useState([])
    const url = "http://localhost:8080/e-shop";
    useEffect(
        ()=>{
            fetch(url)
                .then(res => res.json())
                .then(data => setProducts(data))
        },[url] // [] => runs every time the url changes
    )



    console.log(products);

    return(

        <section className="section-content padding-y">
            <div className="container">
                <div className="row">

                    <SidebarComponent/>

                    <main className="col-md-9">
                        <ProductListingHeader products={products}/>

                        <ProductsListing products={products}/>

                        {/*<ProductsListingPagination/>*/}

                    </main>
                </div>
            </div>
        </section>

    );


}