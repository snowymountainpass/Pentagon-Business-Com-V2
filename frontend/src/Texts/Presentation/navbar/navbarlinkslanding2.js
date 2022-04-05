
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

  rightLinks: [
    {
      href: "/e-shop",
      children: "E-Shop",
    },
    {
      href: "mailto:office@pentagon.ro",
      children: "About Us",
    },
    // {
    //   dropdown: true,
    //   ...dropdownnavbar,
    // },
  ],
};
export default textProps;
