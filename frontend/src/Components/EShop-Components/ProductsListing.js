import ProductCard from "./ProductCard";
import {useLocation} from "react-router-dom";
import {useEffect} from "react";

export default function ProductsListing(props){
    console.log(props.products)
    return(
        <>

            {
                props.products.map(product =>(
                    <ProductCard product={product} key={product.productID}/>
                ))

            }



        </>



    );

}