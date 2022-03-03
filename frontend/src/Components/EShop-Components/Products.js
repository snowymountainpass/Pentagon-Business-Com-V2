import ProductListingHeader from "./ProductListingHeader";
import ProductsListing from "./ProductsListing";
// import ProductsListingPagination from "./ProductsListingPagination";
import SidebarComponent from "./SidebarComponent";
import {useEffect, useState} from "react";



export default function Products(){

    const [products,setProducts] = useState([]);

    const url = "http://localhost:8080/e-shop";
    useEffect(
        ()=>{
            fetch(url)
                .then(res => res.json())
                .then(data => setProducts(data))
        },[url] // [] => runs every time the url changes
    )
    // WORKS!! DO NOT DELETE!!!!





    // useEffect(()=>{
    //     const fetchData = async () =>{
    //         const res = await axios.get(`http://localhost:8080/e-shop?q=${query}`);
    //         setProducts(res.data);
    //     };
    //     if(query.length !==0) fetchData();
    // },[query])




    //
    // aceasta valoare o vom trimite la ProductListingHeader unde se va schimba in functie de search query value
    //acea valoare modificata o vom trimite si la ProductsListing si o vom folosi doar daca este diferita de "" (in caz contrar vom folosi products => to do TERNARY IF CLAUSE)

    // console.log(products);



    return(

        <section className="section-content padding-y">
            <div className="container">
                <div className="row">

                    <SidebarComponent/>

                    <main className="col-md-9">
                        <ProductListingHeader
                            products = {products}
                            setChangeProducts = {setProducts}
                        />

                        <ProductsListing products={products}/>

                        {/*<ProductsListingPagination/>*/}

                    </main>
                </div>
            </div>
        </section>

    );


}