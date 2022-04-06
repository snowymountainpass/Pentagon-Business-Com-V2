import {Link} from "react-router-dom";
import React from "react";


export default function NavigationBar(){


    return(
        <>
            <nav className="w-full z-50 flex flex-wrap items-center justify-between px-2 py-3 mb-3">

                <div className="flex container mx-auto flex flex-wrap items-center justify-between px-0 lg:px-4">


                    {logoLink && logoLink.to ? (
                        <Link
                            {...logoLink}
                            className={
                                "text-sm font-bold leading-relaxed inline-flex items-center mr-4 py-2 whitespace-nowrap uppercase " +
                                linkColors[color]
                            }
                        >
                            {brand}
                        </Link>
                    ) : logoLink ? (
                        <a
                            {...logoLink}
                            className={
                                "text-sm font-bold leading-relaxed inline-flex items-center mr-4 py-2 whitespace-nowrap uppercase " +
                                linkColors[color]
                            }
                        >
                            {brand}
                        </a>
                    ) : null}

                    <button
                        className="ml-auto cursor-pointer text-xl leading-none px-3 py-1 border border-solid border-blueGray-400 rounded bg-transparent block outline-none focus:outline-none text-blueGray-300 lg:hidden"
                        type="button"
                        onClick={startAnitmation}
                    >
                        <i className="fas fa-bars"></i>
                    </button>



                </div>

            </nav>

        </>
    )

}