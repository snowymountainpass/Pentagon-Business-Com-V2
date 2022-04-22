import {Link} from "react-router-dom";
import React, {useEffect, useState} from "react";


import Badge from "@material-ui/core/Badge";
import ShoppingCartIcon from "@material-ui/icons/ShoppingCart";
import PersonIcon from '@material-ui/icons/Person';

import {useAtom} from "jotai";

import {NUMBER_ITEMS_IN_CART} from "../EShop-Components/ProductListing Components/ProductCard";

export default function RegistrationLogin() {

    const [loggedInState, setloggedInState] = useState(
        (localStorage.getItem("PTG V2 Login Token") &&
            localStorage.getItem("PTG V2 Login Token") !== "invalid credentials") ? true : false
    );

    const [text, setText] = useState(loggedInState ? "Sign Out" : "Sign In");
    const [pageLink, setPageLink] = useState(loggedInState ? "/e-shop" : "/e-shop/login");


    function logout() {

        if(localStorage.getItem("PTG V2 Login Token")!=null){

            const requestOptions = {
                method: 'POST',
                headers: {'Content-Type': 'application/json'},
                body: JSON.stringify(localStorage.getItem("PTG V2 Login Token"))
            };

            fetch('http://localhost:8080/e-shop/logout', requestOptions).then(r => r);

        }

        setText("Sign In");
        setPageLink("/e-shop/login");
        setloggedInState(!loggedInState);

        localStorage.clear();
        setNumberItemsInCart(0);
    }

    function login() {
        setText("Sign Out");
        setPageLink("/e-shop");
        setloggedInState(!loggedInState);
    }

    useEffect(() => {

        if (loggedInState) {
            setText("Sign Out");
            setPageLink("/e-shop");
        } else {
            setText("Sign In");
            setPageLink("/e-shop/login");
            setloggedInState(!loggedInState);
        }

    }, [])


    const [numberItemsInCart, setNumberItemsInCart] = useAtom(NUMBER_ITEMS_IN_CART);


    return (
        <>
            <div className="widgets-wrap float-md-right text-white">
                <div className="widget-header  mr-3 text-white">
                    <Link

                        className={
                            "hover:opacity-75 px-3 py-4 lg:py-2 flex items-center text-xs uppercase font-bold transition-all duration-150 ease-in-out text-white"

                        }
                        to={"/e-shop/shopping-cart"}
                    >
                        <Badge color="secondary" badgeContent={numberItemsInCart} overlap="rectangular">
                            <ShoppingCartIcon fontSize={"medium"}/>{" "}
                        </Badge>
                    </Link>
                </div>
            </div>

            <div style={{
                display: ((localStorage.getItem("PTG V2 Login Token") &&
                    localStorage.getItem("PTG V2 Login Token") !== "invalid credentials") ? true : false) ? "block" : "none"
            }}>
                <Link

                    className={
                        "hover:opacity-75 px-3 py-4 lg:py-2 flex items-center text-xs uppercase font-bold transition-all duration-150 ease-in-out text-white"

                    }
                    to={"/e-shop/user-account"}
                >

                    <PersonIcon fontSize={"medium"}/>
                </Link>
            </div>

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

            <div style={{
                display: ((localStorage.getItem("PTG V2 Login Token") &&
                    localStorage.getItem("PTG V2 Login Token") !== "invalid credentials") ? true : false) ? "none" : "block"
            }}>

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
                localStorage.getItem("PTG V2 Login Token") !== "invalid credentials") ? true : false)}`}</p>
        </>


    );

}


