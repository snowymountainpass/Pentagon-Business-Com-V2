package com.clockworkcode.pentagonbusinesscomv2.service;

import com.clockworkcode.pentagonbusinesscomv2.model.user.AppUser;
import com.clockworkcode.pentagonbusinesscomv2.model.user.AppUserShippingAddress;
import com.clockworkcode.pentagonbusinesscomv2.repository.AppUserShippingAddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserShippingAddressService {

    private final LoginTokenService loginTokenService;
    private final AppUserShippingAddressRepository appUserShippingAddressRepository;

    public AppUserShippingAddressService(LoginTokenService loginTokenService, AppUserShippingAddressRepository appUserShippingAddressRepository) {
        this.loginTokenService = loginTokenService;
        this.appUserShippingAddressRepository = appUserShippingAddressRepository;
    }

    public void addUserShippingAddress(List<String> userShippingDetails){

        AppUser appUser = loginTokenService.getAppUserByLoginToken(userShippingDetails.get(0));

        appUserShippingAddressRepository.save(
                new AppUserShippingAddress(
                        userShippingDetails.get(1),
                        userShippingDetails.get(2),
                        userShippingDetails.get(3),
                        userShippingDetails.get(4),
                        userShippingDetails.get(5),
                        userShippingDetails.get(6),
                        userShippingDetails.get(7),
                        userShippingDetails.get(8),
                        userShippingDetails.get(9),
                        userShippingDetails.get(10),
                        appUser
                )
        );

    }

    public void updateUserShippingAddress(String loginToken){

    }

}
