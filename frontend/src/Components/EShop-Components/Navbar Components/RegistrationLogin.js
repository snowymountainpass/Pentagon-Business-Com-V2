import {Link} from "react-router-dom";
import {useEffect, useState} from "react";

export default function RegistrationLogin({loginToken}) {

    const [loggedInState, setloggedInState] = useState(loginToken ? true : false);
    const [text, setText] = useState(loggedInState ? "Sign Out" : "Sign In");
    const [pageLink, setPageLink] = useState(loggedInState ? "/e-shop" : "/e-shop/login");

    function logout() {
        setText("Sign In");
        setPageLink("/e-shop/login");
        setloggedInState(!loggedInState);
        localStorage.clear();
    }

    function login() {
        setText("Sign Out");
        setPageLink("/e-shop");
        setloggedInState(!loggedInState);
    }

    useEffect(()=>{

        if(loggedInState){
            setText("Sign Out");
            setPageLink("/e-shop");
        }else {
            setText("Sign In");
            setPageLink("/e-shop/login");
            setloggedInState(!loggedInState);
        }

    },[])

    return (
        <div className="widget-header icontext text-white">
            <a href="#" className="icon icon-sm rounded-circle border"><i className="fa fa-user"/></a>
            <div className="text text-white-50">
                <span className="text-muted">Welcome!</span>
                <div>

                    <div onClick={loggedInState ? logout : login}>
                        <p>{`loggedinState:${loggedInState}`}</p>
                        <Link to={pageLink}>{text}</Link>
                    </div>
                    <div><Link to="/e-shop/register">Register</Link></div>
                </div>
            </div>
        </div>
    );

}


