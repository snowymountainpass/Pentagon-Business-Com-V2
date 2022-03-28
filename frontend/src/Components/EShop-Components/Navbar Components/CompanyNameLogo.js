import React from "react";

export default function CompanyNameLogo(){

    return(
        <div className="col-lg-2 col-4 flex-fill mr-auto">
            {/*className="col-lg-2 col-4 flex-fill"*/}
            {/*<a href="#" className="brand-wrap">*/}
            {/*    Pentagon Business Com*/}
            {/*</a>*/}
            <div className={"text-sm font-bold leading-relaxed inline-flex items-center mr-4 py-3 whitespace-nowrap uppercase text-white"}>

                <img
                    src={require("../../../Assets/img/Pentagon Assets/pentagon logo mic.jpg")}
                    className="rounded-full mr-2"
                    style={{ width: "35px" }}                     // LOGO SIZE
                />
                <span>
                    <a href="/" className="brand-wrap">
                    Pentagon Business Com
                    </a>
                </span>

            </div>




        </div>
    );

}