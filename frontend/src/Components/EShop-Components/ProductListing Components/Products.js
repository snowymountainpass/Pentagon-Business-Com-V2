import ProductListingHeader from "./ProductListingHeader";
import ProductsListing from "./ProductsListing";
import SidebarComponent from "./SidebarComponent";
import {useEffect, useState} from "react";
import {atom, useAtom} from "jotai";


export const MIN_MAX_PRICES = atom([]);

export default function Products({}) {

    const [products, setProducts] = useState([]);
    const [query, setQuery] = useState('');

    let url = "http://localhost:8080/e-shop";

    useEffect(
        () => {
            if (query !== "") {
                url = url + "/product/" + query;
            }
            console.log("URL: " + url);

            fetch(url)
                .then(response => {
                    return response.json();
                })
                .then(data => setProducts(data))

        }, [query]
    )

    const [brandsList, setBrandsList] = useState([]);

    useEffect(
        () => {
            fetch("http://localhost:8080/e-shop/unique-brands")
                .then(res => res.json())
                .then(data => {
                    setBrandsList(data);
                })
        }, []
    )

    const [minMaxPrice, setMinMaxPrice] = useAtom(MIN_MAX_PRICES);

    useEffect(
        () => {
            fetch("http://localhost:8080/e-shop/get-min-max-price")
                .then(res => res.json())
                .then(data => {
                    setMinMaxPrice(data)
                })
        }, []
    )


    const [categoriesList, setCategoriesList] = useState([]);

    useEffect(
        () => {
            fetch("http://localhost:8080/e-shop/unique-product-categories")
                .then(res => res.json())
                .then(data => {
                    setCategoriesList(data);
                })
        }, []
    )


    return (

        <section className="section-content padding-y">
            <div className="container mt-5 padding-top">
                <div className="row">

                    <SidebarComponent
                        products={products}
                        setChangeProducts={setProducts}
                        brandsList={brandsList}
                        minmaxPrice={minMaxPrice}
                        categoriesList={categoriesList}
                    />

                    <main className="col-md-9">
                        <ProductListingHeader
                            products={products}
                            setChangeQuery={setQuery}
                        />
                        <ProductsListing products={products}/>
                    </main>
                </div>
            </div>
        </section>

    );


}