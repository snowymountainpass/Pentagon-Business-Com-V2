import React from "react";
import PropTypes from "prop-types";

import {useForm} from "react-hook-form";

// components
import Button from "../../Elements/Button";
import Input from "../../Elements/Input.js";

export default function CardUserAccount({
  // returnButton,
  // detailsButton,
}) {
  const widths = {
    1: "lg:w-1/12",
    2: "lg:w-2/12",
    3: "lg:w-3/12",
    4: "lg:w-4/12",
    5: "lg:w-5/12",
    6: "lg:w-6/12",
    7: "lg:w-7/12",
    8: "lg:w-8/12",
    9: "lg:w-9/12",
    10: "lg:w-10/12",
    11: "lg:w-11/12",
    12: "lg:w-12/12",
  };

  const {handleSubmit} = useForm();


  function saveUserDetails(userDetails){
    // console.log("userDetails: "+ userDetails.firstName);
  }

  return (
    <>
      <div className="relative flex flex-col min-w-0 break-words bg-white w-full mb-6 shadow-lg rounded-lg">
        <div className="px-4 py-5 flex-auto">
          <form >
            {/*onSubmit={handleSubmit(saveUserDetails)}*/}
            <div className="container mx-auto px-4">
              <h3 className="text-3xl font-semibold mt-4 mb-6">Account/Billing Details</h3>
              <div className="flex flex-wrap -mx-4">

                <div className={"px-4 pb-2 relative w-full " + widths[6]}>
                  <label className="block uppercase text-blueGray-700 text-xs font-bold mb-2 ml-1">First Name*</label>
                  <Input name={"firstName"} type={"text"} placeholder={"E.g. John"}/>
                </div>

                <div className={"px-4 pb-2 relative w-full " + widths[6]}>
                  <label className="block uppercase text-blueGray-700 text-xs font-bold mb-2 ml-1">Last Name*</label>
                  <Input name={"lastName"}  type={"text"} placeholder={"E.g. Smith"}/>
                </div>

                <div className={"px-4 pb-2 relative w-full " + widths[6]}>
                  <label className="block uppercase text-blueGray-700 text-xs font-bold mb-2 ml-1">Email*</label>
                  <Input name={"email"} type={"email"} placeholder={"E.g. johnsmith123@yahoo.com"}/>
                </div>

                <div className={"px-4 pb-2 relative w-full " + widths[6]}>
                  <label className="block uppercase text-blueGray-700 text-xs font-bold mb-2 ml-1">Phone*</label>
                  <Input name={"phone"} type={"text"} placeholder={"E.g. +1 (5417) 543 010"}/>
                </div>

                <div className={"px-4 pb-2 relative w-full " + widths[8]}>
                  <label className="block uppercase text-blueGray-700 text-xs font-bold mb-2 ml-1">Street Address*</label>
                  <Input name={"streetAddress"} type={"text"} placeholder={"E.g. Street Somesul Mic, number 1,Bucharest"}/>
                </div>

                <div className={"px-4 pb-2 relative w-full " + widths[4]}>
                  <label className="block uppercase text-blueGray-700 text-xs font-bold mb-2 ml-1">POSTCODE/ZIP*</label>
                  <Input name={"postcode"} type={"text"} placeholder={"E.g. 340112"}/>
                </div>

                <div className={"px-4 pb-2 relative w-full " + widths[4]}>
                  <label className="block uppercase text-blueGray-700 text-xs font-bold mb-2 ml-1">APT, SUITE, ETC.</label>
                  <Input name={"streetAddress2"} type={"text"} placeholder={"E.g. apartment 12"}/>
                </div>

                <div className={"px-4 pb-2 relative w-full " + widths[4]}>
                  <label className="block uppercase text-blueGray-700 text-xs font-bold mb-2 ml-1">CITY*</label>
                  <Input name={"city"} type={"text"} placeholder={"E.g. Bucharest"}/>
                </div>

                <div className={"px-4 pb-2 relative w-full " + widths[4]}>
                  <label className="block uppercase text-blueGray-700 text-xs font-bold mb-2 ml-1">COUNTRY*</label>
                  <Input name={"country"} type={"text"} placeholder={"E.g. Romania"}/>
                </div>

              </div>

              <h3 className="text-3xl font-semibold mt-4 mb-6">Shipping Details</h3>
              <div className="flex flex-wrap -mx-4">

                <div className={"px-4 pb-2 relative w-full " + widths[6]}>
                  <label className="block uppercase text-blueGray-700 text-xs font-bold mb-2 ml-1">First Name*</label>
                  <Input name={"shipping_firstName"} type={"text"} placeholder={"E.g. John"}/>
                </div>

                <div className={"px-4 pb-2 relative w-full " + widths[6]}>
                  <label className="block uppercase text-blueGray-700 text-xs font-bold mb-2 ml-1">Last Name*</label>
                  <Input name={"shipping_lastName"} type={"text"} placeholder={"E.g. Smith"}/>
                </div>

                <div className={"px-4 pb-2 relative w-full " + widths[6]}>
                  <label className="block uppercase text-blueGray-700 text-xs font-bold mb-2 ml-1">Email*</label>
                  <Input name={"shipping_email"} type={"email"} placeholder={"E.g. johnsmith123@yahoo.com"}/>
                </div>

                <div className={"px-4 pb-2 relative w-full " + widths[6]}>
                  <label className="block uppercase text-blueGray-700 text-xs font-bold mb-2 ml-1">Phone*</label>
                  <Input name={"shipping_phone"} type={"text"} placeholder={"E.g. +1 (5417) 543 010"}/>
                </div>

                <div className={"px-4 pb-2 relative w-full " + widths[8]}>
                  <label className="block uppercase text-blueGray-700 text-xs font-bold mb-2 ml-1">Street Address*</label>
                  <Input name={"shipping_streetAddress"} type={"text"} placeholder={"E.g. Street Somesul Mic, number 1,Bucharest"}/>
                </div>

                <div className={"px-4 pb-2 relative w-full " + widths[4]}>
                  <label className="block uppercase text-blueGray-700 text-xs font-bold mb-2 ml-1">POSTCODE/ZIP*</label>
                  <Input name={"shipping_postcode"} type={"text"} placeholder={"E.g. 340112"}/>
                </div>

                <div className={"px-4 pb-2 relative w-full " + widths[4]}>
                  <label className="block uppercase text-blueGray-700 text-xs font-bold mb-2 ml-1">APT, SUITE, ETC.</label>
                  <Input name={"shipping_streetAddress2"} type={"text"} placeholder={"E.g. 340112"}/>
                </div>

                <div className={"px-4 pb-2 relative w-full " + widths[4]}>
                  <label className="block uppercase text-blueGray-700 text-xs font-bold mb-2 ml-1">CITY*</label>
                  <Input name={"shipping_city"} type={"text"} placeholder={"E.g. 340112"}/>
                </div>

                <div className={"px-4 pb-2 relative w-full " + widths[4]}>
                  <label className="block uppercase text-blueGray-700 text-xs font-bold mb-2 ml-1">COUNTRY*</label>
                  <Input name={"shipping_country"} type={"text"} placeholder={"E.g. Input Country"}/>
                </div>

              </div>

              <div className="flex justify-between mt-12 mb-8">
                {/*<Button {...returnButton} />*/}
                {/*<Button {...detailsButton} />*/}
              </div>
            </div>
          </form>
        </div>
      </div>
    </>
  );
}

const inputsObject = {
  // NOTE: this width only applies on large devices
  width: PropTypes.oneOf([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]),
  // if you wish, you can send something like
  // <span className="mr-2">Label Name</span><span className="text-red-500">*</span>
  // NOTE: the label tag will be auto generated
  label: PropTypes.node,
};

const inputsShape = PropTypes.shape({
  ...inputsObject,
  // props to pass to the Input component
  input: PropTypes.object,
});

const selectsShape = PropTypes.shape({
  ...inputsObject,
  // props to pass to the Select component
  select: PropTypes.object,
});

const inputsTypes = PropTypes.arrayOf(
  PropTypes.oneOfType([inputsShape, selectsShape])
);

CardUserAccount.defaultProps = {
  inputs: [],
  paymentOptions: [],
  onPaymentChange: () => {},
  returnButton: {},
  orderButton: {},
  defaultPaymentOpened: 0,
  paymentTabColor: "blueGray",
};

CardUserAccount.propTypes = {
  title: PropTypes.string,
  inputs: inputsTypes,
  paymentTitle: PropTypes.string,
  // 0 represents the first element
  // also, you should note that
  // the number should not be lower then 0
  // or higher than the number of items - 1
  defaultPaymentOpened: PropTypes.number,
  paymentOptions: PropTypes.arrayOf(
    PropTypes.shape({
      tabName: PropTypes.string,
      inputs: inputsTypes,
    })
  ),
  // this function has two parameters,
  // index number of the tab that was pressed
  // and the tabName of that tab
  // example: onPaymentChange={(index,name) => console.log(index,name)}
  onPaymentChange: PropTypes.func,
  paymentTabColor: PropTypes.oneOf([
    "blueGray",
    "red",
    "orange",
    "amber",
    "emerald",
    "teal",
    "lightBlue",
    "indigo",
    "purple",
    "pink",
  ]),
  // props to pass to the Button component on the left
  returnButton: PropTypes.object,
  // props to pass to the Button component on the right
  orderButton: PropTypes.object,
};



// <form>
//   <div className="container mx-auto px-4">
//     <h3 className="text-3xl font-semibold mt-4 mb-6">Account/Billing Details</h3>
//     <div className="flex flex-wrap -mx-4">
//       {inputs.map((prop, key) => (
//           <div
//               key={key}
//               className={
//                   "px-4 pb-2 relative w-full " + widths[prop.width]
//               }
//           >
//             <label className="block uppercase text-blueGray-700 text-xs font-bold mb-2 ml-1">
//               {prop.label}
//             </label>
//             {prop.input && <Input {...prop.input} />}
//             {prop.select && <Select {...prop.select} />}
//           </div>
//       ))}
//     </div>
//
//     <h3 className="text-3xl font-semibold mt-4 mb-6">Shipping Details</h3>
//     <div className="flex flex-wrap -mx-4">
//       {inputs.map((prop, key) => (
//           <div
//               key={key}
//               className={
//                   "px-4 pb-2 relative w-full " + widths[prop.width]
//               }
//           >
//             <label className="block uppercase text-blueGray-700 text-xs font-bold mb-2 ml-1">
//               {prop.label}
//             </label>
//             {prop.input && <Input {...prop.input} />}
//             {prop.select && <Select {...prop.select} />}
//           </div>
//       ))}
//     </div>
//
//     <div className="flex justify-between mt-12 mb-8">
//       <Button {...returnButton} />
//       <Button {...orderButton} />
//     </div>
//   </div>
// </form>