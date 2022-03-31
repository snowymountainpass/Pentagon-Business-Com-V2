import {Link} from "react-router-dom";

export default function RegistrationLogin({setToken}){

    return(
        <div className="widget-header icontext text-white">
            <a href="#" className="icon icon-sm rounded-circle border"><i className="fa fa-user"/></a>
            <div className="text text-white-50" >
                <span className="text-muted">Welcome!</span>
                <div>
                    <Link to="/e-shop/login">Sign in</Link>
                    <Link to="/e-shop/register">Register</Link>

                </div>
            </div>
        </div>
    );

}