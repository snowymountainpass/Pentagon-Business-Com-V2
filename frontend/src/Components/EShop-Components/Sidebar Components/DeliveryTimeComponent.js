
export default function DeliveryTimeComponent({setChangeProducts}){

    // const [isChecked, setIsChecked] = useState(false);

    function handleDeliveryClick(event){
        event.preventDefault();

        const requestOptions = {
            method: 'GET',
            headers: {Accept: 'application/json', 'Content-Type': 'application/json'},
        };

        console.log(event.target.checked);

        if(event.target.checked){
            fetch(`http://localhost:8080/e-shop/delivery-time/`+event.target.value,requestOptions)
                .then(response => {
                    return response.json();
                })
                .then(data => {
                    setChangeProducts(data);
                });
        }

    }


    return(
        <div>
            <label className="custom-control custom-radio">
                <input type="radio"
                       name="myfilter_radio"
                       className="custom-control-input"
                       value="instock"
                       onChange={event => {
                           handleDeliveryClick(event);
                       }}
                />
                <div className="custom-control-label">Local Stock (1-2 days)</div>
            </label>
            <label className="custom-control custom-radio">
                <input type="radio"
                       name="myfilter_radio"
                       className="custom-control-input"
                       value="14days"
                       onChange={event => {
                           handleDeliveryClick(event);
                       }}
                />
                <div className="custom-control-label">External Stock (7-14 Days)</div>
            </label>
            <label className="custom-control custom-radio">
                <input type="radio"
                       name="myfilter_radio"
                       className="custom-control-input"
                       value="all"
                       onChange={event => {
                           handleDeliveryClick(event);
                       }}
                />
                <div className="custom-control-label">All</div>
            </label>
        </div>


    );

}