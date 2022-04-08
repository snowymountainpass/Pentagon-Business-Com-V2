package com.clockworkcode.pentagonbusinesscomv2.service;

import com.clockworkcode.pentagonbusinesscomv2.model.user.AppUser;
import com.clockworkcode.pentagonbusinesscomv2.repository.AppUserRepository;
import com.clockworkcode.pentagonbusinesscomv2.repository.ConfirmationTokenRepository;
import com.clockworkcode.pentagonbusinesscomv2.security.token.ConfirmationToken;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {

    private final ConfirmationTokenRepository confirmationTokenRepository;
    private final AppUserRepository appUserRepository;

    public void saveConfirmationToken(ConfirmationToken token){
        confirmationTokenRepository.save(token);
    }
    public Optional<ConfirmationToken> getToken(String token){
       return confirmationTokenRepository.findByToken(token);
    }

    public int setConfirmedAt(String token){
        return confirmationTokenRepository.updateConfirmedAt(token, LocalDateTime.now());
    }

    public AppUser getAppUserByConfirmationToken(String token){

//        if(confirmationTokenRepository.findByToken(token).get().getAppUser()!=null){
//            System.out.println("APPUSER exists!");
//        }
//        BigInteger userID = confirmationTokenRepository.findByToken(token).ifPresent( ConfirmationToken -> ConfirmationToken.getAppUser().getAppUserID());
        ConfirmationToken cftk = confirmationTokenRepository.findByToken(token).get();
//        Long userID = cftk.getAppUser().getAppUserID();

        if(cftk.getAppUser()!=null){
            System.out.println("APPUSER exists IN DB!");
        }

       return confirmationTokenRepository.findByToken(token).get().getAppUser();
    }

}
