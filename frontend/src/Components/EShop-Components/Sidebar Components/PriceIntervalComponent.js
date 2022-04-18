import {useEffect, useState} from "react";

import {MIN_MAX_PRICES} from "../ProductListing Components/Products";
import {useAtom} from "jotai";

export default function PriceIntervalComponent({setChangeProducts, minmaxPrice}) {

    const [minMaxAtom,setMinMaxAtom] = useAtom(MIN_MAX_PRICES);

    const [minMaxState, setMinMaxState] = useState({
        minPrice: minMaxAtom[0],
        maxPrice: minMaxAtom[1],
    })



    function handlePriceChange(e){
        e.preventDefault();

        setMinMaxState(
            {...minMaxState, [e.target.name]: e.target.value,}
        )

        if(minMaxState.minPrice === null && minMaxState.maxPrice === null){
            setMinMaxState({minPrice: minMaxAtom[0]});
            setMinMaxState({maxPrice: minMaxAtom[1]});
        } // conditie buna



    }

    function passPriceValues() {

        const requestOptions = {
            method: 'GET',
            headers: {Accept: 'application/json', 'Content-Type': 'application/json'},
        };

        fetch(`http://localhost:8080/e-shop/min-max-prices/${minMaxState.minPrice}-${minMaxState.maxPrice}`, requestOptions)
            .then(response => {
                console.log("else cond: "+response.status);
                return response.json();
            })
            .then(data => {
                setChangeProducts(data);
            });

        console.log("minMaxState (@handlePriceChange()): "+ minMaxState.minPrice + " - " + minMaxState.maxPrice);

    }

    useEffect(
        () => {
            passPriceValues();
        }, [minMaxState]
    )


    return (
        <>

            <div className="input-group">
                <input className="form-control"
                       placeholder={"€" + minmaxPrice[0]}
                       type="number" min={minmaxPrice[0]}
                       max={minmaxPrice[1]}
                       value={minMaxState.minPrice !== null ? minMaxState.minPrice : minMaxAtom[0] }
                       name="minPrice"
                       onChange={event => {
                           handlePriceChange(event);
                           passPriceValues(event)
                       }
                       }
                />

                <div className="input-group-prepend">
                    <span className="input-group-text">-</span>
                </div>

                <input className="form-control"
                       placeholder={"€" + minmaxPrice[1]}
                       type="number" min={minmaxPrice[0]}
                       max={minmaxPrice[1]}
                       value={minMaxState.maxPrice !== null ? minMaxState.maxPrice : minMaxAtom[1] }
                       name="maxPrice"
                       onChange={event => {
                           handlePriceChange(event);
                           passPriceValues(event)
                       }
                       }
                />

            </div>

        </>
    );

}