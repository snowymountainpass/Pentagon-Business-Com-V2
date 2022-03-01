import infoareaicontitlelist from "../../../General/infoareas/infoareaicontitlelist";

const textProps = {
  heading3: {
    // color: "red",
    // subtitle: "Notus PRO",
    title: "Product Catalogue Title",
    description:
      "Description of Product Catalogue ( max 2 rows)",
    alignment: "center",
  },
  infoAreas: [
    { ...infoareaicontitlelist },
    {
      icon: "fas fa-money-bill-wave",
      color: "lightBlue",
      title: "Product Category 2",
      description:
        "Product Category 2 description",
      list: [
        {
          icon: "fas fa-check",
          text: "info 1",
        },
        {
          icon: "fas fa-check",
          text: "info 2",
        },
        {
          icon: "fas fa-check",
          text: "info 3",
        },
      ],
      link: {
        children: "Go to e-shop",
        href: "/e-shop",
      },
    },
    {
      icon: "fas fa-first-aid",
      color: "lightBlue",
      title: "Product Category 3",
      description: "Product Category 3 description",
      list: [
        {
          icon: "fas fa-check",
          text: "info 1",
        },
        {
          icon: "fas fa-check",
          text: "info 2",
        },
        {
          icon: "fas fa-check",
          text: "info 3",
        },
      ],
    },
    {
      icon: "fas fa-laptop-code",
      color: "lightBlue",
      title: "Product Category 4",
      description: "Product Category 4 description",
      list: [
        {
          icon: "fas fa-check",
          text: "info 1",
        },
        {
          icon: "fas fa-check",
          text: "info 2",
        },
        {
          icon: "fas fa-check",
          text: "info 3",
        },
      ],
    },
  ],
};

export default textProps;
