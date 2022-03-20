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
                console.log("Query: "+query);
                console.log("Url: "+url);
            }
            fetch(url)
                .then(res => res.json())
                .then(data => setProducts(data))

        },[query]
    )

    console.log("Products size: "+products.length);
    console.log("Products objects: "+products);
    // console.log("Query: "+query);
    // console.log("Url: "+url);


    const [brandsList, setBrandsList] = useState([]);

    useEffect(

        ()=>{
            fetch("http://localhost:8080/e-shop/unique-brands")
                .then( res => res.json())
                .then( data => {setBrandsList(data);console.log("Brands List: "+brandsList)} )
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
                    />

                    <main className="col-md-9">
                        <ProductListingHeader
                            products = {products}
                            // setChangeProducts = {setProducts}
                            setChangeQuery = {setQuery}
                            // query={query}
                        />

                        <ProductsListing products={products}/>

                        {/*<ProductsListingPagination/>*/}

                    </main>
                </div>
            </div>
        </section>

    );


}