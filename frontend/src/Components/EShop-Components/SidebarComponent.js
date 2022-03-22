import DeliveryTimeComponent from "./Sidebar Components/DeliveryTimeComponent";
import PriceIntervalComponent from "./Sidebar Components/PriceIntervalComponent";
import BrandSelectionComponent from "./Sidebar Components/BrandSelectionComponent";
import ProductCategoryComponent from "./Sidebar Components/ProductCategoryComponent";

export default function SidebarComponent({setChangeProducts, categoriesList, brandsList, minmaxPrice}) {

    return (

        <aside className="col-md-3">

            <div className="card">
                <article className="filter-group">
                    <header className="card-header">
                        <a data-toggle="collapse" data-target="#collapse_1" aria-expanded="true" className="">
                            <i className="icon-control fa fa-chevron-down"/>
                            <h6 className="title">Product type</h6>
                        </a>
                    </header>
                    <div className="filter-content collapse show" id="collapse_1">
                        <div className="card-body">

                            <ProductCategoryComponent
                                setChangeProducts={setChangeProducts}
                                categoriesList={categoriesList}
                            />

                        </div>
                    </div>
                </article>

                <article className="filter-group">
                    <header className="card-header">
                        <a data-toggle="collapse" data-target="#collapse_2" aria-expanded="true" className="">
                            <i className="icon-control fa fa-chevron-down"/>
                            <h6 className="title">Brands</h6>
                        </a>
                    </header>
                    <div className="filter-content collapse show" id="collapse_2">
                        <div className="card-body">

                            <BrandSelectionComponent
                                setChangeProducts={setChangeProducts}
                                brandsList={brandsList}
                            />

                        </div>
                    </div>
                </article>

                <article className="filter-group">
                    <header className="card-header">
                        <a data-toggle="collapse" data-target="#collapse_3" aria-expanded="true" className="">
                            <i className="icon-control fa fa-chevron-down"/>
                            <h6 className="title">Price range </h6>
                        </a>
                    </header>
                    <div className="filter-content collapse show" id="collapse_3">
                        <div className="card-body">

                            <PriceIntervalComponent
                                setChangeProducts={setChangeProducts}
                                minmaxPrice={minmaxPrice}
                            />


                        </div>
                    </div>
                </article>

                <article className="filter-group">
                    <header className="card-header">
                        <a data-toggle="collapse" data-target="#collapse_5" aria-expanded="false" className="">
                            <i className="icon-control fa fa-chevron-down"/>
                            <h6 className="title">Delivery Time </h6>
                        </a>
                    </header>
                    <div className="filter-content collapse in" id="collapse_5">
                        <div className="card-body">
                            <DeliveryTimeComponent
                                setChangeProducts={setChangeProducts}
                            />
                        </div>
                    </div>
                </article>

            </div>
            {/*<button className="btn btn-block btn-primary mt-2">Apply</button>*/}
        </aside>

    );

}