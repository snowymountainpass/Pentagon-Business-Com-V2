package com.clockworkcode.pentagonbusinesscomv2.model.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class AppUserShippingAddressRequest {

    private final String loginToken;
    private final String shipping_firstName ;
    private final String shipping_lastName ;
    private final String shipping_email;
    private final String shipping_phone;
    private final String shipping_streetAddress;
    private final String shipping_postcode;
    private final String shipping_streetAddress2;
    private final String shipping_city;
    private final String shipping_county;
    private final String shipping_country;

}
