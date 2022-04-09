package com.clockworkcode.pentagonbusinesscomv2.service;

import com.clockworkcode.pentagonbusinesscomv2.model.user.AppUser;
import com.clockworkcode.pentagonbusinesscomv2.repository.LoginTokenRepository;

import com.clockworkcode.pentagonbusinesscomv2.security.token.ConfirmationToken;
import com.clockworkcode.pentagonbusinesscomv2.security.token.LoginToken;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class LoginTokenService {

    private final LoginTokenRepository loginTokenRepository;

    public void saveLoginToken(LoginToken loginToken){
        loginTokenRepository.save(loginToken);
    }

    public Optional<LoginToken> getToken(String token){
        return loginTokenRepository.findByToken(token);
    }

    //TODO ADD METHOD THAT REMOVES THE TOKEN AFTER IT EXPIRES

    public AppUser getAppUserByLoginToken(String token){

        LoginToken loginToken = loginTokenRepository.findByToken(token).get();

        if(loginToken.getAppUser()!=null){
            System.out.println("APPUSER exists IN DB!");
        }

        return loginTokenRepository.findByToken(token).get().getAppUser();
    }

}
