package com.clockworkcode.pentagonbusinesscomv2.service;

import com.clockworkcode.pentagonbusinesscomv2.model.user.AppUser;
import com.clockworkcode.pentagonbusinesscomv2.repository.LoginTokenRepository;

import com.clockworkcode.pentagonbusinesscomv2.security.token.ConfirmationToken;
import com.clockworkcode.pentagonbusinesscomv2.security.token.LoginToken;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class LoginTokenService {

    private final LoginTokenRepository loginTokenRepository;

    public void saveLoginToken(LoginToken loginToken){
        loginTokenRepository.save(loginToken);
    }
    public void deleteLoginToken(Long appUserId){
        loginTokenRepository.deleteById(appUserId);
    }

    public Optional<LoginToken> getToken(String token){
        return loginTokenRepository.findByToken(token);
    }

    //TODO ADD METHOD THAT REMOVES THE TOKEN AFTER IT EXPIRES

    public AppUser getAppUserByLoginToken(String token){

        LoginToken loginToken = loginTokenRepository.findByToken(token).get();

        if(loginToken.getAppUser()!=null){
            log.info("APPUSER exists IN DB!");
        }

        return loginTokenRepository.findByToken(token).get().getAppUser();
    }

    public List<LoginToken> getTokensForAppUserID(Long appUserID){
        return loginTokenRepository.findAll().stream().filter(loginToken -> loginToken.getAppUser().getAppUserID().equals(appUserID)).collect(Collectors.toList());
    }

}
