import React from "react";
import PropTypes from "prop-types";

// components
// import Button from "../../Elements/Button";
// import Skew from "../../Skews/Skew";
// import {toPadding} from "chart.js/helpers";
//75
export default function HeaderVideoTitle({
  video,

}) {
  return (
    <>

      <div>
        <br/>
        <br/>
        <br/>
      </div>
      {/*<div className="p-5 flex items-center overflow-hidden relative bg-black min-h-screen-75 min-h-700-px">*/}
      <div className="flex position-relative bg-black min-h-700-px">

        <video
          playsInline="playsinline"
          autoPlay="autoplay"
          muted="muted"
          loop="loop"
          // className="absolute min-w-full max-w-none min-h-full z-2 transform -translate-x-1/2 -translate-y-1/2 top-7/20 left-1/2 mt-xl-5"
          className="position-relative min-w-full max-w-none min-h-screen-60" //min-h-screen min-h-full
        >
          <source src={video} type="video/mp4" />
        </video>

      </div>
    </>
  );
}

HeaderVideoTitle.defaultProps = {
  skew: {},
};

HeaderVideoTitle.propTypes = {
  video: PropTypes.string.isRequired,

};
