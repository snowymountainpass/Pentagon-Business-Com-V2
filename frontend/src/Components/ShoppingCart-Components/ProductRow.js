import {useEffect, useState} from "react";

// import Button from '@mui/material/Button';
// import AddIcon from '@mui/icons-material/Add';
// import RemoveIcon from '@mui/icons-material/Remove';
// import ButtonGroup from '@mui/material/ButtonGroup';

import Button from '@material-ui/core/Button';
import ButtonGroup from '@material-ui/core/ButtonGroup';
import AddIcon from '@material-ui/icons/Add';
import RemoveIcon from '@material-ui/icons/Remove';

export default function ProductRow({name,description,price,quantity,setTotalAmount}){

    const [productsInCart,setProductsInCart] = useState([]);

    const [productQuantity,setProductQuantity] = useState(quantity);

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

    useEffect(()=>{
        console.log("@useEffect");
        getProductsAndQuantitiesInCart();


        Object.keys(productsInCart).map(function (key,index){
            console.log(productsInCart[key]);
        })
         // MERGE => apare un ARRAY

    },[])

    useEffect(()=>{
        setTotalAmount(productQuantity*price);
    },[price, productQuantity, setTotalAmount])
    
    return(
        <>
            {
                Object.keys(productsInCart).map( (key, index) => (

                    //HTML

                    <tr key={index}>
                        <td>
                            <figure className="itemside">
                                <div className="aside"><img src={productsInCart[key][5]}
                                                          className="img-sm" alt={productsInCart[key][0]+".jpg"}/></div>
                                <figcaption className="info">
                                    <p className="title text-dark">{productsInCart[key][0]}</p>
                                    <p className="text-muted small">{productsInCart[key][1]}</p>
                                    
                                </figcaption>
                            </figure>
                        </td>
                        <td>

                            <ButtonGroup  >
                                <Button
                                    onClick={() => {
                                        setProductQuantity(Math.max(productsInCart[key][3] - 1, 0));

                                    }}
                                    size={"small"}
                                >
                                    {" "}
                                    <RemoveIcon fontSize="small" />
                                </Button>
                                <Button
                                    onClick={() => {
                                        setProductQuantity(productsInCart[key][3] + 1);
                                        setTotalAmount(productQuantity*productsInCart[key][4]);
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
                                <var className="price">€{productsInCart[key][3]*productsInCart[key][4]}</var>
                                <small className="text-muted">{productsInCart[key][3]} x €{productsInCart[key][4]} each
                                </small>
                            </div>
                        </td>
                        <td className="text-right">
                            <a data-original-title="Show Datasheet" title="Show Datasheet" href={productsInCart[key][2]}
                               download target="_blank" rel="noreferrer noopener" className="btn btn-light mr-2"
                               data-toggle="tooltip"> <i className="fa fa-info-circle"/></a>

                            <a href="" className="btn btn-light"> Remove</a> {/* in href vom folosi ruta de DELETE CART ITEM + CART ITEM ID   */}
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