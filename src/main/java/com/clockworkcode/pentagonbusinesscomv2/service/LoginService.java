package com.clockworkcode.pentagonbusinesscomv2.service;

import com.clockworkcode.pentagonbusinesscomv2.model.login.LoginRequest;
import com.clockworkcode.pentagonbusinesscomv2.model.logout.LogoutRequest;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class LoginService {

    private final AppUserService appUserService;


    public String login(LoginRequest request){
        String requestResult = appUserService.signInUser(request.getEmail(),request.getPassword());

        log.info("LoginService-1 => LoginService - LOGIN requestResult: "+ requestResult);

        return requestResult;
    }

    public void logout(LogoutRequest logoutRequest){
        appUserService.signOut(logoutRequest.getLoginToken());
    }

}
