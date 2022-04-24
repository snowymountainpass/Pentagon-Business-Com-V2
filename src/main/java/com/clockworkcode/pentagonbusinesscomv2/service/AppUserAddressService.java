package com.clockworkcode.pentagonbusinesscomv2.service;

import com.clockworkcode.pentagonbusinesscomv2.model.user.AppUser;
import com.clockworkcode.pentagonbusinesscomv2.model.user.AppUserAddress;
import com.clockworkcode.pentagonbusinesscomv2.repository.AppUserAddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserAddressService {

    private final LoginTokenService loginTokenService;
    private final AppUserAddressRepository appUserAddressRepository;

    public AppUserAddressService(LoginTokenService loginTokenService, AppUserAddressRepository appUserAddressRepository) {
        this.loginTokenService = loginTokenService;
        this.appUserAddressRepository = appUserAddressRepository;
    }

    public void addUserAddress(String loginToken, List<String> userAddressDetails){

        AppUser appUser = loginTokenService.getAppUserByLoginToken(loginToken);

//        appUserAddressRepository.save(
//                new AppUserAddress(
//
//                )
//        );

    }

    public void updateUserAddress(String loginToken){

    }

}
