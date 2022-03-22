

import {useEffect, useState} from "react";
import DeliveryTimeComponent from "./Sidebar Components/DeliveryTimeComponent";
import PriceIntervalComponent from "./Sidebar Components/PriceIntervalComponent";
import BrandSelectionComponent from "./Sidebar Components/BrandSelectionComponent";

export default function SidebarComponent({setChangeProducts,brandsList,minmaxPrice}  ){

    function handleCategoryClick(event){
        event.preventDefault();
        let productCategory = event.target.id;
        // console.log(productCategory);

        const requestOptions = {
            method: 'GET',
            headers: {Accept: 'application/json', 'Content-Type': 'application/json'},
            // body: JSON.stringify({ "productName":query }) //
        };

        fetch(`http://localhost:8080/e-shop/`+productCategory, requestOptions)
            .then(response => {
                return response.json();
                // console.log(response);
            })
            .then(data => {
                setChangeProducts(data);
            });

    }


    return(

    <aside className="col-md-3">

        <div className="card">
            <article className="filter-group">
                <header className="card-header">
                    <a  data-toggle="collapse" data-target="#collapse_1" aria-expanded="true" className="">
                        <i className="icon-control fa fa-chevron-down"/>
                        <h6 className="title">Product type</h6>
                    </a>
                </header>
                <div className="filter-content collapse show" id="collapse_1">
                    <div className="card-body">

                        <ul className="list-menu"
                            onClick={ event=> {
                                handleCategoryClick(event);
                                event.target.style.color="blue";
                            } }
                            onMouseOut={ event=> {
                                event.target.style.color="black";
                            } }>
                            <li><a id="TELEFON_SIP">TELEFOANE SIP</a></li>
                            <li><a id="SISTEM_AUDIO_CONFERINTA">SISTEME DE AUDIO CONFERINTA </a></li>
                            <li><a id="CASTI_CALLCENTER">CASTI CALL-CENTER</a></li>
                            <li><a id="SWITCH">SWITCH</a></li>
                            <li><a id="ACCESS_POINT_WIRELESS">ACCESS POINT WIRELESS </a></li>
                            <li><a id="SISTEM_VIDEO_CONFERINTA">SISTEME DE VIDEO CONFERINTA</a></li>
                        </ul>

                    </div>
                </div>
            </article>

            <article className="filter-group">
                <header className="card-header">
                    <a  data-toggle="collapse" data-target="#collapse_2" aria-expanded="true" className="">
                        <i className="icon-control fa fa-chevron-down"/>
                        <h6 className="title">Brands</h6>
                    </a>
                </header>
                <div className="filter-content collapse show" id="collapse_2">
                    <div className="card-body">

                        <BrandSelectionComponent
                            setChangeProducts={setChangeProducts}
                            brandsList={brandsList}
                        />

                    </div>
                </div>
            </article>

            <article className="filter-group">
                <header className="card-header">
                    <a  data-toggle="collapse" data-target="#collapse_3" aria-expanded="true" className="">
                        <i className="icon-control fa fa-chevron-down"/>
                        <h6 className="title">Price range </h6>
                    </a>
                </header>
                <div className="filter-content collapse show" id="collapse_3">
                    <div className="card-body">

                        <PriceIntervalComponent
                            setChangeProducts={setChangeProducts}
                            minmaxPrice={minmaxPrice}
                        />


                    </div>
                </div>
            </article>

            <article className="filter-group">
                <header className="card-header">
                    <a  data-toggle="collapse" data-target="#collapse_5" aria-expanded="false" className="">
                        <i className="icon-control fa fa-chevron-down"/>
                        <h6 className="title">Delivery Time </h6>
                    </a>
                </header>
                <div className="filter-content collapse in" id="collapse_5">
                    <div className="card-body">
                        <DeliveryTimeComponent
                            setChangeProducts={setChangeProducts}
                        />
                    </div>
                </div>
            </article>

        </div>
        {/*<button className="btn btn-block btn-primary mt-2">Apply</button>*/}
    </aside>

);

}