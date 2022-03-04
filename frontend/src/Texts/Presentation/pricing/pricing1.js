// import cardinfoiconProps from "../../../Texts/presentation/cards/cardpricing";

import cardinfoiconProps from "../../../Texts/Presentation/cards/cardpricing";

const textProps = {
  title: "ALCATEL RAINBOW ",
  firstButtonText: "SMB",
  secondButtonText: "Enterprise",
  defaultOpen: 1,
  description:
    "Rainbow delivers end-to-end communication solutions with flexible deployment - private, hybrid or public - connecting people, machines, and processes.\n" +
      "●\tAudio & Video Conferencing: create or join audio and video meetings with up to 120 participants and up to 12 simultaneous video streams.\n" +
      "●\tRich-telephony capabilities: connect your existing on-premises telephony system or a cloud PBX with Rainbow.\n" +
      "●\tHigh Level Security: ISO 27001 compliant and designed with product security features to help us prevent and detect security threats. Data privacy focused, following applicable laws such as GDPR and CCPA.\n",
  cardinfoiconProps: { ...cardinfoiconProps },
  cardblogimageProps: {
    headText: "Business",
    price: "2€+VAT",
    unit: "per user/per month-year",
    list: [
      {
        feature: "Good for: ",
        text: "Larger Teams & Businesses",
      },
      {
        feature: "Benfit: ",
        text: "Guaranteed Uptime",
      },
      {
        feature: "Benfit: ",
        text: "One stop shop for team communication",
      },
    ],
    link: {
      href: "https://www.openrainbow.com/",
      children: "Request a quotation",
    },
  },
  cardcontactustitleProps: {
    headText: "Enterprise",
    price: "4€+VAT",
    unit: "per user/per month-year",
    list: [
      {
        feature: "Everything in Business ",
        text: "with multi-party hybrid services",
      },
      {
        feature: "Extra: ",
        text: "Business Tools integration",
      },
      {
        feature: "Extra: ",
        text: "Premium Services to administrators",
      },
    ],
    link: {
      href: "https://www.openrainbow.com/",
      children: "Request a quotation",
    },
  },
  // cardinfoimageProps: {
  //   headText: "Platinum(TBD)",
  //   price: "$TBD",
  //   unit: "per month",
  //   list: [
  //     {
  //       feature: "TBD",
  //       text: "TBD",
  //     },
  //     {
  //       feature: "TBD",
  //       text: "TBD",
  //     },
  //     {
  //       feature: "TBD",
  //       text: "TBD",
  //     },
  //   ],
  //   link: {
  //     href: "https://www.openrainbow.com/",
  //     children: "Request a quotation",
  //   },
  // },
};
export default textProps;
