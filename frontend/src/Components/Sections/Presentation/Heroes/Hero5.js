import React from "react";
import PropTypes from "prop-types";
// sections

// components
import Heading2Badge from "../../../Headings/Heading2Badge";
// import InfoAreaIconTitleLinkColor from "../../../InfoAreas/Presentation/InfoAreaIconTitleLinkColor";
import CardInfoFullColor from "../../../Cards/Presentation/CardInfoFullColor";
import cardinfofullcolor from "../../../../Texts/Presentation/cards/cardinfofullcolor";

export default function Hero5({ heading2badge, infoAreas }) {
  return (
    <>
      <div className="py-12 text-white">
        {heading2badge && <Heading2Badge {...heading2badge} />}
        <div className="items-center flex flex-wrap -mx-4">
          {infoAreas.map((prop, key) => {
            return (
              <div
                className="text-center px-4 relative w-full lg:w-4/12"
                key={key}
              >
                {/*<InfoAreaIconTitleLinkColor {...prop} />*/}
                <CardInfoFullColor {...prop}/>
              </div>
            );
          })}
        </div>
      </div>
    </>
  );
}

Hero5.defaultProps = {
  infoAreas: [],
  heading2badge: null,
};
Hero5.propTypes = {
  // prop to pass to the Heading2Badge component
  heading2badge: PropTypes.object,
  // an array of props that can be passed to the
  // InfoAreaIconTitleLinkColor component
  infoAreas: PropTypes.arrayOf(PropTypes.object),
};
