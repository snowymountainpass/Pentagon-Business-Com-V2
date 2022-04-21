// import paymentsImg from "../../../public/assets/images/Pentagon Assets/payments-img.png";

export default function AmountSummary({totalAmount,discount}){

    function calculateAmount(){
        console.log("@AmountSummary - totalAmount: " + totalAmount);
        // return totalAmount.reduce( (accumulator,current) => accumulator+current );
        // returns the sum of the values in the totalAmount array

    }
    // const totalAmountInCart = calculateAmount();
    calculateAmount();
    return(
        <div className="card">
            <div className="card-body">
                <dl className="dlist-align">
                    <dt>Total price:</dt>
                    <dd className="text-right">EUR {10}</dd>
                </dl>
                <dl className="dlist-align">
                    <dt>Discount:</dt>
                    <dd className="text-right">EUR {discount}</dd>
                </dl>
                <dl className="dlist-align">
                    <dt>Total:</dt>
                    <dd className="text-right  h5"><strong>€{10-discount}</strong></dd>
                </dl>
                <hr/>
                <p className="text-center mb-3">
                    {/*<img src="assets/images/misc/payments.png" height="26"/>*/}
                    {/*<img src="../public/assets/images/misc/payments-img.png" height="26" alt={"payments-img.png"}/>*/}
                    {/*<img src={process.env.PUBLIC_URL + "/images/Pentagon Assets/payments-img.png"} height="26" alt={"payments-img.png"}/>*/}


                </p>

            </div>
        </div>

    );

}