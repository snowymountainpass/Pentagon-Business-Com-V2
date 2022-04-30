const textProps = {
  inputs: [
    {
      width: 6,
      label: "First Name*",
      input: {
        type: "text",
        placeholder: "E.g. Smith",
      },
    },
    {
      width: 6,
      label: "Last Name*",
      input: {
        type: "text",
        placeholder: "E.g. John",
      },
    },
    {
      width: 6,
      label: "Email Address*",
      input: {
        type: "email",
        placeholder: "E.g. johnsmith123@yahoo.com",
      },
    },
    {
      width: 6,
      label: "Phone*",
      input: {
        type: "text",
        placeholder: "E.g. +1 (5417) 543 010",
      },
    },
    {
      width: 8,
      label: "Street address*",
      input: {
        type: "text",
        placeholder: "E.g. Street Somesul Mic, number 1,Bucharest",
      },
    },
    {
      width: 4,
      label: "Postcode/Zip*",
      input: {
        type: "text",
        placeholder: "E.g. 340112",
      },
    },
    {
      width: 4,
      label: "Apt, suite, etc.",
      input: {
        type: "text",
        placeholder: "E.g. YC7B 3UT",
      },
    },
    {
      width: 4,
      label: "City*",
      input: {
        type: "text",
        placeholder: "E.g. Bucharest",
      },
    },
    {
      width: 4,
      label: "Country*",
      select: {
        placeholder: "Select Country",
        items: [
          "Select country",
          "Romania",
          "Moldova"
        ],
      },
    },
  ],

  returnButton: {
    color: "light",
    children: "Return to cart",
    href:"/e-shop"
  },
  detailsButton: {
    color: "purple",
    children: "Save Details",

  },
};
export default textProps;
