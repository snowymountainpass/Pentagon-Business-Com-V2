export default function AmountSummary({totalAmount,discount}){

    return(
        <div className="card">
            <div className="card-body">
                <dl className="dlist-align">
                    <dt>Total price:</dt>
                    <dd className="text-right">EUR {totalAmount?totalAmount:""}</dd>
                </dl>
                <dl className="dlist-align">
                    <dt>Discount:</dt>
                    <dd className="text-right">EUR {discount?discount:""}</dd>
                </dl>
                <dl className="dlist-align">
                    <dt>Total:</dt>
                    <dd className="text-right  h5"><strong>€{totalAmount && discount ? totalAmount-discount : ""}</strong></dd>
                </dl>
                <hr/>
            </div>
        </div>

    );

}