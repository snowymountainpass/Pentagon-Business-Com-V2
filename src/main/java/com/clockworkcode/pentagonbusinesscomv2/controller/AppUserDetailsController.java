package com.clockworkcode.pentagonbusinesscomv2.controller;

import com.clockworkcode.pentagonbusinesscomv2.model.request.AppUserDetailsRequest;
import com.clockworkcode.pentagonbusinesscomv2.model.request.AppUserShippingAddressRequest;
import com.clockworkcode.pentagonbusinesscomv2.model.user.AppUser;
import com.clockworkcode.pentagonbusinesscomv2.model.user.AppUserAddress;
import com.clockworkcode.pentagonbusinesscomv2.model.user.AppUserShippingAddress;
import com.clockworkcode.pentagonbusinesscomv2.service.AppUserAddressService;
import com.clockworkcode.pentagonbusinesscomv2.service.AppUserService;
import com.clockworkcode.pentagonbusinesscomv2.service.AppUserShippingAddressService;
import com.clockworkcode.pentagonbusinesscomv2.service.LoginTokenService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    private final LoginTokenService loginTokenService;

    @PostMapping("/user-account/save-details")
    public List<String> saveUserDetails(@RequestBody AppUserDetailsRequest request) {

        List<String> appUserDetails = List.of(request.getFirstName(), request.getLastName(), request.getPhone(), request.getEmail());
        appUserService.saveAppUserDetails(request.getLoginToken(), appUserDetails);


        List<String> appUserAddressDetails = List.of(request.getStreetAddress(), request.getStreetAddress2(), request.getPostcode()
                , request.getCity(), request.getCounty(), request.getCountry(), request.getPhone());
        appUserAddressService.addUserAddress(request.getLoginToken(), appUserAddressDetails);

        return Stream.concat(appUserDetails.stream(), appUserAddressDetails.stream()).collect(Collectors.toList());
    }

    @PostMapping("/user-account/save-shipping-details")
    public List<String> saveUserShippingDetails(@RequestBody AppUserShippingAddressRequest request) {

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

    @GetMapping("/user-account/get-user-details/{loginToken}")
    public ResponseEntity<List<String>> getLatestUserDetails(@PathVariable String loginToken) {

        AppUser appUser = loginTokenService.getAppUserByLoginToken(loginToken);
        int userAddressesListSize = appUserAddressService.getAppUserAddressesByAppUserID(appUser.getAppUserID()).size();
        AppUserAddress userAddress = null;
//        if(userAddressesListSize==1){
//             userAddress = appUserAddressService.getAppUserAddressesByAppUserID(appUser.getAppUserID()).get(0);
//        }
//        else if (userAddressesListSize>1) {
//             userAddress = appUserAddressService.getAppUserAddressesByAppUserID(appUser.getAppUserID()).get(userAddressesListSize-1);
//        }

        if(userAddressesListSize>0){
            userAddress = appUserAddressService.getAppUserAddressesByAppUserID(appUser.getAppUserID()).get(userAddressesListSize-1);
        }


        List<String> appUserAddressDetails = List.of(
                userAddress.getAddressLine1(),
                userAddress.getAddressLine2(),
                userAddress.getPostalCode(),
                userAddress.getCity(),
                userAddress.getCounty(),
                userAddress.getCountry(),
                userAddress.getTelephone()
        );


        List<String> appUserDetails = List.of(
                appUser.getFirstName(),
                appUser.getLastName(),
                appUser.getTelephone(),
                appUser.getEmail()
        );


        return ResponseEntity.ok().body( Stream.concat(appUserDetails.stream(), appUserAddressDetails.stream()).collect(Collectors.toList()) );
    }

    @GetMapping("/user-account/get-user-shipping-details/{loginToken}")
    public ResponseEntity<List<String>> getLatestUserShippingDetails(@PathVariable String loginToken) {

        AppUser appUser = loginTokenService.getAppUserByLoginToken(loginToken);

        int userShippingAddressesListSize = appUserShippingAddressService.getAppUserShippingAddressesByAppUserID(appUser.getAppUserID()).size();

        List<String> userShippingDetails = null;
        if (userShippingAddressesListSize > 0) {
            AppUserShippingAddress appUserShippingAddress = appUserShippingAddressService
                    .getAppUserShippingAddressesByAppUserID(appUser.getAppUserID())
                    .get(userShippingAddressesListSize - 1);

            userShippingDetails = List.of(
                    loginToken,
                    appUserShippingAddress.getShippingFirstName(),
                    appUserShippingAddress.getShippingLastName(),
                    appUserShippingAddress.getShippingEmail(),
                    appUserShippingAddress.getShippingTelephone(),
                    appUserShippingAddress.getShippingAddress(),
                    appUserShippingAddress.getShippingPostalCode(),
                    appUserShippingAddress.getShippingAddress2(),
                    appUserShippingAddress.getShippingCity(),
                    appUserShippingAddress.getShippingCounty(),
                    appUserShippingAddress.getShippingCountry()
            );
        }

        return ResponseEntity.ok().body(userShippingDetails);
    }
}
