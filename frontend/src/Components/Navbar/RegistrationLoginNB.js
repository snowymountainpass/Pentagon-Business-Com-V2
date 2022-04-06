import {Link} from "react-router-dom";
import React, {useEffect, useState} from "react";

export default function RegistrationLoginNB() {

    const [loggedInState, setloggedInState] = useState(localStorage.getItem("PTG V2 Login Token")  ? true : false);
    const [text, setText] = useState(loggedInState ? "Sign Out" : "Sign In");
    const [pageLink, setPageLink] = useState(loggedInState ? "/e-shop" : "/e-shop/login");

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

    return (
        <>

            <Link

                className={
                    "hover:opacity-75 px-3 py-4 lg:py-2 flex items-center text-xs uppercase font-bold transition-all duration-150 ease-in-out text-white"

                }
                to={"/e-shop"}
            >
                <i className="fa fa-shopping-cart"/>
            </Link>

            <Link

                className={
                    "hover:opacity-75 px-3 py-4 lg:py-2 flex items-center text-xs uppercase font-bold transition-all duration-150 ease-in-out text-white"

                }
                to={"/e-shop"}
            >
                <i className="fa fa-user"/>
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


            <Link

                className={
                    "hover:opacity-75 px-3 py-4 lg:py-2 flex items-center text-xs uppercase font-bold transition-all duration-150 ease-in-out text-white"
                }
                to={"/e-shop/register"}
            >
                Register
            </Link>
            <p className={"text-white"}>{`loggedinState:${loggedInState}`}</p>
        </>



    );

}


