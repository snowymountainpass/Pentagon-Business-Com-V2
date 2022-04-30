import {atom, useAtom} from "jotai";
import {useEffect} from "react";

export const NUMBER_ITEMS_IN_CART = atom(0);

export default function ProductCard(props) {

    const [productsInCart, setProductsInCart] = useAtom(NUMBER_ITEMS_IN_CART);

    function getNumberOfItemsInCart() {

        fetch('http://localhost:8080/e-shop/cart-items/get-shopping-cart-total-number-of-items')
            .then(
                response => response.json()
            )
            .then(data => {
                setProductsInCart(data);
            });
    }


    function addProductAndGetTotalQuantity() {

        const requestOptions = {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify({
                userToken: localStorage.getItem("PTG V2 Login Token"),
                productID: props.pkey,
                quantity: 1
            })
        };

        fetch('http://localhost:8080/e-shop/cart-items/add-product', requestOptions)
            .then(getNumberOfItemsInCart);

    }

    useEffect(()=>{
        if(localStorage.getItem("PTG V2 Login Token")!=null){
            getNumberOfItemsInCart();
        }
        // console.log("NR productsInCart: "+ productsInCart);
    },[])

    return (
        <article className="card card-product-list">
            <div className="row no-gutters">
                <aside className="col-md-3">
                    <a className="img-wrap">
                        <span className="badge badge-new"> NEW </span>
                        <img src={props.product.img} alt={props.product.productName}/>
                    </a>
                </aside>
                <div className="col-md-6">
                    <div className="info-main">
                        <a className="h5 title"> {props.product.productName} </a>
                        <div className="rating-wrap mb-3">
                            <ul className="rating-stars">
                                <li className="stars-active w-80">

                                    {[...Array(props.product.rating)].map((e, i) => <i className="fa fa-star"
                                                                                       key={i}/>)}

                                </li>
                                <li>

                                    {[...Array(10)].map((e, i) => <i className="fa fa-star" key={i}/>)}

                                </li>
                            </ul>
                            <div className="label-rating">{`${props.product.rating}/10`}</div>
                        </div>

                        <p> {props.product.productDescription} </p>
                    </div>
                </div>
                <aside className="col-sm-3">
                    <div className="info-aside">
                        <div className="price-wrap">
                            <span className="price-new h5"> {`€${props.product.productPrice}`} </span>
                            <del className="price-old"> {`€${props.product.productPrice + 20}`} </del>


                        </div>
                        <p className="text-success">{`Delivery Cost: ${(parseInt(props.product.productPrice) * 10) / 100}%`}</p>
                        <br/>
                        <p className="text-quantity">{`Quantity Available: ${props.product.productInventory}`}</p>
                        <br/>
                        <p>
                            <a href={props.product.datasheet} download className="btn btn-primary btn-block"
                               target="_blank" rel="noreferrer noopener"
                            >Details</a>

                            <a className="btn btn-light btn-block"
                               onClick={localStorage.getItem("PTG V2 Login Token") != null ? addProductAndGetTotalQuantity : null}
                            >
                                <i className="fa fa-shopping-cart"/>
                                <span className="text">Add to Cart</span>
                            </a>
                        </p>
                    </div>
                </aside>
            </div>
        </article>

    );

}