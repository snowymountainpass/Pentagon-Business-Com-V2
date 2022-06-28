
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
                </div>
            </header>

            <form className="pb-3">
                <div className="input-group">
                    <input
                        id = 'searchBar'
                        type="text"
                        className="form-control rounded"
                        placeholder="Search"
                        onChange={event => searchInputChange(event)}
                        onPaste={event => searchInputChange(event)}
                    />
                </div>
            </form>
        </>


    );

}