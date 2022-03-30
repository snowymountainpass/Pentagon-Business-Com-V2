import React, {useState} from "react";
import PropTypes from "prop-types";
// components
// import Button from "../../../Components/Elements/Button";
// import Input from "../../Elements/Input";
// import Checkbox from "../../Elements/Checkbox";

export default function CardRegister({
                                         // title,
                                         // subtitle,
                                         // inputs,
                                         // socials,
                                         // button,
                                         // checkbox,
                                         // forgotPassword,
                                         // createAccount,
                                     }) {

    const inputError = {
        border: `2px solid #F2180A`,
        color: `red !important`
    };


    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [confirmPassword, setConfirmPassword] = useState("");

    const [match, setMatch] = useState(false);
    const [charNumberValid, setCharNumberValid] = useState(false);
    const [specialCharValid, setSpecialCharValid] = useState(false);
    const [uppercaseValid, setUppercaseValid] = useState(false);
    const [numberValid, setNumberValid] = useState(false);


    // Check the length of the input
    const checkPasswordLength = (password) => {
        if (password.length >= 8) {
            setCharNumberValid(true);
        } else {
            setCharNumberValid(false);
        }
    }

    // Check for special characters
    const checkSpecialCharacters = (password) => {
        const pattern = /[ !@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]/g;
        if (pattern.test(password)) {
            setSpecialCharValid(true);
        } else {
            setSpecialCharValid(false);

        }
    }

    // Check for an uppercase character
    const checkUppercase = (password) => {
        const pattern = /[A-Z]/;
        if (pattern.test(password)) {
            setUppercaseValid(true);
        } else {
            setUppercaseValid(false);
        }
    }

    // Check for a number
    const checkNumber = (password) => {
        const pattern = /[0-9]/;
        if (pattern.test(password)) {
            setNumberValid(true);
        } else {
            setNumberValid(false);

        }
    }

    const handleEmailChange = (event) => {
        setEmail(event.target.value);
    }

    const handlePasswordChange = (event) => {

        setPassword(event.target.value);

        checkPasswordLength(event.target.value);
        checkSpecialCharacters(event.target.value);
        checkUppercase(event.target.value);
        checkNumber(event.target.value);
    };

    const handleConfirmPasswordChange = (event) => {

        setConfirmPassword(event.target.value);
        setMatch(null);
    };

    const comparePassword = (event) => {
        if (password === confirmPassword) {
            setMatch(true);
        } else {
            setMatch(false);
        }


    }
    const handleSubmit = (event) => {
        event.preventDefault();

        console.log("email: " + email);
        console.log("password: " + password);



    }


    return (
        <>
            <div
                className="relative flex flex-col min-w-0 break-words w-full mb-6 shadow-lg rounded-lg bg-blueGray-100">
                <div className="rounded-t-lg bg-blueGray-800 mb-0 px-6 py-6">
                    <div className="text-center mb-3">
                        <h2 className="text-blueGray-300 text-lg font-bold">Signup</h2>
                    </div>

                </div>
                <div className="flex-auto px-4 lg:px-10 py-6">

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
                            <div className="relative w-full">
                                <label
                                    className={`block uppercase text-blueGray-700 text-xs font-bold mb-2 ml-1 ${match === false ? inputError : null}`}>Confirm Password</label>
                                <input type="password" id="confirmPassword"
                                       className={`w-full placeholder-blueGray-200 text-blueGray-700 relative bg-white rounded-md outline-none focus:ring focus:ring-lightBlue-500 focus:ring-1 focus:border-lightBlue-500 border border-solid transition duration-200 mb-3${match === false ? inputError : ''}`}
                                       value={confirmPassword}
                                       onChange={(event) => handleConfirmPasswordChange(event)}
                                       onBlur={event =>  comparePassword(event)}
                                       placeholder="Confirm Password"/>
                            </div>

                            <div className="relative w-full">
                                <div className="validator">
                                    <i className={charNumberValid ? "fas fa-check success" : "fas fa-times error"}/>
                                    <p className="validation-item">8-20 characters</p>
                                </div>
                                <div className="validator">
                                    <i className={specialCharValid ? "fas fa-check success" : "fas fa-times error"}/>
                                    <p className="validation-item">1 special character</p>
                                </div>
                                <div className="validator">
                                    <i className={uppercaseValid ? "fas fa-check success" : "fas fa-times error"}/>
                                    <p className="validation-item">1 uppercase letter</p>
                                </div>
                                <div className="validator">
                                    <i className={numberValid ? "fas fa-check success" : "fas fa-times error"}/>
                                    <p className="validation-item">1 number</p>
                                </div>
                            </div>


                            <div className="text-center mt-6">
                                <button onClick={(event) => handleSubmit(event)} type="button"
                                    // className="inline-block outline-none focus:outline-none align-middle transition-all duration-150 ease-in-out uppercase border border-solid font-bold last:mr-0 mr-2 text-black bg-blueGray-500 border-blueGray-500 active:bg-blueGray-600 active:border-blueGray-600"
                                        className="bg-blue-500 hover:bg-blue-700 text-black-50 font-bold py-2 px-4 rounded"
                                >
                                    Register
                                </button>
                            </div>
                        </div>


                        {/*  AICI LUCRAM*/}
                    </form>
                </div>
            </div>
        </>
    );
}

CardRegister.defaultProps = {
    inputs: [],
    button: {},
};

CardRegister.propTypes = {
    title: PropTypes.string,
    subtitle: PropTypes.string,
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


// const [email,setEmail] = useState("");
// const [password,setPassword] = useState("");
// const [passConfirm,setPassConfirm] = useState("");
//
// function showCredentials(event){
//   event.preventDefault();
//
//   console.log("Email "+event.target.input);
//   console.log("Password: "+event.target.value);
//   console.log("Password Confirm: "+event.target.value);
//
// }


// <form>
//   {inputs.map((prop, key) => {
//     return (
//         <div key={key} className="relative w-full">
//           <label className="block uppercase text-blueGray-700 text-xs font-bold mb-2 ml-1">
//             {prop.label}
//           </label>
//           <Input {...prop.input} />
//         </div>
//     );
//   })}
//   <div className="mt-2 inline-block">
//     <Checkbox {...checkbox} />
//   </div>
//
//   <div className="text-center mt-6">
//     <Button {...button} />
//   </div>
// </form>


// <form>
//     {/*  AICI LUCRAM*/}
//
//     <div className="form">
//
//         <div className="relative w-full">
//             <label className="block uppercase text-blueGray-700 text-xs font-bold mb-2 ml-1" htmlFor="email">Email </label>
//             <input type="email" id="email"
//                    className=" w-full placeholder-blueGray-200 text-blueGray-700 relative bg-white rounded-md outline-none focus:ring focus:ring-lightBlue-500 focus:ring-1 focus:border-lightBlue-500 border border-solid transition duration-200 mb-3 "
//                    value={email} onChange={(e) => handleInputChange(e)} placeholder="Email"
//             />
//         </div>
//         <div className="relative w-full">
//             <label className="block uppercase text-blueGray-700 text-xs font-bold mb-2 ml-1" htmlFor="password">Password </label>
//             <input type="password" id="password"
//                    className=" w-full placeholder-blueGray-200 text-blueGray-700 relative bg-white rounded-md outline-none focus:ring focus:ring-lightBlue-500 focus:ring-1 focus:border-lightBlue-500 border border-solid transition duration-200 mb-3 "
//                    value={password} onChange={(e) => handleInputChange(e)}
//                    placeholder="Password"/>
//         </div>
//         <div className="relative w-full">
//             <label className="block uppercase text-blueGray-700 text-xs font-bold mb-2 ml-1" htmlFor="confirmPassword">Confirm Password </label>
//             <input  type="password" id="confirmPassword"
//                     className=" w-full placeholder-blueGray-200 text-blueGray-700 relative bg-white rounded-md outline-none focus:ring focus:ring-lightBlue-500 focus:ring-1 focus:border-lightBlue-500 border border-solid transition duration-200 mb-3 "
//                     value={confirmPassword} onChange={(e) => handleInputChange(e)}
//                     placeholder="Confirm Password"/>
//         </div>
//
//         <div className="text-center mt-6">
//             <button onClick={(event) => handleSubmit(event)} type="button"
//                 // className="inline-block outline-none focus:outline-none align-middle transition-all duration-150 ease-in-out uppercase border border-solid font-bold last:mr-0 mr-2 text-black bg-blueGray-500 border-blueGray-500 active:bg-blueGray-600 active:border-blueGray-600"
//                     className="bg-blue-500 hover:bg-blue-700 text-black-50 font-bold py-2 px-4 rounded"
//             >
//                 Register
//             </button>
//         </div>
//     </div>
//
//
//     {/*  AICI LUCRAM*/}
// </form>


// const handleInputChange = (e) => {
//     const {id, value} = e.target;
//
//     if (id === "email") {
//         setEmail(value);
//     }
//     if (id === "password") {
//         setPassword(value);
//     }
//     if (id === "confirmPassword") {
//         setConfirmPassword(value);
//     }
//
// }
//
// const handleSubmit = (event) => {
//     event.preventDefault();
//
//     console.log("email: "+email);
//     console.log("password: "+password);
//     console.log("confirmPassword: "+confirmPassword);
// }