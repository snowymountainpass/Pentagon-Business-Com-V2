package com.clockworkcode.pentagonbusinesscomv2.service;

import com.clockworkcode.pentagonbusinesscomv2.model.login.LoginRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class LoginService {

    private final AppUserService appUserService;
    private final LoginTokenService loginTokenService;

    public String login(LoginRequest request){

        String token = appUserService.signInUser(request.getEmail(),request.getPassword());

        return token;
    }

}
