package com.clockworkcode.pentagonbusinesscomv2.service;

import com.clockworkcode.pentagonbusinesscomv2.model.user.AppUser;
import com.clockworkcode.pentagonbusinesscomv2.repository.LoginTokenRepository;

import com.clockworkcode.pentagonbusinesscomv2.security.token.LoginToken;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class LoginTokenService {

    private final LoginTokenRepository loginTokenRepository;

    public void saveLoginToken(LoginToken loginToken){
        loginTokenRepository.save(loginToken);
    }
    public void deleteLoginToken(Long appUserId){

        log.info("LoginTokeService-1 => REACHED LoginTokeService - deleteLoginToken METHOD");
        log.info("LoginTokeService-2 => Number of login token (BEFORE DELETION) for appUserID "+appUserId+" is: " + (int) loginTokenRepository.findAll().stream().filter(loginToken -> loginToken.getAppUser().getAppUserID().equals(appUserId)).count() );

        loginTokenRepository.deleteLoginTokenByAppUser_AppUserID(appUserId);

        log.info("LoginTokeService-3 =>Number of login token (AFTER DELETION) for appUserID "+appUserId+" is: " + (int) loginTokenRepository.findAll().stream().filter(loginToken -> loginToken.getAppUser().getAppUserID().equals(appUserId)).count());
    }



    public LoginToken getToken(String token){
        return loginTokenRepository.findByToken(token);
    }

    //TODO ADD METHOD THAT REMOVES THE TOKEN AFTER IT EXPIRES

    public AppUser getAppUserByLoginToken(String token){

        LoginToken loginToken = loginTokenRepository.findByToken(token);

        if(loginToken.getAppUser()!=null){
            log.info("getAppUserByLoginToken-1 => APPUSER exists IN DB!");
        }

        log.info("getAppUserByLoginToken-2 => AppUserID - "+loginToken.getAppUser().getAppUserID() + " with token " + loginToken.getToken() );

        return loginTokenRepository.findByToken(token).getAppUser();
    }

    public List<LoginToken> getTokensForAppUserID(Long appUserID){
        return loginTokenRepository.findAll().stream().filter(loginToken -> loginToken.getAppUser().getAppUserID().equals(appUserID)).collect(Collectors.toList());
    }

}
