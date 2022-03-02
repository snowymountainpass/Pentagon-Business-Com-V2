import CompanyNameLogo from "./Navbar Components/CompanyNameLogo";
import SearchBar from "./Navbar Components/SearchBar";
import ShoppingCart from "./Navbar Components/ShoppingCart";
import RegistrationLogin from "./Navbar Components/RegistrationLogin";
import React from "react";


export default function Navbar()
{



    // const navBg = {
    //     dark: "bg-blueGray-800 shadow-md",
    //     light: "bg-blueGray-200 shadow-md",
    //     transparent: "lg:bg-transparent bg-white",
    //     white: "bg-white shadow-md",
    //     black: "bg-black shadow-md",
    //     blueGray: "bg-blueGray-500 shadow-md",
    //     red: "bg-red-500 shadow-md",
    //     orange: "bg-orange-500 shadow-md",
    //     amber: "bg-amber-500 shadow-md",
    //     emerald: "bg-emerald-500 shadow-md",
    //     teal: "bg-teal-500 shadow-md",
    //     lightBlue: "bg-lightBlue-500 shadow-md",
    //     indigo: "bg-indigo-500 shadow-md",
    //     purple: "bg-purple-500 shadow-md",
    //     pink: "bg-pink-500 shadow-md",
    // };
    // const linkColors = {
    //     light: "text-blueGray-500",
    //     dark: "text-white",
    //     transparent: "lg:text-white text-blueGray-500",
    //     white: "text-blueGray-500",
    //     black: "text-white",
    //     blueGray: "text-white",
    //     red: "text-white",
    //     orange: "text-white",
    //     amber: "text-white",
    //     emerald: "text-white",
    //     teal: "text-white",
    //     lightBlue: "text-white",
    //     indigo: "text-white",
    //     purple: "text-white",
    //     pink: "text-white",
    // };




    return(
        <nav className={"w-full h-full bg-blueGray-800 shadow-md text-white"}>
            {/*className={"fixed w-full z-50 flex flex-wrap items-center justify-between px-2 py-3 mb-3 bg-blueGray-800 shadow-md"}*/}
            <header className="section-header  ">
                <section className=" border-bottom "> {/**/}
                    <div className="container ">
                        <div className=" row align-items-center" >
                            <CompanyNameLogo/>

                            {/*<SearchBar/>*/}

                            <div className="col-lg-4 col-sm-6 col-12 text-white ">

                                <div className="widgets-wrap float-md-right">

                                    {/*<ShoppingCart/>*/}

                                    {/*<RegistrationLogin/>*/}

                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </header>

        </nav>





    );

}