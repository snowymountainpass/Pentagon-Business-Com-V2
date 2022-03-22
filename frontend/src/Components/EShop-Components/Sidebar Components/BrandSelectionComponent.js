import {useState} from "react";


export default function BrandSelectionComponent({setChangeProducts,brandsList}){

    const [checked, setChecked] = useState([]);

    const handleCheck = (event) => {
        let updatedList = [...checked];
        if (event.target.checked) {
            updatedList = [...checked, event.target.value];
        } else {
            updatedList.splice(checked.indexOf(event.target.value), 1);
        }
        setChecked(updatedList);

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

    return(
        <>
            {brandsList.map((item, index) => (
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


        </>
    );


}