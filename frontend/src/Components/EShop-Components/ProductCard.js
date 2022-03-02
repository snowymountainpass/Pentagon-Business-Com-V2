
export default function ProductCard(props){

    return(
        <article className="card card-product-list">
            <div className="row no-gutters">
                <aside className="col-md-3">
                    <a href="#" className="img-wrap">
                        <span className="badge badge-danger"> NEW </span>
                        <img src={props.product.img}/>
                    </a>
                </aside>
                <div className="col-md-6">
                    <div className="info-main">
                        <a href="#" className="h5 title"> {props.product.productName} </a>
                        <div className="rating-wrap mb-3">
                            <ul className="rating-stars">
                                <li className="stars-active w-80">

                                    {[...Array(props.product.rating)].map((e, i) => <i className="fa fa-star" key={i}></i>)}

                                </li>
                                <li>
                                    
                                    {[...Array(10)].map((e, i) => <i className="fa fa-star" key={i}></i>)}

                                </li>
                            </ul>
                            <div className="label-rating">{`${props.product.rating}/10`}</div>
                        </div>

                        <p> {props.product.productDescription} </p>
                    </div>
                </div>
                <aside className="col-sm-3">
                    <div className="info-aside">
                        <div className="price-wrap">
                            <span className="price h5"> $140 </span>
                            <del className="price-old"> $198</del>
                        </div>
                        <p className="text-success">Free shipping</p>
                        <br/>
                        <p>
                            <a href="#" className="btn btn-primary btn-block"> Details </a>
                            <a href="#" className="btn btn-light btn-block"><i className="fa fa-shopping-cart"></i>
                                <span className="text">Add to Cart</span>
                            </a>
                        </p>
                    </div>
                </aside>
            </div>
        </article>

    );

}