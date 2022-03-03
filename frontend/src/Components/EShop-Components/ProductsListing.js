import ProductCard from "./ProductCard";
import {useLocation} from "react-router-dom";
import {useEffect} from "react";

export default function ProductsListing(props){


    let location = useLocation();

    console.log(location.pathname)

    // if(location.pathname.toString().includes())
    //
    // useEffect(
    //     ()={
    //
    //     },[]
    // )

    return(
        <>

            {
                props.products.map(product =>(
                    <ProductCard product={product} key={product.productID}/>
                ))

            }

            {/*<ProductCard/>*/}
            {/*<ProductCard/>*/}
            {/*<ProductCard/>*/}

        </>



    );

}