
// import dropdownnavbar from "../../misc/dropdowns/dropdownnavbar";

const textProps = {
  color: "dark",
  type: "fixed",
  logoImage:
   require("../../../Assets/img/Pentagon Assets/pentagon logo mic.jpg"),
  logoText: "Pentagon Business Com",
  logoLink: {
    to: "/",
  },

  leftLinks:[
    {
      href: "/e-shop",
      children: "E-Shop",},
    {
      href: "mailto:office@pentagon.ro",
      children: "About Us",
    }
  ],

  rightLinks: [
    {
      href: "",
      children: <i className="fa fa-shopping-cart"/>,
    },
    {
      href: "",
      children: <i className="fa fa-user"/>
    },
    {
      href: "",
      children: "Sign In",
    },


    // {
    //   dropdown: true,
    //   ...dropdownnavbar,
    // },
  ],
};
export default textProps;
