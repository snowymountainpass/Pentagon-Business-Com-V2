import {useEffect, useState} from "react";
import {atom, useAtom} from "jotai";

import Button from '@material-ui/core/Button';
import ButtonGroup from '@material-ui/core/ButtonGroup';
import AddIcon from '@material-ui/icons/Add';
import RemoveIcon from '@material-ui/icons/Remove';

import {NUMBER_ITEMS_IN_CART} from "../EShop-Components/ProductListing Components/ProductCard";
export const TOTAL_VALUE_IN_CART = atom(0);

export default function ProductRow(){

    const [totalAmountInCart,setTotalAmountInCart] = useAtom(TOTAL_VALUE_IN_CART);

    const [productsInCart,setProductsInCart] = useState([]);
    const [numberProductsInCart, setNumberProductsInCart] = useAtom(NUMBER_ITEMS_IN_CART);

    function getProductsAndQuantitiesInCart(){
        fetch("http://localhost:8080/e-shop/shopping-cart/"+localStorage.getItem("PTG V2 Login Token"))
            .then(response =>
            {
                console.log(response.status);
                return response.json();
            })
            .then(data => {
                setProductsInCart(data);
            })


    }

    function getNumberOfItemsInCart(){

        fetch('http://localhost:8080/e-shop/cart-items/get-shopping-cart-total-number-of-items')
            .then(
                response => response.json()
            )
            .then(data=> {
                setNumberProductsInCart(data);
            });

        console.log("current number of items(@ProductRow): "+ numberProductsInCart);

    }


    function decreaseProductAndGetTotalQuantity(selectedProductID){

        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ userToken: localStorage.getItem("PTG V2 Login Token")
                ,productID:selectedProductID
                ,quantity:-1 })
        };

        fetch('http://localhost:8080/e-shop/cart-items/add-product', requestOptions)
            .then(r=>r)
            .then(getNumberOfItemsInCart);

    }

    function addProductAndGetTotalQuantity(selectedProductID){

        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ userToken: localStorage.getItem("PTG V2 Login Token")
                ,productID:selectedProductID
                ,quantity:1 })
        };

        fetch('http://localhost:8080/e-shop/cart-items/add-product', requestOptions)
            .then(r=>r)
            .then(getNumberOfItemsInCart);

    }

    function deleteCartItem(cartItemID){

        fetch("http://localhost:8080/e-shop/cart-items/" + cartItemID).then(getNumberOfItemsInCart);

        console.log("removed cartItem with ID: "+ cartItemID);

    }


    function getCartValueTotalV2() {

        fetch('http://localhost:8080/e-shop/cart-items/cart-items-amount/'+localStorage.getItem("PTG V2 Login Token"))
            .then(response => response.text())
            .then(data=>{
                setTotalAmountInCart(parseInt(data));
            });

        console.log("Total amount in getCartValueTotalV2: "+ totalAmountInCart);
    }


    useEffect(()=>{
        console.log("@useEffect");

        getProductsAndQuantitiesInCart();

        Object.keys(productsInCart).map(function (key,index){
            console.log(productsInCart[key]);
        })

        getCartValueTotalV2();

    },[numberProductsInCart])

    useEffect(()=>{
        getNumberOfItemsInCart();
    },[])



    return(
        <>
            {
                Object.keys(productsInCart).map( (key, index) => (

                    //HTML

                    <tr key={index}>
                        <td>
                            <figure className="itemside">
                                <div className="aside"><img src={productsInCart[key][6]}
                                                          className="img-sm" alt={productsInCart[key][1]+".jpg"}/></div>
                                <figcaption className="info">
                                    <p className="title text-dark">{productsInCart[key][1]}</p>
                                    <p className="text-muted small">{productsInCart[key][2]}</p>

                                </figcaption>
                            </figure>
                        </td>
                        <td>

                            <ButtonGroup  >
                                <Button
                                    onClick={() => {
                                        decreaseProductAndGetTotalQuantity(productsInCart[key][0]);getCartValueTotalV2();
                                    }}
                                    size={"small"}
                                >
                                    {" "}
                                    <RemoveIcon fontSize="small" />
                                </Button>
                                <Button
                                    onClick={() => {

                                        addProductAndGetTotalQuantity(productsInCart[key][0]);getCartValueTotalV2();
                                    }}
                                    size={"small"}
                                >
                                    {" "}
                                    <AddIcon fontSize="small" />
                                </Button>
                            </ButtonGroup>

                        </td>
                        <td>
                            <div className="price-wrap">
                                <var className="price">€{productsInCart[key][4]*productsInCart[key][5]}</var>
                                <small className="text-muted">{productsInCart[key][4]} x €{productsInCart[key][5]} each
                                </small>
                            </div>
                        </td>
                        <td className="text-right">
                            <a data-original-title="Show Datasheet" title="Show Datasheet" href={productsInCart[key][3]}
                               download target="_blank" rel="noreferrer noopener" className="btn btn-light mr-2"
                               data-toggle="tooltip"> <i className="fa fa-info-circle"/></a>

                            <a  className="btn btn-light"
                            onClick={()=>deleteCartItem(productsInCart[key][0])}
                            > Remove</a>
                        </td>
                    </tr>


                    //HTML


                ))

            }



        </>

    );

}

// <tr>
//     <td>
//         <figure className="itemside">
//             {/*<div className="aside"><img src="assets/images/items/1.jpg" className="img-sm"/></div>*/}
//             <div className="aside"><img src="../public/assets/images/items/1.jpg" className="img-sm" alt={"1.jpg"}/></div>
//             <figcaption className="info">
//                 <p className="title text-dark">{name}</p>
//                 <p className="text-muted small">{description}</p>
//             </figcaption>
//         </figure>
//     </td>
//     <td>
//
//         <ButtonGroup  >
//             <Button
//                 onClick={() => {
//                     setProductQuantity(Math.max(productQuantity - 1, 0));
//
//                 }}
//                 size={"small"}
//             >
//                 {" "}
//                 <RemoveIcon fontSize="small" />
//             </Button>
//             <Button
//                 onClick={() => {
//                     setProductQuantity(productQuantity + 1);
//                     setTotalAmount(productQuantity*price);
//                 }}
//                 size={"small"}
//             >
//                 {" "}
//                 <AddIcon fontSize="small" />
//             </Button>
//         </ButtonGroup>
//
//     </td>
//     <td>
//         <div className="price-wrap">
//             <var className="price">${price*productQuantity}</var>
//             <small className="text-muted">{productQuantity} x ${price} each </small>
//         </div>
//     </td>
//     <td className="text-right">
//         <a data-original-title="Save to Wishlist" title="" href="" className="btn btn-light mr-2"
//            data-toggle="tooltip"> <i className="fa fa-heart"/></a>
//         <a href="" className="btn btn-light"> Remove</a>
//     </td>
// </tr>