package com.clockworkcode.pentagonbusinesscomv2.service;

import org.springframework.stereotype.Service;

@Service
public class AppUserAddressService {

    private final LoginTokenService loginTokenService;

    public AppUserAddressService( LoginTokenService loginTokenService) {
        this.loginTokenService = loginTokenService;
    }

    public void addUserAddress(String loginToken){

        Long appUserID = loginTokenService.getAppUserByLoginToken(loginToken).getAppUserID();



    }

    public void updateUserAddress(String loginToken){

    }

}
