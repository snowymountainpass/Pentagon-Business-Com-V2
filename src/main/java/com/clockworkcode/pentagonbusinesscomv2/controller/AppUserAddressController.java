package com.clockworkcode.pentagonbusinesscomv2.controller;

import com.clockworkcode.pentagonbusinesscomv2.model.request.AppUserDetailsRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/e-shop")
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
@Slf4j
public class AppUserAddressController {

    @PostMapping("/user-account/save-details")
    public void saveUserDetails(@RequestBody AppUserDetailsRequest request){

        log.info("loginToken @useraccount: "+ request.getLoginToken());
        log.info("firstName @useraccount: "+ request.getFirstName());
        log.info("lastName @useraccount: "+ request.getLastName());
        log.info("email @useraccount: "+ request.getEmail());
//        log.info("user details list @useraccount: "+ request.getDetails());

    }

}
