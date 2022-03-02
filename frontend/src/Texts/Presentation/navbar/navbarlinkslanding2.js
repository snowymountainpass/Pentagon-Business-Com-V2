
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
  // socials: [
  //   {
  //     icon: "facebook",
  //     text: "Share on Facebook",
  //     link: "https://www.facebook.com/CreativeTim",
  //   },
  //   {
  //     icon: "instagram",
  //     text: "Follow on Instagram",
  //     link: "https://www.instagram.com/creativetimofficial/",
  //   },
  //   {
  //     icon: "twitter",
  //     text: "Tweet on Twitter",
  //     link: "https://twitter.com/CreativeTim",
  //   },
  //   {
  //     icon: "github",
  //     text: "Star on Github",
  //     link: "https://github.com/creativetimofficial",
  //   },
  // ],
  rightLinks: [
    {
      href: "/e-shop",
      children: "E-Shop",
    },
    {
      href: "/",
      children: "About Us",
    },
    // {
    //   dropdown: true,
    //   ...dropdownnavbar,
    // },
  ],
};
export default textProps;
