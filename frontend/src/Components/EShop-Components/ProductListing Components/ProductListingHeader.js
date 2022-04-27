
export default function ProductListingHeader({products,setChangeQuery}) {


    function searchInputChange(event){

        event.preventDefault();

        if(event.target.value!=="" || event.target.value!=null){
            setChangeQuery(event.target.value);
        }

    }

    return (
        <>
            <header className="border-bottom mb-4 pb-3">
                <div className="form-inline">
                    <span className="mr-md-auto">{products.length} Item(s) found </span>

                    <select className="mr-2 form-inline" data-width="auto">
                        <option>Price ↑</option>
                        <option>Price ↓</option>
                        <option>Best Sellers</option>
                        <option>Name (A-Z)</option>
                        <option>Name (Z-A)</option>
                    </select>
                    <div className="btn-group">
                        <a href="#" className="btn btn-outline-secondary active" data-toggle="tooltip"
                           title="List view">
                            <i className="fa fa-bars"></i></a>
                        <a href="#" className="btn  btn-outline-secondary" data-toggle="tooltip" title="Grid view">
                            <i className="fa fa-th"></i></a>
                    </div>

                </div>
            </header>

            <form className="pb-3">
                <div className="input-group">
                    <input
                        id = 'searchBar'
                        type="text"
                        className="form-control rounded-left"
                        placeholder="Search"
                        onChange={event => searchInputChange(event)}
                        onPaste={event => searchInputChange(event)}
                    />
                </div>
            </form>
        </>


    );

}