

export default function ProductListingHeader(){

    return(

        <header className="border-bottom mb-4 pb-3">
            <div className="form-inline">
                <span className="mr-md-auto">32 Items found </span>
                <select className="mr-2 form-control">
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



    );

}