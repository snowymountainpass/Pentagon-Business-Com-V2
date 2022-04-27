export default function ProductCategoryComponent({setChangeProducts, categoriesList}) {


    function handleCategoryClick(event) {
        event.preventDefault();
        let productCategory = event.target.value;

        const requestOptions = {
            method: 'GET',
            headers: {Accept: 'application/json', 'Content-Type': 'application/json'},

        };

        fetch(`http://localhost:8080/e-shop/` + productCategory, requestOptions)
            .then(response => {
                return response.json();
            })
            .then(data => {
                setChangeProducts(data);
            });

    }


    return (
        <>
            <ul className="list-menu">
                {
                    categoriesList.map(
                        (item, index) =>
                            (
                                <label key={index} className="custom-control custom-radio">
                                    <input type="radio"
                                           name="myfilter_radio"
                                           className="custom-control-input"
                                           value={item}
                                           defaultChecked={item.value === "ALL TYPES"}
                                           onChange={
                                               event => {
                                                   handleCategoryClick(event);
                                               }
                                           }
                                    />
                                    <div className="custom-control-label">{item}</div>
                                </label>

                            )
                    )
                }

                <label key={"all"} className="custom-control custom-radio">
                    <input type="radio"
                           name="myfilter_radio"
                           className="custom-control-input"
                           value={"ALL TYPES"}
                           onChange={
                               event => {
                                   handleCategoryClick(event);
                               }
                           }
                    />
                    <div className="custom-control-label">{"ALL TYPES"}</div>
                </label>
            </ul>


        </>
    );

}