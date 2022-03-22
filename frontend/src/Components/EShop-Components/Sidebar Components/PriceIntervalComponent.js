import {useEffect, useState} from "react";


export default function PriceIntervalComponent({setChangeProducts, minmaxPrice}) {

    const [minMaxState, setMinMaxState] = useState({
        minPrice: "",
        maxPrice: "",
    })


    const handlePriceChange = e => {
        e.preventDefault();

        setMinMaxState(
            {...minMaxState, [e.target.name]: e.target.value,}
        )
    }


    function passPriceValues() {

        const requestOptions = {
            method: 'GET',
            headers: {Accept: 'application/json', 'Content-Type': 'application/json'},
        };

        if (minMaxState.minPrice == null && minMaxState.maxPrice == null) {

            fetch(`http://localhost:8080/e-shop/min-max-prices/${minmaxPrice[0]}-${minmaxPrice[1]}`, requestOptions)
                .then(response => {
                    return response.json();
                })
                .then(data => {
                    setChangeProducts(data);
                });
        } else if (minMaxState.minPrice !== null && minMaxState.maxPrice !== null) {

            fetch(`http://localhost:8080/e-shop/min-max-prices/${minMaxState.minPrice}-${minMaxState.maxPrice}`, requestOptions)
                .then(response => {
                    return response.json();
                })
                .then(data => {
                    setChangeProducts(data);
                });
        }

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
                       value={minMaxState.minPrice}
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
                       value={minMaxState.maxPrice}
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