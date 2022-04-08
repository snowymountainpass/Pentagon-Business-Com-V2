import React, {useEffect, useState} from "react";
import PropTypes from "prop-types";
import {Link, useNavigate,Navigate,Redirect} from "react-router-dom";
import EShop from "../../../Pages/EShop";

// components

export default function CardLoginSocial({
                                            title,
                                            forgotPassword,
                                            createAccount,
                                            setLoginToken
                                        }) {

    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const [tokenValue, setTokenValue] = useState("");
    
    let navigate = useNavigate();

    useEffect(()=>{
        localStorage.setItem("PTG V2 Login Token", tokenValue);
        console.log("Token value is: " + tokenValue);
        if(localStorage.getItem("PTG V2 Login Token")!=="" && localStorage.getItem("PTG V2 Login Token")!=="invalid credentials"){
            sendLoggedInUserToken();
            navigate(-1);
        }
        // (localStorage.getItem("PTG V2 Login Token") !== "" && localStorage.getItem("PTG V2 Login Token") !== "invalid credentials") ? <Redirect to="http://localhost:3000/e-shop"/> :<Redirect to="http://localhost:3000/e-shop/login"/>

        // if(localStorage.getItem("PTG V2 Login Token") !== "" && localStorage.getItem("PTG V2 Login Token") !== "invalid credentials"){
        //     navigate("http://localhost:3000/e-shop",{replace:true})
        // }

    },[tokenValue])


    const handleEmailChange = (event) => {
        setEmail(event.target.value);
    }

    const handlePasswordChange = (event) => {
        setPassword(event.target.value);
    };


    function handleSubmit(event) {
        event.preventDefault();

        console.log("email: " + email);
        console.log("password: " + password);

        const requestOptions = {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify({email: email, password: password})
        };
        fetch('http://localhost:8080/e-shop/login', requestOptions)
            .then((response) => response.text())
            .then((data) => {
                setTokenValue(data);
                setLoginToken(data);

            })
            .catch((error) => {
            console.error('Error:', error);
        });

    }

    function sendLoggedInUserToken(){

        const loggedInUserToken = localStorage.getItem("PTG V2 Login Token");

        const requestOptions = {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            // body: JSON.stringify({userToken: email,loggedInUserToken})
        };

        fetch('http://localhost:8080/e-shop/login/' + loggedInUserToken, requestOptions)
            .then(response  =>console.log(response));

    }


    return (
        <>
            <div className="relative flex flex-col w-full mb-6 shadow-lg rounded-lg bg-white">
                <div className="mb-0 px-6 py-6">
                    <div className="text-center mb-3">
                        <h6 className="text-blueGray-500 text-sm  font-bold" style={{fontSize: '25px'}}>{title}</h6>
                    </div>

                </div>
                <div className="flex-auto px-4 lg:px-10 py-10 pt-0">
                    {/* AICI LUCRAM  */}


                    <form>
                        {/*  AICI LUCRAM*/}

                        <div className="form">

                            <div className="relative w-full">
                                <label className="block uppercase text-blueGray-700 text-xs font-bold mb-2 ml-1"
                                       htmlFor="email">Email </label>
                                <input type="email" id="email"
                                       className=" w-full placeholder-blueGray-200 text-blueGray-700 relative bg-white rounded-md outline-none focus:ring focus:ring-lightBlue-500 focus:ring-1 focus:border-lightBlue-500 border border-solid transition duration-200 mb-3 "
                                       placeholder="Email"
                                    // ref={(input) => {
                                    //     this.email = input;
                                    // }}
                                       value={email}
                                       onChange={(event) => handleEmailChange(event)}
                                />
                            </div>
                            <div className="relative w-full">
                                <label className="block uppercase text-blueGray-700 text-xs font-bold mb-2 ml-1"
                                       htmlFor="password">Password </label>
                                <input type="password" id="password"
                                       className=" w-full placeholder-blueGray-200 text-blueGray-700 relative bg-white rounded-md outline-none focus:ring focus:ring-lightBlue-500 focus:ring-1 focus:border-lightBlue-500 border border-solid transition duration-200 mb-3 "
                                       value={password}
                                       onChange={(event) => handlePasswordChange(event)}
                                       placeholder="Password"/>
                            </div>


                            <div className="text-center mt-6">
                                <button onClick={(event) => {

                                    if (email && password) {
                                        // handleSubmit(event).then( tokenValue !=="" ? handleClick: console.log("token value is undefined!"));
                                        handleSubmit(event);



                                    }
                                }} type="button"
                                        className="bg-blue-500 hover:bg-blue-700 text-black-50 font-bold py-2 px-4 rounded"
                                >
                                    SIGN IN
                                </button>
                            </div>
                        </div>
                    </form>


                    {/*AICI LUCRAM  */}
                </div>
            </div>
            {Object.keys(forgotPassword).length === 0 &&
            Object.keys(createAccount).length === 0 ? null : (
                <div className="flex flex-wrap mt-6 relative">
                    <div className="w-1/2">
                        {forgotPassword && forgotPassword.to ? (
                            <Link {...forgotPassword} className="text-blueGray-500 ml-2">
                                <small>Forgot password?</small>
                            </Link>
                        ) : forgotPassword && forgotPassword.href ? (
                            <a {...forgotPassword} className="text-blueGray-500 ml-2">
                                <small>Forgot password?</small>
                            </a>
                        ) : null}
                    </div>
                    <div className="w-1/2 text-right">
                        {createAccount && createAccount.to ? (
                            <Link {...createAccount} className="text-blueGray-500 mr-2">
                                <small>Create new account</small>
                            </Link>
                        ) : createAccount && createAccount.href ? (
                            <a {...createAccount} className="text-blueGray-500 mr-2">
                                <small>Create new account</small>
                            </a>
                        ) : null}
                    </div>
                </div>
            )}
        </>
    );
}

CardLoginSocial.defaultProps = {
    inputs: [],
    button: {},
    forgotPassword: {},
    createAccount: {},
};

CardLoginSocial.propTypes = {
    title: PropTypes.string,
    subtitle: PropTypes.string,
    // NOTE: the "Forgot password?" text is allready set
    forgotPassword: PropTypes.object,
    // NOTE: the "Create new account" text is allready set
    createAccount: PropTypes.object,
    // It is represetnted by the props you
    // can pass to our Button component element
    button: PropTypes.object,
    socials: PropTypes.arrayOf(
        PropTypes.shape({
            icon: PropTypes.oneOf([
                "facebook",
                "twitter",
                "instagram",
                "github",
                "pinterest",
                "youtube",
                "vimeo",
                "slack",
                "dribbble",
                "reddit",
                "tumblr",
                "linkedin",
            ]),
            // It is represetnted by the props you
            // can pass to our Button component element
            // for example you can add an onClick handler
            button: PropTypes.object,
        })
    ),
    // It is represetnted by the props you
    // can pass to our Checkbox component element
    checkbox: PropTypes.object,
    inputs: PropTypes.arrayOf(
        PropTypes.shape({
            label: PropTypes.string,
            // It is represetnted by the props you
            // can pass to our Input component element
            // NOTE: if you wish to generate a textarea, you will need to pass
            // // // inside this object >> type: "textarea"
            // // // full example >> input: { type: "textarea" }
            input: PropTypes.object,
        })
    ),
};


// await fetch('http://localhost:8080/e-shop/login', requestOptions) // WORKING
//      .then((response) =>{
//          console.log(response);
//          return response.text();
//      })
//      .then(data=>{
//          console.log(data);
//      }); // WORKING - > DISPLAYS THE TOKEN (handleSubmit mthd must be async ; await fetch)


// console.log("Local Storage token: "+localStorage.getItem("token"))