import ProductCard from "./ProductCard";

export default function ProductsListing(props) {
    return (
        <>
            {
                props.products.map(product => (
                    <ProductCard product={product} pkey={product.productID} key={product.productID}/>
                ))
            }

        </>
    );
}