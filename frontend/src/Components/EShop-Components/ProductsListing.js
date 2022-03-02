import ProductCard from "./ProductCard";


export default function ProductsListing(props){

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