

export default function ProductListTitle(){

    return(
        <section className="section-pagetop bg">
            <div className="container">
                <h2 className="title-page">Product Catalogue</h2>
                <nav>
                    <ol className="breadcrumb ">
                        <li className="breadcrumb-item"><a href="/">Home</a></li>
                        {/*<li className="breadcrumb-item"><a href="#">Best category</a></li>*/}
                        <li className="breadcrumb-item active" aria-current="page">Products Listing</li>
                    </ol>
                </nav>
            </div>
        </section>
    );

}