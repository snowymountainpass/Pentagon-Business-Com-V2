package com.clockworkcode.pentagonbusinesscomv2.service;

import com.clockworkcode.pentagonbusinesscomv2.model.user.AppUser;
import com.clockworkcode.pentagonbusinesscomv2.model.user.AppUserAddress;
import com.clockworkcode.pentagonbusinesscomv2.repository.AppUserAddressRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AppUserAddressService {

    private final LoginTokenService loginTokenService;
    private final AppUserAddressRepository appUserAddressRepository;

    public AppUserAddressService(LoginTokenService loginTokenService, AppUserAddressRepository appUserAddressRepository) {
        this.loginTokenService = loginTokenService;
        this.appUserAddressRepository = appUserAddressRepository;
    }

    public void addUserAddress(String loginToken, List<String> userAddressDetails){

        AppUser appUser = loginTokenService.getAppUserByLoginToken(loginToken);

        appUserAddressRepository.save(
                new AppUserAddress(
                    userAddressDetails.get(0),
                        userAddressDetails.get(1),
                        userAddressDetails.get(3),
                        userAddressDetails.get(4),
                        userAddressDetails.get(5),
                        userAddressDetails.get(6),
                        userAddressDetails.get(2),
                        appUser
                )
        );

    }

    public void updateUserAddress(String loginToken){
        log.info(loginToken);
    }

}
