import {useState} from "react";

export default function Coupon() {

    const codesList = ["50%off", "60%off", "70%off"]

    const [discountCode, setDiscountCode] = useState("");

    function checkIfValidCode() {

        if (codesList.includes(discountCode)) {
            console.log(discountCode + " is a valid code!");
        }


    }
    return (
        <div className="card mb-3">
            <div className="card-body">
                <div className="form-group">
                    <label>Have coupon?</label>
                    <div className="input-group">
                        <input type="text" className="form-control" name="" placeholder="Coupon code"
                               onChange={event => setDiscountCode(event.target.value)}
                        />
                        <span className="input-group-append">
                                <button  className="btn btn-primary"
                                        onClick={checkIfValidCode}>Apply</button>
                            </span>
                    </div>
                </div>
            </div>
        </div>

    )
        ;

}