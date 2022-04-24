package com.clockworkcode.pentagonbusinesscomv2.service;

import com.clockworkcode.pentagonbusinesscomv2.model.user.AppUser;
import org.springframework.stereotype.Service;

@Service
public class AppUserShippingAddressService {

    private final LoginTokenService loginTokenService;

    public AppUserShippingAddressService(LoginTokenService loginTokenService) {
        this.loginTokenService = loginTokenService;
    }

    public void addUserShippingAddress(String loginToken){

        AppUser appUser = loginTokenService.getAppUserByLoginToken(loginToken);



    }

    public void updateUserShippingAddress(String loginToken){

    }

}
