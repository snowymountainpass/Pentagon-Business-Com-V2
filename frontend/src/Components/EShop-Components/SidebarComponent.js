// import {useSearchParams} from "react-router-dom";
// const [searchParams, setSearchParams] = useSearchParams();


import {useState} from "react";
import Checkbox from "../EShop-Components/Checkbox";

export default function SidebarComponent({products,setChangeProducts}  ){

    const OPTIONS = ["Alcatel-Lucent", "Konftel"];

    function handleCategoryClick(event){
        event.preventDefault();
        let productCategory = event.target.id;
        console.log(productCategory);

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

    const [state,setState] = useState(
        {
            checkboxes: OPTIONS.reduce(
                (options, option) => ({
                    ...options,
                    [option]: false
                }),
                {}
            )
        }

    );

    const handleCheckboxChange = changeEvent => {
        const { name } = changeEvent.target;

        setState(prevState => ({
            checkboxes: {
                ...prevState.checkboxes,
                [name]: !prevState.checkboxes[name]
            }
        }));
    };

    const handleFormSubmit = formSubmitEvent => {
        formSubmitEvent.preventDefault();

        Object.keys(state.checkboxes)
            .filter(checkbox => state.checkboxes[checkbox])
            .forEach(checkbox => {
                console.log(checkbox, "is selected.");
            });
    };

    const createCheckbox = option => (
        <Checkbox
            label={option}
            isSelected={state.checkboxes[option]}
            onCheckboxChange={handleCheckboxChange}
            key={option}
        />
    );

    const createCheckboxes = () => OPTIONS.map(createCheckbox);

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
                        <div className="card-body" onChange={handleFormSubmit}>
                            {createCheckboxes()}
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
                            <i className="icon-control fa fa-chevron-down"></i>
                            <h6 className="title">Price range </h6>
                        </a>
                    </header>
                    <div className="filter-content collapse show" id="collapse_3">
                        <div className="card-body">
                            <input type="range" className="custom-range" min="0" max="100000" name=""/>
                            <div className="form-row">
                                <div className="form-group col-md-6">
                                    <label>Min</label>
                                    <input className="form-control" placeholder="$0" type="number"/>
                                </div>
                                <div className="form-group text-right col-md-6">
                                    <label>Max</label>
                                    <input className="form-control" placeholder="$1,0000" type="number"/>
                                </div>
                            </div>
                            {/*<button className="btn btn-block btn-primary">Apply</button>*/}
                        </div>
                    </div>
                </article>

                {/*<article className="filter-group">*/}
                {/*    <header className="card-header">*/}
                {/*        <a href="#" data-toggle="collapse" data-target="#collapse_4" aria-expanded="true" className="">*/}
                {/*            <i className="icon-control fa fa-chevron-down"></i>*/}
                {/*            <h6 className="title">Sizes </h6>*/}
                {/*        </a>*/}
                {/*    </header>*/}
                {/*    <div className="filter-content collapse show" id="collapse_4">*/}
                {/*        <div className="card-body">*/}
                {/*            <label className="checkbox-btn">*/}
                {/*                <input type="checkbox"/>*/}
                {/*                <span className="btn btn-light"> XS </span>*/}
                {/*            </label>*/}
                {/*            <label className="checkbox-btn">*/}
                {/*                <input type="checkbox"/>*/}
                {/*                <span className="btn btn-light"> SM </span>*/}
                {/*            </label>*/}
                {/*            <label className="checkbox-btn">*/}
                {/*                <input type="checkbox"/>*/}
                {/*                <span className="btn btn-light"> LG </span>*/}
                {/*            </label>*/}
                {/*            <label className="checkbox-btn">*/}
                {/*                <input type="checkbox"/>*/}
                {/*                <span className="btn btn-light"> XXL </span>*/}
                {/*            </label>*/}
                {/*        </div>*/}
                {/*    </div>*/}
                {/*</article>*/}

                <article className="filter-group">
                    <header className="card-header">
                        <a  data-toggle="collapse" data-target="#collapse_5" aria-expanded="false" className="">
                            <i className="icon-control fa fa-chevron-down"></i>
                            <h6 className="title">Delivery Time </h6>
                        </a>
                    </header>
                    <div className="filter-content collapse in" id="collapse_5">
                        <div className="card-body">
                            {/*<label className="custom-control custom-radio">*/}
                            {/*    <input type="radio" name="myfilter_radio" checked="" className="custom-control-input"/>*/}
                            {/*    <div className="custom-control-label">Any condition</div>*/}
                            {/*</label>*/}
                            <label className="custom-control custom-radio">
                                <input type="radio" name="myfilter_radio" className="custom-control-input"/>
                                <div className="custom-control-label">In stock</div>
                            </label>
                            <label className="custom-control custom-radio">
                                <input type="radio" name="myfilter_radio" className="custom-control-input"/>
                                <div className="custom-control-label">14 Days</div>
                            </label>
                            {/*<label className="custom-control custom-radio">*/}
                            {/*    <input type="radio" name="myfilter_radio" className="custom-control-input"/>*/}
                            {/*    <div className="custom-control-label">Very old</div>*/}
                            {/*</label>*/}
                        </div>
                    </div>
                </article>

            </div>
            <button className="btn btn-block btn-primary mt-2">Apply</button>
        </aside>

    );

}