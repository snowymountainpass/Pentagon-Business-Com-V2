const textProps = {
  // image: require("assets/img/ct-logo-text-black.png").default,
  // image: require("../../../Assets/img/Pentagon Assets/pentagon logo.jpg").default,
  image: require("../../../Assets/img/Pentagon Assets/pentagon logo.jpg"),
  address: "Str. Antiaeriana, Bucharest, Romania",
  phone: "tel: +4 02 13 21 38 08",
  invoice: {
    text: "Invoice no",
    id: "#0453119",
  },

  invoiceDate: {
    text: "Invoice Date:",
    date: "06/03/2021",
  },
  dueDate: {
    text: "Expiration Date:",
    date: "11/03/2021",
  },
  footerTitle: "Thank you for buying our products!",
  footerDescriprion: "To finalize your order, please send this invoice to office@pentagon.ro with proof of payment (bank statement)!",
  contact: [
    {
      type: "email:",
      info: "office@pentagon.ro",
    },
  ],
  totalCount: {
    text: "Total",
    info: "$750",
  },
  tableHead: ["Item", "Qty", "Price", "Amount"],
  tableBody: [
    ["Premium Support", "1", "$9.00", "$9.00"],
    ["Notus PRO React", "2", "$150.00", "$300.00"],
    ["Parts for service", "1", "$89.00", "$89.00"],
  ],
};
export default textProps;
