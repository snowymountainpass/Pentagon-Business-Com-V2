import CompanyNameLogo from "./Navbar Components/CompanyNameLogo";
import SearchBar from "./Navbar Components/SearchBar";
import ShoppingCart from "./Navbar Components/ShoppingCart";
import RegistrationLogin from "./Navbar Components/RegistrationLogin";


export default function Navbar(){

    return(
        <header className="section-header">
            <section className="header-main border-bottom">
                <div className="container">
                    <div className="row align-items-center">
                        <CompanyNameLogo/>

                        <SearchBar/>

                        <div className="col-lg-4 col-sm-6 col-12">
                            <div className="widgets-wrap float-md-right">

                                <ShoppingCart/>

                                <RegistrationLogin/>

                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </header>
    );

}