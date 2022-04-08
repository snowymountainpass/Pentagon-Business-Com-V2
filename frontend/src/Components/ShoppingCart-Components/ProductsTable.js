import ProductRow from "./ProductRow";
import {Link} from "react-router-dom";


export default function ProductsTable({setTotalAmount}){

    return(

        <div className="card">

            <table className="table table-borderless table-shopping-cart">
                <thead className="text-muted">
                <tr className="small text-uppercase">
                    <th scope="col">Product</th>
                    <th scope="col" width="120">Quantity</th>
                    <th scope="col" width="120">Price</th>
                    <th scope="col" className="text-right" width="200"/>
                </tr>
                </thead>

                {/*TABLE BODY*/}
                <tbody>
                <ProductRow
                name={"product 1"}
                description={"product 1 description"}
                price={10}
                quantity={0}
                setTotalAmount={setTotalAmount}
                />
                </tbody>
                {/*TABLE BODY*/}

            </table>

            <div className="card-body border-top">
                <a href="#" className="btn btn-primary float-md-right"> Make Purchase <i className="fa fa-chevron-right"/>
                </a>
                {/*<a href="/e-shop" className="btn btn-light"> <i className="fa fa-chevron-left"/> Continue shopping </a>*/}
                <Link to="/e-shop" className="btn btn-light"> <i className="fa fa-chevron-left"/> Continue shopping </Link>
            </div>
        </div>

    );
}