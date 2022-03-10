import ProductListingHeader from "./ProductListingHeader";
import ProductsListing from "./ProductsListing";
// import ProductsListingPagination from "./ProductsListingPagination";
import SidebarComponent from "./SidebarComponent";
import {useEffect, useState} from "react";



export default function Products(){

    const [products,setProducts] = useState([]);
    const [query, setQuery] = useState('');

    let url = "http://localhost:8080/e-shop";
    // useEffect(
    //     ()=>{
    //         fetch(url)
    //             .then(res => res.json())
    //             .then(data => setProducts(data))
    //     },[] // [] => runs every time the url changes
    // ) WORKS DON'T DELETE

    useEffect(
        ()=>{
            if(query!==""){url=url+"/product"}
            fetch(url)
                .then(res => res.json())
                .then(data => setProducts(data))

        },[] // [] => runs every time the url changes
    )

    console.log("Products: "+products.length)

    return(

        <section className="section-content padding-y">
            <div className="container">
                <div className="row">

                    <SidebarComponent/>

                    <main className="col-md-9">
                        <ProductListingHeader
                            products = {products}
                            setChangeProducts = {setProducts}
                            setChangeQuery = {setQuery}
                            query={query}
                        />

                        <ProductsListing products={products}/>

                        {/*<ProductsListingPagination/>*/}

                    </main>
                </div>
            </div>
        </section>

    );


}