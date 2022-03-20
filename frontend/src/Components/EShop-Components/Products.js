import ProductListingHeader from "./ProductListingHeader";
import ProductsListing from "./ProductsListing";
// import ProductsListingPagination from "./ProductsListingPagination";
import SidebarComponent from "./SidebarComponent";
import {useEffect, useState} from "react";



export default function Products(){

    const [products,setProducts] = useState([]);
    const [query, setQuery] = useState('');

    let url = "http://localhost:8080/e-shop/";

    useEffect(
        ()=>{
            if(query!==""){url=url+"product/"+query;
            }
            fetch(url)
                .then(res => res.json())
                .then(data => setProducts(data))

        },[query]
    )

    console.log("Products size: "+products.length);
    console.log("Products objects: "+products);


    const [brandsList, setBrandsList] = useState([]);

    useEffect(

        ()=>{
            fetch("http://localhost:8080/e-shop/unique-brands")
                .then( res => res.json())
                .then( data => {setBrandsList(data);console.log("Brands List: "+brandsList)} )
        },[]

    )

    const [minMaxPrice,setMinMaxPrice] = useState([]);

    useEffect(
        ()=>{
            fetch("http://localhost:8080/e-shop/get-min-max-price")
                .then(res => res.json())
                .then(data => {setMinMaxPrice(data);console.log("Min Max Prices List: "+minMaxPrice)})
        },[]
    )


    return(

        <section className="section-content padding-y">
            <div className="container">
                <div className="row">

                    <SidebarComponent
                        products = {products}
                        setChangeProducts = {setProducts}
                        brandsList = {brandsList}
                        minmaxPrice = {minMaxPrice}
                    />

                    <main className="col-md-9">
                        <ProductListingHeader
                            products = {products}
                            setChangeQuery = {setQuery}
                        />

                        <ProductsListing products={products}/>

                        {/*<ProductsListingPagination/>*/}

                    </main>
                </div>
            </div>
        </section>

    );


}