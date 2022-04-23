package com.clockworkcode.pentagonbusinesscomv2.service;

import com.clockworkcode.pentagonbusinesscomv2.model.user.AppUser;
import org.springframework.stereotype.Service;

@Service
public class AppUserAddressService {

    private final LoginTokenService loginTokenService;

    public AppUserAddressService( LoginTokenService loginTokenService) {
        this.loginTokenService = loginTokenService;
    }

    public void addUserAddress(String loginToken){

        AppUser appUser = loginTokenService.getAppUserByLoginToken(loginToken);



    }

    public void updateUserAddress(String loginToken){

    }

}
