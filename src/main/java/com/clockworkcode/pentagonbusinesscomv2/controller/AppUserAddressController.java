package com.clockworkcode.pentagonbusinesscomv2.controller;

import com.clockworkcode.pentagonbusinesscomv2.model.request.AppUserDetailsRequest;
import com.clockworkcode.pentagonbusinesscomv2.service.AppUserAddressService;
import com.clockworkcode.pentagonbusinesscomv2.service.AppUserService;
import com.clockworkcode.pentagonbusinesscomv2.service.AppUserShippingAddressService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/e-shop")
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
@Slf4j
public class AppUserAddressController {
    private final AppUserService appUserService;
    private final AppUserAddressService appUserAddressService;
    private final AppUserShippingAddressService appUserShippingAddressService;

    @PostMapping("/user-account/save-details")
    public void saveUserDetails(@RequestBody AppUserDetailsRequest request){

        log.info("loginToken @useraccount: "+ request.getLoginToken());
        log.info("firstName @useraccount: "+ request.getFirstName());
        log.info("lastName @useraccount: "+ request.getLastName());
        log.info("email @useraccount: "+ request.getEmail());
//        log.info("user details list @useraccount: "+ request.getDetails());

        //TODO DE FACUT METODA PRIN CARE ADAUGAM VALORILE PT USER DETAILS
        //TODO DE FACUT METODA PRIN CARE ADAUGAM VALORILE PT USER SHIPPING DETAILS

        List<String> appUserDetails =List.of(request.getFirstName(),request.getLastName(),request.getPhone(),request.getEmail());
        appUserService.saveAppUserDetails(request.getLoginToken(),appUserDetails);


        List<String> userAddressDetails = List.of(request.getStreetAddress(), request.getPostcode(),
                                                    request.getStreetAddress2(),request.getCity(), request.getCountry());
        appUserAddressService.addUserAddress(request.getLoginToken(),userAddressDetails);



    }

}
