import ProductListingHeader from "./ProductListingHeader";
import ProductsListing from "./ProductsListing";
import ProductsListingPagination from "./ProductsListingPagination";
import SidebarComponent from "./SidebarComponent";

export default function Products(){

    return(

        <section className="section-content padding-y">
            <div className="container">
                <div className="row">

                    <SidebarComponent/>

                    <main className="col-md-9">
                        <ProductListingHeader/>

                        <ProductsListing/>

                        {/*<ProductsListingPagination/>*/}

                    </main>
                </div>
            </div>
        </section>

    );


}