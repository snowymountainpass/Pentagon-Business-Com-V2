

export default function AmountSummary({totalAmount,discount}){


    return(
        <div className="card">
            <div className="card-body">
                <dl className="dlist-align">
                    <dt>Total price:</dt>
                    <dd className="text-right">USD {totalAmount}</dd>
                </dl>
                <dl className="dlist-align">
                    <dt>Discount:</dt>
                    <dd className="text-right">USD {discount}</dd>
                </dl>
                <dl className="dlist-align">
                    <dt>Total:</dt>
                    <dd className="text-right  h5"><strong>${totalAmount-discount}</strong></dd>
                </dl>
                <hr/>
                <p className="text-center mb-3">
                    {/*<img src="assets/images/misc/payments.png" height="26"/>*/}
                    <img src="../public/assets/images/misc/payments.png" height="26" alt={"payments.png"}/>
                </p>

            </div>
        </div>

    );

}