import {useEffect, useState} from "react";

import {MIN_MAX_PRICES} from "../ProductListing Components/Products";
import {useAtom} from "jotai";

export default function PriceIntervalComponent({setChangeProducts, minmaxPrice}) {

    const [minMaxState, setMinMaxState] = useState({
        minPrice: "",
        maxPrice: "",
    })

    const [minMaxAtom,setMinMaxAtom] = useAtom(MIN_MAX_PRICES);

    // console.log("minMaxAtom: "+minMaxAtom);
    // console.log("minMaxAtom (min): "+minMaxAtom[0]);
    // console.log("minMaxAtom (max): "+minMaxAtom[1]);

    function handlePriceChange(e){
        e.preventDefault();

        setMinMaxState(
            {...minMaxState, [e.target.name]: e.target.value,}
        )
        // console.log("minMaxState (@handlePriceChange()): "+ minMaxState.minPrice + " - " + minMaxState.maxPrice);

        if(minMaxState.minPrice === null && minMaxState.maxPrice === null){
            setMinMaxState({minPrice: minMaxAtom[0]});
            setMinMaxState({minPrice: minMaxAtom[1]});
        }
        //  if(minMaxState.minPrice === '' && minMaxState.maxPrice === ''){
        //
        //     if(minMaxState.minPrice === ''){
        //         setMinMaxState({minPrice: minMaxAtom[0]});
        //     }
        //     else if(minMaxState.maxPrice === ''){
        //         setMinMaxState({minPrice: minMaxAtom[1]});
        //     }
        //
        // }

    }


    function passPriceValues(event) {

        const requestOptions = {
            method: 'GET',
            headers: {Accept: 'application/json', 'Content-Type': 'application/json'},
        };
        // console.log("minMaxState (@passPriceValues()): "+ minMaxState.minPrice + " - " + minMaxState.maxPrice);

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
            // console.log("minMaxState (@useEffect): "+ minMaxState.minPrice + " - " + minMaxState.maxPrice);
        }, [minMaxState]
    )


    return (
        <>

            <div className="input-group">
                <input className="form-control"
                       placeholder={"€" + minmaxPrice[0]}
                       type="number" min={minmaxPrice[0]}
                       max={minmaxPrice[1]}
                       value={minMaxState.minPrice}
                       name="minPrice"
                       onChange={event => {
                           passPriceValues(event)
                           handlePriceChange(event);
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
                       value={minMaxState.maxPrice}
                       name="maxPrice"
                       onChange={event => {
                           passPriceValues(event)
                           handlePriceChange(event);
                       }
                       }
                />

            </div>

        </>
    );

}