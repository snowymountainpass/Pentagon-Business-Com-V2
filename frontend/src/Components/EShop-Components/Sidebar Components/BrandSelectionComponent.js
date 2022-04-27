import {useState} from "react";


export default function BrandSelectionComponent({setChangeProducts, brandsList}) {

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

    function handleBrandClick(checkedBrandsList) {
        const requestOptions = {
            method: 'POST',
            headers: {Accept: 'application/json', 'Content-Type': 'application/json'},
            body: JSON.stringify(checkedBrandsList)
        };

        fetch(`http://localhost:8080/e-shop/brands`, requestOptions)
            .then(response => {
                return response.json();
            })
            .then(data => {
                setChangeProducts(data);
            });

    }

    return (
        <>
            {brandsList.map((item, index) => (
                <label key={index} className="custom-control custom-checkbox">
                    <input className="custom-control-input"
                           value={item} type="checkbox" onClick={handleCheck}
                    />
                    <div className="custom-control-label">
                        {item}
                    </div>
                </label>


            ))}
        </>
    );
}