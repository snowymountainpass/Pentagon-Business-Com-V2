
export default function SearchBar(){
    return(
        <div className="col-lg-6 col-sm-12">
            <form action="#" className="search">
                <div className="input-group w-100">
                    <input type="text" className="form-control" placeholder="Search"/>
                    <div className="input-group-append">
                        <button className="btn btn-primary" type="submit">
                            <i className="fa fa-search"></i>
                        </button>
                    </div>
                </div>
            </form>
        </div>
    );
}