package com.clockworkcode.pentagonbusinesscomv2.model.request;

import lombok.*;

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
    private final String county;
    private final String country;

}
