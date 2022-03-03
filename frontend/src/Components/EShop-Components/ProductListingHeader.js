import {useEffect, useState} from "react";


export default function ProductListingHeader({products,setChangeProducts}){

    const [query,setQuery] = useState('');

    useEffect(() => {
        // POST request using fetch inside useEffect React hook
        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(query) //{ productName:  }
        };
        fetch('http://localhost:3000/e-shop/product-name', requestOptions)
            .then(response => response.json())
            .then(data => setChangeProducts(data));

    }, [query]);

    return(
        <>
            <header className="border-bottom mb-4 pb-3">
                <div className="form-inline">
                    <span className="mr-md-auto">{products.length} Item(s) found </span>

                    <select className="mr-2 form-inline" data-width="auto"> {/*data-width="auto" form-control*/}
                        <option>Price ↑</option>
                        <option>Price ↓</option>
                        <option>Best Sellers</option>
                        <option>Name (A-Z)</option>
                        <option>Name (Z-A)</option>
                    </select>
                    <div className="btn-group">
                        <a href="#" className="btn btn-outline-secondary active" data-toggle="tooltip" title="List view">
                            <i className="fa fa-bars"></i></a>
                        <a href="#" className="btn  btn-outline-secondary" data-toggle="tooltip" title="Grid view">
                            <i className="fa fa-th"></i></a>
                    </div>

                </div>
            </header>

            <form className="pb-3">
                <div className="input-group">
                    <input
                        type="text"
                        className="form-control rounded" //-left
                        placeholder="Search"
                        onChange={event => setQuery(event.target.value.toLowerCase())}

                    />
                    {/*<div className="input-group-append">*/}
                    {/*    <button className="btn btn-light" type="button"><i className="fa fa-search"></i></button>*/}
                    {/*</div>*/}
                </div>
            </form>
        </>




    );

}