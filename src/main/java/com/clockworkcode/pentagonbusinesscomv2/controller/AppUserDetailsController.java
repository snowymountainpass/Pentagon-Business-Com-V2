package com.clockworkcode.pentagonbusinesscomv2.controller;

import com.clockworkcode.pentagonbusinesscomv2.model.request.AppUserDetailsRequest;
import com.clockworkcode.pentagonbusinesscomv2.model.request.AppUserShippingAddressRequest;
import com.clockworkcode.pentagonbusinesscomv2.service.AppUserAddressService;
import com.clockworkcode.pentagonbusinesscomv2.service.AppUserService;
import com.clockworkcode.pentagonbusinesscomv2.service.AppUserShippingAddressService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping(path = "/e-shop")
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
@Slf4j
public class AppUserDetailsController {
    private final AppUserService appUserService;
    private final AppUserAddressService appUserAddressService;
    private final AppUserShippingAddressService appUserShippingAddressService;

    @PostMapping("/user-account/save-details")
    public List<String> saveUserDetails(@RequestBody AppUserDetailsRequest request){

        List<String> appUserDetails =List.of(request.getFirstName(),request.getLastName(),request.getPhone(),request.getEmail());
        appUserService.saveAppUserDetails(request.getLoginToken(),appUserDetails);


        List<String> appUserAddressDetails = List.of(request.getStreetAddress(),request.getStreetAddress2(),request.getPostcode()
                ,request.getCity(),request.getCounty(), request.getCountry(),request.getPhone());
        appUserAddressService.addUserAddress(request.getLoginToken(),appUserAddressDetails);

        return Stream.concat( appUserDetails.stream(),appUserAddressDetails.stream() ).collect(Collectors.toList());
    }

    @PostMapping("/user-account/save-shipping-details")
    public List<String> saveUserShippingDetails(@RequestBody AppUserShippingAddressRequest request){

        List<String> appUserShippingDetails = List.of(
                request.getLoginToken(),
                request.getShipping_firstName(),
                request.getShipping_lastName(),
                request.getShipping_email(),
                request.getShipping_phone(),
                request.getShipping_streetAddress(),
                request.getShipping_postcode(),
                request.getShipping_streetAddress2(),
                request.getShipping_city(),
                request.getShipping_county(),
                request.getShipping_country()
        );

        appUserShippingAddressService.addUserShippingAddress(appUserShippingDetails);

        return appUserShippingDetails;
    }
}
