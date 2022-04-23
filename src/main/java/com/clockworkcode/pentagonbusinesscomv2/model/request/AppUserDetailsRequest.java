package com.clockworkcode.pentagonbusinesscomv2.model.request;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class AppUserDetailsRequest {

    private final String loginToken;
    private final String firstName;
    private final String lastName;
    private final String email ;
    private final String phone;
    private final String streetAddress;
    private final String postcode;
    private final String streetAddress2;
    private final String city;
    private final String country;

    private final String shipping_firstName ;
    private final String shipping_lastName ;
    private final String shipping_email;
    private final String shipping_phone;
    private final String shipping_streetAddress;
    private final String shipping_postcode;
    private final String shipping_streetAddress2;
    private final String shipping_city;
    private final String shipping_country;

}
