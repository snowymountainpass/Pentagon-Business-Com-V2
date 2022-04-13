import {Link} from "react-router-dom";
import React, {useEffect, useState} from "react";


import Badge from "@material-ui/core/Badge";
import ShoppingCartIcon from "@material-ui/icons/ShoppingCart";
import PersonIcon from '@material-ui/icons/Person';


export default function RegistrationLogin() {

    const [loggedInState, setloggedInState] = useState(
        (localStorage.getItem("PTG V2 Login Token") &&
        localStorage.getItem("PTG V2 Login Token")!=="invalid credentials") ? true : false


    );

    const [productsInCart, setProductsInCart] = useState(
        JSON.parse( localStorage.getItem("no. items in cart") )  || 0

    );

    const [text, setText] = useState(loggedInState ? "Sign Out" : "Sign In");
    const [pageLink, setPageLink] = useState(loggedInState ? "/e-shop" : "/e-shop/login");

    const [itemCount, setItemCount] = useState(0);

    function logout() {
        setText("Sign In");
        setPageLink("/e-shop/login");
        setloggedInState(!loggedInState);
        localStorage.clear();
    }

    function login() {
        setText("Sign Out");
        setPageLink("/e-shop");
        setloggedInState(!loggedInState);
    }

    useEffect(()=>{

        if(loggedInState){
            setText("Sign Out");
            setPageLink("/e-shop");
        }else {
            setText("Sign In");
            setPageLink("/e-shop/login");
            setloggedInState(!loggedInState);
        }

    },[])


    useEffect(()=>{
        // setItemCount()
        console.log( "No. items in cart: " + parseInt( productsInCart )+1 );
        // setItemCount( parseInt( localStorage.getItem("no. items in cart") ) )

    },[productsInCart])

    return (
        <>
            <div className="widgets-wrap float-md-right text-white">
                <div className="widget-header  mr-3 text-white">
                    <Link

                        className={
                            "hover:opacity-75 px-3 py-4 lg:py-2 flex items-center text-xs uppercase font-bold transition-all duration-150 ease-in-out text-white"

                        }
                        to={"/shopping-cart"}
                    >
                        {/*<i className="fa fa-shopping-cart"/>*/}
                        {/*<Badge color="secondary" badgeContent={ itemCount !=null ? itemCount : 0 } overlap="rectangular">*/}
                        <Badge color="secondary" badgeContent={ localStorage.getItem("no. items in cart")!==null ? parseInt( localStorage.getItem("no. items in cart"))+1 :0 } overlap="rectangular">
                            <ShoppingCartIcon fontSize={"medium"} />{" "}
                        </Badge>
                    </Link>
                </div>
            </div>

            <Link

                className={
                    "hover:opacity-75 px-3 py-4 lg:py-2 flex items-center text-xs uppercase font-bold transition-all duration-150 ease-in-out text-white"

                }
                to={"/e-shop"}
            >
                {/*<i className="fa fa-user"/>*/}
                <PersonIcon fontSize={"medium"} />
            </Link>

            <div onClick={loggedInState ? logout : login}>
                <Link
                    className={
                        "hover:opacity-75 px-3 py-4 lg:py-2 flex items-center text-xs uppercase font-bold transition-all duration-150 ease-in-out text-white"
                    }
                    to={pageLink}
                >
                    {text}
                </Link>

            </div>

            <div style={{display:((localStorage.getItem("PTG V2 Login Token") &&
                    localStorage.getItem("PTG V2 Login Token")!=="invalid credentials") ? true : false)?"none":"block"}}>

                <Link

                    className={
                        "hover:opacity-75 px-3 py-4 lg:py-2 flex items-center text-xs uppercase font-bold transition-all duration-150 ease-in-out text-white"
                    }
                    to={"/e-shop/register"}
                >
                    Register
                </Link>

            </div>

            <p className={"text-white"}>{`loggedinState:${((localStorage.getItem("PTG V2 Login Token") &&
                localStorage.getItem("PTG V2 Login Token")!=="invalid credentials") ? true : false)}`}</p>
        </>



    );

}


