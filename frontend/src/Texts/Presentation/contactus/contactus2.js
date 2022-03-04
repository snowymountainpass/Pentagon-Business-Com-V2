import React from "react";

import infoareaicon from "../infoarea/infoareaicon";

// "assets/img/illustrations/bg_contactus3.svg"
const textProps = {
  image: require("../../../Assets/img/Pentagon Assets/ALE-City.png"), // DE PUS IMAGINE RELEVANTA
  heading2: {
    color: "lightBlue",
    // subtitle: "We are here",
    title: "Are you looking for answers?",
    description:
      "Discover what Pentagon Business Com can do for you. If you would like to know more about how the products, solutions and services we offer will transform the way you work and communicate",
    alignment: "center",
  },
  button: {
    color: "lightBlue",
    children: (
      <>
        <a href="mailto:office@pentagon.ro">
          <i className="mr-1 fas fa-comment" /> Contact Us Today
        </a>
      </>
    ),
  },
  infoAreas: [
    {
      ...infoareaicon,
      color: "lightBlue",
    },
    {
      icon: "fas fa-envelope",
      color: "lightBlue",
      title: "Email",
      description: "office@pentagon.ro",
    },
    {
      icon: "fas fa-mobile-alt",
      color: "lightBlue",
      title: "Technical Department",
      description: "+4021 3213808",
    },
    {
      icon: "fas fa-user-circle",
      color: "lightBlue",
      title: "Sales Department",
      description: "+4021 3719721",
    },
  ],
};
export default textProps;
