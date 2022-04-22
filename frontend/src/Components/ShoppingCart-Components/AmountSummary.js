// import paymentsImg from "../../../public/assets/images/Pentagon Assets/payments-UserAccount-AL-Background.png";

export default function AmountSummary({totalAmount,discount}){

    function calculateAmount(){
        console.log("@AmountSummary - totalAmount: " + totalAmount);

    }
    calculateAmount();
    return(
        <div className="card">
            <div className="card-body">
                <dl className="dlist-align">
                    <dt>Total price:</dt>
                    <dd className="text-right">EUR {totalAmount}</dd>
                </dl>
                <dl className="dlist-align">
                    <dt>Discount:</dt>
                    <dd className="text-right">EUR {discount}</dd>
                </dl>
                <dl className="dlist-align">
                    <dt>Total:</dt>
                    <dd className="text-right  h5"><strong>€{totalAmount-discount}</strong></dd>
                </dl>
                <hr/>
                <p className="text-center mb-3">
                    {/*<img src="assets/images/misc/payments.png" height="26"/>*/}
                    {/*<img src="../public/assets/images/misc/payments-UserAccount-AL-Background.png" height="26" alt={"payments-UserAccount-AL-Background.png"}/>*/}
                    {/*<img src={process.env.PUBLIC_URL + "/images/Pentagon Assets/payments-UserAccount-AL-Background.png"} height="26" alt={"payments-UserAccount-AL-Background.png"}/>*/}


                </p>

            </div>
        </div>

    );

}