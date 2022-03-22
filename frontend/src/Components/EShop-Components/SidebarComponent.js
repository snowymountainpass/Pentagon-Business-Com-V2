

import {useEffect, useState} from "react";
import DeliveryTimeComponent from "./Sidebar Components/DeliveryTimeComponent";

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


    const brandsNamesList = brandsList;

    const [checked, setChecked] = useState([]);

    const handleCheck = (event) => {
        let updatedList = [...checked];
        if (event.target.checked) {
            updatedList = [...checked, event.target.value];
        } else {
            updatedList.splice(checked.indexOf(event.target.value), 1);
        }
        setChecked(updatedList);

        // console.log(updatedList);

        handleBrandClick(updatedList);

    };

    function handleBrandClick(checkedBrandsList){
        const requestOptions = {
            method: 'POST',
            headers: {Accept: 'application/json', 'Content-Type': 'application/json'},
            body: JSON.stringify(checkedBrandsList)
        };

        fetch( `http://localhost:8080/e-shop/brands`, requestOptions)
            .then(response => {
                return response.json();
            })
            .then(data => {
                setChangeProducts(data);
            });

    }


    const [minMaxState,setMinMaxState] = useState({
        // minPrice:minmaxPrice[0],
        // maxPrice:minmaxPrice[1],
        minPrice:"",
        maxPrice:"",
        // minDefault:minmaxPrice[0],
        // maxDefault:minmaxPrice[1],
    })


    const handlePriceChange = e => {

        e.preventDefault();

        setMinMaxState(
            {...minMaxState,[e.target.name]:e.target.value,}
        )

    }


    function passPriceValues(){

        // console.log("Min price: "+minMaxState.minPrice);
        // console.log("Max price: "+minMaxState.maxPrice);
        //
        // console.log("-----------------------------------");
        // console.log("Min DEFAULT price: "+minmaxPrice[0]);
        // console.log("Max DEFAULT price: "+minmaxPrice[1]);

        const requestOptions = {
            method: 'GET',
            headers: {Accept: 'application/json', 'Content-Type': 'application/json'},
        };


        if(minMaxState.minPrice==null && minMaxState.maxPrice==null ){

            fetch(`http://localhost:8080/e-shop/min-max-prices/${minmaxPrice[0]}-${minmaxPrice[1]}`,requestOptions)
                .then(response => {
                    return response.json();
                })
                .then(data => {
                    setChangeProducts(data);
                });

        }
        else if( minMaxState.minPrice!==null && minMaxState.maxPrice!==null ){

            fetch(`http://localhost:8080/e-shop/min-max-prices/${minMaxState.minPrice}-${minMaxState.maxPrice}`,requestOptions)
                .then(response => {
                    return response.json();
                })
                .then(data => {
                    setChangeProducts(data);
                });

        }

    }

    useEffect(
        ()=>{
            passPriceValues();
        },[minMaxState]
    )



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

                        {brandsNamesList.map((item, index) => (
                            // <div key={index}>
                            //
                            //     <input value={item} type="checkbox" onChange={handleCheck} />
                            //     <span>{item}</span>
                            // </div>

                            <label key={item} className="custom-control custom-checkbox">
                            <input className="custom-control-input"
                                   value={item} type="checkbox" onClick={handleCheck}
                            />
                                <div className="custom-control-label">
                                     {item}
                                </div>
                            </label>



                            ))}


                        {/*<label className="custom-control custom-checkbox">*/}
                        {/*    <input type="checkbox" className="custom-control-input"/>*/}
                        {/*    <div className="custom-control-label">ALCATEL-LUCENT*/}
                        {/*        <b className="badge badge-pill badge-light float-right">120</b></div>*/}
                        {/*</label>*/}
                        {/*<label className="custom-control custom-checkbox">*/}
                        {/*    <input type="checkbox" className="custom-control-input"/>*/}
                        {/*    <div className="custom-control-label">KONFTEL*/}
                        {/*        <b className="badge badge-pill badge-light float-right">15</b></div>*/}
                        {/*</label>*/}

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

                        <div className="input-group">
                            <input className="form-control"
                                   placeholder={"€"+minmaxPrice[0]}
                                   type="number" min={minmaxPrice[0]}
                                   max={minmaxPrice[1]}
                                   value={minMaxState.minPrice}
                                   name="minPrice"
                                   onChange={ event => {handlePriceChange(event);passPriceValues(event)}
                                   }
                            />

                            <div className="input-group-prepend">
                                <span className="input-group-text">-</span>
                            </div>

                            <input className="form-control"
                                   placeholder={"€"+minmaxPrice[1]}
                                   type="number" min={minmaxPrice[0]}
                                   max={minmaxPrice[1]}
                                   value={minMaxState.maxPrice}
                                   name="maxPrice"
                                   onChange={ event => {handlePriceChange(event);passPriceValues(event)}
                                   }
                            />

                        </div>


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